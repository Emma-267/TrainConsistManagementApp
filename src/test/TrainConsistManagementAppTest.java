package test;

import org.junit.Test;
import static org.junit.Assert.*;

public class TrainConsistManagementAppTest{
    private boolean searchBogie(String[] bogieIDs,String target){
        for(String id:bogieIDs){
            if(id.equals(target)){
                return true;
            }
        }
        return false;
    }

    @Test
    public void testSearch_BogieFound(){
        String[] bogies={"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(searchBogie(bogies,"BG309"));
    }

    @Test
    public void testSearch_BogieNotFound(){
        String[] bogies={"BG101","BG205","BG309","BG412","BG550"};
        assertFalse(searchBogie(bogies,"BG999"));
    }

    @Test
    public void testSearch_FirstElementMatch(){
        String[] bogies={"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(searchBogie(bogies, "BG101"));
    }

    @Test
    public void testSearch_LastElementMatch(){
        String[] bogies={"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(searchBogie(bogies,"BG550"));
    }

    @Test
    public void testSearch_SingleElementArray(){
        String[] bogies={"BG101"};
        assertTrue(searchBogie(bogies,"BG101"));
    }
}