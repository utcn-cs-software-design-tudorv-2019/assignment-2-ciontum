package Model.entity;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class StudentData {
    @Id
    private  String ID;
    private String Name;
    private String grupa;
    private String usern;
    public StudentData()
    {
        this.ID=null;
        this.Name=null;
        this.grupa=null;
        this.usern=null;
    }
    public StudentData(String id,String firstname,String lastname,String usern)
    {
        this.ID=id;
        this.Name=firstname;
        this.grupa=lastname;
        this.usern=usern;


    }

    public String getID() {
        return this.ID;
    }



    public void setID(String IDs) {
        System.out.println(ID);
        this.ID=IDs;
        System.out.println(this.ID);
    }
    public String getUser() {
        return this.usern;
    }



    public void setUser(String user) {
        System.out.println(user);
        this.usern=user;
        System.out.println(this.usern);
    }
    public String getName() {
        return Name;
    }



    public void setName(String name) {
        this.Name=name;
    }

    public String getGrupa() {
        return grupa;
    }



    public void setGrupa(String grupa) {
        this.grupa=grupa;
    }
}
