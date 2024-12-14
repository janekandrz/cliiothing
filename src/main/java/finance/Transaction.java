package finance;

import java.util.Date;

public class Transaction {


    private final String date;
    private final double amount;
    private final Category category;

    public Transaction(double a, Category c, String d) {
        this.date = d;
        this.amount = a;
        this.category = c;
    }

    public String getTDate() {
        return this.date;
    }

    public Category getTCategory() {
        return this.category;
    }

    public double getTAmount() {
        return this.amount;
    }

    public String TransactionString() {

        String amount = String.valueOf(this.getTAmount());
        String date = String.valueOf(this.getTDate());
        String category = String.valueOf(this.getTCategory());

        return amount + "," + category + "," + date;
    }




}
