package ru.innopolis.exception;

/**
 * This kind of exception is thrown when some input data are not valid
 * (e.g. incorrect data in login, during user creation)
 */
public class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}
