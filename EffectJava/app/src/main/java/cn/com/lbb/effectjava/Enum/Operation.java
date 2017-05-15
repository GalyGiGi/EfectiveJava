package cn.com.lbb.effectjava.Enum;

/**
 * Created by zengcheng on 2017/5/12.
 *
 * 此例演示了特定枚举常量拥有特定行为的事例
 */



public enum Operation {

    PLUS("+") {
        @Override
        public double operate(double v1, double v2) {
            return v1 + v2;
        }
    },

    MINUS("-") {
        @Override
        public double operate(double v1, double v2) {
            return v1 - v2;
        }
    };


    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public abstract double operate(double v1, double v2);

    @Override
    public String toString() {
        return symbol;
    }

}
