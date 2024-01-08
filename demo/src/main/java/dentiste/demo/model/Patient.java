package dentiste.demo.model;

import dentiste.demo.annotation.ColumnField;
import dentiste.demo.annotation.Getter;
import dentiste.demo.annotation.Setter;
import dentiste.demo.annotation.TableName;
import dentiste.demo.table.JDBC;

import java.sql.Date;
import java.sql.SQLException;
import java.util.LinkedList;

@TableName(database = "dentiste", driver = "postgres", name = "patient", password = "366325", user = "postgres")
public class Patient extends JDBC {

    @ColumnField(columnName = "id", primaryKey = true, defaultValue = true)
    int id;

    @ColumnField(columnName = "nom")
    String nom;

    @ColumnField(columnName = "dtn")
    Date dtn;

    @ColumnField(columnName = "id_genre")
    int id_genre;

    public void traiterDent(int id_type)throws Exception{
        if(id_type == 1){
            this.traiterDentB();
            this.traiterDentS();
        }else if(id_type == 2){
            this.traiterDentS();
            this.traiterDentB();
        }
    }

    public void traiterDentB() throws Exception{
        LinkedList<Dent_patient> dents = this.getDentAmboarinaBeaute();
        for (int i = 0; i < dents.size(); i++) {
            Budget_patient budg = this.getBudgetPatientByIdPatient();
            double budget = budg.getBudget();
            if(budget > 0){
                Dp dent = getDentPatientByIdDent(dents.get(i).getId_dent());
                if(dent.getEtat() < 10){
                    traiterDent(dent);
                }
            }
        }
    }

    public void traiterDentS() throws Exception{
        LinkedList<Dent_patient> dents = this.getDentAmboarinaSanitaire();
        for (int i = 0; i < dents.size(); i++) {
            Budget_patient budg = this.getBudgetPatientByIdPatient();
            double budget = budg.getBudget();
            if(budget > 0){
                Dp dent = getDentPatientByIdDent(dents.get(i).getId_dent());
                
                    traiterDent(dent);
                
            }
        }
    }    

    public  void traiterDent(Dp dent)throws Exception{
        dent = (Dp) dent.select("WHERE id="+dent.getId()).getFirst();
        int etat = dent.getEtat();
        double traiNet = dent.getCoutTraitementByIdTraitement(1).getFirst().getCout();
        double traiRep = dent.getCoutTraitementByIdTraitement(2).getFirst().getCout();
        double traiEnl = dent.getCoutTraitementByIdTraitement(3).getFirst().getCout();
        double traiRemp = dent.getCoutTraitementByIdTraitement(4).getFirst().getCout();
        Budget_patient budg = this.getBudgetPatientByIdPatient();
        double budget = budg.getBudget();
                        System.out.println("budget client === "+budget+" etat "+etat);

        if(budget > 0 ){

            
            if(etat <= 9 & etat >= 7 & etat < 10){
                while (etat < 10) {
                    double vola = budget - traiNet;

                    System.out.println("budgetNet = "+vola);
                    if(vola >= 0 ){
                        etat = etat + 1;
                        System.out.println(" etat = "+etat);
                        budget = budget - traiNet;
                        
                        budg.update("budget", String.valueOf(budget));
                        
                        dent.update("etat", String.valueOf(etat));
                        // dent.setEtat(etat);
                        traiterDent(dent);
                    }else {
                        break;
                    }
                }
            }else if (etat <= 6 && etat >= 4){
                while (etat < 7) {
                    double vola = budget - traiRep;
                    System.out.println("budgetRep = "+vola);
                    if(vola >= 0 ){
                        etat = etat + 1;
                        System.out.println(" etat ="+etat);
                        budget = budget - traiRep;
                        
                        budg.update("budget", String.valueOf(budget));
                        
                        dent.update("etat", String.valueOf(etat));
                        // dent.setEtat(etat);
                        traiterDent(dent);
                    }else {
                        break;
                    }
                    

                }
            }else if (etat <= 3 && etat >= 1 ){
                double vola = budget - traiEnl;
                System.out.println("budget manala = "+vola);
                if(vola >= 0){
                    budget = budget - traiEnl;         
                    dent.update("etat", "0");
                    budg.update("budget", String.valueOf(budget));
                    System.out.println("budget = "+budget);
                    
                }
                
            }else if(etat == 0 ){
                double vola = budget - traiRemp;
                System.out.println("budget manolo = "+vola);
                if(vola >= 0){
                    budget = budget - traiRemp;
                    dent.update("etat", "10");
                    budg.update("budget", String.valueOf(budget));
                }

            }
        
        }else{
            System.out.println("lany");
            throw new Exception("2000000000000000000000000000000024444444444444444444444444444");
        }
    }
    
    public LinkedList<Dent_patient> getDentAmboarinaBeaute()throws Exception{
        LinkedList<Dent_patient> dp = new Dent_patient().select("where etat < 10 and id_type = 1 and id_patient = "+this.id);
        return dp;
    }

    public LinkedList<Dent_patient> getDentAmboarinaSanitaire()throws Exception{
        LinkedList<Dent_patient> dp = new Dent_patient().select("where etat < 10 and id_type = 2 and id_patient = "+this.id);
        return dp;
    }

    public LinkedList<Dent_patient> getDentPatientHByIdPatient()throws Exception{
        LinkedList<Dent_patient> dp = new Dent_patient().select("where code like 'A%' and id_patient = "+this.id);
        return dp;
    }

    public LinkedList<Dent_patient> getDentPatientBByIdPatient()throws Exception{
        LinkedList<Dent_patient> dp = new Dent_patient().select("where code like 'B%' and id_patient = "+this.id);
        return dp;
    }

    public Dp getDentPatientByIdDent(int id_dent)throws Exception{
        Dp dp = (Dp) new Dp().select("where id_dent = "+id_dent+" and id_patient = "+this.id).getFirst();
        return dp;
    }

    public Budget_patient getBudgetPatientByIdPatient()throws Exception{
        Budget_patient val = (Budget_patient) new Budget_patient().select("where id_patient = "+this.id).getFirst();
        return val;
    }

    public LinkedList<Patient> getAllPatient()throws Exception{
        LinkedList<Patient> patients = new Patient().select();
        return patients;
    }

    public Patient(String nom, Date dtn, int id_genre) throws SQLException, ClassNotFoundException {
        setNom(nom);
        setDtn(dtn);
        setId_genre(id_genre);

    }

    public Patient() throws SQLException, ClassNotFoundException {
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

    @Getter(columnName = "dtn")
    public Date getDtn() {
        return dtn;
    }

    @Setter(columnName = "dtn")
    public void setDtn(Date dtn) {
        this.dtn = dtn;
    }

    @Getter(columnName = "id_genre")
    public int getId_genre() {
        return id_genre;
    }

    @Setter(columnName = "id_genre")
    public void setId_genre(int id_genre) {
        this.id_genre = id_genre;
    }
}
