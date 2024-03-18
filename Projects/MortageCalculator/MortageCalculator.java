package MyJava.Projects.MortageCalculator;

class MortageCalculator {

    private final static byte MONTH_IN_YEAR = 12;
    private final static byte PERCENT = 100;

    private int principleAmount;
    private float monthlyRate;
    private short numberOfPayments;

    public MortageCalculator(int principleAmount, float annualRate, byte years) {
        this.principleAmount = principleAmount;
        this.monthlyRate = getMonthlyRate(annualRate);
        this.numberOfPayments = (short) getNumberOfPayments(years);
    }

    public double[] getAllPayments() {
        var payments = new double[numberOfPayments + 1]; // Plus 1 for last $0.00

        for (short month = 0; month <= numberOfPayments; month++)
            payments[month] = calculateBalance(month);

        return payments;
    }

    private double calculateMortage() {
        double mortage = (principleAmount * monthlyRate
                * (Math.pow(1 + monthlyRate, numberOfPayments) / (Math.pow(1 + monthlyRate, numberOfPayments) - 1)));
        return mortage;
    }

    private double calculateBalance(short numberOfPaymentsDone) {
        double balance = principleAmount
                * (Math.pow(1 + monthlyRate, numberOfPayments) - Math.pow(1 + monthlyRate, numberOfPaymentsDone))
                / (Math.pow(1 + monthlyRate, numberOfPayments) - 1);
        return balance;
    }

    public double getMortage() {
        return calculateMortage();
    }

    public double getBalance(short numberOfPaymentsDone) {
        return calculateBalance(numberOfPaymentsDone);
    }

    private float getMonthlyRate(float annualRate) {
        return annualRate / PERCENT / MONTH_IN_YEAR;
    }

    private int getNumberOfPayments(byte years) {
        return years * MONTH_IN_YEAR;
    }

}