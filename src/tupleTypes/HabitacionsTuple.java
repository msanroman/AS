package tupleTypes;

public class HabitacionsTuple {
	
	public String tipusHabitacio;
	public int numeroDisponibles;
	public float preu;

	public HabitacionsTuple(String tipus, int numeroDisponibles, float preuTotal) {
		
		this.tipusHabitacio = tipus;
		this.numeroDisponibles = numeroDisponibles;
		this.preu = preuTotal;
	}
}