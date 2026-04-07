package test;

import org.junit.Test;
import static org.junit.Assert.*;
import main.TrainConsistManagementApp;

public class TrainConsistManagementAppTest{
    public static boolean binarySearchBogie(String[] bogieIDs, String target){
        int left=0;
        int right=bogieIDs.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            int cmp=bogieIDs[mid].compareTo(target);
            if(cmp==0){
                return true;
            }else if(cmp<0){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return false;
    }

    @Test
    public void testBinarySearch_BogieFound(){
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(binarySearchBogie(bogies,"BG309"));
    }

    @Test
    public void testBinarySearch_BogieNotFound(){
        String[] bogies={"BG101","BG205","BG309","BG412","BG550"};
        assertFalse(binarySearchBogie(bogies,"BG999"));
    }

    @Test
    public void testBinarySearch_FirstElementMatch(){
        String[] bogies={"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(binarySearchBogie(bogies,"BG101"));
    }

    @Test
    public void testBinarySearch_LastElementMatch(){
        String[] bogies={"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(binarySearchBogie(bogies,"BG550"));
    }

    @Test
    public void testBinarySearch_SingleElementArray(){
        String[] bogies={"BG101"};
        assertTrue(binarySearchBogie(bogies,"BG101"));
    }

    @Test
    public void testBinarySearch_EmptyArray(){
        String[] bogies={};
        assertFalse(binarySearchBogie(bogies,"BG101"));
    }

    @Test
    public void testBinarySearch_UnsortedInputHandled(){
        String[] bogies={"BG309","BG101","BG550","BG205","BG412"};
        assertFalse(binarySearchBogie(bogies,"BG205"));
    }
}