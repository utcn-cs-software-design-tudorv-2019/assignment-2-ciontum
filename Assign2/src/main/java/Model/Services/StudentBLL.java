package Model.Services;

import Model.Repository.ProfileDao;
import Model.Repository.StudentDao;
import Model.entity.NoteData;
import Model.entity.StudentData;

public class StudentBLL {

    public StudentBLL(){

    }
    public static void addStudent2(String id, String nume, String grupa)
    {
        StudentDao.addStudent(new StudentData(id,nume,grupa,null));
    }
    public static void enroll(String id2,String id,String examen,String grupa)
    {
        ProfileDao.enroll(new NoteData(id2,id,examen,grupa));
    }
}
