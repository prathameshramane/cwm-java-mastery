package MyJava.Algorithms.Sorting;

//Time Complexity -> Best Case : O(n) Worst Case : O(n^2)
//Space Complexity -> Best Case : O(1) Worst Case : O(1)

import java.util.*;

class BubbleSort {
    public static void main(String[] args) {
        int[] a = { 6, 5, 4, 3, 3, 2, 1 };
        boolean isSorted;
        for (int i = 0; i < a.length; i++) {
            isSorted = true;
            for (int j = 1; j < a.length - i; j++) {
                if (a[j] < a[j - 1]) {
                    swap(a, j - 1, j);
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
        }

        System.out.println(Arrays.toString(a));
    }

    public static void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
}