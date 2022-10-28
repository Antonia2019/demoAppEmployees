package com.example.demo.array;


import java.util.Arrays;

public class AddApp {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        MyList myList = new MyList();
        System.out.println(Arrays.toString(myList.add(55, arr)));

        System.out.println(Arrays.toString(myList.get(3, arr)));

        System.out.println(Arrays.toString(myList.remove(0, arr))); //2

    }
}
