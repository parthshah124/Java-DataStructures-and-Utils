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

    public void addChild(TreeNode node){
        if(isFull()) throw new IndexOutOfBoundsException();
        else {
            this.children[childCount] = node;
            childCount++;
        }
    }

    public TreeNode[] getChildren(){
        if(isLeaf()) throw new NullPointerException();
        else return this.children;
    }

    public TreeNode getChildAt(int index){
        if(index >= childCount) throw new IndexOutOfBoundsException();
        else return this.children[index];
    }

    public TreeNode removeChild(int index){
        if(index >= childCount) throw new IndexOutOfBoundsException();
        TreeNode removedNode = this.children[index];
        if(index == childCount - 1){
            this.children[index] = null;
        } else {
            for(int i = index; i < childCount - 1 && children[i] != null; i++){
                this.children[i] = this.children[i+1];
            }
        }
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
