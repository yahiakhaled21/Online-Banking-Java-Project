package bank.bank;
import java.io.IOException;
import java.sql.*;
import java.util.jar.Attributes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class DButils {

    static Connection connection = null;
    public static Connection connectDB(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts_schema", "root", "Yayagam007#");
            return connection;
        }catch (Exception exception){
            return null;
        }
    }

    public static void changeScene(ActionEvent event, String fxmlFile, String title, String ID, String Name, String Email, String PhoneNum, String Address, String CardNum, String MembershipType, int Balance) {
        Parent root = null;

        if (ID != null && Name != null && Email != null && PhoneNum != null && Address != null && CardNum != null && MembershipType != null) {
            try {
                FXMLLoader loader = new FXMLLoader(DButils.class.getResource(fxmlFile));
                root = loader.load();
                MyAccountController myAccountController = loader.getController();
                myAccountController.setUserInformation(ID, Name, Email, PhoneNum, Address, CardNum, MembershipType, Balance);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                root = FXMLLoader.load(DButils.class.getResource(fxmlFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();

    }

    public static void changeScene2(ActionEvent event, String fxmlFile, String title, int Balance, String ID) {
        Parent root = null;

        try {
            FXMLLoader loader = new FXMLLoader(DButils.class.getResource(fxmlFile));
            root = loader.load();
            DepositController depositController = loader.getController();
            depositController.setUserInformation(Balance, ID);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
}


    public static void changeScene3(ActionEvent event, String fxmlFile, String title, int Balance, String ID) {
        Parent root = null;

        try {
            FXMLLoader loader = new FXMLLoader(DButils.class.getResource(fxmlFile));
            root = loader.load();
            WithdrawController withdrawController = loader.getController();
            withdrawController.setUserInformation(Balance, ID);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
    }


    public static void registerUser(ActionEvent event, String ID, String Name, String Email, String PhoneNum, String Address, String CardNum, String Password, String MembershipType, int Balance) {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts_schema", "root", "Yayagam007#");
            psCheckUserExists = connection.prepareStatement("SELECT * FROM accounts WHERE ID = ?");
            psCheckUserExists.setString(1, ID);
            resultSet = psCheckUserExists.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("User with this ID already exists");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("User with this ID already exists");
                alert.show();
            } else {
                psInsert = connection.prepareStatement("INSERT INTO accounts (`ID`, `Name`, `Email`, `PhoneNum`, `Address`, `CardNum`, `Password`, `MembershipType`, `Balance`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                psInsert.setString(1, ID);
                psInsert.setString(2, Name);
                psInsert.setString(3, Email);
                psInsert.setString(4, PhoneNum);
                psInsert.setString(5, Address);
                psInsert.setString(6, CardNum);
                psInsert.setString(7, Password);
                psInsert.setString(8, MembershipType);
                psInsert.setInt(9, Balance);
                psInsert.executeUpdate();
                changeScene(event, "MyAccount.fxml", "MyAccount", ID, Name, Email, PhoneNum, Address, CardNum, MembershipType, Balance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psCheckUserExists != null) {
                try {
                    psCheckUserExists.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psInsert != null) {
                try {
                    psInsert.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void loginUser(ActionEvent event, String ID, String Password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts_schema", "root", "Yayagam007#");
            preparedStatement = connection.prepareStatement("SELECT * FROM accounts WHERE ID=?");
            preparedStatement.setString(1, ID);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("User not found in database!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Provided credentials are incorrect!");
                alert.show();
            } else {
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("Password");
                    String Name = resultSet.getString("Name");
                    String Email = resultSet.getString("Email");
                    String PhoneNum = resultSet.getString("PhoneNum");
                    String Address = resultSet.getString("Address");
                    String CardNum = resultSet.getString("CardNum");
                    String MembershipType = resultSet.getString("MembershipType");
                    int Balance = resultSet.getInt("Balance");
                    if (retrievedPassword.equals(Password)) {
                        changeScene(event, "MyAccount.fxml", "MyAccount", ID, Name, Email, PhoneNum, Address, CardNum, MembershipType, Balance);

                    } else {
                        System.out.println("Password didn't match");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("The provided credentials are incorrect");
                        alert.show();
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void Cancel(ActionEvent event, String ID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts_schema", "root", "Yayagam007#");
            preparedStatement = connection.prepareStatement("SELECT * FROM accounts WHERE ID=?");
            preparedStatement.setString(1, ID);
            resultSet = preparedStatement.executeQuery();


                while (resultSet.next()) {
                    String Name = resultSet.getString("Name");
                    String Email = resultSet.getString("Email");
                    String PhoneNum = resultSet.getString("PhoneNum");
                    String Address = resultSet.getString("Address");
                    String CardNum = resultSet.getString("CardNum");
                    String MembershipType = resultSet.getString("MembershipType");
                    int Balance = resultSet.getInt("Balance");
                    changeScene(event, "MyAccount.fxml", "MyAccount", ID, Name, Email, PhoneNum, Address, CardNum, MembershipType, Balance);
                }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static ObservableList<Account> getDataUsers(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ObservableList<Account> list = FXCollections.observableArrayList();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts_schema","root","Yayagam007#");
            preparedStatement = connection.prepareStatement("SELECT * FROM accounts ");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                list.add(new Account(resultSet.getString("ID"), resultSet.getString("Name"), resultSet.getString("Email"), resultSet.getString("PhoneNum"), resultSet.getString("Address"), resultSet.getString("CardNum"), resultSet.getString("Password"), resultSet.getString("MembershipType"), Integer.parseInt(resultSet.getString("Balance"))));
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }

        return list;
    }

    public static void Deposit(ActionEvent event, String ID, int Balance) throws SQLException {
        connection = DButils.connectDB();
        try
        {
            PreparedStatement stat = connection.prepareStatement("UPDATE accounts SET Balance= '"+Balance+"' WHERE ID='"+ID+"' ");

            stat.executeUpdate();
        }
        finally
        {
            connection.close();
        }
    }

    public static void Withdraw(ActionEvent event, String ID, int Balance) throws SQLException {
        connection = DButils.connectDB();
        try
        {
            PreparedStatement stat = connection.prepareStatement("UPDATE accounts SET Balance= '"+Balance+"' WHERE ID='"+ID+"' ");

            stat.executeUpdate();
        }
        finally
        {
            connection.close();
        }
    }
}
