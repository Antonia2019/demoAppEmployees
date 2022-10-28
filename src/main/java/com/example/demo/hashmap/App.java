package com.example.demo.hashmap;

public class App {

    public static void main(String[] args) {
        MyHashMap<String, String> myMap = new MyHashMap<>();
        myMap.put("Ionel","23000");
        myMap.put("Oana","23001");
        myMap.put("Silviu","23002");
        myMap.put("Mihai","23003");
        myMap.put("Silviu","23022");
        System.out.println(myMap.get("Oana"));
        myMap.display();


    }
}
