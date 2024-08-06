package bank.bank;

public interface iSubject {
    public void addObserver(iObserver o);
    public void removeObserver(iObserver o);
    public void notifyObservers();
}
