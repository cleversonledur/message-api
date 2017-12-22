package com.sbtest.messages.api.exception;

public class GenericException extends Exception{

    private Exception exception;

    /**
     * Creates a new ServiceLocatorException wrapping another exception, and
     * with a detail message.
     *
     * @param message
     *            the detail message.
     * @param exception
     *            the wrapped exception.
     */
    public GenericException(String message, Exception exception) {
        super(message);
        this.exception = exception;
        return;
    }

    /**
     * Creates a ServiceLocatorException with the specified detail message.
     *
     * @param message
     *            the detail message.
     */
    public GenericException(String message) {
        this(message, null);
        return;
    }

    /**
     * Creates a new ServiceLocatorException wrapping another exception, and
     * with no detail message.
     *
     * @param exception
     *            the wrapped exception.
     */
    public GenericException(Exception exception) {
        this(null, exception);
        return;
    }

    /**
     * Gets the wrapped exception.
     *
     * @return the wrapped exception.
     */
    public Exception getException() {
        return exception;
    }

    /**
     * Retrieves (recursively) the root cause exception.
     *
     * @return the root cause exception.
     */
    public Exception getRootCause() {
        if (exception instanceof GenericException) {
            return ((GenericException) exception).getRootCause();
        }
        return exception == null ? this : exception;
    }

    public String toString() {
        if (exception instanceof GenericException) {
            return ((GenericException) exception).toString();
        }
        return exception == null ? super.toString() : exception.toString();
    }
}
