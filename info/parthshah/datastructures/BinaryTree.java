package info.parthshah.datastructures;

public class BinaryTree<T> {

    private BinaryTreeNode<T> root;

    public BinaryTree(T rootData) {
        this.root = new BinaryTreeNode<T>(rootData);
    }

    public BinaryTree(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public BinaryTreeNode<T> getRoot() { return root; }

    public void setRoot(BinaryTreeNode<T> node){
        this.root = node;
    }

    public void updateRootData(T data){
        root.setData(data);
    }

    public boolean contains(T data){
        if (this.root == null) return false;
        if (this.root.getData().equals(data)) return true;
        else return (new BinaryTree<T>(root.getLeftChild()).contains(data) || new BinaryTree<T>(root.getRightChild()).contains(data));
    }

    public ArrayList<T> inOrderTraversal(){
        ArrayList<T> result = new ArrayList<T>();
        inOrderHelper(result, root);
        return result;
    }

    private void inOrderHelper(ArrayList<T> result, BinaryTreeNode<T> root) {
        if (root == null) return;
        inOrderHelper(result, root.getLeftChild());
        result.add(root.getData());
        inOrderHelper(result, root.getRightChild());
    }

    public ArrayList<T> preOrderTraversal(){
        ArrayList<T> result = new ArrayList<T>();
        preOrderHelper(result, root);
        return result;
    }

    private void preOrderHelper(ArrayList<T> result, BinaryTreeNode<T> root) {
        if (root == null) return;
        result.add(root.getData());
        preOrderHelper(result, root.getLeftChild());
        preOrderHelper(result, root.getRightChild());
    }

    public ArrayList<T> postOrderTraversal(){
        ArrayList<T> result = new ArrayList<T>();
        postOrderHelper(result, root);
        return result;
    }

    private void postOrderHelper(ArrayList<T> result, BinaryTreeNode<T> root) {
        if (root == null) return;
        postOrderHelper(result, root.getLeftChild());
        postOrderHelper(result, root.getRightChild());
        result.add(root.getData());
    }
}