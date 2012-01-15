/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domainControllerTests;

import Hibernate.NewHibernateUtil;
import domainControllers.trSeleccionarHabitacio;
import domainModel.*;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.*;
import tupleTypes.InfoHotel;

/**
 *
 * @author Endymiion
 */
public class trSeleccionarHabitacioTest {
    
    public trSeleccionarHabitacioTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Categoria c = new Categoria("Cinc estrelles");
        session.saveOrUpdate(c);
        Poblacio p = new Poblacio("Pob");
        session.saveOrUpdate(p);
        Hotel h = new Hotel("Ritz", "Luxury", "Cinc estrelles", "Pob");
        session.saveOrUpdate(h);
        PreuTipusHabitacio preu = new PreuTipusHabitacio(new PreuTipusHabitacioId("Ritz", "Suite"), 1000d);
        session.saveOrUpdate(preu);
        Habitacio hab = null;
        hab = new Habitacio(new HabitacioId("Ritz", 104), "Suite");
        session.saveOrUpdate(hab);
        session.getTransaction().commit();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("delete from PreuTipusHabitacio");
        q.executeUpdate();
        q = session.createQuery("delete from Habitacio");
        q.executeUpdate();
        q = session.createQuery("delete from Hotel");
        q.executeUpdate();
        q = session.createQuery("delete from Poblacio");
        q.executeUpdate();
        q = session.createQuery("delete from Categoria");
        q.executeUpdate();
        session.getTransaction().commit();
    }
    
    @Test
    public void testSeleccionarHabitacio() {
        
        trSeleccionarHabitacio tr = new trSeleccionarHabitacio("Ritz", "Suite", new Date(3600000), new Date(3600000*2));
        tr.executa();
        Assert.assertEquals(104, tr.obtenirResultat().numHab);
        Assert.assertTrue(tr.obtenirResultat().preu == Float.valueOf("1000"));
    }
    
    @Test
    public void testGetInfoHotel() {
        
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Hotel h = (Hotel) session.get(Hotel.class, "Ritz");
        InfoHotel info = h.getInfoHotel();
        Assert.assertTrue(info.avaluacio == Float.valueOf("0"));
        Assert.assertTrue(info.categoria.equals("Cinc estrelles"));
        Assert.assertTrue(info.nom.equals("Ritz"));
        Assert.assertTrue(info.descripcio.equals("Luxury"));
    }
}
