package Bank;

import java.util.Date;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, String password, String customerID, String customerName, String customerEmail, String customerNum, String customerAddress, Date dateOpened, String membershipType, double interestRate) {
        super(accountNumber, balance, password, customerID, customerName, customerEmail, customerNum, customerAddress, dateOpened, membershipType);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double CalculateInterest()
    {
        return (interestRate / 100) * getBalance();
    }
}
