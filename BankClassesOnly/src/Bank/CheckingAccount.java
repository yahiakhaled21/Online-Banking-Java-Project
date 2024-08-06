package Bank;

import java.util.Date;

public class CheckingAccount extends Account {
    private double fees;

    public CheckingAccount(String accountNumber, double balance, String password, String customerID, String customerName, String customerEmail, String customerNum, String customerAddress, Date dateOpened, String membershipType, double fees) {
        super(accountNumber, balance, password, customerID, customerName, customerEmail, customerNum, customerAddress, dateOpened, membershipType);
        this.fees = fees;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    @Override
    public void Deposit(double amount) {
        super.Deposit(amount-fees);
    }

    @Override
    public void Withdraw(double amount) {
        super.Withdraw(amount+fees);
    }
}
