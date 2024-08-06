package bank.bank;

public class smsNotifier extends Notifier{
    public smsNotifier(Account account) {
        super(account);
    }

    @Override
    public void display() {
        System.out.println("Sending SMS to " + account.getName());

        if (event.equals("Withdraw")) {
            System.out.println("Withdrawal operation successful. Withdrawal amount is: " + account.amount + "$");
        }
        else if (event.equals("Deposit")) {
            System.out.println("Deposit operation successful. Deposit amount is: " + account.amount + "$");
        }

        System.out.println("The current balance of your account is: " + account.getBalance() + "$");
    }

}
