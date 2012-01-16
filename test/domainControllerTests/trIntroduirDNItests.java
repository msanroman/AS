package domainControllerTests;

import Hibernate.NewHibernateUtil;
import domainControllers.trIntroduirDNI;
import domainModel.Client;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.*;
import static org.junit.Assert.*;

public class trIntroduirDNItests {
    
    public trIntroduirDNItests() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Client c = new Client("46975089G", "Miguel", "San Román", "msanromanv@gmail.com");
        session.saveOrUpdate(c);
        session.getTransaction().commit();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from Client");
        query.executeUpdate();
        session.getTransaction().commit();
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void aNonExistentUserShouldThrowAnExceptionWhenInsertingHisDNI() {
        
        trIntroduirDNI tx = new trIntroduirDNI("FALSEDNI");
        try {
            tx.executa();
            fail();
        } catch (Exception ex) {
            Assert.assertEquals("clientNoExisteix", ex.getMessage());
        }
        
    }
    
    @Test
    public void anExistentUserShouldBeRetrievedCorrectly() {
        
        trIntroduirDNI tx = new trIntroduirDNI("46975089G");
        try {
            tx.executa();
            Assert.assertEquals("Miguel", tx.obtenirResultat().nom);
            Assert.assertEquals("San Román", tx.obtenirResultat().cognoms);
            Assert.assertEquals("msanromanv@gmail.com", tx.obtenirResultat().email);
        } catch (Exception ex) {
            fail();
        }
    }
    
    @After
    public void tearDown() {
    }
}
