package com.example.demo.linklist;

public class MyLinkedList {

    public Node head;

    public MyLinkedList() {

    }

    public static void add(MyLinkedList list, int data) {
        Node new_node = new Node(data);

        if (list.head == null) {
            list.head = new_node;

        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
    }


    public static void remove(MyLinkedList list, int value) {
        Node currNode = list.head;
        Node prev = null;
        if (currNode != null && currNode.data == value) {
            list.head = currNode.next;
            return;
        }

        while (currNode != null && currNode.data != value) {
            prev = currNode;
            currNode = currNode.next;
        }

        if (currNode != null) {
            prev.next = currNode.next;
        }

        if (currNode == null) {
            System.out.println(value + " not found");
        }
    }

    public static void display(MyLinkedList list) {
        Node currNode = list.head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

}
