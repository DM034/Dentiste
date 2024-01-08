package dentiste.demo.model;

import dentiste.demo.annotation.ColumnField;
import dentiste.demo.annotation.Getter;
import dentiste.demo.annotation.Setter;
import dentiste.demo.annotation.TableName;
import dentiste.demo.table.JDBC;

import java.sql.SQLException;

@TableName(database = "dentiste", driver = "postgres", name = "budget_fanja", password = "366325", user = "postgres")
public class Budget_fanja extends JDBC {

    @ColumnField(columnName = "id", primaryKey = true, defaultValue = true)
    int id;

    @ColumnField(columnName = "id_route")
    int id_route;

    @ColumnField(columnName = "budget")
    double budget;

    @ColumnField(columnName = "etat")
    int etat;

    public Budget_fanja( int id_route, double budget, int etat) throws SQLException, ClassNotFoundException {
        setId_route(id_route);
        setBudget(budget);
        setEtat(etat);
    }

    public Budget_fanja() throws SQLException, ClassNotFoundException {
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

    @Getter(columnName = "id_route")
    public int getId_route() {
        return id_route;
    }

    @Setter(columnName = "id_route")
    public void setId_route(int id_route) {
        this.id_route = id_route;
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
