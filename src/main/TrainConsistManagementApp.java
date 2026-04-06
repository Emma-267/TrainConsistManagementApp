package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Group bogies into categories using Stream collectors.
//@version 9.0
public class TrainConsistManagementApp{
    public static class Bogie{
        String name;
        int capacity;
        public Bogie(String name, int capacity){
            this.name=name;
            this.capacity=capacity;
        }
        public String getName(){
            return name;
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
        System.out.println("================================");
        System.out.println("== UC9 - Group Bogies By Type ==");
        System.out.println("================================\n");
        List<Bogie> bogies=new ArrayList<>();
        bogies.add(new Bogie("Sleeper",72));
        bogies.add(new Bogie("AC Chair",56));
        bogies.add(new Bogie("First Class",24));
        bogies.add(new Bogie("Sleeper",70));
        bogies.add(new Bogie("AC Chair",60));
        System.out.println("All Bogies:");
        for(Bogie b:bogies){
            System.out.println(b.toString());
        }
        Map<String,List<Bogie>> groupedBogies=bogies.stream().collect(Collectors.groupingBy(b->b.name));
        System.out.println("\nGrouped Bogies:");
        for(Map.Entry<String,List<Bogie>> entry:groupedBogies.entrySet()){
            System.out.println("Bogie Type: "+entry.getKey()+"\nCapacity -> "+entry.getValue()+"\n");
        }
        System.out.println("UC9 grouping completed...");
    }
}