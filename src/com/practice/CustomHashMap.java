package com.practice;

public class CustomHashMap<K,V> {

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    Node<K,V>[] table = new Node[DEFAULT_INITIAL_CAPACITY];

    static int size = 0;
    public V put(K key, V val){

        int hashCode = hash(key);
        Node<K,V> node = new Node<>(key,val,hashCode,null);
        int index = (DEFAULT_INITIAL_CAPACITY-1)&hashCode;
        if(table[index]==null){
            table[index] = node;
            size++;
        }
        else{
            if(key.equals(table[index].getKey()) && hashCode==table[index].hash)
                table[index].value = val;
            else {
                Node<K, V> temp = table[index];
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = node;
                table[index] = temp;
                size++;
            }
        }
        return val;
    }

    public V get(K key){
        int hashCode = hash(key);
        for(int i=0;i<table.length;i++){
            if(table[i]==null)
                continue;
            Node<K,V> node = table[i];
            while(node!=null){
                if(key.equals(node.getKey()) && hashCode==node.hash){
                    return node.value;
                }
                node = node.next;
            }
        }
        return null;
    }

    public int size(){
        return size;
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static class Node<K,V>{

        K key;
        V value;
        int hash;
        Node<K,V> next;

        public Node(K key, V value, int hash, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
