package dentiste.demo.model;

import dentiste.demo.annotation.ColumnField;
import dentiste.demo.annotation.Getter;
import dentiste.demo.annotation.Setter;
import dentiste.demo.annotation.TableName;
import dentiste.demo.table.JDBC;

import java.sql.SQLException;

@TableName(database = "dentiste", driver = "postgres", name = "v_routeLalana", password = "366325", user = "postgres")
public class RouteLalana extends JDBC {

    @ColumnField(columnName = "id", primaryKey = true, defaultValue = true)
    int id;

    @ColumnField(columnName = "id_route")
    int id_route;

    @ColumnField(columnName = "nom")
    String nom;

    @ColumnField(columnName = "id_lalana")
    int id_lalana;

    @ColumnField(columnName = "code")
    String code;

    @ColumnField(columnName = "id_type_lalana")
    int id_type_lalana;

    @ColumnField(columnName = "etat")
    int etat;

    public RouteLalana( int id_route,String nom, int id_lalana,String code,int id_type_lalana, int etat) throws SQLException, ClassNotFoundException {
        setId_route(id_route);
        setNom(nom);
        setId_lalana(id_lalana);
        setCode(code);
        setId_type(id_type_lalana);
        setEtat(etat);
    }

    public RouteLalana() throws SQLException, ClassNotFoundException {
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

    @Getter(columnName = "nom")
    public String getNom() {
        return nom;
    }

    @Setter(columnName = "nom")
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Getter(columnName = "id_lalana")
    public int getId_lalana() {
        return id_lalana;
    }

    @Setter(columnName = "id_lalana")
    public void setId_lalana(int id_lalana) {
        this.id_lalana = id_lalana;
    }

    @Getter(columnName = "code")
    public String getCode() {
        return code;
    }

    @Setter(columnName = "code")
    public void setCode(String code) {
        this.code = code;
    }

    @Getter(columnName = "id_type_lalana")
    public int getId_type() {
        return id_type_lalana;
    }

    @Setter(columnName = "id_type_lalana")
    public void setId_type(int id_type_lalana) {
        this.id_type_lalana = id_type_lalana;
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
