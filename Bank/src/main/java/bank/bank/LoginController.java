package bank.bank;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public Button LoginButton;
    public Button ExitButton;
    public Button RegisterButton;
    public ImageView BankImg;
    public TextField AccNumberTxt;
    public PasswordField PasswordTxt;
    public Button DBbutton;


    public void initialize(URL url, ResourceBundle resourceBundle) {


        LoginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DButils.loginUser(actionEvent, AccNumberTxt.getText(), PasswordTxt.getText());
                }
        });

        RegisterButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DButils.changeScene(actionEvent, "Register.fxml", "Register", null, null, null, null, null, null, null, 0);
            }
        });
    }

    public void DatabaseButton(ActionEvent event) throws IOException {
        Stage stage = (Stage) DBbutton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("DatabaseView.fxml"));
        stage.setTitle("Database");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void Exit(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }

}