package info.parthshah.datastructures;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T>{
    public BinarySearchTree(T rootData) {
        super(rootData);
    }

    public BinarySearchTree(BinaryTreeNode<T> root) {
        super(root);
    }

    @Override
    public boolean contains(T data){
        if(this.getRoot() == null) return false;
        BinaryTreeNode<T> node = this.getRoot();
        if(node.getData().equals(data)) return true;
        else{
            if(node.getData().compareTo(data) > 0){
                return (new BinarySearchTree<T>(this.getRoot().getLeftChild()).contains(data));
            } else {
                return (new BinarySearchTree<T>(this.getRoot().getRightChild()).contains(data));
            }
        }
    }

    public void add(BinaryTreeNode<T> node){
         if(node.getData().compareTo(this.getRoot().getData()) < 0){
             if (this.getRoot().getLeftChild() == null) {
                 this.getRoot().setLeftChild(node);
             }
             else {
                 new BinarySearchTree<T>(this.getRoot().getLeftChild()).add(node);
             }
         } else {
             if (this.getRoot().getRightChild() == null) {
                 this.getRoot().setRightChild(node);
             }
             else {
                 new BinarySearchTree<T>(this.getRoot().getRightChild()).add(node);
             }
         }
    }

    public void delete(T data){
        if(!this.contains(data)) return;
        if(this.getRoot().getData().equals(data)){
            deleteRoot();
            return;
        }
        BinaryTreeNode<T> parent = this.findParent(data);
        if(parent.getLeftChild() != null && parent.getLeftChild().getData().equals(data)){
            if (parent.getLeftChild().getLeftChild() == null){
                parent.setLeftChild(parent.getLeftChild().getRightChild());
                return;
            }
            else if (parent.getLeftChild().getRightChild() == null){
                parent.setLeftChild(parent.getLeftChild().getLeftChild());
                return;
            }
            else {
                if(parent.getLeftChild().getRightChild().getLeftChild() == null){
                    parent.getLeftChild().getRightChild().setLeftChild(parent.getLeftChild().getLeftChild());
                    parent.setLeftChild(parent.getLeftChild().getRightChild());
                    return;
                }
                BinaryTreeNode<T> successor = findSuccessor(parent.getLeftChild());
                parent.getLeftChild().setData(successor.getData());
                BinarySearchTree<T> temp = new BinarySearchTree<T>(parent.getLeftChild().getRightChild());
                temp.delete(data);
                return;
            }
        }
        else {
            if (parent.getRightChild().getLeftChild() == null){
                parent.setRightChild(parent.getRightChild().getRightChild());
                return;
            }
            else if (parent.getRightChild().getRightChild() == null){
                parent.setRightChild(parent.getRightChild().getLeftChild());
                return;
            }
            else {
                if(parent.getRightChild().getRightChild().getLeftChild() == null){
                    parent.getRightChild().getRightChild().setLeftChild(parent.getRightChild().getLeftChild());
                    parent.setRightChild(parent.getRightChild().getRightChild());
                    return;
                }
                BinaryTreeNode<T> successor = findSuccessor(parent.getRightChild());
                parent.getRightChild().setData(successor.getData());
                BinarySearchTree<T> temp = new BinarySearchTree<T>(parent.getRightChild().getRightChild());
                temp.delete(data);
                return;
            }
        }
    }

    private BinaryTreeNode<T> findParent(T data){
        if ((this.getRoot().getLeftChild() != null && this.getRoot().getLeftChild().getData().equals(data))
            || (this.getRoot().getRightChild() != null && this.getRoot().getRightChild().getData().equals(data))){
            return this.getRoot();
        }
        else if (this.getRoot().getLeftChild() != null && this.getRoot().getData().compareTo(data) > 0){
            return (new BinarySearchTree<T>(getRoot().getLeftChild()).findParent(data));
        } else if (this.getRoot().getRightChild() != null && this.getRoot().getData().compareTo(data) < 0){
            return (new BinarySearchTree<T>(getRoot().getRightChild()).findParent(data));
        }
        return null;
    }

    private void deleteRoot(){
        if(this.getRoot().getLeftChild() == null && this.getRoot().getRightChild() == null){
            this.setRoot(null);
        }
        else if (this.getRoot().getRightChild() == null){
            this.setRoot(this.getRoot().getLeftChild());
        }
        else if (this.getRoot().getLeftChild() == null){
            this.setRoot(this.getRoot().getRightChild());
        }
        else {
            BinaryTreeNode<T> successor = findSuccessor(this.getRoot());
            this.getRoot().setData(successor.getData());
            BinarySearchTree<T> tempTree = new BinarySearchTree<T>(this.getRoot().getRightChild());
            tempTree.delete(successor.getData());
            this.getRoot().setRightChild(tempTree.getRoot());
        }
    }

    private BinaryTreeNode<T> findSuccessor(BinaryTreeNode<T> node){
        node = node.getRightChild();
        while(node.getLeftChild() != null){
            node = node.getLeftChild();
        }
        return node;
    }
}
