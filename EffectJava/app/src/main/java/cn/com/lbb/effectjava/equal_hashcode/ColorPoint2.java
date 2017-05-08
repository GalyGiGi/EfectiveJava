package cn.com.lbb.effectjava.equal_hashcode;

/**
 * Created by zengcheng on 2017/4/8.
 */

public class ColorPoint2 { //复合优先于继承,这是equals的最佳实现,同时注意hashcode方法也要重写
    SimplePoint simplePoint;
    int color;

    public SimplePoint asSimplePoint() {
        return simplePoint;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint2)) {
            return false;
        }
        if (o instanceof ColorPoint2) {
            ColorPoint2 cp = (ColorPoint2) o;
            return simplePoint.equals(cp.asSimplePoint()) && color == cp.color;
        }
        return false;
    }
}
