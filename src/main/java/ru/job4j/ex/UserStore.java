package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User foundUser = null;
        for (int i = 0; i < users.length; i++) {
            if (login.equals(users[i].getUsername())) {
                foundUser = users[i];
                break;
            }
        }
        if (foundUser == null) {
            throw new UserNotFoundException("User with login: " + login + " not found");
        }
        return foundUser;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid()) {
            throw new UserInvalidException("User is invalid");
        }
        if (user.getUsername().length() < 3) {
            throw new UserInvalidException("Username cannot contain less than 3 symbols");
        }
        return false;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true),
                new User("Pe", true)
        };
        try {
            User user = findUser(users, "Pe");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException userInvalidException) {
            System.out.println(userInvalidException.getMessage());
        } catch (UserNotFoundException userNotFoundException) {
            System.out.println(userNotFoundException.getMessage());
        }
    }
}
