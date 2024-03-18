package MyJava.Projects.MortageCalculator;

import java.text.NumberFormat;

public class MortageReport {

    /**
     *
     */
    private final NumberFormat CURRENCY_INSTANCE = NumberFormat.getCurrencyInstance();
    private MortageCalculator mortage;

    public MortageReport(MortageCalculator mortage) {
        this.mortage = mortage;
    }

    public void printMortage() {
        System.out.println();
        System.out.println("Mortage\n-----------\n" + CURRENCY_INSTANCE.format(mortage.getMortage()));
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE\n--------------------");
        for (double payment : mortage.getAllPayments())
            System.out.println(CURRENCY_INSTANCE.format(payment));
    }
}
