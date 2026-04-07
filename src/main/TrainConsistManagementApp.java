package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//Prevent invalid passenger bogies from being added to the train by enforcing capacity rules using a custom exception.
//@version 14.0
public class TrainConsistManagementApp{
    public static class InvalidCapacityException extends Exception{
        public InvalidCapacityException(String message){
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
        System.out.println("==========================================");
        System.out.println("== UC14 - Handle Invalid Bogie Capacity ==");
        System.out.println("==========================================\n");
        List<PassengerBogie> bogies=new ArrayList<>();
        try{
            PassengerBogie b1=new PassengerBogie("Sleeper",72);
            PassengerBogie b2=new PassengerBogie("AC Chair",-5);
            validateCapacity(b1);
            bogies.add(b1);
            validateCapacity(b2);
            bogies.add(b2);
        }catch(InvalidCapacityException e){
            System.out.println(e.getMessage());
        }
        System.out.println("\nCreated Bogies: ");
        for(PassengerBogie b:bogies){
            System.out.println(b);
        }
        System.out.println("\nUC14 exception handling completed...");
    }
}