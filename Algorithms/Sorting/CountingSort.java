package MyJava.Algorithms.Sorting;

//Time Complexity -> O(n + k)
//Space Complexity -> O(k) [Array of size k]

import java.util.*;

public class CountingSort {
    public static void main(String[] args) {
        int[] a = {6,5,4,3,3,2,1};
        sort(a, 6);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] array, int k) {
        int[] elemsCount = new int[k+1];
        for (int i = 0; i < array.length; i++)
            elemsCount[array[i]]++;

        int index = 0;
        for (int i = 0; i < elemsCount.length; i++)
            if (elemsCount[i] != 0)
                for (int j = 0; j < elemsCount[i]; j++)
                    array[index++] = i;

    }
}
