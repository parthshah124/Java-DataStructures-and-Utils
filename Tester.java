import info.parthshah.datastructures.ArrayList;

import java.util.Iterator;

public class Tester {
    public static void main(String[] args){
        ArrayListTester();
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
}
