package info.parthshah.datastructures;

import java.util.Iterator;

public class HashSet<T> implements Iterable<T> {
    private int capacity = 16;
    private Object[] map;
    private int size;

    public HashSet(){
        map = new Object[capacity];
    }

    public HashSet(int capacity){
        this.capacity = capacity;
        map = new Object[capacity];
    }

    public void add(T data){
        if(contains(data)) return;
        int hash = hashFunction(data);
        if(map[hash] == null) map[hash] = new LinkedList<T>();
        LinkedList<T> list = (LinkedList<T>) map[hash];
        list.append(new ListNode(data));
        size++;
    }

    public boolean contains(T data){
        int hash = hashFunction(data);
        if(map[hash] == null) return false;
        LinkedList<T> list = (LinkedList<T>) map[hash];
        return list.contains(data);
    }

    public T remove(T data){
        int hash = hashFunction(data);
        if(map[hash] == null) throw new IllegalArgumentException(data.toString() + " is not present in the Set!");
        LinkedList<T> list = (LinkedList<T>) map[hash];
        int index = list.getIndexOf(data);
        if(index < 0) throw new IllegalArgumentException(data.toString() + " is not present in the Set!");
        size--;
        return list.remove(index);
    }

    public int size(){
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    public class Itr implements Iterator<T> {
        int next;
        int previous = -1;
        Iterator<T> currentItr;
        LinkedList<T> currentList;

        @Override
        public boolean hasNext() {
            if(currentItr == null){
                currentList = (LinkedList<T>) map[next];
                currentItr = currentList != null ? currentList.iterator() : null;
            }
            while(next < capacity){
                if(currentItr != null && currentItr.hasNext()) return true;
                next++;
                if(next == capacity) return false;
                currentList = (LinkedList<T>) map[next];
                currentItr = currentList != null ? currentList.iterator() : null;
            }
            return false;
        }

        @Override
        public T next() {
            return hasNext() ? currentItr.next() : null;
        }
    }

    private int hashFunction(T data){
        return data.hashCode() % capacity;
    }
}
