package co.com.demo.exceptions.swaglabs;

public class ExceptionValidatingTitle extends AssertionError{

    public ExceptionValidatingTitle(String message, Throwable causa){
        super(message, causa);
    }
}
