package Model.Repository;


import Model.entity.NoteData;
import Model.entity.StudentData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AdminDao {
    //   static SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
    static Session session;
    static SessionFactory sessionFactory;
    public static String s;

    public void test2(String text) {
        s = text;
    }

    private static String sql = "SELECT * FROM students";

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();//HibernateUtil.java:11
        } catch (Throwable ex) {
            System.err.println("Initial session factory creation failed" + ex);
            throw new ExceptionInInitializerError(ex);//HibernateUtil.java:14
        }
    }


    public static void addStudent(StudentData student) {
        System.out.println("Creating student");
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
    }


    public static List<StudentData> loadStudentData() {
        ObservableList<StudentData> list;

        session = sessionFactory.openSession();
        Query q = session.createQuery("select _c from StudentData _c");
        System.out.println("Reading client");

        //list=q.list();

        List<StudentData> list2;
        list2 = new ArrayList<StudentData>();
        list2 = q.list();
        list2 = FXCollections.observableArrayList(list2);

        list = (ObservableList) list2;
        session.close();
        return list;

    }

    public static void deleteStudent(int l2, String Temp) throws SQLException {
        String sqlDelete = "DELETE FROM students WHERE ID = ?";
        if (l2 >= 0) {

            session = sessionFactory.openSession();
            session.beginTransaction();
            StudentData s = (StudentData) session.get(StudentData.class, Temp);

            session.delete(s);
            session.getTransaction().commit();
            session.close();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("No selection was made");
            alert.setContentText("You have not selected");
            alert.showAndWait();
        }
    }

    public static void updateStudent(StudentData student, int l2, String temp, String user) throws SQLException {


        if (l2 >= 0) {

            System.out.println("Updating mustang price...");
            session = sessionFactory.openSession();
            session.beginTransaction();
            StudentData s = (StudentData) session.get(StudentData.class, temp);
            if (!student.getName().equals(""))
                s.setName(student.getName());

            if (!student.getGrupa().equals(""))
                s.setGrupa(student.getGrupa());
            if (!student.getUser().equals(""))
                s.setUser(student.getUser());


            session.saveOrUpdate(s);
            session.getTransaction().commit();


        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("No selection was made");
            alert.setContentText("You have not selected");
            alert.showAndWait();
        }
    }

    public static void addGrade(NoteData nota, int l, String temp1, String temp2) throws SQLException {
        String sqlUpdate = "UPDATE examene SET Nota = ? where nume=? and examen=?";


        if (l >= 0) {
            System.out.println("Creating student");
            session = sessionFactory.openSession();
            session.beginTransaction();
            NoteData nota1=(NoteData)session.get(NoteData.class,temp1);
            nota1.setNota(nota.getNota());
            session.saveOrUpdate(nota1);
            session.getTransaction().commit();
            session.close();


        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("No selection was made");
            alert.setContentText("You have not selected");
            alert.showAndWait();
        }
    }

    public static List<NoteData> loadStudentData2() throws SQLException {
        ObservableList<NoteData> list;

        session = sessionFactory.openSession();
        Query q = session.createQuery("select _c from NoteData _c");
        System.out.println("Reading client");

        //list=q.list();

        List<NoteData> list2;
        list2 = new ArrayList<NoteData>();
        list2 = q.list();
        list2 = FXCollections.observableArrayList(list2);

        list = (ObservableList) list2;
        session.close();
        return list;

    }
}