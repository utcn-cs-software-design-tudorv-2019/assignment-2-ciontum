package Model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="login")
public class LoginData {

        private String user;
        private String parola;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public LoginData(String user, String parola)
       {
           this.user=user;
           this.parola=parola;
       }
}
