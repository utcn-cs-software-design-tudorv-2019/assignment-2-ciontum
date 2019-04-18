package Model.Repository;

import Model.entity.StudentData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDao {
    public String s;
    public void test(String text){
        s=text;
    }
    static Session session;
    static SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();//HibernateUtil.java:11
        } catch (Throwable ex) {
            System.err.println("Initial session factory creation failed" + ex);
            throw new ExceptionInInitializerError(ex);//HibernateUtil.java:14
        }
    }
    public static void addStudent(StudentData student)  {
        String sqlInsert = "INSERT INTO students(ID,nume,grupa,username) VALUES (?,?,?,?)";
        System.out.println("Creating student");
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
    }

}
