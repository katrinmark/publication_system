package ru.innopolis.utils;

import ru.innopolis.exception.ValidationException;

/**
 * This util is used to validate data before transferring it to database
 */
public class ValidatorUtil {
    public static void validatePassword(String password, String confirmPassword) throws ValidationException {
        if (password == null || confirmPassword == null || !password.equals(confirmPassword)) {
           throw new ValidationException("Пароли не совпадают");
        }
    }
}
