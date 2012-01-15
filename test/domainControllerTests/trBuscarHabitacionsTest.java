package domainControllerTests;

import Hibernate.NewHibernateUtil;
import domainControllers.trBuscarHabitacions;
import domainModel.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import static org.junit.Assert.fail;
import org.junit.*;
import tupleTypes.HotelAmbHabitacions;

/**
 *
 * @author Endymiion
 */
public class trBuscarHabitacionsTest {
    
    public trBuscarHabitacionsTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void testBuscarHabitacionsWithNoLocationsShouldThrowAnException() {
        clearDatabase();
        trBuscarHabitacions tx = new trBuscarHabitacions("Manresa", new Date(100), new Date(101),3);
        try {
            tx.executa();
            fail();
        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.assertEquals("No existeix aquesta poblacio", ex.getMessage());
        }
    }
    
    @Test
    public void testBuscarHabitacionsWithNoHotelsWithRoomsAvailableShouldThrowAnException() {
        clearDatabase();
        insertLocation();
        trBuscarHabitacions tx = new trBuscarHabitacions("Olesa", new Date(100), new Date(101),3);
        try {
            tx.executa();
            fail();
        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.assertEquals("hotelsNoDisp", ex.getMessage());
        }
        deleteLocation();
    }
    
    @Test
    public void testBuscarHabitacionsWithAHotelWithOneRoomAvailableShouldReturnOneAvailableRoom() {
        
        insertLocationWithOneHotelAndOneRoom();
        trBuscarHabitacions tx = new trBuscarHabitacions("Manresa", new Date(100), new Date(101),3);
        try {
            tx.executa();
            ArrayList<HotelAmbHabitacions> hAmbHab = tx.obtenirResultat();
            Assert.assertEquals(hAmbHab.size(), 1);
        } catch (Exception ex) {
            ex.printStackTrace();
            fail();
        }
    }

    private void deleteLocation() {
        
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from Poblacio");
        query.executeUpdate();
    }

    private void insertLocation() throws HibernateException {
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Poblacio p = new Poblacio("Olesa");
        session.merge(p);
        session.getTransaction().commit();
    }
    
    private void insertLocationWithOneHotelAndOneRoom() {
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Poblacio p = new Poblacio("Manresa");
        Categoria c = new Categoria("Categoria1");
        Hotel h = new Hotel("Hotel", "desc", "Categoria1", "Manresa");
        HabitacioId hId = new HabitacioId("Hotel", 1);
        TipusHabitacio tipusHab = new TipusHabitacio("Suite", 3, "descHabitacio");
        PreuTipusHabitacio preuTipusHab = new PreuTipusHabitacio(new PreuTipusHabitacioId("Hotel", "Suite"), 1000d);
        Habitacio hab = new Habitacio(hId, "Suite");
        
        session.saveOrUpdate(p);
        session.saveOrUpdate(c);
        session.saveOrUpdate(h);
        session.saveOrUpdate(tipusHab);
        session.saveOrUpdate(preuTipusHab);
        session.saveOrUpdate(hab);
        session.getTransaction().commit();
    }

    @After
    public void tearDown() {
    }

    private void clearDatabase() throws HibernateException {
        
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from Habitacio");
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