package com.lunzi.spiderboy.bean;

/**
 * Created by lunzi on 2018/12/29 9:37 AM
 */
public class Test11 {
    public static void main(String[] args) {
        new Derived();
    }
}

class Base1 {
    private int i = 2;

    public Base1() {
        this.display();
    }

    public void display() {
        System.out.println(i);
    }
}

class Derived extends Base1 {
    private int i = 22;

    public Derived() {
        super();
        i = 222;
    }

    public void display() {
        System.out.println(i);
    }
}

