package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Filter passenger bogies using Stream pipelines based on seating capacity.
//@version 8.0
public class TrainConsistManagementApp{
    public static class Bogie{
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
    public static void main(String[] args){
        System.out.println("=================================================");
        System.out.println("== UC8 - Filter Passenger Bogies Using Streams ==");
        System.out.println("=================================================\n");
        List<Bogie> bogies=new ArrayList<>();
        bogies.add(new Bogie("Sleeper",72));
        bogies.add(new Bogie("AC Chair",56));
        bogies.add(new Bogie("First Class",24));
        bogies.add(new Bogie("General",90));
        System.out.println("All Bogies:");
        bogies.forEach(System.out::println);
        System.out.println("\nFiltered Bogies (Capacity > 60):");
        List<Bogie> bogie=bogies.stream().filter(b -> b.capacity > 60).toList();
        bogie.forEach(System.out::println);
        System.out.println("UC8 filtering completed...");
    }
}