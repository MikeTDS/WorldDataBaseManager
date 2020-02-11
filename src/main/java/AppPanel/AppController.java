package AppPanel;
import LoginPanel.LoginWindow;
import UserController.User;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {

    private static User user;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    public static void setupAppController(){
        user = new User();
        setLogged(false);
    }
    public static void initializeUser(String name){
        user.setName(name);
    }
    public static void setLogged(boolean l){
        user.setLogged(l);
    }
    public static boolean isLogged(){
        return user.isLogged();
    }

    public static void startMainApp(){
        if(isLogged()){

        }
    }

    public void onLogOut(){
        App.closeWindow();
        user.setLogged(false);
        restartLogging();
    }

    private void restartLogging(){
        LoginWindow loginWindow = new LoginWindow();
        Stage stage = new Stage();
        try{
            loginWindow.start(stage);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
