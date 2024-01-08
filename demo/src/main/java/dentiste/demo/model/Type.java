package dentiste.demo.model;

import dentiste.demo.annotation.ColumnField;
import dentiste.demo.annotation.Getter;
import dentiste.demo.annotation.Setter;
import dentiste.demo.annotation.TableName;
import dentiste.demo.table.JDBC;

import java.sql.SQLException;
import java.util.LinkedList;

@TableName(database = "dentiste", driver = "postgres", name = "type", password = "366325", user = "postgres")
public class Type extends JDBC {

    @ColumnField(columnName = "id", primaryKey = true, defaultValue = true)
    int id;

    @ColumnField(columnName = "nom")
    String nom;

    @ColumnField(columnName = "valeur")
    int valeur;

    public LinkedList<Type> getAllType()throws Exception{
        LinkedList<Type> type = new Type().select();
        return type;
    }

    public Type( String nom, int valeur) throws SQLException, ClassNotFoundException {
        setNom(nom);
        setValeur(valeur);
    }

    public Type() throws SQLException, ClassNotFoundException {
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

    @Getter(columnName = "valeur")
    public int getValeur() {
        return valeur;
    }

    @Setter(columnName = "valeur")
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
}
