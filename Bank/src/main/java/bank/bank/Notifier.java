package bank.bank;

public abstract class Notifier implements iObserver{
    Account account;
    public String accountNumber;
    public String event;

    public Notifier(Account account){
        this.account = account;
        account.addObserver(this);
    }

    public void update(String accountNumber, String event){
        this.accountNumber = accountNumber;
        this.event = event;
        display();
    }

    public abstract void display();
}
