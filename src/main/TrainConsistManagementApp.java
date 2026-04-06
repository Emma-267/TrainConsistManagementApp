package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//Validate Train ID and Cargo Code formats using Regular Expressions.
//@version 11.0
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
        System.out.println("=============================================");
        System.out.println("== UC11 - Validate Train ID and Cargo Code ==");
        System.out.println("=============================================\n");
        Scanner scanner=new Scanner(System.in);
        String trainRegex="TRN-\\d{4}";
        String cargoRegex="PET-[A-Z]{2}";
        Pattern trainPattern=Pattern.compile(trainRegex);
        Pattern cargoPattern=Pattern.compile(cargoRegex);
        System.out.println("Enter Train ID (Format: TRN-1234): ");
        String trainId=scanner.nextLine();
        System.out.println("Enter Cargo Code (Format: PRT-AB): ");
        String cargoCode=scanner.nextLine();
        Matcher trainMatcher=trainPattern.matcher(trainId);
        Matcher cargoMatcher=cargoPattern.matcher(cargoCode);
        System.out.println("\nValidation results:");
        System.out.println("Train ID valid: "+trainMatcher.matches());
        System.out.println("Cargo Code valid: "+cargoMatcher.matches());
        System.out.println("\nUC11 validation completed...");
    }
}