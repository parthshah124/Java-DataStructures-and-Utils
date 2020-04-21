package info.parthshah.datastructures;

public class ListNode<T>{
    T data;
    ListNode next;

    public ListNode(T data){
        this.data = data;
        this.next = null;
    }

    public T getData(){
        return data;
    }
}