package info.parthshah.datastructures;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

// iterator
public class LinkedList<T> implements Iterable<T>{
    private ListNode<T> head;
    private ListNode<T> tail;
    private int size;
    private int mods;

    public LinkedList(){

    }
    public LinkedList(T[] array){
        for(T element : array){
            this.append(new ListNode(element));
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public void append(ListNode node){
        if(isEmpty()){
            head = node;
            tail = head;
        } else {
            tail.next = node;
            tail = tail.next;
        }
        size++;
        mods++;
    }

    public void addInFront(ListNode node){
        if(isEmpty()){
            head = node;
            tail = head;
        } else {
            node.next = head;
            head = node;
        }
        size++;
        mods++;
    }

    public ListNode getHead(){
        if(isEmpty()) throw new NullPointerException();
        else return head;
    }

    public ListNode getTail(){
        if(isEmpty()) throw new NullPointerException();
        else return tail;
    }

    public ListNode get(int index){
        if(isEmpty()) throw new NullPointerException();
        if(index >= size) throw new IndexOutOfBoundsException();
        ListNode result = head;
        for(int i=0; i < index; i++){
            result = result.next;
        }
        return result;
    }

    public T getData(int index){
        ListNode resultNode = get(index);
        return (T)resultNode.getData();
    }

    public int getIndexOf(T data){
        ListNode node = head;
        for(int i=0; i < size; i++, node = node.next){
            if(node.getData().equals(data)) return i;
        }
        return -1;
    }

    public boolean contains(T data){
        return getIndexOf(data) != -1 ? true : false;
    }

    public void addAtIndex(ListNode node, int index){
        if(index < 0) throw new IndexOutOfBoundsException();
        if(index == 0) addInFront(node);
        else if(index == size) append(node);
        else if(index > size) throw new IndexOutOfBoundsException();
        else{
            ListNode before = get(index - 1);
            ListNode after = before.next;
            before.next = node;
            node.next = after;
            size++;
            mods++;
        }
    }

    public void addAtIndex(T data, int index){
        addAtIndex(new ListNode(data), index);
    }

    public T remove(int index){
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
        ListNode result;
        if(index == 0){
            result = head;
            head = head.next;
        } else {
            ListNode before = get(index - 1);
            result = before.next;
            before.next = before.next.next;
        }
        size--;
        mods++;
        return (T) result.getData();
    }

    public T[] toArray(T[] arr){
        if(arr.length < size) throw new ArrayIndexOutOfBoundsException();
        ListNode node = head;
        for(int i=0; i<size; i++){
            arr[i] = (T) node.getData();
            node = node.next;
        }
        return arr;
    }

    public Iterator<T> iterator(){
        return new LinkedList.Itr();
    }

    public class Itr implements Iterator<T> {
        ListNode<T> node = head;
        int expectedMods = mods;

        @Override
        public boolean hasNext() {
            checkForModifications();
            return node != null;
        }

        @Override
        public T next() {
            checkForModifications();
            if(node != null){
                T result = node.getData();
                node = node.next;
                return result;
            }
            else throw new NoSuchElementException();
        }

        private void checkForModifications(){
            if(expectedMods != mods) throw new ConcurrentModificationException();
        }
    }
}
