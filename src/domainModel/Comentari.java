package domainModel;


public class Comentari  implements java.io.Serializable {


    private ComentariId id;
    private Integer avaluacio;
    private String descripcio;

    public Comentari() {
    }

	
    public Comentari(ComentariId id) {
        this.id = id;
    }
    public Comentari(ComentariId id, Integer avaluacio, String descripcio) {
       this.id = id;
       this.avaluacio = avaluacio;
       this.descripcio = descripcio;
    }
   
    public ComentariId getId() {
        return this.id;
    }
    
    public void setId(ComentariId id) {
        this.id = id;
    }
    public Integer getAvaluacio() {
        return this.avaluacio;
    }
    
    public void setAvaluacio(Integer avaluacio) {
        this.avaluacio = avaluacio;
    }
    public String getDescripcio() {
        return this.descripcio;
    }
    
    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
}
