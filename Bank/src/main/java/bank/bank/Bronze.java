package bank.bank;

public class Bronze implements IMembership{

    public double InterestRateCalc() {
        return 0.02;
    }
    public double withdrawLimitCalc() {
        return 1000;
    }
    public double transferLimitCalc() {
        return 1000;
    }
}
