package test;

import junit.framework.TestCase;
import main.TrainConsistManagementApp;
import main.TrainConsistManagementApp.Bogie;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainConsistManagementAppTest extends TestCase{
    private List<TrainConsistManagementApp.Bogie> bogies;
    private final int THRESHOLD=70;
    @Override
    protected void setUp(){
        bogies=new ArrayList<>();
        bogies.add(new Bogie("Sleeper",72));
        bogies.add(new Bogie("AC Chair",56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General",90));
    }
    private List<TrainConsistManagementApp.Bogie> filterBogies(List<Bogie> list, int threshold){
        return list.stream().filter(b->b.getCapacity()>threshold).collect(Collectors.toList());
    }

    @Test
    public void testFilter_CapacityGreaterThanThreshold(){
        List<Bogie> result=filterBogies(bogies,THRESHOLD);
        assertTrue("Results should only contain capacities > 70",result.stream().allMatch(b->b.getCapacity()>THRESHOLD));
    }

    @Test
    public void testFilter_CapacityEqualToThreshold(){
        List<Bogie> result=filterBogies(bogies,THRESHOLD);
        boolean containsThresholdValue=result.stream().anyMatch(b->b.getCapacity()==THRESHOLD);
        assertFalse("Bogie with capacity exactly 70 should be excluded",containsThresholdValue);
    }

    @Test
    public void testFilter_CapacityLessThanThreshold(){
        List<Bogie> result=filterBogies(bogies,THRESHOLD);
        assertTrue("Filtered list should not contain bogies with capacity < 70",result.stream().noneMatch(b->b.getCapacity()<THRESHOLD));
    }

    @Test
    public void testFilter_MultipleBogiesMatching(){
        List<Bogie> result=filterBogies(bogies,THRESHOLD);
        assertEquals("Should find exactly 2 matching bogies",2,result.size());
    }

    @Test
    public void testFilter_NoBogiesMatching(){
        List<Bogie> result=filterBogies(bogies,100);
        assertTrue("Filtered list should be empty when no matches exist",result.isEmpty());
    }

    @Test
    public void testFilter_AllBogiesMatching(){
        List<Bogie> result=filterBogies(bogies,10);
        assertEquals("Filtered list should contain all original bogies",bogies.size(),result.size());
    }

    @Test
    public void testFilter_EmptyBogieList(){
        List<Bogie> emptyList=new ArrayList<>();
        List<Bogie> result=filterBogies(emptyList,THRESHOLD);
        assertTrue("Filtering an empty list should return an empty result",result.isEmpty());
    }

    @Test
    public void testFilter_OriginalListUnchanged(){
        int originalSize=bogies.size();
        filterBogies(bogies,THRESHOLD);
        assertEquals("Original list size should remain unchanged after streaming",originalSize,bogies.size());
    }
}