package Model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="note")
public class NoteData {
    @Id
    private String id;
    private String nume;
    private String examen;
    private String nota;

    public NoteData(String id2,String id,String firstname,String lastname)
    {
        this.id=id2;
        this.nume=id;
        this.examen=firstname;
        this.nota=lastname;


    }
    public NoteData()
    {
        this.nume=null;
        this.examen=null;
        this.nota=null;


    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getExamen() {
        return examen;
    }

    public void setExamen(String examen) {
        this.examen = examen;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
}

