import java.util.HashSet;
import java.util.Set;

//Ensure no duplicate bogie IDs are added to the train.
//@version 3.0
public class TrainConsistManagementApp{
    public static void main(String[] args){
        System.out.println("==================================");
        System.out.println("== UC3 - Track Unique Bogie IDs ==");
        System.out.println("==================================\n");
        Set<String> bogies=new HashSet<>();
        bogies.add("BG101");
        bogies.add("BG102");
        bogies.add("BG103");
        bogies.add("BG104");
        bogies.add("BG101");
        bogies.add("BG102");
        System.out.println("Bogies IDs After Insertion:\n"+bogies);
        System.out.println("\nNote:\nDuplicates are automatically ignored by HashSet.");
        System.out.println("\nUC3 uniqueness validation completed...");
    }
}
