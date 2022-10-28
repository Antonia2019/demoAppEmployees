package com.example.demo.exercices.hashmap;


public class MyHashMap<K, V> {
    private final Entry<K, V>[] table;   //Array of Entry.
    private final int capacity = 4;  //Initial capacity of HashMap

    static class Entry<K, V> { // entry class
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public MyHashMap() {
        table = new Entry[capacity];
    }

    public void put(K newKey, V data) { // put method
        if (newKey == null)
            return;    //does not allow to store null.
        //calculate hash of key.
        int hash = hash(newKey);
        //create new entry.
        Entry<K, V> newEntry = new Entry<>(newKey, data, null);
        //if table location does not contain any entry, store entry there.
        if (table[hash] == null) {
            table[hash] = newEntry;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];
            while (current != null) { //we have reached last entry of bucket.
                if (current.key.equals(newKey)) {
                    if (previous == null) {  //node has to be insert on first of bucket.
                        newEntry.next = current.next;
                        table[hash] = newEntry;
                        return;
                    } else {
                        newEntry.next = current.next;
                        previous.next = newEntry;
                        return;
                    }
                }
                previous = current;
                current = current.next;
            }
            assert previous != null;
            previous.next = newEntry;
        }

    }

    public V get(K key) {     // method
        int hash = hash(key);
        if (table[hash] == null) {
            return null;
        } else {
            Entry<K, V> temp = table[hash];
            while (temp != null) {
                if (temp.key.equals(key))
                    return temp.value;
                temp = temp.next; //return value corresponding to key.
            }
            return null;   //returns null if key is not found.
        }
    }


    private int hash(K key) { //calculate hash of key
        return Math.abs(key.hashCode()) % capacity;
    }

    public void display() {
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                Entry<K, V> entry = table[i];
                while (entry != null) {
                    System.out.print("{" + entry.key + "=" + entry.value + "}" + " ");
                    entry = entry.next;
                }
            }
        }
    }
}