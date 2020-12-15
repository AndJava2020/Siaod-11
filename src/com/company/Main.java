package com.company;

public class Main {

    public static void main(String[] args) {
        HashTable main=new HashTable();
        main.add("abc");
        main.add("efg");
        main.add("kekw");
        main.add("hello");
        System.out.println();
        main.find("kekw");
        main.show();
        System.out.println();
        main.remove("abc");
        main.remove("efg");
        main.find("abc");
        main.show();
        System.out.println();
        main.add("abc");
        main.add("efg");
        main.show();
        main.find("abc");
        main.find("efg");
        main.show();
    }
}
