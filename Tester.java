import info.parthshah.datastructures.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        System.out.println("What do you want to test? (type the index and press enter)");
        System.out.println("1. ArrayList");
        System.out.println("2. LinkedList");
        System.out.println("3. Stack");
        System.out.println("4. Queue");
        System.out.println("5. N-ary Tree");
        System.out.println("6. Binary Tree");
        System.out.println("7. Binary Search Tree");
        System.out.println("8. HashMap");
        System.out.println("9. Priority Queue");
        System.out.println("10. Trie");

        //Scanner input = new Scanner( System.in );
        //int index = input.nextInt();
        int index = 9;

        switch (index){
            case 1:
                ArrayListTester();
                break;
            case 2:
                LinkedListTester();
                break;
            case 3:
                StackTester();
                break;
            case 4:
                QueueTester();
                break;
            case 5:
                NaryTreeTester();
                break;
            case 6:
                BinaryTreeTester();
                break;
            case 7:
                BSTTester();
                break;
            case 8:
                HashMapTester();
                break;
            case 9:
                PriorityQueueTester();
                break;
            case 10:
                TrieTester();
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }

    private static void ArrayListTester(){
        ArrayList<Integer> myArrayList = new ArrayList<Integer>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        System.out.print(myArrayList.get(0) + " ");
        System.out.print(myArrayList.get(1) + " ");
        System.out.print(myArrayList.get(2) + " ");
        System.out.print(myArrayList.get(3) + " ");
        //System.out.print(myArrayList.get(4) + " ");
        System.out.println();
        myArrayList.remove(0);
        System.out.print(myArrayList.get(0) + " ");
        System.out.print(myArrayList.get(1) + " ");
        System.out.print(myArrayList.get(2) + " ");
        //System.out.print(myArrayList.get(3) + " ");
        System.out.println();
        System.out.println("Size: " + myArrayList.size());
        System.out.println("Does contain 1: " + myArrayList.contains(1));
        System.out.println("Does contain 2: " + myArrayList.contains(2));

        Integer[] arr = new Integer[myArrayList.size()];
        arr = myArrayList.toArray(arr);
        for(Integer i : arr){
            System.out.print(i + " ");
        }

        Iterator<Integer> i = myArrayList.iterator();
        while (i.hasNext()){
            System.out.print(i.next() + " ");
        }
    }

    private static void LinkedListTester(){
        LinkedList<Integer> myLinkedList = new LinkedList<Integer>();
        myLinkedList.append(new ListNode(1));
        myLinkedList.append(new ListNode(2));
        myLinkedList.addInFront(new ListNode(3));
        myLinkedList.append(new ListNode(4));
        myLinkedList.addInFront(new ListNode(5));
        myLinkedList.addAtIndex(9, 5);
        Integer[] arr = new Integer[myLinkedList.size()];
        arr = myLinkedList.toArray(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println("Head: " + myLinkedList.getHead().getData());
        System.out.println("Tail: " + myLinkedList.getTail().getData());
        System.out.println("Size: " + myLinkedList.size());
        System.out.println("Index of: " + myLinkedList.getIndexOf(11));

        myLinkedList.remove(5);
        arr = new Integer[myLinkedList.size()];
        arr = myLinkedList.toArray(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();

        myLinkedList.remove(0);
        arr = new Integer[myLinkedList.size()];
        arr = myLinkedList.toArray(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();

        myLinkedList.remove(2);
        arr = new Integer[myLinkedList.size()];
        arr = myLinkedList.toArray(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }

        System.out.println();
        myLinkedList = new LinkedList<Integer>(new Integer[]{1,2,3,4,5});
        Iterator<Integer> i = myLinkedList.iterator();
        while (i.hasNext()){
            System.out.print(i.next() + " ");
        }
    }

    private static void StackTester(){
        Stack<Integer> myStack = new Stack<Integer>();
        System.out.println("is Empty?: " + myStack.isEmpty());
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println("size: " + myStack.size());
        System.out.println("popping " + myStack.pop());
        System.out.println("size: " + myStack.size());
        System.out.println("is Empty?: " + myStack.isEmpty());
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        System.out.println("top element: " + myStack.peek());
        System.out.println("contains 3?: " + myStack.contains(3));
        System.out.println("size: " + myStack.size());
        System.out.println("contains 5?: " + myStack.contains(5));
        System.out.println("position of 2: " + myStack.search(2));
        System.out.println("position of 3: " + myStack.search(3));
        Integer[] arr = new Integer[myStack.size()];
        arr = myStack.toArray(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
    }

    private static void QueueTester(){
        Queue<Integer> myQueue = new Queue<Integer>();
        System.out.println("is Empty?: " + myQueue.isEmpty());
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        System.out.println("size: " + myQueue.size());
        System.out.println("dequeuing " + myQueue.dequeue());
        System.out.println("size: " + myQueue.size());
        System.out.println("is Empty?: " + myQueue.isEmpty());
        myQueue.enqueue(4);
        myQueue.enqueue(5);
        myQueue.enqueue(6);
        System.out.println("front element: " + myQueue.peek());
        System.out.println("contains 3?: " + myQueue.contains(3));
        System.out.println("size: " + myQueue.size());
        System.out.println("contains 5?: " + myQueue.contains(5));
        System.out.println("position of 2: " + myQueue.search(2));
        System.out.println("position of 3: " + myQueue.search(3));
        Integer[] arr = new Integer[myQueue.size()];
        arr = myQueue.toArray(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
    }

    private static void NaryTreeTester(){
        NaryTree<Integer> tree = new NaryTree<Integer>(4, 0);
        TreeNode<Integer> root = tree.getRoot();
        root.setChild(new TreeNode(1, 4), 0);
        root.setChild(new TreeNode(2, 4), 2);
        root.setChild(new TreeNode(3, 4), 3);
        System.out.println(root.getChildCount());
        TreeNode<Integer> child1 = root.getChildAt(2);
        System.out.println(child1.getChildCount());
        child1.setChild(new TreeNode(4, 4), 0);
        child1.setChild(new TreeNode(5, 4), 1);
        child1.setChild(new TreeNode(6, 4), 3);
        System.out.println(child1.getChildCount());
        //root.removeChild(2);
        System.out.println(root.getChildCount());
        System.out.println(tree.contains(5));
        System.out.println(tree.contains(7));
        ArrayList<Integer> bfsList = tree.bfs();
        Integer[] arr = new Integer[bfsList.size()];
        arr = bfsList.toArray(arr);
        for(Integer i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
        ArrayList<Integer> dfsList = tree.dfs();
        arr = dfsList.toArray(arr);
        for(Integer i : arr){
            System.out.print(i + " ");
        }
    }

    private static void BinaryTreeTester(){
        BinaryTree<Integer> tree = new BinaryTree<Integer>(1);
        BinaryTreeNode<Integer> root = tree.getRoot();
        root.setLeftChild(new BinaryTreeNode(2));
        root.setRightChild(new BinaryTreeNode(3));
        root.getLeftChild().setLeftChild(new BinaryTreeNode(4));
        root.getLeftChild().setRightChild(new BinaryTreeNode(5));
        root.getRightChild().setLeftChild(new BinaryTreeNode(6));
        root.getRightChild().setRightChild(new BinaryTreeNode(7));
        root.getRightChild().getRightChild().setRightChild(new BinaryTreeNode(8));
        System.out.println(tree.contains(5));
        System.out.println(tree.contains(10));

        ArrayList<Integer> inOrderList = tree.inOrderTraversal();
        Integer[] arr = new Integer[inOrderList.size()];
        arr = inOrderList.toArray(arr);
        for(Integer i : arr){
            System.out.print(i + " ");
        }
        System.out.println();

        ArrayList<Integer> preOrderList = tree.preOrderTraversal();
        arr = preOrderList.toArray(arr);
        for(Integer i : arr){
            System.out.print(i + " ");
        }
        System.out.println();

        ArrayList<Integer> postOrderList = tree.postOrderTraversal();
        arr = postOrderList.toArray(arr);
        for(Integer i : arr){
            System.out.print(i + " ");
        }
    }

    private static void BSTTester(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(3);
        tree.add(new BinaryTreeNode<Integer>(1));
        tree.add(new BinaryTreeNode<Integer>(5));
        tree.add(new BinaryTreeNode<Integer>(0));
        tree.add(new BinaryTreeNode<Integer>(4));
        tree.add(new BinaryTreeNode<Integer>(7));
        tree.add(new BinaryTreeNode<Integer>(2));
        tree.add(new BinaryTreeNode<Integer>(3));
        tree.add(new BinaryTreeNode<Integer>(10));
        tree.add(new BinaryTreeNode<Integer>(12));
        tree.add(new BinaryTreeNode<Integer>(5));
        System.out.println(tree.contains(5));
        System.out.println(tree.contains(13));

        ArrayList<Integer> inOrderList = tree.inOrderTraversal();
        Integer[] arr = new Integer[inOrderList.size()];
        arr = inOrderList.toArray(arr);
        for(Integer i : arr){
            System.out.print(i + " ");
        }
        System.out.println();

        ArrayList<Integer> preOrderList = tree.preOrderTraversal();
        arr = preOrderList.toArray(arr);
        for(Integer i : arr){
            System.out.print(i + " ");
        }
        System.out.println();

        ArrayList<Integer> postOrderList = tree.postOrderTraversal();
        arr = postOrderList.toArray(arr);
        for(Integer i : arr){
            System.out.print(i + " ");
        }

        tree.delete(3);
        System.out.println();
        ArrayList<Integer> newInOrderList = tree.inOrderTraversal();
        Integer[] newArr = new Integer[newInOrderList.size()];
        newArr = newInOrderList.toArray(newArr);
        for(Integer i : newArr){
            System.out.print(i + " ");
        }
    }

    private static void HashMapTester(){
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(6, "Six");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(32, "Thirty two");
        HashSet<Integer> set = map.keySet();
        for(Integer i : set){
            System.out.println(i + " " +  map.get(i));
        }
        System.out.println(map.size());
        map.remove(1);
        map.remove(16);
        map.remove(32);
        System.out.println();
        set = map.keySet();
        for(Integer i : set){
            System.out.println(i + " " +  map.get(i));
        }
        System.out.println(map.size());
    }

    private static void PriorityQueueTester(){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.enqueue(13);
        queue.enqueue(10);
        queue.enqueue(16);
        System.out.println(queue.size());
        queue.enqueue(15);
        queue.enqueue(20);
        queue.enqueue(4);
        queue.enqueue(7);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.size());
        queue.enqueue(1);
        System.out.println(queue.size());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.size());
        queue.enqueue(13);
        queue.enqueue(10);
        queue.enqueue(16);
        System.out.println(queue.size());
        queue.enqueue(15);
        queue.enqueue(20);
        queue.enqueue(4);
        queue.enqueue(7);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.size());
        queue.enqueue(1);
        System.out.println(queue.size());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

    private static void TrieTester(){

    }
}
