package Bank;

public class Gold implements IMembership{
    int withdrawLimit = 10000;
    int transferLimit = 10000;

    @Override
    public double InterestRateCalc() {
        return 0.1;
    }
}
