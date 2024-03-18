package MyJava.Projects;

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        final String FIZZ = "Fizz";
        final String BUZZ = "Buzz";
        int number;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        number = sc.nextInt();
        if(number % 3 == 0 && number % 5 == 0)
            System.out.println(FIZZ+BUZZ);
        else if(number % 3 == 0)
            System.out.println(FIZZ);
        else if(number % 5 == 0)
            System.out.println(BUZZ);
        else
            System.out.println(number);
        sc.close();
    }
}
