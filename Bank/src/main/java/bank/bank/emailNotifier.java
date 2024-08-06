package bank.bank;

public class emailNotifier extends Notifier{
    public emailNotifier(Account account) {
        super(account);
    }

    @Override
    public void display() {
        System.out.println("Sending Email to " + account.getName());

        if(event.equals("Withdraw")){
            System.out.println("Withdrawal operation successful. Withdrawal amount is: " + account.amount + "$");
        }
        else if(event.equals("Deposit")){
            System.out.println("Deposit operation successful. Deposit amount is: " + account.amount + "$");
        }

        System.out.println("The current balance of your account is " + account.getBalance() + "$");
    }


}
