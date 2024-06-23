public class ItemIsEmptyException extends Exception{
    //Constructor that has a parameter of String message
    public ItemIsEmptyException(String message){
        //Pass the message to the superclass Exception
        super(message);
    }
}
