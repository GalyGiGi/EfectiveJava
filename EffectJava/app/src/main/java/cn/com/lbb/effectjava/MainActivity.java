package cn.com.lbb.effectjava;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import cn.com.lbb.effectjava.equal_hashcode.Car;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void testHashCode(View v) {
        Car car1 = new Car("suv", "benz", 1, 2017.0f, 2008);
        Car car2 = new Car("suv", "benz", 1, 2017.0f, 2008);
        boolean e = car1.equals(car2);
        boolean e2 = car2.equals(car1);
        int code1 = car1.hashCode();
        int code2 = car2.hashCode();
    }


}
