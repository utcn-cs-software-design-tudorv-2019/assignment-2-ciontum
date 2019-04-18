import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Main extends Application {
    public void start(Stage stage) throws Exception{
        URL url = new File("src/main/java/View/login.fxml").toURL();

        Parent root=(Parent) FXMLLoader.load(url);

        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Management");
        stage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
