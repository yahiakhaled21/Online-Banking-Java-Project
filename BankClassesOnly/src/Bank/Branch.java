package Bank;

public class Branch {
    private String city;
    private String address;

    public Branch(String city, String address) {
        this.city = city;
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }
}
