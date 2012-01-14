package tupleTypes;

public class HabitacionsTuple {
	
	public String tipusHabitacio;
	public int numeroDisponibles;
	public double preu;

	public HabitacionsTuple(String tipus, int numeroDisponibles, double preuTotal) {
		
		this.tipusHabitacio = tipus;
		this.numeroDisponibles = numeroDisponibles;
		this.preu = preuTotal;
	}
}