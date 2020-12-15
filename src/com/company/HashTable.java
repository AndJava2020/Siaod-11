package com.company;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class HashTable<T> {
    TreeMap<Integer, Set<T>> hashtable;
    HashTable(){
        hashtable=new TreeMap<>();
    }
    public void add(T word){
        int hashCode=hash(word);
        if(hashtable.containsKey(hashCode) &&!hashtable.get(hashCode).contains(word)) {
            System.out.println("err");
            hashtable.get(hashCode).add(word);
        }
        else{
            Set<T>temp= new TreeSet<>();
            temp.add(word);
            hashtable.put(hashCode,temp);
        }
    }
    public void show(){
        for (int t:hashtable.keySet()
        ) {
            System.out.print("Key "+ t+" Values: ");
            Set<T> words= hashtable.get(t);
            for (T g:words
            ) {
                System.out.print(" "+g);
            }
            System.out.println();
        }
        System.out.println();
    }
    public void remove(T word){
        for (int t:hashtable.keySet()
        ) {
            Set<T> words= hashtable.get(t);
            for (T g:words
            ) {
                if(g.equals(word)){
                    words.remove(g);
                    if(words.isEmpty()) hashtable.remove(t);
                    return;
                }
            }
        }
    }
    public void find(T word){
        int hash=hash(word);
        if(hashtable.containsKey(hash)){
            for (T t:hashtable.get(hash)
            ) {
                if(t==word)
                    System.out.println("contains " + word) ;
                    return;

            }
        }
        System.out.println("doesnt contain " + word) ;
    }
    private int hash(T word){
        if(word.getClass() ==new String().getClass()){
            return hashString((String) word);
        }
        else{
            return hashDefault(word);
        }
    }
    private int hashString(String word) {
        int hashCode=0;
        for (int i = 0; i <word.length(); i++) {
            hashCode+=(int)word.charAt(i);
        }
        System.out.println("Key: "+word + " Value: "+hashCode);
        return hashCode;
    }
    private int hashDefault(T word) {
        int hashCode=word.hashCode();
        return hashCode;
    }
}
