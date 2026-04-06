package test;

import junit.framework.TestCase;
import org.junit.Test;
import java.util.*;
import main.TrainConsistManagementApp;
import main.TrainConsistManagementApp.Bogie;

public class TrainConsistManagementAppTest extends TestCase{
    private int calculateTotal(List<Bogie> bogies){
        return bogies.stream().map(Bogie::getCapacity).reduce(0, Integer::sum);
    }

    @Test
    public void testReduce_TotalSeatCalculation(){
        List<Bogie> bogies=Arrays.asList(
                new Bogie("Sleeper",72),
                new Bogie("AC Chair",56),
                new Bogie("First Class",24),
                new Bogie("Sleeper",70)
        );
        int total=calculateTotal(bogies);
        assertEquals(222,total);
    }

    @Test
    public void testReduce_EmptyBogieList(){
        List<Bogie> bogies=new ArrayList<>();
        int total=calculateTotal(bogies);
        assertEquals(0,total);
    }

    @Test
    public void testReduce_SingleBogieCapacity(){
        List<Bogie> bogies=Collections.singletonList(new Bogie("First Class",24));
        int total=calculateTotal(bogies);
        assertEquals(24,total);
    }

    @Test
    public void testReduce_MultipleBogiesAggregation(){
        List<Bogie> bogies=Arrays.asList(
                new Bogie("A",10),
                new Bogie("B",20),
                new Bogie("C",30)
        );
        int total=calculateTotal(bogies);
        assertEquals(60,total);
    }

    @Test
    public void testReduce_OriginalListUnchanged(){
        List<Bogie> bogies=new ArrayList<>();
        bogies.add(new Bogie("Sleeper",72));
        bogies.add(new Bogie("AC Chair",56));
        int originalSize=bogies.size();
        calculateTotal(bogies);
        assertEquals(originalSize,bogies.size());
        assertEquals("Sleeper",bogies.get(0).getName());
    }
}