package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//Sort passenger bogie capacities using a basic algorithm (Bubble Sort) instead of library methods.
//@version 16.0
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
        System.out.println("=============================================");
        System.out.println("== UC16 - Manual Sorting Using Bubble Sort ==");
        System.out.println("=============================================\n");
        int[] capacities={72,56,24,70,60};
        System.out.println("Original Capacities: ");
        for(int c:capacities){
            System.out.print(c+" ");
        }
        for(int i=0;i<capacities.length-1;i++){
            for(int j=0;j<capacities.length-i-1;j++){
                if (capacities[j]>capacities[j+1]){
                    int temp=capacities[j];
                    capacities[j]=capacities[j+1];
                    capacities[j+1]=temp;
                }
            }
        }
        System.out.println("\n\nSorted Capacities (Ascending): ");
        for(int c:capacities){
            System.out.print(c+" ");
        }
        System.out.println("\n\nUC16 sorting completed...");
    }
}