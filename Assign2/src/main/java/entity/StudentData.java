package entity;



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
    public StudentData()
    {
        this.ID=null;
        this.Name=null;
        this.grupa=null;
    }
    public StudentData(String id,String firstname,String lastname)
    {
        this.ID=id;
        this.Name=firstname;
        this.grupa=lastname;



    }

    public String getID() {
        return this.ID;
    }



    public void setID(String IDs) {
        System.out.println(ID);
        this.ID=IDs;
        System.out.println(this.ID);
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
