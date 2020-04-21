package info.parthshah.datastructures;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<T> {
    public static final int INITIAL_SIZE = 10;
    public static final int INCREMENTS = 10;
    private int size;
    private Object[] array;
    private int mods;

    public ArrayList(){
        array = new Object[INITIAL_SIZE];
    }

    public void add(T element){
        if(size >= array.length){
            increaseCapacity();
        }
        array[size] = element;
        size++;
        mods++;
    }

    private void increaseCapacity(){
        array = Arrays.copyOf(array, size + INCREMENTS);
    }

    public boolean contains(T element){
        return getIndexOf(element) >= 0;
    }

    public int size(){
        return size;
    }

    public T get(int index){
        if(index >= size) throw new IndexOutOfBoundsException();
        return (T)array[index];
    }

    public T remove(int index){
        if(index >= size) throw new IndexOutOfBoundsException();
        T data = (T)array[index];
        System.arraycopy(array, index+1, array, index, size-index-1);
        size--;
        array[size] = null;
        mods++;
        return data;
    }

    public int getIndexOf(T element){
        for(int i=0; i<size; i++){
            if(element.equals(array[i])) return i;
        }
        return -1;
    }

    public T[] toArray(T[] arr){
        if(arr.length < size) throw new ArrayIndexOutOfBoundsException();
        System.arraycopy(array, 0, arr, 0, size);
        return arr;
    }

    public Iterator<T> iterator(){
        return new Itr();
    }

    public class Itr implements Iterator<T>{

        int next;
        int previous = -1;
        int expectedMods = mods; //For fast fail.

        @Override
        public boolean hasNext() {
            checkForModifications();
            return next != size;
        }

        @Override
        public T next() {
            checkForModifications();
            if(next >= size) throw new NoSuchElementException();
            previous = next;
            next++;
            return (T)array[previous];
        }

        private void checkForModifications(){
            if(expectedMods != mods) throw new ConcurrentModificationException();
        }
    }

}
