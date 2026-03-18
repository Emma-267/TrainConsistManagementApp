import java.util.LinkedHashSet;
import java.util.Set;

//Maintain insertion order while enforcing uniqueness.
//@version 5.0
public class TrainConsistManagementApp{
    public static void main(String[] args){
        System.out.println("==============================================");
        System.out.println("== UC5 - Preserve Insertion Order of Bogies ==");
        System.out.println("==============================================\n");
        Set<String> formation=new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper");
        System.out.println("Final Train Formation:\n"+formation);
        System.out.println("\nNote:\nLinkedHashSet preserves insertion order and removes duplicates automatically.");
        System.out.println("\nUC5 formation setup completed...");
    }
}