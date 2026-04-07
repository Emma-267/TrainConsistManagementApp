package test;

import org.junit.Test;
import static org.junit.Assert.*;
import main.TrainConsistManagementApp;

public class TrainConsistManagementAppTest{
    private boolean searchBogieSafe(String[] bogieIds, String searchId){
        if(bogieIds.length==0){
            throw new IllegalStateException("No bogies exist in the train. Search cannot be performed.");
        }
        return TrainConsistManagementApp.binarySearchBogie(bogieIds,searchId);
    }

    @Test(expected=IllegalStateException.class)
    public void testSearch_ThrowsExceptionWhenEmpty(){
        String[] bogies={};
        searchBogieSafe(bogies,"BG101");
    }

    @Test
    public void testSearch_AllowsSearchWhenDataExists(){
        String[] bogies={"BG101","BG205"};
        try{
            boolean result=searchBogieSafe(bogies,"BG101");
            assertTrue(result);
        }catch(IllegalStateException e){
            fail("Exception should not be thrown when data exists");
        }
    }

    @Test
    public void testSearch_BogieFoundAfterValidation(){
        String[] bogies={"BG101","BG205","BG309"};
        boolean result=searchBogieSafe(bogies,"BG205");
        assertTrue(result);
    }

    @Test
    public void testSearch_BogieNotFoundAfterValidation(){
        String[] bogies={"BG101","BG205","BG309"};
        boolean result=searchBogieSafe(bogies,"BG999");
        assertFalse(result);
    }

    @Test
    public void testSearch_SingleElementValidCase(){
        String[] bogies={"BG101"};
        boolean result=searchBogieSafe(bogies,"BG101");
        assertTrue(result);
    }
}