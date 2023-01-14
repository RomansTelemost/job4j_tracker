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

    private static String checkLetters(String password) {
        char[] letters = password.toCharArray();
        boolean hasUpperCaseLetter = false;
        boolean hasLowerCaseLetter = false;
        boolean hasDigit = false;
        boolean hasSpecialSymbol = false;

        for (char letter : letters) {
            if (Character.isUpperCase(letter)) {
                hasUpperCaseLetter = true;
            }
            if (Character.isLowerCase(letter)) {
                hasLowerCaseLetter = true;
            }
            if (Character.isDigit(letter)) {
                hasDigit = true;
            }
            if (!Character.isLetter(letter)
                    && !Character.isDigit(letter)) {
                hasSpecialSymbol = true;
            }
            if (hasUpperCaseLetter
                    && hasLowerCaseLetter
                    && hasDigit
                    && hasSpecialSymbol) {
                break;
            }
        }

        if (!hasUpperCaseLetter) {
            return "Password should contain at least "
                    + "one uppercase letter";
        }

        if (!hasLowerCaseLetter) {
            return "Password should contain at least "
                    + "one lowercase letter";
        }

        if (!hasDigit) {
            return "Password should contain at least one figure";
        }

        if (!hasSpecialSymbol) {
            return "Password should contain at least "
                    + "one special symbol";
        }
        return "";
    }

    public static String validate(String password) {

        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }

        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }

        String message = checkLetters(password);
        if (!message.isBlank()) {
            throw new IllegalArgumentException(message);
        }

        if (containForbiddenTextSequences(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: "
                    + "qwerty, 12345, password, admin, user");
        }

        return password;
    }
}
