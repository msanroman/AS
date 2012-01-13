package domainModel;

import java.util.ArrayList;
import java.util.Date;

import tupleTypes.HabitacionsTuple;
import tupleTypes.InfoHotel;


public class Hotel {


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
    
	private static class infoHabitacio {
		
		public int numHabitacio;
		public float preuHabitacio;
		
		public infoHabitacio(int num, float preu) {
			
			this.numHabitacio = num;
			this.preuHabitacio = preu;
		}
	}
	
	private ArrayList<PreuTipusHabitacio> preuTipusHabitacio;
	private ArrayList<Habitacio> habitacions = new ArrayList<Habitacio>();
	private ArrayList<Comentari> comentaris;
	private Categoria categoria;
	private static long TIME_IN_MILLIS = 3600000;
	
	public ArrayList<HabitacionsTuple> getHabitacions(Date dIni, Date dFi, int numOcup) {
		
		ArrayList<HabitacionsTuple> habitacions = new ArrayList<HabitacionsTuple>();
		
		for(Habitacio habitacio : this.habitacions) {
			int capacitat = habitacio.getCapacitat();
			if (numOcup <= capacitat) {
				if (habitacio.estaDisponible()) {
					String tipus = habitacio.getTipus();
					boolean tipusExistent = false;
					for(HabitacionsTuple h : habitacions) {
						if (h.tipusHabitacio == tipus) {
							h.numeroDisponibles++;
							tipusExistent = true;
							break;
						}
					}
					if (!tipusExistent) {
						float preuTotal = 0;
						for(PreuTipusHabitacio p : preuTipusHabitacio) {
							if (p.getNom() == tipus) {
								float preu = p.getPreu();
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
		int nComents = 0;
		for(Comentari c: this.comentaris) {
			nComents++;
			int aval = c.getAvaluacio();
			sumAval += aval;
		}
		
		float avaluacio;
		if (nComents == 0) {
			
			avaluacio = 0;
		}
		else {
			avaluacio = sumAval/nComents;
		}
		
		String nomCategoria = this.categoria.getNom();
		
		InfoHotel result = new InfoHotel(this.nom, this.descripcio, nomCategoria, avaluacio);
		return result;
	}
	
	public infoHabitacio seleccionarHabitacio(String tipusHabitacio, Date dIni, Date dFi) {
		
		int num = 0;
		for(Habitacio h: this.habitacions) {
			String tipus = h.getTipus();
			if (tipus == tipusHabitacio) {
				if (h.estaDisponible(dIni, dFi)) {
					num = h.getNumero();
					break;
				}
			}
		}
		
		float preu = 0;
		for(PreuTipusHabitacio p: this.preuTipusHabitacio) {
			
			if (tipusHabitacio == p.getTipus()) {
				preu = p.getPreu();
				preu = preu*(dFi.getTime() - dIni.getTime())/TIME_IN_MILLIS;
			}
		}
		
		return new infoHabitacio(num, preu);
	}

}
