package cn.com.lbb.effectjava.method;

import java.util.Date;

/**
 * Created by zengcheng on 2017/5/20.
 *
 * 如果方法需要接收一个可变对象,或者返回一个可变对象给客户端,需要考虑使用保护性拷贝,保证安全
 *
 */

public class CloneProtect {


    public static class Period {
        private final Date start;
        private final Date end;


        /**
         *
         * 1.此处没有使用clone方法,因为Date不是final的,有可能clone出来的对象是恶意的Date的子类
         * 2.先拷贝,再做合法性检查,并且使用拷贝之后的对象做检查,是为了避免在危险阶段期间从另一个线程
         * 改变类的参数(TIME of check)
         * 3.
         *
         * @param s
         * @param e
         * @throws NullPointerException
         * @throws IllegalArgumentException
         */
        public Period(Date s, Date e) {
            start = new Date(s.getTime());
            end = new Date(e.getTime());
            if (start.compareTo(end) > 0) {
                throw new IllegalArgumentException(start + "after" + end);
            }
        }

        public Date start() {
            return new Date(start.getTime());
        }

        public Date end() {
            return new Date(end.getTime());
        }
    }
}
