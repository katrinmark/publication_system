package ru.innopolis.exception;

/**
 * This kind of exception can be thrown during unexpected publication process
 */
public class PublicationException extends Exception {
    public PublicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
