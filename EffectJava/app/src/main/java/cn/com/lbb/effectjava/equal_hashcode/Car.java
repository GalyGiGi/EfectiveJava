package cn.com.lbb.effectjava.equal_hashcode;

/**
 *
 * Created by zengcheng on 2017/4/4.
 */

public class Car {
    private String type;
    private String brand;
    private int serialNo;
    private float date;
    private long time;
    private double color;

    public Car(String type, String brand, int serialNo, float d, long time) {
        this.type = type;
        this.brand = brand;
        this.serialNo = serialNo;
        this.date = d;
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Car)) {
            return false;
        }
        Car c = (Car) o;
        return c.type.equals(type) && c.brand.equals(brand)
                && c.serialNo == serialNo
                && Float.compare(c.date, date) == 0 && c.time == time;

    }

    @Override
    public int hashCode() {
        int result = 5;//任意一个非0初始值都可
        int[] codes = new int[6];
        codes[0] = type.hashCode();
        codes[1] = brand.hashCode();
        codes[2] = serialNo;
        codes[3] = Float.floatToIntBits(date);
        codes[4] = (int) (time ^ (time >>> 32));
        long c = Double.doubleToLongBits(color);
        codes[5] = (int) (c ^ (c >>> 32));
        for (int i = 0; i < codes.length; i++) {
            result = result * 31 + codes[i];
        }
        return result;
    }
}
