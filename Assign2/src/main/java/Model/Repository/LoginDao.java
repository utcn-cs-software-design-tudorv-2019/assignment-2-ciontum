package Model.Repository;

import Model.entity.LoginData;
import javafx.fxml.FXML;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LoginDao {
   static LoginData loginModel;
    static Session session;
    static SessionFactory sessionFactory;
//    static LoginData s=(LoginData) session.get(LoginData.class,"stud");
    @FXML
    public static int Logins(String user,String pass)
    {
        try
        {
            if(user.equals("stud"))
            {
                return 1;
            }
            else if (user.equals("admin"))
            {
                return 2;

            }
            else
            {
                return 3;
            }
        }
        catch (Exception localException)
        {

        }
        return 0;
    }
}
