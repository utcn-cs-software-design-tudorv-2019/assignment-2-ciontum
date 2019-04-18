package Controller;

import Model.Repository.AdminDao;
import Model.Repository.StudentDao;
import Model.Services.LoginBLL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class LoginController {
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Button loginbtn;
    public static String s;
    @FXML
    public void Login(ActionEvent event) {
        String user = this.username.getText();
        String pass = this.password.getText();
        if (LoginBLL.Login(user, pass) == 1) {
            Stage stage = (Stage) this.loginbtn.getScene().getWindow();
            stage.close();
            s=user;
            studentLogin();
        }
        else
        if(LoginBLL.Login(user,pass)==2){
            Stage stage = (Stage) this.loginbtn.getScene().getWindow();
            stage.close();
            s=user;
            adminLogin();
        }
    }

    public void studentLogin() {
        try {
            Stage userStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            URL url = new File("src/main/java/View/studentsfx.fxml").toURL();
            Pane root = (Pane) loader.load(url);

            //StudentDao  studentController= (StudentDao)loader.getController();
            StudentDao studentController = new StudentDao();

            StudentController studentController2 = (StudentController) loader.getController();
            studentController.test(s);
            //data.test(s);
            Scene scene = new Scene(root);
            userStage.setScene(scene);
            userStage.setTitle("Student dash");
            userStage.setResizable(false);
            userStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void adminLogin() {
        try {
            Stage adminStage = new Stage();
            FXMLLoader loader2 = new FXMLLoader();
            URL url = new File("src/main/java/View/adminfx.fxml").toURL();
            Pane root2 = (Pane) loader2.load(url);

            AdminDao adminController = new AdminDao();
            AdminController adminController2 = (AdminController) loader2.getController();
            adminController.test2(s);

            Scene scene = new Scene(root2);
            adminStage.setScene(scene);
            adminStage.setTitle("admin dash");
            adminStage.setResizable(false);
            adminStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
