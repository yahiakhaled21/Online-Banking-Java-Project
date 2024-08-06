package bank.bank;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class DatabaseController implements Initializable {


    public Button addButton;
    public Button updateButton;
    public Button deleteButton;
    public TextField txt_email;
    public TextField txt_name;
    public TextField txt_phoneNum;
    public TextField txt_address;
    public TextField txt_password;
    public TextField txt_cardNum;
    public TextField txt_membership;
    public TextField txt_Balance;
    public TextField txt_id;
    public TableView accountsTable;
    public TableColumn col_id;
    public TableColumn col_name;
    public TableColumn col_email;
    public TableColumn col_phoneNum;
    public TableColumn col_address;
    public TableColumn col_cardNum;
    public TableColumn col_password;
    public TableColumn col_membership;
    public TableColumn col_balance;
    ObservableList<Account> listM;
    int index = -1;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    public void addUsers(){
        connection = DButils.connectDB();
        try {

            preparedStatement = connection.prepareStatement("INSERT INTO accounts (`ID`, `Name`, `Email`, `PhoneNum`, `Address`, `CardNum`, `Password`, `MembershipType`, `Balance`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1,txt_id.getText());
            preparedStatement.setString(2,txt_name.getText());
            preparedStatement.setString(3,txt_email.getText());
            preparedStatement.setString(4,txt_phoneNum.getText());
            preparedStatement.setString(5,txt_address.getText());
            preparedStatement.setString(6,txt_cardNum.getText());
            preparedStatement.setString(7,txt_password.getText());
            preparedStatement.setString(8,txt_membership.getText());
            preparedStatement.setInt(9, Integer.parseInt(txt_Balance.getText()));
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null,"User Added Successfully" );
            updateTable();

        }catch (Exception exception){


        }
    }

    @FXML
    public void selectSelection (MouseEvent mouseEvent) {
        index = accountsTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        txt_id.setText(col_id.getCellData(index).toString());
        txt_name.setText(col_name.getCellData(index).toString());
        txt_email.setText(col_email.getCellData(index).toString());
        txt_phoneNum.setText(col_phoneNum.getCellData(index).toString());
        txt_address.setText(col_address.getCellData(index).toString());
        txt_cardNum.setText(col_cardNum.getCellData(index).toString());
        txt_password.setText(col_password.getCellData(index).toString());
        txt_membership.setText(col_membership.getCellData(index).toString());
        txt_Balance.setText(col_balance.getCellData(index).toString());


    }

    public void updateData(){
        connection = DButils.connectDB();

        try {
            String str1 = txt_id.getText();
            String str2 = txt_name.getText();
            String str3 = txt_email.getText();
            String str4 = txt_phoneNum.getText();
            String str5 = txt_address.getText();
            String str6 = txt_cardNum.getText();
            String str7 = txt_password.getText();
            String str8 = txt_membership.getText();
            Integer str9 = Integer.valueOf(txt_Balance.getText());
            preparedStatement = connection.prepareStatement("UPDATE accounts SET  Name= '"+str2+"', Email= '"+str3+"', PhoneNum= '"+str4+"', Address= '"+str5+"', CardNum= '"+str6+"', Password= '"+str7+"', MembershipType= '"+str8+"', Balance= '"+str9+"' WHERE ID='"+str1+"' ");
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null,"UPDATED SUCCESSFULLY");
            updateTable();
        }catch (Exception exception){

        }

    }

    public void deleteData(){
        connection = DButils.connectDB();
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM accounts where ID = ?");
            preparedStatement.setString(1, txt_id.getText());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null,"DELETED");
            updateTable();

        }catch (Exception exception){

        }
    }
    public void updateTable(){
        col_id.setCellValueFactory(new PropertyValueFactory<Account,String>("ID"));
        col_name.setCellValueFactory(new PropertyValueFactory<Account,String>("Name"));
        col_email.setCellValueFactory(new PropertyValueFactory<Account,String>("Email"));
        col_phoneNum.setCellValueFactory(new PropertyValueFactory<Account,String>("PhoneNum"));
        col_address.setCellValueFactory(new PropertyValueFactory<Account,String>("Address"));
        col_cardNum.setCellValueFactory(new PropertyValueFactory<Account,String>("CardNum"));
        col_password.setCellValueFactory(new PropertyValueFactory<Account,String>("Password"));
        col_membership.setCellValueFactory(new PropertyValueFactory<Account,String>("MembershipType"));
        col_balance.setCellValueFactory(new PropertyValueFactory<Account,Integer>("Balance"));
        listM = DButils.getDataUsers();
        accountsTable.setItems(listM);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateTable();

    }

}
