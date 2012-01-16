
import Hibernate.NewHibernateUtil;
import domainModel.*;
import java.util.Date;
import org.hibernate.Session;

/*
 * The data that will be inserted when it's fully implemented
 * 
  -- Poblacions --

1. Manresa
2. Barcelona

-- Hotels --

1. Hotel Manresa
2. Hotel Pastel Manresa
3. Hotel Princesa Sofia
4. Hotel Pastel Sofia

-- TipusHabitacio --

1. Suite
2. Standard

-- PreuTipusHabitacio --

1. ManresaSuite500
2. ManresaStandard250
3. PastelManresaSuite400
4. PastelManresaStandard150
5. PrincesaSuite1000
6. PrincesaStandard600

-- Habitacio --

1. HabitacioSuiteManresa
2. HabitacioStandardPastel
3. HabitacioPrincesaSuite
4. HabitacioPrincesaStandard
 * 
 * 
 */


public class DataLoader {
    public void fillDatabase() {
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Poblacio p = new Poblacio("Manresa");
        Categoria c = new Categoria("Categoria1");
        Hotel h = new Hotel("Hotel Manresa", "desc", "Categoria1", "Manresa");
        Hotel h2 = new Hotel("Hotel Pastel Manresa", "desc2", "Categoria1", "Manresa");
        
        HabitacioId hId = new HabitacioId("Hotel Manresa", 1);
        HabitacioId hId0 = new HabitacioId("Hotel Pastel Manresa", 2);
        
        TipusHabitacio tipusHab = new TipusHabitacio("Suite", 3, "descHabitacio");
        TipusHabitacio tipusHab2 = new TipusHabitacio("Standard", 3, "descHabitacio");
        
        PreuTipusHabitacio preuTipusHab = new PreuTipusHabitacio(new PreuTipusHabitacioId("Hotel Manresa", "Suite"), 500d);
        PreuTipusHabitacio preuTipusHab2 = new PreuTipusHabitacio(new PreuTipusHabitacioId("Hotel Manresa", "Standard"), 250d);
        PreuTipusHabitacio preuTipusHab3 = new PreuTipusHabitacio(new PreuTipusHabitacioId("Hotel Pastel Manresa", "Suite"), 400d);
        PreuTipusHabitacio preuTipusHab4 = new PreuTipusHabitacio(new PreuTipusHabitacioId("Hotel Pastel Manresa", "Standard"), 150d);
        
        Habitacio hab = new Habitacio(hId, "Suite");
        Habitacio hab2 = new Habitacio(hId0, "Standard");
        Reserva res = new Reserva(new ReservaId("Hotel Manresa", 1, new Date(100)), new Date(100), new Date(101), 500d);
        Reserva res2 = new Reserva(new ReservaId("Hotel Pastel Manresa", 2, new Date(100)), new Date(100), new Date(101), 150d);

        session.saveOrUpdate(p);
        session.saveOrUpdate(c);
        session.saveOrUpdate(h);
        session.saveOrUpdate(h2);
        session.saveOrUpdate(tipusHab);
        session.saveOrUpdate(tipusHab2);
        session.saveOrUpdate(preuTipusHab);
        session.saveOrUpdate(preuTipusHab2);
        session.saveOrUpdate(preuTipusHab3);
        session.saveOrUpdate(preuTipusHab4);
        session.saveOrUpdate(hab);
        session.saveOrUpdate(hab2);
        session.saveOrUpdate(res);
        session.saveOrUpdate(res2);
        session.getTransaction().commit();
   }
}
