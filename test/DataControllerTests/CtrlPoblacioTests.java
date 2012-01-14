/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataControllerTests;

import DataControllers.CtrlPoblacio;
import DataInterface.ICtrlPoblacio;
import Factories.CtrlDataFactoria;
import Hibernate.NewHibernateUtil;
import domainModel.Poblacio;
import java.util.ArrayList;
import org.hibernate.Session;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Endymiion
 */
public class CtrlPoblacioTests {
    
    private static CtrlDataFactoria factoria;
    private static ICtrlPoblacio cp;
    private static Session session;
    
    public CtrlPoblacioTests() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
        session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        factoria = CtrlDataFactoria.getInstance();
        cp = factoria.getCtrlPoblacio();
        for (int i = 0; i < 4; ++i) {
            Poblacio p = new Poblacio(String.valueOf(i));
            session.saveOrUpdate(p);
        }
        session.getTransaction().commit();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test    
    public void testTots() {
        
        ArrayList<Poblacio> tots = cp.tots();
        Assert.assertEquals(4, tots.size());
    }
    
    @Test
    public void testGet() {
        
        Assert.assertNotNull(cp.getPoblacio("1"));
    }
    
    @After
    public void tearDown() {
        
    }
}
