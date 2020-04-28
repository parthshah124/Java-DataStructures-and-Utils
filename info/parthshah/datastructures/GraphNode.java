package info.parthshah.datastructures;

public class GraphNode<T> {
    private T data;
    private ArrayList<GraphNode<T>> neighbors;

    public GraphNode(T data) {
        this.data = data;
        this.neighbors = new ArrayList<GraphNode<T>>();
    }

    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data = data;
    }

    public void addNeighbor(T data) {
        this.neighbors.add(new GraphNode<T>(data));
    }

    public void addNeighbor(GraphNode<T> node) {
        this.neighbors.add(node);
    }

    public void removeNeighbor(T data){
        for(int i=0; i<neighbors.size(); i++){
            if(neighbors.get(i).data == data){
                neighbors.remove(i);
                return;
            }
        }
    }

    public void removeNeighbor(GraphNode<T> node){
        if(neighbors.contains(node)){
            neighbors.remove(neighbors.getIndexOf(node));
        }
        else
            throw new IllegalArgumentException();
    }
}
