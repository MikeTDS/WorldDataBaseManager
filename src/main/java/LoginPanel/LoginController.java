package LoginPanel;

import AppPanel.App;
import AppPanel.AppController;
import DataBase.HibernateManager;
import DataBase.LoginData;
import RegisterPanel.RegisterWindow;
import com.google.common.hash.Hashing;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

public class LoginController implements Initializable, ILoginController, ICrypto{
    public PasswordField loginPasswordField;
    public TextField loginTextField;
    private RegisterWindow registerWindow;
    @FXML
    Button signInButton;
    @Override
    public void initialize(URL location, ResourceBundle resources){}

    public void onLogin(){
        String name = loginTextField.getText();
        String password = loginPasswordField.getText();
        if(!name.equals("") && !password.equals("")) {
            LoginData current = new LoginData();
            current.setLogin(name);
            current.setPassword(hashPassword(password));
            HibernateManager.sendLoginData(current);
        }
    }

    public void onSignUp(){
        try{
            Stage stage = new Stage();
            registerWindow= new RegisterWindow();
            registerWindow.start(stage);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void performLogin(String name){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Logged in successfully");
        alert.setHeaderText(null);
        alert.setContentText("You are logged in as: " + name);
        alert.showAndWait();
        startApp(name);
    }
    public static void rejectLogin(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Could not log in");
        alert.setHeaderText(null);
        alert.setContentText("Wrong login or password");
        alert.showAndWait();
    }

    public static String hashPassword(String password){
            return Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
    }

    private static void startApp(String name){
        AppController.initializeUser(name);
        AppController.setLogged(true);
        AppController.startMainApp();
        App app = new App();
        Stage stage = new Stage();
        try{
            app.start(stage);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        LoginWindow.closeWindow();
    }
}