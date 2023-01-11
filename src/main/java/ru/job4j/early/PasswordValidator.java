package ru.job4j.early;

public class PasswordValidator {

    private static final String[] FORBIDDEN_TEXT_SEQUENCES = {
            "qwerty",
            "12345",
            "password",
            "admin",
            "user"
    };

    private static boolean containForbiddenTextSequences(String password) {
        for (String forbiddenTextSequence : FORBIDDEN_TEXT_SEQUENCES) {
            if (password.toLowerCase().contains(forbiddenTextSequence)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containAtLeastOneSpecialSymbol(String password) {
        char[] letters = password.toCharArray();
        for (char letter : letters) {
            if (!Character.isLetter(letter)
                    && !Character.isDigit(letter)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containAtLeastOneFigure(String password) {
        char[] letters = password.toCharArray();
        for (char letter : letters) {
            if (Character.isDigit(letter)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containAtLeastOneLowercaseLetter(String password) {
        char[] letters = password.toCharArray();
        for (char letter : letters) {
            if (Character.isLowerCase(letter)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containAtLeastOneUppercaseLetter(String password) {
        char[] letters = password.toCharArray();
        for (char letter : letters) {
            if (Character.isUpperCase(letter)) {
                return true;
            }
        }
        return false;
    }

    public static String validate(String password) {

        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }

        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }

        if (!containAtLeastOneUppercaseLetter(password)) {
            throw new IllegalArgumentException("Password should contain at least "
                    + "one uppercase letter");
        }

        if (!containAtLeastOneLowercaseLetter(password)) {
            throw new IllegalArgumentException("Password should contain at least "
                    + "one lowercase letter");
        }

        if (!containAtLeastOneFigure(password)) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }

        if (!containAtLeastOneSpecialSymbol(password)) {
            throw new IllegalArgumentException("Password should contain at least "
                    + "one special symbol");
        }

        if (containForbiddenTextSequences(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: "
                    + "qwerty, 12345, password, admin, user");
        }

        return password;
    }
}
