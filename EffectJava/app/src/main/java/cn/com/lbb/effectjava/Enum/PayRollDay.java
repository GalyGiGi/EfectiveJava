package cn.com.lbb.effectjava.Enum;


/**
 * Created by zengcheng on 2017/5/12.
 * <p>
 * 此例演示了多个枚举常量共享相同的行为的事例,这种情况需要考虑策略枚举
 * 避免产生太多样板代码的同时,强制以后没加一种节日,必须搭配一种计算方法。如果使用switch语句的话,可能会忘记给新加的节日添加算法
 */

public enum PayRollDay {
    MONDAY(PayType.WEEKDAY), TUESDAY(PayType.WEEKDAY), WENDSDAY(PayType.WEEKDAY), THURSDAY(PayType.WEEKDAY), FRIDAY(PayType.WEEKDAY), SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);
    private PayType payType;

    double pay(double hourWorked, double payRate) {
        return payType.pay(hourWorked, payRate);
    }

    PayRollDay(PayType payType) {
        this.payType = payType;
    }

    private enum PayType {
        WEEKDAY {
            @Override
            double overTimePay(double hourWorked, double payRate) {
                return hourWorked <= HOUR_PER_SHIFT ? 0 : (hourWorked - HOUR_PER_SHIFT) * payRate / 2;
            }
        }, WEEKEND {
            @Override
            double overTimePay(double hourWorked, double payRate) {
                return (hourWorked - HOUR_PER_SHIFT) * payRate / 2;
            }
        };
        private static final int HOUR_PER_SHIFT = 8;

        abstract double overTimePay(double hourWorked, double payRate);

        double pay(double hourWorked, double payRate) {
            double basePay = hourWorked * payRate;
            return basePay + overTimePay(hourWorked, payRate);
        }
    }
}
