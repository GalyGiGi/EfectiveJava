package cn.com.lbb.effectjava.clone_demo;

/**
 * Created by zengcheng on 2017/4/8.
 */

public class CarCloneConstructor {
    int mode;
    Object[] wheel;
    Door door;

    public CarCloneConstructor(CarCloneConstructor car) {
        this.mode = car.mode;
        this.wheel = car.wheel.clone();
        this.door = new Door(car.door);

    }

    static class Door {
        int size;

        public Door(Door door) {
            this.size = door.size;
        }
    }
}
