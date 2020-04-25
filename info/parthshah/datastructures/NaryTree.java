package info.parthshah.datastructures;

public class NaryTree<T> {
    private TreeNode<T> root;
    private int n;

    public NaryTree(int n, T rootData){
        this.n = n;
        this.root = new TreeNode(rootData, n);
    }

    public TreeNode<T> getRoot(){
        return root;
    }

    public void updateRootData(T data){
        root.setData(data);
    }

    public int getN(){
        return n;
    }

    public boolean contains(T data){
        Queue<TreeNode<T>> queue = new Queue<TreeNode<T>>();
        queue.enqueue(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.dequeue();
            if(node.getData().equals(data)) return true;
            else if(!node.isLeaf()){
                for(TreeNode child : node.getChildren()){
                    if(child != null) queue.enqueue(child);
                }
            }
        }
        return false;
    }

    public ArrayList<T> bfs(){
        ArrayList<T> result = new ArrayList<T>();
        Queue<TreeNode<T>> queue = new Queue<TreeNode<T>>();
        queue.enqueue(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.dequeue();
            result.add((T) node.getData());
            if(!node.isLeaf()){
                for(TreeNode child : node.getChildren()){
                    if(child != null) queue.enqueue(child);
                }
            }
        }
        return result;
    }

    public ArrayList<T> dfs(){
        ArrayList<T> result = new ArrayList<T>();
        dfsHelper(result, root);
        return result;
    }

    private void dfsHelper(ArrayList<T> arr, TreeNode<T> node){
        arr.add(node.getData());
        if(!node.isLeaf()){
            for(TreeNode<T> child : node.getChildren()) {
                if(!node.isLeaf() && child != null){
                    dfsHelper(arr, child);
                }
            }
        }
    }
}
