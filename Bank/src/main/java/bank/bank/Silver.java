package bank.bank;

public class Silver implements IMembership{

    public double InterestRateCalc() {
        return 0.05;
    }
    public double withdrawLimitCalc() {
        return 5000;
    }
    public double transferLimitCalc() {
        return 5000;
    }
}
