/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Hibernate.NewHibernateUtil;
import domainModel.Hotel;
import org.hibernate.Session;
import org.junit.*;

/**
 *
 * @author Miguel
 */
public class TestHibernate {
    
    private Session session;
    
    public TestHibernate() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        
        session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
    }
    
    @Test
    public void testPersistenceAndRetrieval() {
        
        Hotel hotel = new Hotel("Jordi", "Pradel", "", "");
        session.persist(hotel);
        Hotel newHotel = (Hotel) session.get(Hotel.class, "Jordi");
        session.getTransaction().commit();
        Assert.assertEquals(hotel.getNom(), newHotel.getNom());
        Assert.assertEquals(hotel.getDescripcio(), newHotel.getDescripcio());
    }
    
    @After
    public void tearDown() {
    }

}
