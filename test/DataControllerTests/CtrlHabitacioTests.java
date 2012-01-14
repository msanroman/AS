/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataControllerTests;

import DataInterface.ICtrlHabitacio;
import Factories.CtrlDataFactoria;
import Hibernate.NewHibernateUtil;
import domainModel.Habitacio;
import domainModel.HabitacioId;
import domainModel.Hotel;
import domainModel.TipusHabitacio;
import org.hibernate.classic.Session;
import org.junit.*;

/**
 *
 * @author Miguel
 */
public class CtrlHabitacioTests {
    
    private static CtrlDataFactoria factoria;
    private static Session session;
    private static ICtrlHabitacio ch;
    private static Habitacio expected;
    
    public CtrlHabitacioTests() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
        session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        factoria = CtrlDataFactoria.getInstance();
        ch = factoria.getCtrlHabitacio();
        TipusHabitacio t = new TipusHabitacio("Suite");
        session.saveOrUpdate(t);
        Hotel h = new Hotel("Ritz");
        session.saveOrUpdate(h);
        expected = new Habitacio(new HabitacioId("Ritz", 101), "Suite");
        session.saveOrUpdate(expected);
        session.getTransaction().commit();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void testGet() {
        
        Habitacio actual = ch.getHabitacio(101, "Ritz");
        Assert.assertEquals(expected.getId(), actual.getId());
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
