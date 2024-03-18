package MyJava.Algorithms.Sorting;

//Time Complexity -> Best Case : O(nlogn) Worst Case : O(n^2)
//Space Complexity -> Best Case : O(logn) Worst Case : O(logn)

import java.util.*;
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {6,5,4,3,3,2,1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] array){
        sort(array, 0, array.length-1);
    }

    public static void sort(int[] array, int start, int end){
        if(start >= end)
            return;
        
        int boundary = partition(array, start, end);

        sort(array, start, boundary-1);
        sort(array, boundary+1, end);
    }

    public static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int boundary = start -1;
        for(int i=start; i<=end; i++)
            if(array[i] <= pivot)
                swap(array, i, ++boundary);
        return boundary;
    }

    public static void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
}
