package com.blackfish.java.generic.boundary;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/5/7 10:35
 * @Description:
 */
public class Test {

//    public static <T> void eatFruit(Box<T> t ){
//        System.out.println("eat "+ t.toString());
//    }

//    public static void eatFruit(Box<Fruit> t ){
//        System.out.println("eat "+ t.getT().getName());
//    }

    public static void eatFruit(Box<? extends Fruit> t ){
        System.out.println("eat "+ t.getT().getName());
    }

    public static void main(String[] args) {
        Box<Fruit> fruitBox = new Box<>();
        Box<Apple> appleBox = new Box<>();
        Fruit fruit = new Fruit("水果");
        fruitBox.setT(fruit);
        Test.eatFruit(fruitBox);

        Apple apple = new Apple("苹果");
        appleBox.setT(apple);
        Test.eatFruit(appleBox);

        fruitBox.setT(apple);
        Test.eatFruit(fruitBox);

        Box<? extends Fruit> box1 = new Box<Apple>();
        Box<? extends Fruit> box2 = new Box<Fruit>();
//        box1.setT(new Apple(""));
//        box2.setT(new Fruit(""));

        Box<? super Fruit> box3 = new Box<Fruit>();
        Box<? super Fruit> box4 = new Box<Object>();
        box3.setT(new Fruit("123"));
        System.out.println(box3.getT());


        Object[] strings = new String[2];
        strings[0]="sdf";
        strings[1]=123;


    }

}
