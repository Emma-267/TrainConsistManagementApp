package test;

import junit.framework.TestCase;
import org.junit.Test;
import java.util.*;
import java.util.stream.Collectors;
import main.TrainConsistManagementApp;
import main.TrainConsistManagementApp.Bogie;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest{
    public static List<Bogie> filterWithLoop(List<Bogie> bogies){
        List<Bogie> result=new ArrayList<>();
        for(Bogie b:bogies){
            if(b.getCapacity()>60){
                result.add(b);
            }
        }
        return result;
    }
    public static List<Bogie> filterWithStream(List<Bogie> bogies){
        return bogies.stream().filter(b->b.getCapacity()>60).collect(Collectors.toList());
    }

    @Test
    public void testLoopFilteringLogic(){
        List<TrainConsistManagementApp.Bogie> bogies=Arrays.asList(
                new TrainConsistManagementApp.Bogie("A",70),
                new TrainConsistManagementApp.Bogie("B",50)
        );
        List<TrainConsistManagementApp.Bogie> result=filterWithLoop(bogies);
        assertEquals(1,result.size());
        assertTrue(result.get(0).getCapacity()>60);
    }

    @Test
    public void testStreamFilteringLogic(){
        List<TrainConsistManagementApp.Bogie> bogies=Arrays.asList(
                new TrainConsistManagementApp.Bogie("A",80),
                new TrainConsistManagementApp.Bogie("B",40)
        );
        List<TrainConsistManagementApp.Bogie> result=filterWithStream(bogies);
        assertEquals(1,result.size());
        assertTrue(result.get(0).getCapacity()>60);
    }

    @Test
    public void testLoopAndStreamResultsMatch(){
        List<TrainConsistManagementApp.Bogie> bogies=Arrays.asList(
                new TrainConsistManagementApp.Bogie("A",70),
                new TrainConsistManagementApp.Bogie("B",30),
                new TrainConsistManagementApp.Bogie("C",90)
        );
        List<TrainConsistManagementApp.Bogie> loopResult=filterWithLoop(bogies);

        List<TrainConsistManagementApp.Bogie> streamResult=filterWithStream(bogies);
        assertEquals(loopResult.size(),streamResult.size());
    }

    @Test
    public void testExecutionTimeMeasurement(){
        List<TrainConsistManagementApp.Bogie> bogies=Arrays.asList(
                new TrainConsistManagementApp.Bogie("A",70),
                new TrainConsistManagementApp.Bogie("B",80)
        );
        long start=System.nanoTime();
        filterWithLoop(bogies);
        long end=System.nanoTime();
        long elapsed=end-start;
        assertTrue(elapsed>0);
    }

    @Test
    public void testLargeDatasetProcessing(){
        List<TrainConsistManagementApp.Bogie> bogies=new ArrayList<>();
        for(int i=0;i<10000;i++){
            bogies.add(new TrainConsistManagementApp.Bogie("B"+i,i%100));
        }
        List<TrainConsistManagementApp.Bogie> result=filterWithStream(bogies);
        assertNotNull(result);
        assertTrue(result.size()>0);
    }
}