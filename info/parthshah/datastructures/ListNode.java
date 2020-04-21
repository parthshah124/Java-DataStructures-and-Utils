package info.parthshah.datastructures;

public class ListNode<T>{
    private T data;
    ListNode next;

    public ListNode(T data){
        this.data = data;
        this.next = null;
    }

    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data = data;
    }
}