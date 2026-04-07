package main;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//Search and identify a specific bogie ID from an unsorted list using Linear Search.
//@version 18.0
public class TrainConsistManagementApp{
    public static class InvalidCapacityException extends Exception{
        public InvalidCapacityException(String message){
            super(message);
        }
    }
    public static class CargoSafetyException extends Exception{
        public CargoSafetyException(String message){
            super(message);
        }
    }
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
        public void assignCargo(String cargo){
            try{
                if("Rectangular".equalsIgnoreCase(this.type)&& "Petroleum".equalsIgnoreCase(cargo)){
                    throw new CargoSafetyException("Error: Unsafe cargo assignment!");
                }
                this.cargo=cargo;
                System.out.println("Cargo assigned successfully -> "+cargo);
            }catch(CargoSafetyException e){
                System.out.println(e.getMessage());
            }finally{
                System.out.println("Cargo validation completed for "+type+" bogie\n");
            }
        }
    }
    public static class PassengerBogie{
        String name;
        int capacity;
        public PassengerBogie(String name, int capacity){
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
    public static void validateCapacity(PassengerBogie bogie) throws InvalidCapacityException{
        if(bogie.getCapacity()<=0){
            throw new InvalidCapacityException("Error: Capacity must be greater than zero");
        }
    }
    public static void main(String[] args){
        System.out.println("=======================================");
        System.out.println("== UC18 - Linear Search for Bogie ID ==");
        System.out.println("=======================================\n");
        String[] bogieIds={"BG101","BG205","BG309","BG412","BG550"};
        String searchId="BG309";
        System.out.println("Available Bogie IDs: ");
        for(String Ids:bogieIds){
            System.out.println(Ids);
        }
        boolean found=false;
        for(String Ids:bogieIds){
            if(Ids.equals(searchId)){
                found=true;
            }
        }
        if(found){
            System.out.println("\nBogie "+searchId+" found in train consist.");
        }
        else{
            System.out.println("\nBogie "+searchId+" not found in train consist.");
        }
        System.out.println("\nUC18 searching completed...");
    }
}