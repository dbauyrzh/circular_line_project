/**
 * This class creates an exception that is thrown when the array is empty.
 */
public class NoElementException extends RuntimeException {
    /**
     * Constructor.
     */
    public NoElementException(){
        super("No element to process");
    }
}
