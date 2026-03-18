import java.util.ArrayList;
import java.util.List;

//Allow dynamic insertion and removal of passenger bogies using ArrayList.
//@version 2.0
public class TrainConsistManagementApp{
    public static void main(String[] args){
        System.out.println("=========================================");
        System.out.println("== UC2 - Add Passenger Bogies to Train ==");
        System.out.println("=========================================\n");
        List<String> passengerBogies=new ArrayList<>();
        System.out.println("After Adding Bogies:");
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");
        System.out.println("Passenger Bogies: "+passengerBogies);
        System.out.println("\nAfter Removing 'AC Chair:");
        passengerBogies.remove("AC Chair");
        System.out.println("Passenger Bogies: "+passengerBogies);
        System.out.println("\nChecking if 'Sleeper exists:");
        System.out.println("Contains Sleeper?: "+passengerBogies.contains("Sleeper"));
        System.out.println("\nFinal Train Passenger Consist:\n"+passengerBogies);
        System.out.println("\nUC2 operations completed successfully...");
    }
}