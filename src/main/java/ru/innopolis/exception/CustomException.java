package ru.innopolis.exception;

/**
 * This exception is used to throw a user message informing about corresponding situation
 */
public class CustomException extends Exception{
    public CustomException(String message) {
        super(message);
    }
}
