package cn.com.lbb.effectjava.equal_hashcode;

/**
 * Created by zengcheng on 2017/4/8.
 */

public class ColorPoint extends SimplePoint {
    int color;

//    @Override
//    public boolean equals(Object o) {//满足对称性,不满足传递性
//        if (!(o instanceof SimplePoint)) {
//            return false;
//        }
//        if (!(o instanceof ColorPoint)) {
//            return super.equals(o);
//        }
//
//        return super.equals(o) && ((ColorPoint) o).color == color;
//    }


    @Override
    public boolean equals(Object o) { //如果存在ColorPoint类的一个子类,并且没有增加值域,此时equals一律返回false,如果把他们放到hashSet里面,就可能没法一起正常使用,所以也不适用
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        ColorPoint cp = (ColorPoint) o;
        return cp.x == x && cp.y == y && cp.color == color;
    }
}
