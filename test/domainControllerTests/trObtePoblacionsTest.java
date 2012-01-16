/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domainControllerTests;

import Hibernate.NewHibernateUtil;
import domainControllers.trObtenirPoblacions;
import domainModel.Poblacio;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Endymiion
 */
public class trObtePoblacionsTest {
    
    public trObtePoblacionsTest() {
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
    public void testObtenirPoblacionsWithoutPoblacionsSavedShouldThrowAnException() {
        
        trObtenirPoblacions tx = new trObtenirPoblacions();
        try {
            tx.executa();
            fail();
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(), "noHiHaPoblacions");
        }
    }
    
    @Test
    public void testObtenirPoblacionsWithPoblacionsShouldReturnItsNames() {
        
        insertPoblacions();
        trObtenirPoblacions tx = new trObtenirPoblacions();
        try {
            tx.executa();
        } catch (Exception ex) {
            fail();
        }
        
        ArrayList<String> actual = tx.obtenirResultat();
        Assert.assertEquals(5, actual.size());
        int j = 0;
        for(String nom : actual) {
            Assert.assertEquals("Poblacio " + String.valueOf(j), nom);
            ++j;
        }
    }

    private void deletePoblacions() throws HibernateException {
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from Poblacio");
        query.executeUpdate();
        session.getTransaction().commit();
    }

    private void insertPoblacions() throws HibernateException {
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        for(int i = 0; i < 5; ++i){
            Poblacio p = new Poblacio("Poblacio " + String.valueOf(i));
            session.merge(p);
        }
        session.getTransaction().commit();
    }
    
    @After
    public void tearDown() {
        deletePoblacions();
    }
}
