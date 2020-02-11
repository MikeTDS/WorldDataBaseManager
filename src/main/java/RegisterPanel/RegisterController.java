package RegisterPanel;

import DataBase.HibernateManager;
import LoginPanel.LoginController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController implements IRegisterController {
    public PasswordField loginPasswordField;
    public TextField loginTextField;
    @FXML
    Button createAccountButton;
    @Override
    public void onCreateAccount(){
        String login = loginTextField.getText();
        String password = loginPasswordField.getText();
        if(!login.equals("") && !password.equals("")){
            HibernateManager.sendDataToRegister(login, LoginController.hashPassword(password));
        }
        loginPasswordField.clear();
        loginTextField.clear();
    }
    public static void performCreation(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registered successfully");
        alert.setHeaderText(null);
        alert.setContentText("Your account is registered.");
        alert.showAndWait();
        RegisterWindow.closeWindow();
    }
    public static void rejectCreation(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Could not register.");
        alert.setHeaderText(null);
        alert.setContentText("This login is already used.");
        alert.showAndWait();
    }
}
