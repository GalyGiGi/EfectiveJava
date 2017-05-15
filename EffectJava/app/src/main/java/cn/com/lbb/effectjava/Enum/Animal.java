package cn.com.lbb.effectjava.Enum;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zengcheng on 2017/5/13.
 */

public class Animal {
    private String name;
    private Type type;

    public enum Type {
        MAMMAL, OVIPAROUS
    }

    public Animal(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * 这种处理方式的问题很多:
     * 1.数组不能与泛型兼容,需要进行unchecked cast
     * 2.数组不知道它的索引代表什么
     * 3.其实程序会抛出ArrayIndexOutOfBoundsException,利用枚举的序数进行索引的数组,正确的使用int值并不容易
     */
    public static void classifyByArray() {
        Animal[] allAnimals = new Animal[5];
        allAnimals[0]=new Animal("Chicken",Type.OVIPAROUS);
        allAnimals[1]=new Animal("Pig",Type.MAMMAL);
        allAnimals[2]=new Animal("Dog",Type.MAMMAL);
        allAnimals[3]=new Animal("Sheep",Type.MAMMAL);
        allAnimals[4]=new Animal("Cow",Type.MAMMAL);


        Set<Animal>[] animals = (Set<Animal>[]) new Set[allAnimals.length];//unchecked cast
        for (int i = 0; i < animals.length; i++) {
            animals[i] = new HashSet<>();
        }
        for (Animal animal : allAnimals) {
            animals[animal.type.ordinal()].add(animal);
        }
        for (int i = 0; i < animals.length; i++) {
            System.out.printf("i am %s my type is %s%n", Animal.Type.values()[i], animals[i]);
        }
    }

    public static Map<Animal.Type, Set<Animal>> classifyError(Animal[] allAnimals) {
        Map<Animal.Type, Set<Animal>> map = new HashMap<>();
        for (Type type : Type.values()) {
            map.put(type, new HashSet<Animal>());
        }
        for (Animal animal : allAnimals) {
            map.get(animal.type).add(animal);
        }
        return map;
    }

    public static Map<Animal.Type, Set<Animal>> classify(Animal[] allAnimals) {
        Map<Animal.Type, Set<Animal>> map = new EnumMap<>(Animal.Type.class);
        for (Type type : Type.values()) {
            map.put(type, new HashSet<Animal>());
        }
        for (Animal animal : allAnimals) {
            map.get(animal.type).add(animal);
        }
        return map;
    }

    public static void main(String[] args) {
        classifyByArray();
    }
}
