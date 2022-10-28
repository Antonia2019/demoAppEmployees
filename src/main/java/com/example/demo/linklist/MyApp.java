package com.example.demo.linklist;

public class MyApp {

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();

        MyLinkedList.add(linkedList,34);
        MyLinkedList.add(linkedList,16);
        MyLinkedList.add(linkedList,58);
        MyLinkedList.add(linkedList,35);
        MyLinkedList.add(linkedList,90);
        MyLinkedList.remove(linkedList,16);
        MyLinkedList.remove(linkedList,1000);

        MyLinkedList.display(linkedList);


    }

}
