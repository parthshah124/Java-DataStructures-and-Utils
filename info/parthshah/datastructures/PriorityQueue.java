package info.parthshah.datastructures;

public class PriorityQueue<T extends Comparable<T>> {
    private ArrayList<T> queue;

    public PriorityQueue(){
        queue = new ArrayList<T>();
    }

    public void enqueue(T data){
        queue.add(data);
        bubbleUp(queue.size() - 1);
    }

    public T dequeue(){
        T result = queue.get(0);
        queue.setElementAt(0, queue.get(queue.size() - 1));
        queue.remove(queue.size() - 1);
        bubbleDown(0);
        return result;
    }

    public T peek(){
        return queue.get(0);
    }

    public boolean contains(T data){
        return queue.contains(data);
    }

    public int size(){
        return queue.size();
    }

    public boolean isEmpty(){
        return (queue.size() == 0);
    }

    private void bubbleUp(int index){
        if(index == 0) return;
        int parentIndex = (index%2 == 0) ? index/2 - 1 : index/2;
        if(queue.get(parentIndex).compareTo(queue.get(index)) > 0){
            swap(parentIndex, index);
            bubbleUp(parentIndex);
        }
    }

    private void bubbleDown(int index){
        int minChildIndex = getMinChildIndex(index);
        if(minChildIndex == -1) return;
        if(queue.get(minChildIndex).compareTo(queue.get(index)) < 0){
            swap(minChildIndex, index);
            bubbleDown(minChildIndex);
        }
    }

    private void swap(int index1, int index2){
        T temp = queue.get(index1);
        queue.setElementAt(index1, queue.get(index2));
        queue.setElementAt(index2, temp);
    }

    private int getMinChildIndex(int index){
        T leftData = null;
        T rightData = null;
        if(index*2+1 < size()) leftData = queue.get(index*2+1);
        if(index*2+2 < size()) rightData = queue.get(index*2+2);
        if(leftData == null) return -1;
        if(rightData == null) return index*2+1;
        return (leftData.compareTo(rightData) < 0) ? index*2+1 : index*2+2;
    }
}
