/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorkshopController;

import Workshop.modules.Transaction;
import java.util.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pradip
 */
public class TransactionControllerTest {
    
    public TransactionControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of doEntry method, of class TransactionController.
     */
    @Test
    public void testDoEntry() throws Exception {
        System.out.println("doEntry");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=sdf.parse("2015-10-05");
        Transaction t = new Transaction();
        t.setAmount(10000);
        t.setDate(date);
        t.setStatus("paid");
        t.setType("staff");
        t.setTypeId(10);
        TransactionController instance = new TransactionController();
        int expResult = 1;
        int result = instance.doEntry(t);
        assertEquals(expResult, result);
        
        
    }


 
}
