package test;

import Hibernate.NewHibernateUtil;
import domainModel.Categoria;
import java.sql.SQLException;
import org.hibernate.Session;
import org.junit.*;

public class TestHibernate {
    
    private Session session;
    private Categoria categoria;
    
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
        
        categoria = new Categoria("CategoriaTest");
        session.persist(categoria);
        Categoria newCategoria = (Categoria) session.get(Categoria.class, "CategoriaTest");
        session.getTransaction().commit();
        Assert.assertEquals(categoria.getNom(), newCategoria.getNom());
    }
    
    @After
    public void tearDown() throws SQLException {
        
        session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        // Codigo para borrar datos testPersistenceAndRetrieval
        session.delete("Categoria",categoria);
        session.getTransaction().commit();
        
    }

}
