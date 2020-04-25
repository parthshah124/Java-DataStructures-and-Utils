package info.parthshah.datastructures;

public class TreeNode<T> {
    private T data;
    private int childCapacity;
    private TreeNode<T>[] children;
    private int childCount;

    public TreeNode(T data, int capacity){
        this.data = data;
        this.childCapacity = capacity;
        this.children = new TreeNode[childCapacity];
    }

    public T getData(){
        return this.data;
    }

    public void setData(T data){
        this.data = data;
    }

    public void addChild(TreeNode node, int index) throws IllegalAccessException {
        if(index >= childCapacity) throw new IndexOutOfBoundsException();
        if(this.children[index] != null) throw new IllegalAccessException();
        else {
            this.children[index] = node;
            childCount++;
        }
    }

    public void setChild(TreeNode node, int index) {
        if(index >= childCapacity) throw new IndexOutOfBoundsException();
        if(this.children[index] == null) childCount++;
        this.children[index] = node;
    }

    public TreeNode[] getChildren(){
        if(isLeaf()) throw new NullPointerException();
        else return this.children;
    }

    public TreeNode getChildAt(int index){
        if(index >= childCapacity) throw new IndexOutOfBoundsException();
        else return this.children[index];
    }

    public TreeNode removeChild(int index){         // Also removes all it's children
        if(index >= childCapacity) throw new IndexOutOfBoundsException();
        if(this.children[index] == null) throw new NullPointerException();
        TreeNode removedNode = this.children[index];
        this.children[index] = null;
        childCount--;
        return removedNode;
    }

    public int getChildCount(){
        return childCount;
    }

    public int getChildCapacity(){
        return childCapacity;
    }

    public boolean isFull(){
        return (childCount >= childCapacity);
    }

    public boolean isLeaf(){
        return (childCount == 0);
    }
}
