package co.com.calculator.exceptions;

public class ExpectedResultExceptions extends AssertionError{

    public ExpectedResultExceptions(String message, Throwable causa) {
        super(message, causa);
    }
}
