package dentiste.demo.model;

import dentiste.demo.annotation.ColumnField;
import dentiste.demo.annotation.Getter;
import dentiste.demo.annotation.Setter;
import dentiste.demo.annotation.TableName;
import dentiste.demo.table.JDBC;

import java.sql.SQLException;

@TableName(database = "dentiste", driver = "postgres", name = "budget_patient", password = "366325", user = "postgres")
public class Budget_patient extends JDBC {

    @ColumnField(columnName = "id", primaryKey = true, defaultValue = true)
    int id;

    @ColumnField(columnName = "id_patient")
    int id_patient;

    @ColumnField(columnName = "budget")
    double budget;

    @ColumnField(columnName = "etat")
    int etat;

    public Budget_patient( int id_patient, double budget, int etat) throws SQLException, ClassNotFoundException {
        setId_patient(id_patient);
        setBudget(budget);
        setEtat(etat);
    }

    public Budget_patient() throws SQLException, ClassNotFoundException {
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

    @Getter(columnName = "budget")
    public double getBudget() {
        return budget;
    }

    @Setter(columnName = "budget")
    public void setBudget(double budget) {
        this.budget = budget;
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
