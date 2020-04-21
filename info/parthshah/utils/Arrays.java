package info.parthshah.utils;

public class Arrays {
    public static <T> void reverse(T[] arr){
        int len = arr.length;
        for(int i=0; i<len/2; i++){
            T temp = arr[i];
            arr[i] = arr[len-1-i];
            arr[len-1-i] = temp;
        }
    }
}
