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

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class WithdrawController {
    public Label BalanceLabel;
    public Label BalanceLabel1;
    public Label AmountLabel;
    public TextField AmountTxt;
    public Button WithdrawButton;
    public Button CancelButton;
    public Label IDLabel;
    public Label IDLabel1;

    public void setUserInformation(int Balance, String ID) {
        BalanceLabel1.setText(String.valueOf(Balance));
        IDLabel1.setText(String.valueOf(ID));
    }

    public void Withdraw(ActionEvent actionEvent) throws SQLException {
        int value = Integer.valueOf(BalanceLabel1.getText()) - (Integer.valueOf(AmountTxt.getText()));
        if (value >= 0) {
            BalanceLabel1.setText(String.valueOf((Integer.valueOf(BalanceLabel1.getText())) - (Integer.valueOf(AmountTxt.getText()))));
            DButils.Withdraw(actionEvent, IDLabel1.getText(), value);
        }else {
            JOptionPane.showMessageDialog(null,"Not enough balance");
        }
    }

    public void Cancel(ActionEvent actionEvent) throws IOException {
        DButils.Cancel(actionEvent, IDLabel1.getText());
    }
}
