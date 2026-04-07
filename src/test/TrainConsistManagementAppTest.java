package test;

import org.junit.Test;
import static org.junit.Assert.*;
import main.TrainConsistManagementApp.GoodsBogies;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TrainConsistManagementAppTest{
    @Test
    public void testCargo_SafeAssignment(){
        GoodsBogies bogie=new GoodsBogies("Cylindrical","Oil");
        bogie.assignCargo("Petroleum");
        assertEquals("Petroleum",bogie.getCargo());
    }

    @Test
    public void testCargo_UnsafeAssignmentHandled(){
        GoodsBogies bogie=new GoodsBogies("Rectangular","Coal");
        bogie.assignCargo("Petroleum");
        assertTrue(true);
    }

    @Test
    public void testCargo_CargoNotAssignedAfterFailure(){
        GoodsBogies bogie=new GoodsBogies("Rectangular","Coal");
        bogie.assignCargo("Petroleum");
        assertNotEquals("Petroleum",bogie.getCargo());
    }

    @Test
    public void testCargo_ProgramContinuesAfterException(){
        GoodsBogies b1=new GoodsBogies("Rectangular","Coal");
        GoodsBogies b2=new GoodsBogies("Cylindrical","Oil");
        b1.assignCargo("Petroleum");
        b2.assignCargo("Petroleum");
        assertEquals("Petroleum",b2.getCargo());
    }

    @Test
    public void testCargo_FinallyBlockExecution(){
        GoodsBogies bogie=new GoodsBogies("Rectangular","Coal");
        ByteArrayOutputStream output=new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        bogie.assignCargo("Petroleum");
        String consoleOutput=output.toString();
        assertTrue(consoleOutput.contains("Cargo validation completed for "+bogie.getType()+" bogie\n"));
    }
}