import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Sort passenger bogies based on their seating capacity using a custom Comparator.
//@version 7.0
public class TrainConsistManagementApp{
    public static void main(String[] args){
        class Bogie{
            String name;
            int capacity;
            public Bogie(String name, int capacity){
                this.name=name;
                this.capacity=capacity;
            }
            public int getCapacity(){
                return capacity;
            }
            @Override
            public String toString(){
                return name+" -> "+capacity;
            }
        }
        System.out.println("================================================");
        System.out.println("== UC7 - Sort Bogies By Capacity (Comparator) ==");
        System.out.println("================================================\n");
        List<Bogie> bogies=new ArrayList<>();
        bogies.add(new Bogie("Sleeper",72));
        bogies.add(new Bogie("AC Chair",56));
        bogies.add(new Bogie("First Class",24));
        bogies.add(new Bogie("General",90));
        System.out.println("Before Sorting:");
        for(Bogie bogie:bogies){
            System.out.println(bogie);
        }
        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));
        System.out.println("\nAfter Sorting by Capacity:");
        bogies.forEach(System.out::println);
        System.out.println("\nUC7 sorting completed...");
    }
}