package cn.com.lbb.effectjava.clone_demo;

/**
 * Created by zengcheng on 2017/4/8.
 */

public class CarCloneable implements Cloneable {
    int mode;
    Object[] wheel;
    Door door;

    @Override
    public Object clone() {  //重写为public,并且不声明抛异常
        CarCloneable car = null;
        try {
            car = (CarCloneable) super.clone();//先调用super.clone(),再
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        car.wheel = wheel.clone();
        car.door = door.deepCopy();
        return car;
    }

    static class Door {
        Door d1, d2;

        public Door deepCopy() {
            Door door = new Door();
            door.d1 = d1.deepCopy();
            door.d2 = d2.deepCopy();
            return door;
        }
    }
}
