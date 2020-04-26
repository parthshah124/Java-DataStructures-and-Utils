package info.parthshah.datastructures;

public class BinaryTreeNode<T> extends TreeNode<T> {

    public BinaryTreeNode(T data) {
        super(data, 2);
    }

    public BinaryTreeNode getLeftChild(){
        return (BinaryTreeNode) this.getChildAt(0);
    }

    public BinaryTreeNode getRightChild(){
        return (BinaryTreeNode) this.getChildAt(1);
    }

    public void setLeftChild(BinaryTreeNode node) {
        this.setChild(node, 0);
    }

    public void setRightChild(BinaryTreeNode node){
        this.setChild(node, 1);
    }
}
