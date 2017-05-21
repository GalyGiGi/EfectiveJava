package cn.com.lbb.effectjava.method;

import java.math.BigDecimal;

/**
 * Created by zengcheng on 2017/5/21.
 *
 * 如果需要精确的结果,不要用float和double,可以用BigDecimal或者int,long替代
 * 数值范围不超过9位的十进制数可以用Int,不超过18位可以用long,超过就用BigDecimal
 */

public class FloatAndDouble {
    public static void main(String[] args) {
        compute3();
    }
    private static void compute(){
        System.out.printf("1.03-0.42= %s", 1.03 - 0.42);//输出的结果是0.6100000000000001

    }
    private static void compute2(){
        BigDecimal v1= new BigDecimal(1.03);
        BigDecimal v2 = new BigDecimal(0.42);
        double result = v1.subtract(v2).doubleValue();
        System.out.printf("1.03-0.42= %s", result);//输出的结果是0.6100000000000001

    }
    private static void compute3(){
        BigDecimal v1= new BigDecimal("1.03");
        BigDecimal v2 = new BigDecimal("0.42");
        double result = v1.subtract(v2).doubleValue();
        System.out.printf("1.03-0.42= %s", result);//输出的结果是0.61

    }
}
