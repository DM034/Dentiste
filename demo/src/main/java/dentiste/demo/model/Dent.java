package dentiste.demo.model;

import dentiste.demo.annotation.ColumnField;
import dentiste.demo.annotation.Getter;
import dentiste.demo.annotation.Setter;
import dentiste.demo.annotation.TableName;
import dentiste.demo.table.JDBC;

import java.sql.SQLException;

@TableName(database = "dentiste", driver = "postgres", name = "dent", password = "366325", user = "postgres")
public class Dent extends JDBC {

    @ColumnField(columnName = "id", primaryKey = true, defaultValue = true)
    int id;

    @ColumnField(columnName = "nom")
    String nom;

    @ColumnField(columnName = "code")
    int code;

    @ColumnField(columnName = "id_type")
    int id_type;

    public Dent( String nom, int code, int id_type) throws SQLException, ClassNotFoundException {
        setNom(nom);
        setCode(code);
        setId_type(id_type);
    }

    public Dent() throws SQLException, ClassNotFoundException {
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

    @Getter(columnName = "nom")
    public String getNom() {
        return nom;
    }

    @Setter(columnName = "nom")
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Getter(columnName = "code")
    public int getCode() {
        return code;
    }

    @Setter(columnName = "code")
    public void setCode(int code) {
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

}
