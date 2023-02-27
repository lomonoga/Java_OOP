package firstTask;

public class MyException extends Exception {
    /**
     * Custom exception
     * Needed to display error information
     */
    public MyException(String s)
    {
        super(s);
    }
}