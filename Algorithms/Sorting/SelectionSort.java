package MyJava.Algorithms.Sorting;

//Time Complexity -> Best Case : O(n) [Shifting only once per iteration] Worst Case : O(n^2)
//Space Complexity -> Best Case : O(1) Worst Case : O(1)

import java.util.*;
public class SelectionSort {
    public static void main(String[] args){
        int[] a = {6,5,4,3,3,2,1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a){
        for(int i=0; i<a.length; i++){
            int minIndex = findMinIndex(a, i);
            swap(a, minIndex, i);
        }
    }

    public static int findMinIndex(int[] a, int fromIndex){
        int min = fromIndex;
        for(int i=fromIndex+1; i<a.length; i++) {
            if(a[min] > a[i]){
                min = i;
            }
        }
        return min;
    }

    public static void swap(int[] a, int index1, int index2){
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
}
