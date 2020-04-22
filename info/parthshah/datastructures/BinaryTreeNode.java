package info.parthshah.datastructures;

public class BinaryTreeNode<T> extends TreeNode<T> {

    public BinaryTreeNode(T data) {
        super(data, 2);
    }

    public BinaryTreeNode getLeftChild(){
        if(this.getChildAt(0).getClass() != BinaryTreeNode.class){
            throw new ClassCastException();
        }
        return (BinaryTreeNode) this.getChildAt(0);
    }

    public BinaryTreeNode getRightChild(){
        if(this.getChildAt(1).getClass() != BinaryTreeNode.class){
            throw new ClassCastException();
        }
        return (BinaryTreeNode) this.getChildAt(1);
    }

    public void setLeftChild(BinaryTreeNode node){

    }

    public void setRightChild(BinaryTreeNode node){

    }
}
