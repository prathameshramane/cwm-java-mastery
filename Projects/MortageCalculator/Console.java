package MyJava.Projects.MortageCalculator;

import java.util.Scanner;

public class Console {
    private static Scanner sc = new Scanner(System.in);

    public static double readNumber(String prompt){
        return sc.nextDouble();
    }

    public static double readNumber(String prompt, double min, double max) {
        double value;
        while (true) {
            System.out.print(prompt);
            value = sc.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Please enter a value between " + min + " and " + max + " .");
        }
        return value;
    }
}
