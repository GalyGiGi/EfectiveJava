package cn.com.lbb.effectjava.Chapter10.Item71;

// Initialization styles - Pages 282-284
public class Initialization {
    private final static int INVOKE_TIME = 100000000;
    private final static int TEST_TIME = 50;

    private static void test(boolean isSlow) {
        long sum = 0;
        for (int i = 0; i < TEST_TIME; i++) {
            Initialization initialization = new Initialization();
            long start = System.nanoTime();
            for (int j = 0; j < INVOKE_TIME; j++) {
                if (isSlow) {
                    initialization.getField4Slower();

                } else {
                    initialization.getField4();

                }
            }
            long end = System.nanoTime();
            String methodName = isSlow ? "getField4Slower" : "getField4";
            long duration = (end - start) / 10000;
            sum += duration;
            System.out.printf("test method %s case%s , 消耗时间: %s", methodName, i, (end - start) / 10000);
            System.out.print("\n");
        }
        System.out.printf("本次测试平均耗时: %s", sum / TEST_TIME);
    }

    public static void main(String[] args) {

        test(true);
        test(true);
        test(true);


    }

    // Normal initialization of an instance field - Page 282
    private final FieldType field1 = computeFieldValue();

    // Lazy initialization of instance field - synchronized accessor - Page 282
    private FieldType field2;

    synchronized FieldType getField2() {
        if (field2 == null)
            field2 = computeFieldValue();
        return field2;
    }

    // Lazy initialization holder class idiom for static fields - Page 283
    private static class FieldHolder {
        static final FieldType field = computeFieldValue();
    }

    static FieldType getField3() {
        return FieldHolder.field;
    }


    // Double-check idiom for lazy initialization of instance fields - Page 283
    private volatile FieldType field4;

    FieldType getField4() {
        FieldType result = field4;
        if (result == null) {  // First check (no locking)
            synchronized (this) {
                result = field4;
                if (result == null)  // Second check (with locking)
                    field4 = result = computeFieldValue();
            }
        }
        return field4;
    }

    FieldType getField4Slower() {
        if (field4 == null) {  // First check (no locking)
            synchronized (this) {
                if (field4 == null)  // Second check (with locking)
                    field4 = computeFieldValue();
            }
        }
        return field4;
    }

    FieldType getField4Slowest() {//这样最慢,每次都会同步
        synchronized (this) {
            if (field4 == null)  // Second check (with locking)
                field4 = computeFieldValue();
        }
        return field4;
    }

    // Single-check idiom - can cause repeated initialization! - Page 284
    private volatile FieldType field5;

    private FieldType getField5() {
        FieldType result = field5;
        if (result == null)
            field5 = result = computeFieldValue();
        return result;
    }

    private static FieldType computeFieldValue() {
        return new FieldType();
    }
}

class FieldType {
}
