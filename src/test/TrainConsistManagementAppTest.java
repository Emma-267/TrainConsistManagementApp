package test;

import org.junit.Test;
import static org.junit.Assert.*;
import main.TrainConsistManagementApp;

public class TrainConsistManagementAppTest{
    public static void bubbleSort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    @Test
    public void testSort_BasicSorting(){
        int[] arr={72, 56, 24, 70, 60};
        int[] expected={24, 56, 60, 70, 72};
        bubbleSort(arr);
        assertArrayEquals(expected,arr);
    }

    @Test
    public void testSort_AlreadySortedArray(){
        int[] arr={24, 56, 60, 70, 72};
        int[] expected={24, 56, 60, 70, 72};
        bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSort_DuplicateValues(){
        int[] arr={72, 56, 56, 24};
        int[] expected={24, 56, 56, 72};
        bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSort_SingleElementArray(){
        int[] arr={50};
        int[] expected={50};
        bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSort_AllEqualValues(){
        int[] arr={40, 40, 40};
        int[] expected={40, 40, 40};
        bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }
}