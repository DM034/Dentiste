package dentiste.demo.model;

import dentiste.demo.annotation.ColumnField;
import dentiste.demo.annotation.Getter;
import dentiste.demo.annotation.Setter;
import dentiste.demo.annotation.TableName;
import dentiste.demo.table.JDBC;

import java.sql.SQLException;
import java.util.LinkedList;

@TableName(database = "dentiste", driver = "postgres", name = "route", password = "366325", user = "postgres")
public class Route extends JDBC {

    @ColumnField(columnName = "id", primaryKey = true, defaultValue = true)
    int id;

    @ColumnField(columnName = "nom")
    String nom;

    public void traiterLalana(int id_type)throws Exception{
        if(id_type == 1){
            this.traiterLalanaV();
            // this.traiterDentS();
        }else if(id_type == 2){
            this.traiterLalanaH();
            // this.traiterDentB();
        }
    }

    public void traiterLalanaH() throws Exception{
        LinkedList<RouteLalana> lalana = this.getRouteAmboarinaHorsVille();
        for (int i = 0; i < lalana.size(); i++) {
            Budget_fanja budg = this.getBudgetFanjaByIdRoute();
            double budget = budg.getBudget();
            if(budget > 0){
                Rl lal = getRouteLalanaByIdLalana(lalana.get(i).getId_lalana());
                traiterLalana(lal);
            }
        }
    }    

    public void traiterLalanaV() throws Exception{
        LinkedList<RouteLalana> lalana = this.getRouteAmboarinaVille();
        for (int i = 0; i < lalana.size(); i++) {
            Budget_fanja budg = this.getBudgetFanjaByIdRoute();
            double budget = budg.getBudget();
            if(budget > 0){
                Rl lal = getRouteLalanaByIdLalana(lalana.get(i).getId_lalana());
                traiterLalana(lal);
            }
        }
    }    

    public void traiterLalana(Rl route)throws Exception{
        int etat = route.getEtat();
        double traiRep = route.getCoutTraitementLalanaByIdTraitement(2).getFirst().getCout();
        Budget_fanja budg = this.getBudgetFanjaByIdRoute();
        double budget = budg.getBudget();
                        System.out.println("budget client === "+budget);

        if(budget > 0){

            if(etat <= 9 && etat >= 0){
                budget = budget - traiRep;
                System.out.println("budgetNet = "+budget+" etat ="+etat);
                if(budget >= 0){
                    route.update("etat", "10");
                    budg.update("budget", String.valueOf(budget));
                }
            }
        
        }else{
            System.out.println("lany");
        }
    }

    public LinkedList<RouteLalana> getRouteAmboarinaHorsVille()throws Exception{
        LinkedList<RouteLalana> dp = new RouteLalana().select("where etat < 10 and id_type_lalana = 1 and id_route = "+this.id);
        return dp;
    }

    public LinkedList<RouteLalana> getRouteAmboarinaVille()throws Exception{
        LinkedList<RouteLalana> dp = new RouteLalana().select("where etat < 10 and id_type_lalana = 2 and id_route = "+this.id);
        return dp;
    }

    public LinkedList<RouteLalana> getRouteLalanaByIdRoute()throws Exception{
        LinkedList<RouteLalana> dp = new RouteLalana().select("where id_route = "+this.id);
        return dp;
    }

    public Rl getRouteLalanaByIdLalana(int id_lalana)throws Exception{
        Rl dp = (Rl) new Rl().select("where id_lalana = "+id_lalana+" and id_route = "+this.id).getFirst();
        return dp;
    }

    public Budget_fanja getBudgetFanjaByIdRoute()throws Exception{
        Budget_fanja val = (Budget_fanja) new Budget_fanja().select("where id_route = "+this.id).getFirst();
        return val;
    }

    public LinkedList<Route> getAllRoute()throws Exception{
        LinkedList<Route> patients = new Route().select();
        return patients;
    }

    public Route(String nom) throws SQLException, ClassNotFoundException {
        setNom(nom);
    }

    public Route() throws SQLException, ClassNotFoundException {
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
