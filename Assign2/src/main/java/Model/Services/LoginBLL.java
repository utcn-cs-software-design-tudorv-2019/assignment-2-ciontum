package Model.Services;

import Model.Repository.LoginDao;

public class LoginBLL {
    public static int Login(String user,String pass)
    {
        return LoginDao.Logins(user,pass);
    }
}
