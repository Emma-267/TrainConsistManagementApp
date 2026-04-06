package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//Encapsulate bogie rules using functional interfaces and apply them using lambda expressions.
//@version 12.0
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
        System.out.println("====================================================");
        System.out.println("== UC12 - Safety Compliance Check for Goods Bogie ==");
        System.out.println("====================================================\n");
        List<GoodsBogies> goodsBogies=new ArrayList<>();
        goodsBogies.add(new GoodsBogies("Cylindrical","Petroleum"));
        goodsBogies.add(new GoodsBogies("Open","Coal"));
        goodsBogies.add(new GoodsBogies("Box","Grain"));
        goodsBogies.add(new GoodsBogies("Cylindrical","Coal"));
        System.out.println("Goods Bogies in Train:");
        for(GoodsBogies gb:goodsBogies){
            System.out.println(gb.toString());
        }
        boolean isSafetyCompliant=goodsBogies.stream().allMatch(bogie->{
            if("Cylindrical".equalsIgnoreCase(bogie.getType())){
                return "Petroleum".equalsIgnoreCase(bogie.getCargo());
            }
            return true;
        });
        System.out.println("\nSafety Compliance Status: "+isSafetyCompliant);
        if(isSafetyCompliant){
            System.out.println("Train formation is SAFE.");
        }
        else{
            System.out.println("Train formation is NOT SAFE.");
        }
        System.out.println("\nUC12 safety validation completed...");
    }
}