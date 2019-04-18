import Model.Services.AdminBLL;
import Model.entity.StudentData;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.List;

public class Crud {

        @Test
        public void crud() {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();

           // create(session);
            read(session);

            update(session);
            read(session);

           // delete(session);
            read(session);
            AdminBLL d=new AdminBLL();
           // d.addStudent("7","Stefan","30211");
            session.close();
        }

        private void delete(Session session) {
            System.out.println("Deleting student");
            StudentData s=(StudentData) session.get(StudentData.class,"2");

            session.beginTransaction();
            session.delete(s);
            session.getTransaction().commit();
        }

        private void update(Session session) {
            System.out.println("Updating mustang price...");
            StudentData s=(StudentData) session.get(StudentData.class,"1");
            s.setName("Ciprian");


            session.beginTransaction();
            session.saveOrUpdate(s);
            session.getTransaction().commit();
        }

        private void create(Session session) {
            System.out.println("Creating car records...");
            StudentData s=new StudentData("6","Mihai","30233","stud2");
            session.beginTransaction();
            session.save(s);
            session.getTransaction().commit();
        }

        private void read(Session session) {
            Query q = session.createQuery("select _c from StudentData _c");

            List<StudentData> Studlist=q.list();

            System.out.println("Reading car records...");
            for (StudentData c : Studlist) {
                System.out.printf(  c.getName(),c.getGrupa());
            }
        }
    }
