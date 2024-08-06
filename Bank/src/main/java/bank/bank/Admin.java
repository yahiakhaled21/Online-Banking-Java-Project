package bank.bank;

public class Admin {
    private int wage;
    private int workingHours;
    private String userName;
    private String password;

    public Admin(int wage, int workingHours, String userName, String password) {
        this.wage = wage;
        this.workingHours = workingHours;
        this.userName = userName;
        this.password = password;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSalary(){
        return wage * workingHours;
    }
}
