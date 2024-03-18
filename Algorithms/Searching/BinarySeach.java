package MyJava.Algorithms.Searching;

//Time Complexity -> O(logn)
//Space Complexity -> O(logn)

import java.util.*;

public class BinarySeach {

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6 };
        System.out.println(search(a, 0, a.length - 1, 6));
    }

    public static int search(int[] a, int number) {
        int left = 0;
        int right = a.length - 1;

        while (left <= right) {
            int middle = (right + left) / 2;
            if (a[middle] == number)
                return number;
            else if (a[middle] > number)
                right = middle - 1;
            else if (a[middle] < number)
                left = middle + 1;
        }

        return -1;
    }

    public static int search(int[] a, int left, int right, int number) {
        if (left > right)
            return -1;

        int middle = (left + right) / 2;

        if (a[middle] == number)
            return middle;

        if (a[middle] > number)
            return search(a, left, middle - 1, number);

        return search(a, middle + 1, right, number);
    }
}
