import java.util.ArrayList;
import java.util.List;

//Initialize the Train Consist Management App and display the initial state of the train.
//@version 1.0
public class TrainConsistManagementApp{
    public static void main(String[] args){
        System.out.println("==================================");
        System.out.println("== Train Consist Management App ==");
        System.out.println("==================================\n");
        List<String> trainConsist=new ArrayList<>();
        System.out.println("Train initialized successfully...");
        System.out.println("Initial Bogie Count: "+trainConsist.size());
        System.out.println("Current Train Consist: "+trainConsist);
        System.out.println("\nSystem ready for operations...");
    }
}
