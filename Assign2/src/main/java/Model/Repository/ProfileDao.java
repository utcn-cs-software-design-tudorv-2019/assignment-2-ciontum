package Model.Repository;

import Model.entity.NoteData;
import Model.entity.StudentData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ProfileDao {
    static Session session;
    static SessionFactory sessionFactory;
    public static String s;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();//HibernateUtil.java:11
        } catch (Throwable ex) {
            System.err.println("Initial session factory creation failed" + ex);
            throw new ExceptionInInitializerError(ex);//HibernateUtil.java:14
        }
    }

    public static List<StudentData> View(){
        String sqlNume = "select ID,nume,grupa from students where students.username= ?";
        ObservableList<StudentData> list;

        session = sessionFactory.openSession();
        Query q = session.createQuery("select ID,Name,grupa from StudentData where usern='stud'");
        System.out.println("Reading client");

        //list=q.list();

        List<StudentData> list2;
        list2=new ArrayList<StudentData>();
        list2=q.list();
        list2= FXCollections.observableArrayList(list2);

        list=(ObservableList)list2;
        session.close();
        return list;


    }
    public static void enroll(NoteData note){
        String sqlInsert2 = "INSERT INTO examene(nume,examen) VALUES (?,?)";
        String sqlView2="select nume from students where username=?";
        System.out.println("Creating student");
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(note);
        session.getTransaction().commit();
        session.close();
    }
}
