package Bank;

public class Bronze implements IMembership{
    int withdrawLimit = 1000;
    int transferLimit = 1000;

    @Override
    public double InterestRateCalc() {
        return 0.02;
    }
}
