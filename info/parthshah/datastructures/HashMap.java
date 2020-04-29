package info.parthshah.datastructures;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.HashSet;
import java.util.Iterator;

public class HashMap<K, V> {
    private int capacity = 16;
    private Object[] map;
    private int size;

    public HashMap(){
        map = new Object[capacity];
    }

    public HashMap(int capacity){
        this.capacity = capacity;
        map = new Object[capacity];
    }

    public HashSet<K> keySet(){
        if(size == 0) return null;
        HashSet<K> result = new HashSet<K>();
        for(Object list: map){
            if(list != null){
                LinkedList<MapNode<K, V>> mapNodeList = (LinkedList<MapNode<K, V>>) list;
                Iterator<MapNode<K,V>> i = mapNodeList.iterator();
                while (i.hasNext()){
                    result.add(i.next().key);
                }
            }
        }
        return result;
    }

    public void put(K key, V value){
        if(containsKey(key)) throw new KeyAlreadyExistsException();
        int hash = hashFunction(key);
        if(map[hash] == null) map[hash] = new LinkedList<MapNode<K, V>>();
        LinkedList<MapNode<K,V>> list = (LinkedList<MapNode<K, V>>) map[hash];
        list.append(new ListNode(new MapNode<K, V>(key, value)));
        size++;
    }

    public V get(K key){
        int hash = hashFunction(key);
        if(map[hash] == null) return null;
        LinkedList<MapNode<K,V>> list = (LinkedList<MapNode<K, V>>) map[hash];
        Iterator<MapNode<K,V>> i = list.iterator();
        while(i.hasNext()){
            MapNode node = i.next();
            if(node.key.equals(key)) return (V) node.value;
        }
        return null;
    }

    public boolean containsKey(K key){
        return (get(key) != null);
    }

    public V remove(K key){
        int hash = hashFunction(key);
        if(map[hash] == null) return null;
        LinkedList<MapNode<K,V>> list = (LinkedList<MapNode<K, V>>) map[hash];
        Iterator<MapNode<K,V>> i = list.iterator();
        while(i.hasNext()){
            MapNode node = i.next();
            if(node.key.equals(key)) {
                list.remove(list.getIndexOf(node));
                size--;
                return (V) node.value;
            }
        }
        return null;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public void clear(){
        map = (LinkedList<MapNode<K, V>>[]) new Object[capacity];
    }

    private int hashFunction(K key){
        return key.hashCode() % capacity;
    }
}

class MapNode<K,V>{
    K key;
    V value;
    public MapNode(K key, V value){
        this.key = key;
        this.value = value;
    }
}
