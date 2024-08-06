package bank.bank;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DepositController {
    public Label BalanceLabel;
    public Label BalanceLabel1;
    public Label AmountLabel;
    public TextField AmountTxt;
    public Button DepositButton;
    public Button CancelButton;
    public Label IDLabel1;
    public Label IDLabel;

    public void setUserInformation(int Balance, String ID) {
        BalanceLabel1.setText(String.valueOf(Balance));
        IDLabel1.setText(String.valueOf(ID));
    }

    public void Deposit(ActionEvent actionEvent) throws SQLException {
        int value = Integer.valueOf(BalanceLabel1.getText())+ (Integer.valueOf(AmountTxt.getText()));
        BalanceLabel1.setText(String.valueOf((Integer.valueOf(BalanceLabel1.getText()))+ (Integer.valueOf(AmountTxt.getText()))));
        DButils.Deposit(actionEvent, IDLabel1.getText(), value);
        }


    public void Cancel(ActionEvent actionEvent) throws IOException {
        DButils.Cancel(actionEvent, IDLabel1.getText());
    }
}
