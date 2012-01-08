package tupleTypes;

public class InfoHotel {
	
	public String nom;
	public String descripcio;
	public String categoria;
	public float avaluacio;

	public InfoHotel(String nom, String descripció, String nomCategoria,
			float avaluacio) {
		
		this.nom = nom;
		this.descripcio = descripció;
		this.categoria = nomCategoria;
		this.avaluacio = avaluacio;
	}
}