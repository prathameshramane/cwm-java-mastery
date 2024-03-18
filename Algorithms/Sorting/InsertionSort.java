package MyJava.Algorithms.Sorting;

//Time Complexity -> Best Case : O(n^2) Worst Case : O(n^2)
//Space Complexity -> Best Case : O(1) Worst Case : O(1)

import java.util.*;
public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {6,5,4,3,3,2,1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a){
        for(int i=1; i<a.length; i++){
            int current = a[i];
            int j=i-1;
            while(j>=0 && a[j] > current){
                pushRight(a, j);
                j--;
            }
            a[j+1] = current;
        }
    }

    public static void pushRight(int[] a, int index){
        a[index+1] = a[index];
    }
}
