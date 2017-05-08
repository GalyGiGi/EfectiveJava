package cn.com.lbb.effectjava.equal_hashcode;

/**
 * Created by zengcheng on 2017/4/8.
 */

public class SimplePoint {
    int x, y;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SimplePoint)) {
            return false;
        }
        SimplePoint s = (SimplePoint) o;
        if (s.x == x && s.y == y) {
            return true;
        }
        return false;
    }
}
