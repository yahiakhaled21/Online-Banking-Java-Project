package bank.bank;

import java.util.ArrayList;
import java.util.Date;

public class Account implements iSubject{
    private String ID;
    private String Name;
    private String Email;
    private String PhoneNum;
    private String Address;
    private String CardNum;
    private String Password;
    private String membershipType;
    private int Balance;
    private Date dateOpened;
    private ArrayList<iObserver> Observers;
    public String event;
    public double amount;

    public Account() {
    }


    public Account(String ID, String name, String email, String phoneNum, String address, String cardNum, String password, String membershipType, int balance) {
        this.ID = ID;
        Name = name;
        Email = email;
        PhoneNum = phoneNum;
        Address = address;
        CardNum = cardNum;
        Password = password;
        this.membershipType = membershipType;
        Balance = balance;
    }

    public Account(String accountNumber, double balance, String password, String ID, String customerName, String customerEmail, String customerNum, String customerAddress, Date dateOpened, IMembership membershipType, ArrayList<iObserver> observers, String event, double amount) {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        PhoneNum = phoneNum;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCardNum() {
        return CardNum;
    }

    public void setCardNum(String cardNum) {
        CardNum = cardNum;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }

    public Date getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Date dateOpened) {
        this.dateOpened = dateOpened;
    }

    public ArrayList<iObserver> getObservers() {
        return Observers;
    }

    public void setObservers(ArrayList<iObserver> observers) {
        Observers = observers;
    }

    public void Deposit(double amount)
    {
        if (amount > 0)
            Balance += amount;
        statusChanged();
    }

    public  void Withdraw(double amount)
    {
        if (amount <= Balance)
            Balance -= amount;
        else
            System.out.println("Debit amount exceeded account balance ");
        statusChanged();
    }

    @Override
    public void addObserver(iObserver o) {
        Observers.add(o);
    }

    @Override
    public void removeObserver(iObserver o) {
        Observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (iObserver o : Observers){
            o.update(CardNum, event);
        }
    }
    public void statusChanged(){
        notifyObservers();
    }
}
