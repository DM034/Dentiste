package dentiste.demo.model;

import dentiste.demo.annotation.ColumnField;
import dentiste.demo.annotation.Getter;
import dentiste.demo.annotation.Setter;
import dentiste.demo.annotation.TableName;
import dentiste.demo.table.JDBC;

import java.sql.SQLException;

@TableName(database = "dentiste", driver = "postgres", name = "traitement_patient", password = "366325", user = "postgres")
public class Traitement_patient extends JDBC {

    @ColumnField(columnName = "id", primaryKey = true, defaultValue = true)
    int id;

    @ColumnField(columnName = "id_patient")
    int id_patient;

    @ColumnField(columnName = "id_traitement")
    int id_traitement;

    @ColumnField(columnName = "nombre")
    int nombre;

    public Traitement_patient( int id_patient, int id_traitement, int nombre) throws SQLException, ClassNotFoundException {
        setId_patient(id_patient);
        setId_dent(id_traitement);
        setNombre(nombre);
    }

    public Traitement_patient() throws SQLException, ClassNotFoundException {
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

    @Getter(columnName = "id_traitement")
    public int getId_dent() {
        return id_traitement;
    }

    @Setter(columnName = "id_traitement")
    public void setId_dent(int id_traitement) {
        this.id_traitement = id_traitement;
    }

    @Getter(columnName = "nombre")
    public int getNombre() {
        return nombre;
    }

    @Setter(columnName = "nombre")
    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
}
