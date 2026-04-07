package main;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//Sort bogie type names alphabetically using Java’s built-in Arrays.sort() method.
//@version 17.0
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
        System.out.println("=================================================");
        System.out.println("== UC17 - Sort Bogie Names Using Arrays.sort() ==");
        System.out.println("=================================================\n");
        String[] bogieNames={"Sleeper","AC Chair","First Class","General","Luxury"};
        System.out.println("Original Bogie Names: ");
        System.out.println(Arrays.toString(bogieNames));
        System.out.println("\nSorted Bogie Names (Alphabetical): ");
        Arrays.sort(bogieNames);
        System.out.println(Arrays.toString(bogieNames));
        System.out.println("\nUC17 sorting completed...");
    }
}