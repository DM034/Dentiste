package dentiste.demo.model;

import dentiste.demo.annotation.ColumnField;
import dentiste.demo.annotation.Getter;
import dentiste.demo.annotation.Setter;
import dentiste.demo.annotation.TableName;
import dentiste.demo.table.JDBC;

import java.sql.SQLException;
import java.sql.Timestamp;

@TableName(database = "dentiste", driver = "postgres", name = "rdv", password = "366325", user = "postgres")
public class Rdv
 extends JDBC {

    @ColumnField(columnName = "id", primaryKey = true, defaultValue = true)
    int id;

    @ColumnField(columnName = "dateheure")
    Timestamp dateheure;

    @ColumnField(columnName = "id_traitement_patient")
    int id_traitement_patient;

    public Rdv( Timestamp dateheure, int id_traitement_patient) throws SQLException, ClassNotFoundException {
        setDateheure(dateheure);
        setId_traitement_patient(id_traitement_patient);
    }

    public Rdv
    () throws SQLException, ClassNotFoundException {
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

    @Getter(columnName = "dateheure")
    public Timestamp getDateheure() {
        return dateheure;
    }

    @Setter(columnName = "dateheure")
    public void setDateheure(Timestamp dateheure) {
        this.dateheure = dateheure;
    }

    @Getter(columnName = "id_traitement_patient")
    public int getId_traitement_patient() {
        return id_traitement_patient;
    }

    @Setter(columnName = "id_traitement_patient")
    public void setId_traitement_patient(int id_traitement_patient) {
        this.id_traitement_patient = id_traitement_patient;
    }

}
