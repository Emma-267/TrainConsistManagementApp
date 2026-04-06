package test;

import junit.framework.TestCase;
import main.TrainConsistManagementApp;
import main.TrainConsistManagementApp.Bogie;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistManagementAppTest extends TestCase{
    private List<Bogie> bogies;
    private final int THRESHOLD=70;
    @Override
    protected void setUp(){
        bogies=new ArrayList<>();
        bogies.add(new Bogie("Sleeper",72));
        bogies.add(new Bogie("AC Chair",56));
        bogies.add(new Bogie("First Class",24));
        bogies.add(new Bogie("General",90));
        bogies.add(new Bogie("Sleeper",54));
    }

    @Test
    public void testFilter_BogiesGroupedByType(){
        Map<String, List<Bogie>> grouped=bogies.stream().collect(Collectors.groupingBy(Bogie::getName));
        assertNotNull(grouped);
        assertTrue(grouped.containsKey("Sleeper"));
    }

    @Test
    public void testFilter_MultipleBogiesInSameGroup(){
        Map<String, List<Bogie>> grouped=bogies.stream().collect(Collectors.groupingBy(Bogie::getName));
        assertEquals(2,grouped.get("Sleeper").size());
    }

    @Test
    public void testFilter_DifferentBogieTypes(){
        Map<String, List<Bogie>> grouped=bogies.stream().collect(Collectors.groupingBy(Bogie::getName));
        assertNotSame(grouped.get("Sleeper"),grouped.get("AC Chair"));
        assertEquals(4,grouped.keySet().size());
    }

    @Test
    public void testFilter_EmptyBogieList(){
        List<Bogie> emptyList=Collections.emptyList();
        Map<String, List<Bogie>> grouped=emptyList.stream().collect(Collectors.groupingBy(Bogie::getName));
        assertTrue(grouped.isEmpty());
    }

    @Test
    public void testFilter_SingleBogieCategory(){
        List<Bogie> singleCategory=Arrays.asList(new Bogie("Sleeper",24));
        Map<String, List<Bogie>> grouped=singleCategory.stream().collect(Collectors.groupingBy(Bogie::getName));
        assertEquals(1,grouped.size());
        assertTrue(grouped.containsKey("Sleeper"));
    }

    @Test
    public void testFilter_MapContainsCorrectKeys(){
        Map<String, List<Bogie>> grouped=bogies.stream().collect(Collectors.groupingBy(Bogie::getName));
        assertTrue(grouped.containsKey("Sleeper"));
        assertTrue(grouped.containsKey("AC Chair"));
        assertTrue(grouped.containsKey("First Class"));
    }

    @Test
    public void testFilter_GroupSizeValidation(){
        Map<String, List<Bogie>> grouped=bogies.stream().collect(Collectors.groupingBy(Bogie::getName));
        assertEquals(2,grouped.get("Sleeper").size());
        assertEquals(1,grouped.get("AC Chair").size());
    }

    @Test
    public void testFilter_OriginalListUnchanged(){
        int originalSize=bogies.size();
        bogies.stream().collect(Collectors.groupingBy(Bogie::getName));
        assertEquals(originalSize, bogies.size());
        assertEquals("Sleeper", bogies.get(0).getName());
    }
}