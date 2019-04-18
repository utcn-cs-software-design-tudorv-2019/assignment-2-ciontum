package Controller;

import Model.Services.ProfileBLL;
import Model.entity.StudentData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class ProfileController {
    @FXML
    private Label idl;
    @FXML
    TextField idt;
    @FXML
    Label idl1;
    @FXML
    Label numel;
    @FXML
    Label grupal;
    public void View(ActionEvent event)
    {
        StudentData dt=new StudentData();
        this.idl.setText(String.valueOf(ProfileBLL.view2((ArrayList)ProfileBLL.viewProfile()).get(0)));
        this.numel.setText(String.valueOf(ProfileBLL.view2((ArrayList)ProfileBLL.viewProfile()).get(1)));
        this.grupal.setText(String.valueOf(ProfileBLL.view2((ArrayList)ProfileBLL.viewProfile()).get(2)));

        //this.idl.setText(String.valueOf(StudentBLL.viewProfile().getID()));

    }
}
