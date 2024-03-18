package MyJava.Algorithms.Sorting;

//Time Complexity -> Best Case : O(n+k) Worst Case : O(n^2) 
//Space Complexity -> Best Case : O(n)

import java.util.*;

public class BucketSort {
    static LinkedList<Integer>[] bucket = new LinkedList[3];
    public static void main(String[] args) {
        int[] a = {6,5,4,3,3,2,1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] array){
        for(int i=0; i<array.length; i++)
            addToBucket(array[i]);
        
        for(int i=0; i<bucket.length; i++){
            bucket[i].sort(Comparator.naturalOrder());
        }

        int index = 0;
        for(int i=0; i<bucket.length; i++){
            while(!bucket[i].isEmpty()){
                array[index++] = bucket[i].getFirst();
                bucket[i].removeFirst();
            }
        }

        
    }

    public static int calculateIndex(int number){
        return number / bucket.length;
    }

    public static void addToBucket(int number){
        int index = calculateIndex(number);
        if(isEmpty(index)){
            bucket[index] = new LinkedList();
        }
        bucket[index].addLast(number);
    }

    public static boolean isEmpty(int index){
        return bucket[index] == null;
    }
}
