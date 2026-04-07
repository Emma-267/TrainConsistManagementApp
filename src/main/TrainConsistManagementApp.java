package main;

import java.util.*;

//Prevent search operations on an empty train by throwing an exception early.
//@version 20.0
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
    public static boolean binarySearchBogie(String[] bogieIDs, String target){
        int left=0;
        int right=bogieIDs.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            int cmp=bogieIDs[mid].compareTo(target);
            if(cmp==0){
                return true;
            }else if(cmp<0){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println("=============================================");
        System.out.println("== UC20 - Exception Handling During Search ==");
        System.out.println("=============================================\n");
        String[] bogieIds={};
        String searchId="BG309";
        try{
            if(bogieIds.length==0){
                throw new IllegalStateException("No bogies available on the train. Search cannot be performed.");
            }
            boolean found=binarySearchBogie(bogieIds,searchId);
            if(found){
                System.out.println("Bogie "+searchId+" found using Binary Search");
            }else{
                System.out.println("Bogie "+searchId+" not found using Binary Search");
            }
        }catch(IllegalStateException e){
            System.out.println(e.getMessage());
        }
        System.out.println("\nUC20 execution completed...");
    }
}