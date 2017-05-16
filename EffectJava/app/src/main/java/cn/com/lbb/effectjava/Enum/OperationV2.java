package cn.com.lbb.effectjava.Enum;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by zengcheng on 2017/5/15.
 * <p>
 * 用接口模拟可伸缩的枚举
 */

public class OperationV2 {
    interface Operation {
        double opreate(double v1, double v2);
    }

    public enum BasicOperation implements Operation {

        PLUS("+") {
            @Override
            public double opreate(double v1, double v2) {
                return v1 + v2;
            }
        },

        MINUS("-") {
            @Override
            public double opreate(double v1, double v2) {
                return v1 - v2;
            }
        };


        private final String mSymbol;

        BasicOperation(String symbol) {
            mSymbol = symbol;
        }

        @Override
        public String toString() {
            return mSymbol;
        }
    }

    public enum ExtendOperation implements Operation {
        EXP("^") {
            @Override
            public double opreate(double v1, double v2) {
                return Math.pow(v1, v2);
            }
        };
        private final String mSymbol;

        ExtendOperation(String symbol) {
            mSymbol = symbol;
        }

        @Override
        public String toString() {
            return mSymbol;
        }
    }

    private static <T extends Enum<T> & Operation> void test(Class<T> opSet, double x, double y) {
        for (Operation op : opSet.getEnumConstants()) {
            System.out.printf("test>>> %f %s %f = %f%n", x, op, y, op.opreate(x, y));
            op.opreate(x, y);
        }
    }

    /**
     * @param opSet
     * @param x
     * @param y     这种方式简单一些，允许调用者将多个实现类型的操作合并到一起，
     *              但是也放弃了在指定操作上使用enumSet和enumMap的功能，因此，
     *              除非需要灵活的合并多个实现类型的操作，否则最好使用有限制的类型令牌
     */
    private static void testV2(Collection<? extends Operation> opSet, double x, double y) {//
        for (Operation op : opSet) {
            System.out.printf("testV2>>> %f %s %f = %f%n", x, op, y, op.opreate(x, y));
            op.opreate(x, y);
        }
    }

    public static void main(String[] args) {
        test(BasicOperation.class, 3.0, 2.0);
        testV2(Arrays.asList(BasicOperation.values()), 3, 2);
    }
}
