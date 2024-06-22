import java.util.HashMap;
import java.util.Scanner;

public class IponTracker {
    private static HashMap<Double, Double> progress = new HashMap<Double, Double>();
    private static HashMap<String, HashMap<Double,Double>> item = new HashMap<>();
    private static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args) {
        intro();
        menu();
    }
    public static void intro(){
        System.out.println("This program tracks your savings per item");
    }
    public static void menu(){
        System.out.println("\nChoose an action:");
        System.out.println("[1] View all items");
        System.out.println("[2] Add new item");
        System.out.println("[3] Edit progress");
        System.out.println("[4] Exit");
        System.out.print("Enter Choice: ");

        int choice = Integer.parseInt(userInput.nextLine());
        switch(choice){
            case 1: //View all item/s
                viewAll();
                menu();
                break;
            case 2: //Add new item
                addItem();
                menu();
                break;
            case 3:
                break;
            case 4: //Exit progress
                break;
            default:
                System.out.println("\nPlease enter a valid choice");
                menu();
                break;
        }
    }
    public static void viewAll(){
        System.out.println(item);
    }
    public static void addItem(){
        System.out.print("Enter item name: ");
        String itemName = userInput.nextLine();

        System.out.print("Enter price goal: ");
        Double goal = Double.parseDouble(userInput.nextLine());

        System.out.print("Enter your progress: ");
        Double goalProgress = Double.parseDouble(userInput.nextLine());

        progress.put(goal,goalProgress);
//        HashMap<Double,Double> itemProgress = new HashMap<Double,Double>();
//        itemProgress.put(goal,goalProgress);

        item.put(itemName, progress);
    }
}
