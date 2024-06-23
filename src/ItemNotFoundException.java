public class ItemNotFoundException extends Exception{
    //Constructor that has a parameter of String message
    public ItemNotFoundException(String message){
        //Pass the message to the superclass Exception
        super(message);
    }
}
