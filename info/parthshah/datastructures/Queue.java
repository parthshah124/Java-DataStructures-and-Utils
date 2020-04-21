package info.parthshah.datastructures;

public class Queue<T> {
    private LinkedList<T> queue;

    public Queue(){
        queue = new LinkedList<T>();
    }

    public void enqueue(T data){
        queue.append(new ListNode(data));
    }

    public T dequeue(){
        return queue.remove(0);
    }

    public T peek(){
        return  (T) queue.getHead().getData();
    }

    public int search(T data){
        return queue.getIndexOf(data);
    }

    public int size(){
        return queue.size();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public boolean contains(T data){
        return queue.contains(data);
    }

    public T[] toArray(T[] arr){
        return queue.toArray(arr);
    }
}
