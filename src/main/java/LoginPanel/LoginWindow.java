package LoginPanel;
import AppPanel.AppController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginWindow extends Application {
    static Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("../LoginPage.fxml"));
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        AppController.setupAppController();
    }
    public static void closeWindow(){
        try{
            stage.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
