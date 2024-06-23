import java.util.HashMap;
import java.util.Scanner;

public class IponApp {
    private static HashMap<String, Double> progress = new HashMap<String, Double>();
    private static HashMap<String, Double> item = new HashMap<String,Double>();
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        intro(); //Call intro method
        menu(); //Call menu method
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
                break;
            case 2: //Add new item
                addItem();
                break;
            case 3: //Edit progress
                editProgress();
                break;
            case 4: //Delete item
                deleteItem();
                break;
            case 5: //Exit program
                System.out.println("Closing Program...");
                break;
            default: //If int choice is not valid
                System.out.println("\nPlease enter a valid choice");
                menu();
                break;
        }
    }
    public static void viewAll(){
        try{
            if(item.isEmpty()){ //If HashMap item is empty, throw ItemIsEmptyException
                throw new ItemIsEmptyException("\nYou have no items");
            } else { //If HashMap item is not empty
                System.out.println("\nItem\tGoal\tProgress");
                for(String i:item.keySet()){
                    System.out.print(i);
                    System.out.print("\t"+item.get(i));
                    System.out.println("\t"+progress.get(i));
                }
                menu();
            }
        } catch(Exception e) {
            System.out.println("\nSystem Message "+e);
            menu();
        }
    }
    public static void addItem(){
        System.out.print("Enter item name: ");//Input item name
        String itemName = userInput.nextLine();

        System.out.print("Enter price goal: ");//Input the price for the item
        Double goal = Double.parseDouble(userInput.nextLine());

        System.out.print("Enter your progress: ");//Input the progress
        Double goalProgress = Double.parseDouble(userInput.nextLine());

        item.put(itemName, goal); //Put itemName & goal in HashMap item
        progress.put(itemName,goalProgress);//PUt itemName & goalProgress in HashMap progress

        if(goalProgress >= goal){
                System.out.println("You Have reached your goal");
            }
        menu();
    }
    public static void editProgress(){
        System.out.print("Enter the item name to edit progress: ");
        String itemName = userInput.nextLine();
        try{
            if (!item.containsKey(itemName)) {//Throw ItemNotFoundException if item is not in the HashMap item
                throw new ItemNotFoundException("\nItem does not exist");
            } else {
                System.out.print("\nUpdate progress for \""+itemName+"\": ");//Update the progress
                double updatedProgress = Double.parseDouble(userInput.nextLine());

                progress.replace(itemName,updatedProgress);//updated progress will be sent to HashMap progress

                if(progress.get(itemName) >= item.get(itemName)){//Check whether progress is equal or greater than item
                    System.out.println("You Have reached your goal");
                } else { //Calculate remaining goal for an item
                    System.out.println("\nProgress Update");
                    System.out.println("You still have "+(item.get(itemName)-progress.get(itemName))+" left to reach you goal");
                }
                menu();
            }
        } catch(Exception e) {
            System.out.println("\nSystem Message: "+e);
            menu();
        }
    }
    public static void deleteItem(){ //Delete an item from the list
        System.out.print("\nType the name the item to be deleted: ");
        String deleteItem = userInput.nextLine();

        try{
            if(!item.containsKey(deleteItem)){
                throw new ItemNotFoundException("\nItem does not exist");
            } else {
                item.remove(deleteItem);
                progress.remove(deleteItem);
                System.out.println("Item deleted");
                menu();
            }
        } catch(Exception e){
            System.out.println("\nSystem Message: "+e);
            menu();
        }
    }
}
