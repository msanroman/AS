package domainModel;

public class Categoria implements java.io.Serializable {

    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Categoria() {
    }

    public Categoria(String nom) {
       this.nom = nom;
    }
   
}
