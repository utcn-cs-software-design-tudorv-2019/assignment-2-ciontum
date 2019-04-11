package Repository;


import entity.StudentData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class AdminDao {
    static SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
    static Session session;
    public static String s;
    public void test2(String text){
        s=text;
    }

    private static String sql="SELECT * FROM students";




    public List<StudentData> loadStudentData() {
        Query q = session.createQuery("select _c from Student _c");

        List<StudentData> Studlist=q.list();

        System.out.println("Reading car records...");
        for (StudentData c : Studlist) {
            System.out.printf( c.getID(), c.getName(),c.getGrupa());
        }
        session.close();
        return Studlist;
    }


    public static void addStudent(StudentData student  ){
        System.out.println("Creating student");
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
    }

    public static void deleteStudent(int id) {

            System.out.println("Deleting client");
            session = sessionFactory.openSession();
           StudentData c = (StudentData) session.get(StudentData.class,id);
            session.beginTransaction();
            session.delete(c);
            session.getTransaction().commit();
            session.close();

        }

}
