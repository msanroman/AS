package domainModel;

public class Categoria implements java.io.Serializable {

    private String nom;

    public Categoria() {
    }

    public Categoria(String nom) {
       this.nom = nom;
    }
   
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

}
