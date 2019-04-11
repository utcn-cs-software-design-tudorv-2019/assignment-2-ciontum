package Repository;

import Repository.AdminDao;
import entity.StudentData;

import java.sql.SQLException;

public class AdminBLL {
    public AdminBLL() {

    }



    public void addStudent(String id, String nume, String grupa) {
        AdminDao.addStudent(new StudentData(id, nume, grupa));
    }

    public void deleteStudent(int id)
    {
        AdminDao.deleteStudent(id);
    }

    }

