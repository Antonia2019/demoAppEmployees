package com.example.demo;

import com.example.demo.address.Address;
import com.example.demo.employee.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;


public class JsonDemo {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {

        Employee employee1 = new Employee(
                "George", 2500L, "Intern", new Address("Ilfov", "Voda", 5));
        Employee employee2 = new Employee(
                "Mihai", 3500L, "Junior", new Address("Iasi", "M", 35));
        Employee employee3 = new Employee(
                "Ionut", 22500L, "Senior", new Address("Bucuresti", "Tepes", 25));



        // 1. de vazut reflection si facut o mapare 1 - 1 cu reflection intre o tabela de DB si o clasa java



        // 2. de facut cu reflecsion generarea unui JSON dintr-un DTO object
        Field[] employeeFields = employee1.getClass().getDeclaredFields();
        StringBuilder json = new StringBuilder("{");
        for (Field employeeF : employeeFields) {
            json.append(employeeF.getName()).append(":"); //.append(employeeF.get(employee)).append("}");
            employeeF.setAccessible(true);
            if (employeeF.getType().equals(String.class)) {
                json.append("\"").append(employeeF.get(employee1)).append("\", ");
            }
            if (employeeF.getType().equals(Long.class)) {
                json.append("\"").append(employeeF.get(employee1)).append("\", ");
            }
            if (employeeF.getType().equals(String.class)) {
                json.append("\"").append(employeeF.get(employee1)).append("\", ");
            }
            if (employeeF.getType().equals(Address.class)) {
                json.append("\"").append(employeeF.get(employee1)).append("\"}");
            }
        }
        System.out.println(json);




        // 3. De implementat my own arraylist, linked list, hashmap

        //arraylist
        Method methodArrayList = Class.forName("java.util.ArrayList").getMethod("add", Object.class);
        ArrayList<String> arr = new ArrayList<>();
        methodArrayList.invoke(arr,employee1.getName());
        methodArrayList.invoke(arr,employee2.getName());
        methodArrayList.invoke(arr,employee3.getName());
        System.out.println("ArrayList: "+ arr);

        // linked list
        Method methodLinkedList = Class.forName("java.util.LinkedList").getMethod("add", Object.class);
        LinkedList<String> linkedList = new LinkedList<>();
        methodLinkedList.invoke(linkedList, employee1.getName());
        methodLinkedList.invoke(linkedList, employee2.getName());
        methodLinkedList.invoke(linkedList, employee3.getName());
        System.out.println("linkedList: " + linkedList);

        // hashmap
        Method methodHashMap = Class.forName("java.util.HashMap").getMethod("put", Object.class, Object.class);
        Map<String, String> hm = new HashMap<>();
        methodHashMap.invoke(hm, employee1.getId(), employee1.getName());
        methodHashMap.invoke(hm, employee2.getId(), employee2.getName());
        methodHashMap.invoke(hm, employee3.getId(), employee3.getName());
        System.out.println("hashmap: " + hm);



        // ObjectMapper!!!!
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            Employee angajat = new Employee(
                    "Mihai",
                    2500l,
                    "Java Dev Intern",
                    new Address("Oradea","Viilor", 25));
            objectMapper.writeValue(new File("C:\\Users\\AntoniaNicorescu\\Desktop\\demo\\src\\main\\resources\\static\\emp.json"), angajat);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
