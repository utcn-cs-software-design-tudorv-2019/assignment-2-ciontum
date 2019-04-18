package Controller;

import Model.Services.StudentBLL;
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

public class StudentController {
    @FXML
    public javafx.scene.control.TextField id;
    @FXML
    private javafx.scene.control.TextField name;
    @FXML
    private Button btn;
    @FXML
    private TextField idp;

    @FXML
    private TextField examenl;
    private TextField numep;
    @FXML
    private TextField prenumep;
    @FXML
    private TextField cnpp;
    @FXML
    private javafx.scene.control.TextField grupa;
    private String s;
    public void test(String text){
        s=text;
    }

    public void addStudent3(ActionEvent event)  {
        String id=this.id.getText();
        String nume=this.name.getText();
        String grupa=this.grupa.getText();

        StudentBLL.addStudent2(id,nume,grupa);
    }
    @FXML
    public void ViewProfile(ActionEvent event) {

        try {

            Stage stage = (Stage) this.btn.getScene().getWindow();
            stage.close();
            profile();

        } catch (Exception localException) {

        }
    }
    public  void profile() {
        try {
            Stage userStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            URL url = new File("src/main/java/View/profile.fxml").toURL();
            Pane root = (Pane) loader.load(url);
            // ProfileDao datas=loader.getController();
            //datas.test(s);
            Scene scene = new Scene(root);
            userStage.setScene(scene);
            userStage.setTitle("profile");
            userStage.setResizable(false);

            userStage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void enroll(ActionEvent event)
    {
        String examen=this.examenl.getText();
        String nume=this.name.getText();
        String id2=this.id.getText();
        StudentBLL.enroll(id2,nume,examen,null);
    }
}
