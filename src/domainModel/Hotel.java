package domainModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import tupleTypes.HabitacioNumPreu;

import tupleTypes.HabitacionsTuple;
import tupleTypes.InfoHotel;


public class Hotel implements java.io.Serializable {


     private String nom;
     private String descripcio;
     private String nomcategoria;
     private String nompoblacio;

        public Hotel() {
        }


        public Hotel(String nom) {
            this.nom = nom;
        }
        public Hotel(String nom, String descripcio, String nomcategoria, String nompoblacio) {
            this.nom = nom;
            this.descripcio = descripcio;
            this.nomcategoria = nomcategoria;
            this.nompoblacio = nompoblacio;
        }

        public String getNom() {
            return this.nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }
        public String getDescripcio() {
            return this.descripcio;
        }

        public void setDescripcio(String descripcio) {
            this.descripcio = descripcio;
        }
        public String getNomcategoria() {
            return this.nomcategoria;
        }

        public void setNomcategoria(String nomcategoria) {
            this.nomcategoria = nomcategoria;
        }
        public String getNompoblacio() {
            return this.nompoblacio;
        }

        public void setNompoblacio(String nompoblacio) {
            this.nompoblacio = nompoblacio;
        }
    
	private Set<PreuTipusHabitacio> preuTipusHabitacio;

        public Set<PreuTipusHabitacio> getPreuTipusHabitacio() {
            return preuTipusHabitacio;
        }

        public void setPreuTipusHabitacio(Set<PreuTipusHabitacio> preuTipusHabitacio) {
            this.preuTipusHabitacio = preuTipusHabitacio;
        }
	private Set<Habitacio> habitacions = new HashSet<Habitacio>();

        public Set<Habitacio> getHabitacions() {
            return habitacions;
        }

        public void setHabitacions(Set<Habitacio> habitacions) {
            this.habitacions = habitacions;
        }
        
	private ArrayList<Comentari> comentaris;
	private Categoria categoria;
	private static long TIME_IN_MILLIS = 3600000;
	
	public ArrayList<HabitacionsTuple> getHabitacions(Date dIni, Date dFi, int numOcup) {
		
		ArrayList<HabitacionsTuple> habitacions = new ArrayList<HabitacionsTuple>();
		
		for(Habitacio habitacio : this.habitacions) {
			int capacitat = habitacio.getCapacitat();
                        System.out.println("Habitacion " + habitacio.getNomtipus() + " con capacidad " + capacitat);
			if (numOcup <= capacitat) {
                            System.out.println("Tiene hab con capacitat suficiente");
				if (habitacio.estaDisponible(dIni, dFi)) {
                                        System.out.println("Esta disponible");
					String tipus = habitacio.getNomtipus();
					boolean tipusExistent = false;
					for(HabitacionsTuple h : habitacions) {
						if (h.tipusHabitacio.equals(tipus)) {
							h.numeroDisponibles++;
							tipusExistent = true;
							break;
						}
					}
					if (!tipusExistent) {
						double preuTotal = 0;
						for(PreuTipusHabitacio p : preuTipusHabitacio) {
							if (p.getId().getNomtipus().equals(tipus)) {
								double preu = p.getPreu();
								long dies = (dFi.getTime() - dIni.getTime())/TIME_IN_MILLIS;
								preuTotal = preu*dies;
								break;
							}
						}
						habitacions.add(new HabitacionsTuple(tipus, 1, preuTotal));
					}
				}
			}
		}
		return habitacions;
	}

	public InfoHotel getInfoHotel() {
		
		int sumAval = 0;
		float avaluacio;
		if (this.comentaris == null || this.comentaris.isEmpty()) {
			avaluacio = 0;
		}
                else {
                    for(Comentari c: this.comentaris) {
                            int aval = c.getAvaluacio();
                            sumAval += aval;
                    }
                    avaluacio = sumAval/this.comentaris.size();
		}
		
		String nomCategoria = this.nomcategoria;
		
		InfoHotel result = new InfoHotel(this.nom, this.descripcio, nomCategoria, avaluacio);
		return result;
	}
	
	public HabitacioNumPreu seleccionarHabitacio(String tipusHabitacio, Date dIni, Date dFi) {
		
		int num = 0;
		for(Habitacio h: this.habitacions) {
			String tipus = h.getNomtipus();
			if (tipus.equals(tipusHabitacio)) {
				if (h.estaDisponible(dIni, dFi)) {
					num = h.getNumero();
					break;
				}
			}
		}
		
		double preu = 0;
		for(PreuTipusHabitacio p: this.preuTipusHabitacio) {
			
			if (tipusHabitacio.equals(p.getId().getNomtipus())) {
				preu = p.getPreu();
				preu = preu*(dFi.getTime() - dIni.getTime())/TIME_IN_MILLIS;
			}
		}
		
		return new HabitacioNumPreu(num, (float)preu);
	}

}
