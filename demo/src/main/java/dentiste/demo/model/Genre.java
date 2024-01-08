package dentiste.demo.model;

import dentiste.demo.annotation.ColumnField;
import dentiste.demo.annotation.Getter;
import dentiste.demo.annotation.Setter;
import dentiste.demo.annotation.TableName;
import dentiste.demo.table.JDBC;

import java.sql.SQLException;

@TableName(database = "dentiste", driver = "postgres", name = "genre", password = "366325", user = "postgres")
public class Genre extends JDBC {

    @ColumnField(columnName = "id", primaryKey = true, defaultValue = true)
    int id;

    @ColumnField(columnName = "nom")
    String nom;

    public Genre( String nom) throws SQLException, ClassNotFoundException {
        setNom(nom);
    }

    public Genre() throws SQLException, ClassNotFoundException {
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
}
