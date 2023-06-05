import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        HashMap<String, String> h = new HashMap<String, String>();
        
        int n = sc.nextInt();sc.nextLine();
        String line;
        
        for (int i = 0; i < n; i++){
            line = sc.nextLine();
            String[] splitted = line.split(" ");
            
            if (splitted[0].equals("put")){
                h.put(splitted[1], splitted[2]);
            }else if (splitted[0].equals("print")){
                h.print();
            }
        }
    }
}

class HashMap<K, V>{
    private Entry<K, V>[] table;
    private final int size = 26;
    
    public HashMap(){
        table = new Entry[this.size];
    }
    
    public int hash(K key){
        int hashKey = Math.abs(key.hashCode());
        return hashKey % size;
        
    }
    
    public void put(K key, V value){
        int hashKey = hash(key);
        Entry<K, V> entry = table[hashKey];
        
        if (entry == null){
            table[hashKey] = new Entry<>(key, value);
        }else{
            while (entry.next != null){
                if (entry.getKey() == key){
                    entry.setValue(value);
                    return;
                }
                entry = entry.next;
            }
            
            if (entry.getKey() == key){
                entry.setValue(value);
                return;
            }
            
            entry.next = new Entry<>(key, value);
        }
    }
    
    public Entry<K, V> remove(K key){
        int hashKey = hash(key);
        Entry<K, V> entry = table[hashKey];
        
        if (entry == null){
            return null;
        }
        
        if (entry.getKey() == key){
            table[hashKey] = entry.next;
            entry.next = null;
            return entry;
            
        }
        
        Entry<K, V> prev = entry;
        
        while (entry != null){
            if (entry.getKey() == key){
                prev.next = entry.next;
                entry.next = null;
                return entry;
            }
            prev = entry;
            entry = entry.next;
        }
        
        return null;
    }
    
    public void print(){
        for (int i = 0; i < size; i++){
            System.out.print("-- "+ i + ": ");
            Entry<K, V> entry = table[i];
            while(entry != null){
                System.out.print(entry.getKey() + ", " + entry.getValue());
            }
            System.out.println();
        }
    }
}

class Entry<K, V>{
    private K key;
    private V value;
    Entry<K, V> next;

    public Entry(K key, V value){
        this.key = key;
        this.value = value;
    }
    
    public K getKey(){
        return key;
    }
    
    public void setKey(K key){
        this.key = key;
    }
    
    public V getValue(){
        return value;
    }
    
    public void setValue(V value){
        this.value = value;
    }
}