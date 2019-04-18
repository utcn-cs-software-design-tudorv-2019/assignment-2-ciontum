package Controller;

import Model.Services.AdminBLL;
import Model.entity.NoteData;
import Model.entity.StudentData;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class AdminController {
    @FXML
    private TableView<StudentData> studenttable;
    @FXML
    private TableView<NoteData> studenttable1;
    @FXML
    private TableColumn<StudentData,String> idcolumn;
    @FXML
    private TableColumn<StudentData,String> namecolumn;
    @FXML
    private TableColumn<StudentData,String> grupacolumn;
    @FXML
    private TableColumn<NoteData,String> idcolumn1;
    @FXML
    private TableColumn<NoteData,String> namecolumn1;
    @FXML
    private TableColumn<NoteData,String> grupacolumn1;
    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField grupa;
    @FXML
    private TextField id1;
    @FXML
    private TextField cnp;

    public void Add(ActionEvent event)  throws Exception
    {
        String id=this.id.getText();
        String nume=this.name.getText();
        String grupa=this.grupa.getText();
        String user=this.cnp.getText();
        AdminBLL.addStudent(id,nume,grupa,user);

    }
    public void Load(ActionEvent event)
    {
        this.idcolumn.setCellValueFactory(new PropertyValueFactory<StudentData,String>("ID"));
        this.namecolumn.setCellValueFactory(new PropertyValueFactory<StudentData,String>("Name"));
        this.grupacolumn.setCellValueFactory(new PropertyValueFactory<StudentData,String>("Grupa"));
        this.studenttable.setItems(null);
        this.studenttable.setItems((ObservableList)AdminBLL.load());
        for(StudentData c:AdminBLL.load())
        {
            System.out.println(c.getName());
        }
    }
    public void Delete(ActionEvent event) throws SQLException
    {
        int selectedIndex=studenttable.getSelectionModel().getSelectedIndex();
        StudentData asm=(StudentData)studenttable.getSelectionModel().getSelectedItem();
        String tempID=asm.getID();
        studenttable.getItems().remove(selectedIndex);
        AdminBLL.deleteStudent(selectedIndex,tempID);
    }
    public void Update(ActionEvent event) throws SQLException
    {


        String nume=this.name.getText();
        String grupa=this.grupa.getText();
        String user=this.cnp.getText();
        int selectedIndex=studenttable.getSelectionModel().getSelectedIndex();
        StudentData asm=(StudentData)studenttable.getSelectionModel().getSelectedItem();
        String tempID=asm.getID();

        AdminBLL.updateStudent(nume,grupa,selectedIndex,tempID,user);
        String test=grupa;

        studenttable.setItems((ObservableList)AdminBLL.load());
    }
    public void AddGrade(ActionEvent event) throws SQLException
    {
        String nota=this.id1.getText();
        int selectedIndex=studenttable1.getSelectionModel().getSelectedIndex();
        NoteData asm=(NoteData)studenttable1.getSelectionModel().getSelectedItem();
        NoteData asm2=(NoteData) studenttable1.getSelectionModel().getSelectedItem();
        String temp=asm.getNume();
        String temp2=asm2.getExamen();

        AdminBLL.addGrade(nota,selectedIndex,temp,temp2);
    }
    public void LoadGrade(ActionEvent event) throws SQLException
    {

        this.idcolumn1.setCellValueFactory(new PropertyValueFactory<NoteData,String>("nume"));
        this.namecolumn1.setCellValueFactory(new PropertyValueFactory<NoteData,String>("examen"));
        this.grupacolumn1.setCellValueFactory(new PropertyValueFactory<NoteData,String>("nota"));
        this.studenttable1.setItems(null);
        this.studenttable1.setItems((ObservableList)AdminBLL.loadGrade());
    }
}
