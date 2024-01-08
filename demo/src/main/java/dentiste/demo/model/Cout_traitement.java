package dentiste.demo.model;

import dentiste.demo.annotation.ColumnField;
import dentiste.demo.annotation.Getter;
import dentiste.demo.annotation.Setter;
import dentiste.demo.annotation.TableName;
import dentiste.demo.table.JDBC;

import java.sql.SQLException;

@TableName(database = "dentiste", driver = "postgres", name = "cout_traitement", password = "366325", user = "postgres")
public class Cout_traitement extends JDBC {

    @ColumnField(columnName = "id", primaryKey = true, defaultValue = true)
    int id;

    @ColumnField(columnName = "id_traitement")
    int id_traitement;

    @ColumnField(columnName = "id_dent")
    int id_dent;

    @ColumnField(columnName = "cout")
    double cout;

    public Cout_traitement(  int id_traitement, int id_dent, double cout) throws SQLException, ClassNotFoundException {
        setId_dent(id_traitement);
        setId_dent(id_dent);
        setCout(cout);
    }

    public Cout_traitement() throws SQLException, ClassNotFoundException {
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

    @Getter(columnName = "id_dent")
    public int getId_dent() {
        return id_dent;
    }

    @Setter(columnName = "id_dent")
    public void setId_dent(int id_dent) {
        this.id_dent = id_dent;
    }

    @Getter(columnName = "id_traitement")
    public int getId_traitement() {
        return id_traitement;
    }

    @Setter(columnName = "id_traitement")
    public void setId_traitement(int id_traitement) {
        this.id_traitement = id_traitement;
    }

    @Getter(columnName = "cout")
    public double getCout() {
        return cout;
    }

    @Setter(columnName = "cout")
    public void setCout(double cout) {
        this.cout = cout;
    }
}
