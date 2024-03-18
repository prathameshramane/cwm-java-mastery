package MyJava.Projects.MortageCalculator;

public class Main {
    public static void main(String[] args) {
        int principleAmount = (int) Console.readNumber("Principle : ", 1_000, 1_000_000);
        float annualRate = (float) Console.readNumber("Annual Rate : ", 1, 30);
        byte years = (byte) Console.readNumber("Period (In Years) : ", 1, 30);

        var calculator = new MortageCalculator(principleAmount, annualRate, years);
        var report = new MortageReport(calculator);

        report.printMortage();
        report.printPaymentSchedule();
    } 
}
