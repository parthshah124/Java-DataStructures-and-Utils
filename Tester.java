import info.parthshah.datastructures.ArrayList;
import info.parthshah.datastructures.LinkedList;
import info.parthshah.datastructures.ListNode;

import java.util.Iterator;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args){
        System.out.println("What do you want to test? (type the index and press enter)");
        System.out.println("1. ArrayList");
        System.out.println("2. LinkedList");
        Scanner input = new Scanner( System.in );
        int index = input.nextInt();

        switch (index){
            case 1:
                ArrayListTester();
                break;
            case 2:
                LinkedListTester();
                break;

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
}
