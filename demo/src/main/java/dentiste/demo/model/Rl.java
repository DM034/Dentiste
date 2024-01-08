package dentiste.demo.model;

import dentiste.demo.annotation.ColumnField;
import dentiste.demo.annotation.Getter;
import dentiste.demo.annotation.Setter;
import dentiste.demo.annotation.TableName;
import dentiste.demo.table.JDBC;

import java.sql.SQLException;
import java.util.LinkedList;

@TableName(database = "dentiste", driver = "postgres", name = "routeLalana", password = "366325", user = "postgres")
public class Rl extends JDBC {

    @ColumnField(columnName = "id", primaryKey = true, defaultValue = true)
    int id;

    @ColumnField(columnName = "id_route")
    int id_route;

    @ColumnField(columnName = "id_lalana")
    int id_lalana;

    @ColumnField(columnName = "etat")
    int etat;

    public LinkedList<Cout_traitementLalana> getCoutTraitementLalanaByIdTraitement(int idTraitement)throws Exception{
        LinkedList<Cout_traitementLalana> dp = new Cout_traitementLalana().select("where id_traitement = "+idTraitement+" and id_lalana = "+this.id);
        return dp;
    }

    public Rl( int id_route, int id_lalana, int etat) throws SQLException, ClassNotFoundException {
        setId_patient(id_route);
        setId_dent(id_lalana);
        setEtat(etat);
    }

    public Rl() throws SQLException, ClassNotFoundException {
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
    public int getId_patient() {
        return id_route;
    }

    @Setter(columnName = "id_route")
    public void setId_patient(int id_route) {
        this.id_route = id_route;
    }

    @Getter(columnName = "id_lalana")
    public int getId_dent() {
        return id_lalana;
    }

    @Setter(columnName = "id_lalana")
    public void setId_dent(int id_lalana) {
        this.id_lalana = id_lalana;
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
