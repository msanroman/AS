
import Hibernate.NewHibernateUtil;
import Strategies.IPreuStrategy;
import Strategies.PreuAmbDescompte;
import Strategies.PreuAmbPercentatge;

import domainModel.*;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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

1. ManresaSuite500minus100
2. ManresaStandard300minus100
3. PastelManresaSuite400/2
4. PastelManresaStandard200/2
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
        
        IPreuStrategy descompte = new PreuAmbDescompte(new PreuTipusHabitacioId("Hotel Manresa", "Suite"), 100f);
        IPreuStrategy descompte2 = new PreuAmbDescompte(new PreuTipusHabitacioId("Hotel Manresa", "Standard"), 100f);
        IPreuStrategy descompte3 = new PreuAmbPercentatge(new PreuTipusHabitacioId("Hotel Pastel Manresa", "Suite"), 0.5f);
        IPreuStrategy descompte4 = new PreuAmbPercentatge(new PreuTipusHabitacioId("Hotel Pastel Manresa", "Standard"), 0.5f);
        
        PreuTipusHabitacio preuTipusHab = new PreuTipusHabitacio(new PreuTipusHabitacioId("Hotel Manresa", "Suite"), 500f, descompte);
        PreuTipusHabitacio preuTipusHab2 = new PreuTipusHabitacio(new PreuTipusHabitacioId("Hotel Manresa", "Standard"), 300f, descompte2);
        PreuTipusHabitacio preuTipusHab3 = new PreuTipusHabitacio(new PreuTipusHabitacioId("Hotel Pastel Manresa", "Suite"), 400f, descompte3);
        PreuTipusHabitacio preuTipusHab4 = new PreuTipusHabitacio(new PreuTipusHabitacioId("Hotel Pastel Manresa", "Standard"), 200f, descompte4);
        
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
    
    public void clearDatabase() throws HibernateException {
        
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from Reserva");
        query.executeUpdate();
        query = session.createQuery("delete from Habitacio");
        query.executeUpdate();
        query = session.createQuery("delete from PreuAmbDescompte");
        query.executeUpdate();
        query = session.createQuery("delete from PreuAmbPercentatge");
        query.executeUpdate();
        query = session.createQuery("delete from PreuTipusHabitacio");
        query.executeUpdate();
        query = session.createQuery("delete from TipusHabitacio");
        query.executeUpdate();
        query = session.createQuery("delete from Hotel");
        query.executeUpdate();
        query = session.createQuery("delete from Categoria");
        query.executeUpdate();
        query = session.createQuery("delete from Poblacio");
        query.executeUpdate();
        session.getTransaction().commit();
    }
}
