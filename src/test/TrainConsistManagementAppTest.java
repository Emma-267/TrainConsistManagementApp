package test;

import junit.framework.TestCase;
import org.junit.Test;
import java.util.*;
import main.TrainConsistManagementApp;
import main.TrainConsistManagementApp.Bogie;

public class TrainConsistManagementAppTest extends TestCase{
    public static boolean isValidTrainId(String trainId){
        return trainId.matches("TRN-\\d{4}");
    }
    public static boolean isValidCargoCode(String cargoCode){
        return cargoCode.matches("PET-[A-Z]{2}");
    }

    @Test
    public void testRegex_ValidTrainID(){
        assertTrue(isValidTrainId("TRN-1234"));
    }

    @Test
    public void testRegex_InvalidTrainIDFormat(){
        assertFalse(isValidTrainId("TRAIN12"));
        assertFalse(isValidTrainId("TRN12A"));
        assertFalse(isValidTrainId("1234-TRN"));
    }

    @Test
    public void testRegex_ValidCargoCode(){
        assertTrue(isValidCargoCode("PET-AB"));
    }

    @Test
    public void testRegex_InvalidCargoCodeFormat(){
        assertFalse(isValidCargoCode("PET-ab"));
        assertFalse(isValidCargoCode("PET123"));
        assertFalse(isValidCargoCode("AB-PET"));
    }

    @Test
    public void testRegex_TrainIDDigitLengthValidation(){
        assertFalse(isValidTrainId("TRN-123"));
        assertFalse(isValidTrainId("TRN-12345"));
    }

    @Test
    public void testRegex_CargoCodeUppercaseValidation(){
        assertFalse(isValidCargoCode("PET-Ab"));
        assertFalse(isValidCargoCode("PET-aB"));
    }

    @Test
    public void testRegex_EmptyInputHandling(){
        assertFalse(isValidTrainId(""));
        assertFalse(isValidCargoCode(""));
    }

    @Test
    public void testRegex_ExactPatternMatch(){
        assertFalse(isValidTrainId("TRN-1234X"));
        assertFalse(isValidCargoCode("PET-ABCD"));
    }
}