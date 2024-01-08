package dentiste.demo.model;

import dentiste.demo.annotation.ColumnField;
import dentiste.demo.annotation.Getter;
import dentiste.demo.annotation.Setter;
import dentiste.demo.annotation.TableName;
import dentiste.demo.table.JDBC;

import java.sql.SQLException;

@TableName(database = "dentiste", driver = "postgres", name = "v_dent_patient", password = "366325", user = "postgres")
public class Dent_patient extends JDBC {

    @ColumnField(columnName = "id", primaryKey = true, defaultValue = true)
    int id;

    @ColumnField(columnName = "id_patient")
    int id_patient;

    @ColumnField(columnName = "nom")
    String nom;

    @ColumnField(columnName = "id_dent")
    int id_dent;

    @ColumnField(columnName = "code")
    String code;

    @ColumnField(columnName = "id_type")
    int id_type;

    @ColumnField(columnName = "etat")
    int etat;

    public Dent_patient( int id_patient,String nom, int id_dent,String code,int id_type, int etat) throws SQLException, ClassNotFoundException {
        setId_patient(id_patient);
        setNom(nom);
        setId_dent(id_dent);
        setCode(code);
        setId_type(id_type);
        setEtat(etat);
    }

    public Dent_patient() throws SQLException, ClassNotFoundException {
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

    @Getter(columnName = "nom")
    public String getNom() {
        return nom;
    }

    @Setter(columnName = "nom")
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Getter(columnName = "id_dent")
    public int getId_dent() {
        return id_dent;
    }

    @Setter(columnName = "id_dent")
    public void setId_dent(int id_dent) {
        this.id_dent = id_dent;
    }

    @Getter(columnName = "code")
    public String getCode() {
        return code;
    }

    @Setter(columnName = "code")
    public void setCode(String code) {
        this.code = code;
    }

    @Getter(columnName = "id_type")
    public int getId_type() {
        return id_type;
    }

    @Setter(columnName = "id_type")
    public void setId_type(int id_type) {
        this.id_type = id_type;
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
