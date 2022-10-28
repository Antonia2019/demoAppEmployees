package com.example.demo.exercices.array;

public class MyList {

                                              //de fiecare data cand data este plina, trebuie sa ii crestem dimensiunea

    // PT ARRAYLIST
    public int[] add(int val, int[] arr) {
        // val =  elemetul ce trebuie adaugat
        int n = arr.length;

        int[] newarr = new int[n + 1]; // marim arr + 1

        for (int i = 0; i < n; i++) {
            newarr[i] = arr[i];
        }
        newarr[n] = val;
        return newarr;
    }

    public int[] get(int pos, int[] arr) {
        return new int[]{arr[pos]};
    }

    public int[] remove(int pos, int[] arr){
        int[] newarr = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != pos) {
                newarr[j++]=arr[i];
            }
        }
        return newarr;
    }

    // PT LINKLIST
    public int[] addL(int val, int[] arr) {
        
        return null;
    }



}
