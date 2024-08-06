package bank.bank;

public class Gold implements IMembership{
    public double InterestRateCalc() {
        return 0.1;
    }
    public double withdrawLimitCalc() {
        return 10000;
    }
    public double transferLimitCalc() {
        return 10000;
    }
}
