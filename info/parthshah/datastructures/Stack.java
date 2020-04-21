package info.parthshah.datastructures;

import java.util.EmptyStackException;
import info.parthshah.utils.Arrays;

public class Stack<T> {
    private ArrayList<T> stack;

    public Stack(){
        stack = new ArrayList<T>();
    }

    public void push(T data){
        stack.add(data);
    }

    public T pop(){
        if(!isEmpty()){
            return stack.remove(stack.size() - 1);
        } else {
            throw new EmptyStackException();
        }
    }

    public T peek(){
        if(!isEmpty()){
            return stack.get(stack.size() - 1);
        } else {
            throw new EmptyStackException();
        }
    }

    public boolean isEmpty(){
        return stack.size() == 0;
    }

    public boolean contains(T data){
        return stack.contains(data);
    }

    public int search(T data){
        return stack.getIndexOf(data) >=0 ? stack.size() - 1 - stack.getIndexOf(data) : -1;
    }

    public int size(){
        return stack.size();
    }

    public T[] toArray(T[] arr){
        T[] result = stack.toArray(arr);
        Arrays.reverse(result);
        return result;
    }
}