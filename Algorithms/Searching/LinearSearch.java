package MyJava.Algorithms.Searching;

//Time Complexity -> Best Case : O(1) Worst Case : O(n)

import java.util.*;
public class LinearSearch {
    public static void main(String[] args) {
        int[] a = {6,5,4,3,3,2,1};
        System.out.println(search(a, 3));
    }

    public static int search(int[] a, int number){
        for(int i=0; i<a.length; i++){
            if(a[i] == number)
                return i;
        }
        return -1;
    }
}
