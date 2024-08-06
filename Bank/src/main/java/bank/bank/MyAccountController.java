package bank.bank;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class MyAccountController{
    public Label IDLabel;
    public Label NameLabel;
    public Label EmailLabel;
    public Label PhoneNumLabel;
    public Label AddressLabel;
    public Label CardNumLabel;
    public Label BalanceLabel;
    public Label IDLabel1;
    public Label NameLabel1;
    public Label EmailLabel1;
    public Label PhoneNumLabel1;
    public Label AddressLabel1;
    public Label CardNumLabel1;
    public Label BalanceLabel1;
    public Button LogoutButton;
    public Button DepositButton;
    public Button WithdrawButton;
    public Button dataButton;
    public Label MembershipLabel;
    public Label MembershipLabel1;

    public void Logout(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage stage =(Stage)( (Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public void Deposit(ActionEvent actionEvent) throws IOException {
        DButils.changeScene2(actionEvent, "Deposit.fxml", "Deposit", Integer.parseInt(BalanceLabel1.getText()), IDLabel1.getText());
    }

    public void Withdraw(ActionEvent actionEvent) throws IOException {
        DButils.changeScene3(actionEvent, "Withdraw.fxml", "Withdraw", Integer.parseInt(BalanceLabel1.getText()), IDLabel1.getText());
    }

    public void setUserInformation(String ID, String Name, String Email, String PhoneNum, String Address, String CardNum, String MembershipType, int Balance) {
        IDLabel1.setText(ID);
        NameLabel1.setText(Name);
        EmailLabel1.setText(Email);
        PhoneNumLabel1.setText(PhoneNum);
        AddressLabel1.setText(Address);
        CardNumLabel1.setText(CardNum);
        MembershipLabel1.setText(MembershipType);
        BalanceLabel1.setText(String.valueOf(Balance));
    }
}

