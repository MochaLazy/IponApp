import java.util.HashMap;
import java.util.Scanner;

public class IponApp {
    private static HashMap<String, Double> progress = new HashMap<String, Double>();
    private static HashMap<String, Double> item = new HashMap<String,Double>();
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
        System.out.println("[4] Delete an item");
        System.out.println("[5] Exit");
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
            case 3: //Edit progress
                editProgress();
                break;
            case 4: //Delete item
                deleteItem();
                menu();
                break;
            case 5: //Exit program
                System.out.println("Closing Program...");
                break;
            default:
                System.out.println("\nPlease enter a valid choice");
                menu();
                break;
        }
    }
    public static void viewAll(){
        try{
            if(item.isEmpty()){
                throw new itemIsEmptyException("\nYou have no items");
            } else {
                System.out.println("\nItem\tGoal\tProgress");
                for(String i:item.keySet()){
                    System.out.print(i);
                    System.out.print("\t"+item.get(i));
                    System.out.println("\t"+progress.get(i));
//                    for(String a:progress.keySet()){
//                    }
                }
            }
        } catch(Exception e) {
            System.out.println("\nSystem Message "+e);
            menu();
        }
//        System.out.println(item);
    }
    public static void addItem(){
        System.out.print("Enter item name: ");
        String itemName = userInput.nextLine();

        System.out.print("Enter price goal: ");
        Double goal = Double.parseDouble(userInput.nextLine());

        System.out.print("Enter your progress: ");
        Double goalProgress = Double.parseDouble(userInput.nextLine());

        item.put(itemName, goal);
        progress.put(itemName,goalProgress);

        if(goalProgress >= goal){
                System.out.println("You Have reached your goal");
            }

//        try{
//            if(goal >= goalProgress){
//                throw new goalReachedException("You Have reached your goal");
//            }
//        } catch(Exception e) {
//            System.out.println("\nSystem Message "+e);
//            menu();
//        }
    }
    public static void editProgress(){
        System.out.print("Enter the item name to edit progress: ");
        String itemName = userInput.nextLine();
        try{
            if (!item.containsKey(itemName)) {
                throw new ItemNotFoundException("\nItem does not exist");
            } else {
                editor(itemName);
            }
        } catch(Exception e) {
            System.out.println("\nSystem Message: "+e);
            menu();
        }
//        return itemName;
    }
    public static void editor(String itemName){
        System.out.print("\nUpdate progress for \""+itemName+"\": ");
        double updatedProgress = Double.parseDouble(userInput.nextLine());

        progress.replace(itemName,updatedProgress);

            if(progress.get(itemName) >= item.get(itemName)){
                System.out.println("You Have reached your goal");
            } else {
                System.out.println("\nProgress Update");
                System.out.println("You still have "+(item.get(itemName)-progress.get(itemName))+" left to reach you goal");
            }

//        progress.get(item.get("itemName"));
//        System.out.println(item.get("itemName"));
//        item.replace("itemName",);
    }
    public static void deleteItem(){
        System.out.print("\nType the name the item to be deleted: ");
        String deleteItem = userInput.nextLine();

        item.remove(deleteItem);
        progress.remove(deleteItem);
        System.out.println("Item deleted");
    }
}
