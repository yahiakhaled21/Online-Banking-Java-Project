package bank.bank;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    public Label IDLabel;
    public Button RegisterButton;
    public TextField IDTxt;
    public Label NameLabel;
    public TextField NameTxt;
    public Label EmailLabel;
    public TextField EmailTxt;
    public Label PhoneNumLabel;
    public TextField PhoneNumTxt;
    public Label AddressLabel;
    public TextField AddressTxt;
    public Label CardNumLabel;
    public TextField CardNumTxt;
    public Button BackButton;
    public Label PasswordLabel;
    public TextField PasswordTxt;
    public Label MembershipLabel;
    public TextField MembershipTxt;


    public void initialize(URL url, ResourceBundle resourceBundle) {
        RegisterButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!IDTxt.getText().trim().isEmpty() && !NameTxt.getText().trim().isEmpty() && !EmailTxt.getText().trim().isEmpty() && !PhoneNumTxt.getText().trim().isEmpty() && !AddressTxt.getText().trim().isEmpty() && !CardNumTxt.getText().trim().isEmpty() && !PasswordTxt.getText().trim().isEmpty() && !MembershipTxt.getText().trim().isEmpty()){
                    DButils.registerUser(actionEvent, IDTxt.getText(), NameTxt.getText(), EmailTxt.getText(), PhoneNumTxt.getText(), AddressTxt.getText(), CardNumTxt.getText(), PasswordTxt.getText(), MembershipTxt.getText(), 0);

                }
                else {
                    System.out.println("Please fill in all the blanks");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill in all the blanks");
                    alert.show();
                }

            }

        });
        BackButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DButils.changeScene(actionEvent, "Login.fxml", "Login", null, null, null, null, null, null, null, 0);
            }
        });
    }
}
