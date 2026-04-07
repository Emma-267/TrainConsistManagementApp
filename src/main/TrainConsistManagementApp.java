package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//Compare performance of loop-based logic versus stream-based logic using time measurement.
//@version 13.0
public class TrainConsistManagementApp{
    public static class GoodsBogies{
        String type;
        String cargo;
        public GoodsBogies(String type, String cargo){
            this.type=type;
            this.cargo=cargo;
        }
        public String getType(){
            return type;
        }
        public String getCargo(){
            return cargo;
        }
        @Override
        public String toString(){
            return type+" -> "+cargo;
        }
    }
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
        System.out.println("======================================================");
        System.out.println("== UC13 - Performance Comparison (Loops vs Streams) ==");
        System.out.println("======================================================\n");
        List<Bogie> bogies=new ArrayList<>();
        bogies.add(new Bogie("Sleeper",72));
        bogies.add(new Bogie("AC Chair",56));
        bogies.add(new Bogie("First Class",24));
        bogies.add(new Bogie("Sleeper",70));
        long loopStart=System.nanoTime();
        List<Bogie> sleeperBogies=new ArrayList<>();
        for(Bogie b:bogies){
            if(b.getName().equals("Sleeper")){
                sleeperBogies.add(b);
            }
        }
        long loopEnd=System.nanoTime();
        long streamStart=System.nanoTime();
        List<Bogie> sleeperBogiesStream=bogies.stream().filter(b -> b.getName().equals("Sleeper")).collect(Collectors.toList());
        long streamEnd=System.nanoTime();
        System.out.println("Loop Execution Time (ns): "+(loopEnd-loopStart));
        System.out.println("Stream Execution Time (ns): "+(streamEnd-streamStart));
        System.out.println("\nUC13 performance benchmarking completed...");
    }
}
