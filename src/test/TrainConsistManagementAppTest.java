package test;

import org.junit.Test;
import static org.junit.Assert.*;
import main.TrainConsistManagementApp;
import main.TrainConsistManagementApp.PassengerBogie;
import main.TrainConsistManagementApp.InvalidCapacityException;
import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementAppTest{
    @Test
    public void testException_ValidCapacityCreation(){
        try{
            PassengerBogie bogie=new PassengerBogie("Sleeper",72);
            TrainConsistManagementApp.validateCapacity(bogie);
        }catch(InvalidCapacityException e){
            fail("Exception should not be thrown for valid capacity");
        }
    }

    @Test
    public void testException_NegativeCapacityThrowsException(){
        try{
            PassengerBogie bogie=new PassengerBogie("Sleeper",-10);
            TrainConsistManagementApp.validateCapacity(bogie);
            fail("Exception expected for negative capacity");
        }catch(InvalidCapacityException e){
            assertTrue(true);
        }
    }

    @Test
    public void testException_ZeroCapacityThrowsException(){
        try{
            PassengerBogie bogie=new PassengerBogie("AC",0);
            TrainConsistManagementApp.validateCapacity(bogie);
            fail("Exception expected for zero capacity");
        }catch(InvalidCapacityException e){
            assertTrue(true);
        }
    }

    @Test
    public void testException_ExceptionMessageValidation(){
        try{
            PassengerBogie bogie=new PassengerBogie("AC",0);
            TrainConsistManagementApp.validateCapacity(bogie);
            fail("Exception expected");
        }catch(InvalidCapacityException e){
            assertEquals("Error: Capacity must be greater than zero",e.getMessage());
        }
    }

    @Test
    public void testException_ObjectIntegrityAfterCreation() {
        PassengerBogie bogie = new PassengerBogie("Sleeper", 72);

        assertEquals("Sleeper", bogie.getName());
        assertEquals(72, bogie.getCapacity());
    }

    @Test
    public void testException_MultipleValidBogiesCreation(){
        List<PassengerBogie> bogies=new ArrayList<>();
        try{
            PassengerBogie b1=new PassengerBogie("Sleeper",72);
            PassengerBogie b2=new PassengerBogie("AC",60);
            PassengerBogie b3=new PassengerBogie("General",90);
            TrainConsistManagementApp.validateCapacity(b1);
            TrainConsistManagementApp.validateCapacity(b2);
            TrainConsistManagementApp.validateCapacity(b3);
            bogies.add(b1);
            bogies.add(b2);
            bogies.add(b3);
        }catch(InvalidCapacityException e){
            fail("No exception should be thrown for valid bogies");
        }
        assertEquals(3, bogies.size());
    }
}