package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserStoreTest {

    @Test
    public void whenUserNotFoundThenException() {
        User[] users = {
                new User("Ivan", true),
                new User("Joe", true)
        };
        UserNotFoundException exception = assertThrows(UserNotFoundException.class,
                () -> {
                    UserStore.findUser(users, "Iva");
                });
        assertThat(exception.getMessage()).isEqualTo("User with login: Iva not found");
    }

    @Test
    public void whenUserIsValidThenNotException() throws UserInvalidException {
        User user = new User("Joe", true);
        assertThat(UserStore.validate(user)).isFalse();
    }

    @Test
    public void whenUserIsInvalidThenException() {
        User user = new User("Jo", true);
        UserInvalidException exception = assertThrows(UserInvalidException.class,
                () -> {
                    UserStore.validate(user);
                });
        assertThat(exception.getMessage()).isEqualTo("Username cannot contain less than 3 symbols");
    }
}