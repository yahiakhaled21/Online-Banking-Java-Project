package Bank;

public class Silver implements IMembership{
    int withdrawLimit = 5000;
    int transferLimit = 5000;

    @Override
    public double InterestRateCalc() {
        return 0.05;
    }
}
