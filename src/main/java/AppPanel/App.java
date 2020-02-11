package AppPanel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    static Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("../AppPage.fxml"));
        stage.setScene(new Scene(root, 300, 275));
        stage.show();
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