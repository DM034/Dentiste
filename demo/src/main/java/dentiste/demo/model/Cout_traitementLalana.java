package dentiste.demo.model;

import dentiste.demo.annotation.ColumnField;
import dentiste.demo.annotation.Getter;
import dentiste.demo.annotation.Setter;
import dentiste.demo.annotation.TableName;
import dentiste.demo.table.JDBC;

import java.sql.SQLException;

@TableName(database = "dentiste", driver = "postgres", name = "cout_traitementLalana", password = "366325", user = "postgres")
public class Cout_traitementLalana extends JDBC {

    @ColumnField(columnName = "id", primaryKey = true, defaultValue = true)
    int id;

    @ColumnField(columnName = "id_traitement")
    int id_traitement;

    @ColumnField(columnName = "id_lalana")
    int id_lalana;

    @ColumnField(columnName = "cout")
    double cout;

    public Cout_traitementLalana(  int id_traitement, int id_lalana, double cout) throws SQLException, ClassNotFoundException {
        setId_traitement(id_traitement);
        setId_lalana(id_lalana);
        setCout(cout);
    }

    public Cout_traitementLalana() throws SQLException, ClassNotFoundException {
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

    @Getter(columnName = "id_lalana")
    public int getId_lalana() {
        return id_lalana;
    }

    @Setter(columnName = "id_lalana")
    public void setId_lalana(int id_lalana) {
        this.id_lalana = id_lalana;
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
