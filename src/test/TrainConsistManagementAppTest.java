package test;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class TrainConsistManagementAppTest{

    @Test
    public void testSort_BasicAlphabeticalSorting(){
        String[] bogies={"Sleeper","AC Chair","First Class","General","Luxury"};
        String[] expected={"AC Chair","First Class","General","Luxury","Sleeper"};
        Arrays.sort(bogies);
        assertArrayEquals(expected,bogies);
    }

    @Test
    public void testSort_UnsortedInput(){
        String[] bogies={"Luxury","General","Sleeper","AC Chair"};
        String[] expected={"AC Chair","General","Luxury","Sleeper"};
        Arrays.sort(bogies);
        assertArrayEquals(expected,bogies);
    }

    @Test
    public void testSort_AlreadySortedArray(){
        String[] bogies={"AC Chair","First Class","General"};
        String[] expected={"AC Chair","First Class","General"};
        Arrays.sort(bogies);
        assertArrayEquals(expected, bogies);
    }

    @Test
    public void testSort_DuplicateBogieNames(){
        String[] bogies={"Sleeper","AC Chair","Sleeper","General"};
        String[] expected={"AC Chair","General","Sleeper","Sleeper"};
        Arrays.sort(bogies);
        assertArrayEquals(expected,bogies);
    }

    @Test
    public void testSort_SingleElementArray(){
        String[] bogies={"Sleeper"};
        String[] expected={"Sleeper"};
        Arrays.sort(bogies);
        assertArrayEquals(expected,bogies);
    }
}