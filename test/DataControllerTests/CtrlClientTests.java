/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataControllerTests;

import DataInterface.ICtrlClient;
import DataInterface.ICtrlHabitacio;
import Factories.CtrlDataFactoria;
import Hibernate.NewHibernateUtil;
import domainModel.*;
import org.hibernate.classic.Session;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Miguel
 */
public class CtrlClientTests {
    
    private static CtrlDataFactoria factoria;
    private static Session session;
    private static ICtrlClient cc;
    private static Client expected;
    
    public CtrlClientTests() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
        session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        factoria = CtrlDataFactoria.getInstance();
        cc = factoria.getCtrlClient();
        expected = new Client("46975089G", "Miguel", "San Román", "msanromanv@gmail.com");
        session.saveOrUpdate(expected);
        session.getTransaction().commit();        
    }

    @Test
    public void testGet() {
        
        Client actual = cc.getClient("46975089G");
        Assert.assertEquals(expected.getNom(), actual.getNom());
        Assert.assertEquals(expected.getCognoms(), actual.getCognoms());
        Assert.assertEquals(expected.getEmail(), actual.getEmail());
        Assert.assertNotSame(expected, actual);
    }
}
