package MyJava.Algorithms.Searching;

//Time Complexity -> Best Case : O(log3n)

import java.util.*;
class TernarySearch {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6 };
        System.out.println(search(a, 10, 0, a.length-1));
    }

    public static int search(int[] array, int target, int left, int right){
        if(left > right)
            return -1;
        
        int partitionSize = (right-left) / 3;
        int mid1 = left + partitionSize;
        int mid2 = right - partitionSize;

        if(target == array[mid1])
            return mid1;
        
        if(target == array[mid2])
            return mid2;
        
        if(target < array[mid1])
            return search(array, target, left, mid1-1);

        if(target > array[mid2])
            return search(array, target, mid2+1, right);

        return search(array, target, mid1+1, mid2-1);
    }
}