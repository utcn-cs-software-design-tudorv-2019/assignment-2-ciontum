package Model.Services;

import Model.Repository.AdminDao;
import Model.entity.NoteData;
import Model.entity.StudentData;

import java.sql.SQLException;
import java.util.List;

public class AdminBLL {
    public AdminBLL() {

    }


    public static List<StudentData> load() {
        return AdminDao.loadStudentData();
    }
    public static void addStudent(String id, String nume, String grupa,String user) {
        System.out.print(id);
            AdminDao.addStudent(new StudentData(id, nume, grupa, user));

    }

    public static void deleteStudent(int l2,String temp) throws SQLException
    {
        AdminDao.deleteStudent(l2,temp);
    }
    public static void updateStudent(String nume,String grupa,int l2,String temp,String user) throws SQLException
    {
        AdminDao.updateStudent(new StudentData(null,nume,grupa,user),l2,temp,user);
    }
    public static void addGrade(String nota,int l2,String temp,String temp2) throws SQLException
    {
        AdminDao.addGrade(new NoteData("1",null,null,nota),l2,temp,temp2);
    }
    public static List<NoteData> loadGrade() throws SQLException{
        return AdminDao.loadStudentData2();
    }
    }

