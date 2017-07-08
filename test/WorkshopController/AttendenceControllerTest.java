/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorkshopController;

import Workshop.modules.Attendence;
import Workshop.modules.Staff;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
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
public class AttendenceControllerTest {
    
    public AttendenceControllerTest() {
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
     * Test of doAttendence method, of class AttendenceController.
     */
    @Test
    public void testDoAttendence() throws Exception {
        System.out.println("doAttendence");
        Attendence at = new Attendence();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=sdf.parse("2017-07-06");
        at.setDate(date);
        Staff st=new Staff();
        st.setId(3);
        at.setStaffId(st);
        at.setStatus("present");
        AttendenceController instance = new AttendenceController();
        int expResult = 1;
        int result = instance.doAttendence(at);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getAllStaffs method, of class AttendenceController.
     */
   

    /**
     * Test of buildAttendenceTable method, of class AttendenceController.
     */
   

    /**
     * Test of getAttendence method, of class AttendenceController.
     */
    
 
}
