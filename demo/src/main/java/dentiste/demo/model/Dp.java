package dentiste.demo.model;

import dentiste.demo.annotation.ColumnField;
import dentiste.demo.annotation.Getter;
import dentiste.demo.annotation.Setter;
import dentiste.demo.annotation.TableName;
import dentiste.demo.table.JDBC;

import java.sql.SQLException;
import java.util.LinkedList;

@TableName(database = "dentiste", driver = "postgres", name = "dent_patient", password = "366325", user = "postgres")
public class Dp extends JDBC {

    @ColumnField(columnName = "id", primaryKey = true, defaultValue = true)
    int id;

    @ColumnField(columnName = "id_patient")
    int id_patient;

    @ColumnField(columnName = "id_dent")
    int id_dent;

    @ColumnField(columnName = "etat")
    int etat;

    public LinkedList<Cout_traitement> getCoutTraitementByIdTraitement(int idTraitement)throws Exception{
        LinkedList<Cout_traitement> dp = new Cout_traitement().select("where id_traitement = "+idTraitement+" and id_dent = "+this.id);
        return dp;
    }

    public Dp( int id_patient, int id_dent, int etat) throws SQLException, ClassNotFoundException {
        setId_patient(id_patient);
        setId_dent(id_dent);
        setEtat(etat);
    }

    public Dp() throws SQLException, ClassNotFoundException {
        // Constructeur par défaut
    }

    @Getter(columnName = "id")
    public int getId() {
        return id;
    }

    @Setter(columnName = "id")
    public void setId(int id) {
        this.id = id;
    }

    @Getter(columnName = "id_patient")
    public int getId_patient() {
        return id_patient;
    }

    @Setter(columnName = "id_patient")
    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    @Getter(columnName = "id_dent")
    public int getId_dent() {
        return id_dent;
    }

    @Setter(columnName = "id_dent")
    public void setId_dent(int id_dent) {
        this.id_dent = id_dent;
    }

    @Getter(columnName = "etat")
    public int getEtat() {
        return etat;
    }

    @Setter(columnName = "etat")
    public void setEtat(int etat) {
        this.etat = etat;
    }
}
