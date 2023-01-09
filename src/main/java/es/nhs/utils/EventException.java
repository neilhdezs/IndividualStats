package es.nhs.utils;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 05/12/2022
 * Exception to the events
 */
public class EventException extends Exception
{

    public EventException()
    {
        super();
    }

    public EventException(String message)
    {
        super(message);
    }

    public EventException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
