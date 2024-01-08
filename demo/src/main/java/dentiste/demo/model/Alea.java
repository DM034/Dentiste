package dentiste.demo.model;

import dentiste.demo.annotation.ColumnField;
import dentiste.demo.annotation.Getter;
import dentiste.demo.annotation.Setter;
import dentiste.demo.annotation.TableName;
import dentiste.demo.table.JDBC;

import java.sql.SQLException;

@TableName(database = "dentiste", driver = "postgres", name = "alea", password = "366325", user = "postgres")
public class Alea extends JDBC {

    @ColumnField(columnName = "id", primaryKey = true, defaultValue = true)
    int id;

    @ColumnField(columnName = "nify")
    String nify;

    @ColumnField(columnName = "note")
    String note;


    public Alea( String nify, String note) throws SQLException, ClassNotFoundException {
        setNify(nify);
        setNote(note);

    }

    public Alea() throws SQLException, ClassNotFoundException {
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

    @Getter(columnName = "nify")
    public String getNify() {
        return nify;
    }

    @Setter(columnName = "nify")
    public void setNify(String nify) {
        this.nify = nify;
    }


    @Getter(columnName = "note")
    public String getNote() {
        return note;
    }

    @Setter(columnName = "note")
    public void setNote(String note) {
        this.note = note;
    }

}
