package MyJava.Algorithms.Sorting;

//Time Complexity -> Best Case : O(nlogn) Worst Case : O(nlogn)
//Space Complexity -> Best Case : O(n) Worst Case : O(n)

import java.util.*;
public class MergeSort {
    public static void main(String[] args){
        int[] a = {6,5,4,3,3,2,1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a){
        if(a.length < 2)
            return;

        int middle = a.length/2;
        int[] left = new int[middle];
        int[] right = new int[a.length - middle];
        for(int i=0; i<middle; i++){
            left[i] = a[i];
        }
        for(int i=middle; i<a.length; i++){
            right[i-middle] = a[i];
        }

        sort(left);
        sort(right);

        merge(left, right, a);
    }

    public static void merge(int[] left, int[] right, int[] result){
        int i=0, j=0, k=0;
        while(i<left.length && j<right.length){
            if(left[i] <= right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }

        while(i<left.length)
            result[k++] = left[i++];
        while(j<right.length)
            result[k++] = right[j++];
    }
}
