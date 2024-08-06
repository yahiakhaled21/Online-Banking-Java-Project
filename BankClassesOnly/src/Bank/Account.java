package Bank;

import java.util.Date;

public class Account {
    private String accountNumber;
    private double balance;
    private String password;
    private String customerID;
    private String customerName;
    private String customerEmail;
    private String customerNum;
    private String customerAddress;
    private Date dateOpened;
    private String membershipType;

    public Account() {
    }

    public Account(String accountNumber, double balance, String password, String customerID, String customerName, String customerEmail, String customerNum, String customerAddress, Date dateOpened, String membershipType) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.password = password;
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerNum = customerNum;
        this.customerAddress = customerAddress;
        this.dateOpened = dateOpened;
        this.membershipType = membershipType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerNum() {
        return customerNum;
    }

    public void setCustomerNum(String customerNum) {
        this.customerNum = customerNum;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Date getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Date dateOpened) {
        dateOpened = dateOpened;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        membershipType = membershipType;
    }

    public void Deposit(double amount)
    {
        if (amount > 0)
            balance += amount;
    }

    public  void Withdraw(double amount)
    {
        if (amount <= balance)
            balance -= amount;
        else
            System.out.println("Debit amount exceeded account balance ");
    }
}
