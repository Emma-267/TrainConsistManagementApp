package test;

import junit.framework.TestCase;
import org.junit.Test;
import java.util.*;
import main.TrainConsistManagementApp;
import main.TrainConsistManagementApp.GoodsBogies;

public class TrainConsistManagementAppTest extends TestCase{
    private boolean validateSafety(List<GoodsBogies> bogies){
        return bogies.stream().allMatch(bogie->{
            if("Cylindrical".equalsIgnoreCase(bogie.getType())){
                return "Petroleum".equalsIgnoreCase(bogie.getCargo());
            }
            return true;
        });
    }

    @Test
    public void testSafety_AllBogiesValid(){
        List<GoodsBogies> train=Arrays.asList(
                new GoodsBogies("Cylindrical", "Petroleum"),
                new GoodsBogies("Box", "Coal")
        );
        assertTrue(validateSafety(train));
    }

    @Test
    public void testSafety_CylindricalWithInvalidCargo(){
        List<GoodsBogies> train=Collections.singletonList(
                new GoodsBogies("Cylindrical", "Coal")
        );
        assertFalse(validateSafety(train));
    }

    @Test
    public void testSafety_NonCylindricalBogiesAllowed(){
        List<GoodsBogies> train=Arrays.asList(
                new GoodsBogies("Box", "Coal"),
                new GoodsBogies("Open", "Grain")
        );
        assertTrue(validateSafety(train));
    }

    @Test
    public void testSafety_MixedBogiesWithViolation(){
        List<GoodsBogies> train=Arrays.asList(
                new GoodsBogies("Box", "Coal"),
                new GoodsBogies("Cylindrical", "Petroleum"),
                new GoodsBogies("Cylindrical", "Grain")
        );
        assertFalse(validateSafety(train));
    }

    @Test
    public void testSafety_EmptyBogieList(){
        List<GoodsBogies> train=Collections.emptyList();
        assertTrue(validateSafety(train));
    }
}