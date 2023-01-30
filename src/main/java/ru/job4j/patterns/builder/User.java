package ru.job4j.patterns.builder;

import java.util.Objects;

public class User {

    private String name;

    private String surname;

    private byte age;

    private String login;

    private String password;

    private boolean activated;

    private String gender;

    public User() {
    }

    public User(String name, String surname, byte age,
                String login, String password, boolean activated,
                String gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.login = login;
        this.password = password;
        this.activated = activated;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age
                && activated == user.activated
                && Objects.equals(name, user.name)
                && Objects.equals(surname, user.surname)
                && Objects.equals(login, user.login)
                && Objects.equals(password, user.password)
                && Objects.equals(gender, user.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, login, password, activated, gender);
    }

    @Override
    public String toString() {
        return "User{\n\t"
                + "name='" + name + '\'' + ", \n\t"
                + "surname='" + surname + '\'' + ", \n\t"
                + "age=" + age + ", \n\t"
                + "login='" + login + '\'' + ", \n\t"
                + "password='" + password + '\'' + ", \n\t"
                + "activated=" + activated + ", \n\t"
                + "gender='" + gender + '\'' + ", \n"
                + '}';
    }

    static class Builder {
        private String name;
        private String surname;
        private byte age;
        private String login;
        private String password;
        private boolean activated;
        private String gender;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildSurname(String surname) {
            this.surname = surname;
            return this;
        }

        Builder buildAge(byte age) {
            this.age = age;
            return this;
        }

        Builder buildLogin(String login) {
            this.login = login;
            return this;
        }

        Builder buildPassword(String password) {
            this.password = password;
            return this;
        }

        Builder buildActivated(boolean activated) {
            this.activated = activated;
            return this;
        }

        Builder buildGender(String gender) {
            this.gender = gender;
            return this;
        }

        User build() {
            User user = new User();
            user.name = name;
            user.surname = surname;
            user.age = age;
            user.login = login;
            user.password = password;
            user.activated = activated;
            user.gender = gender;
            return user;
        }
    }

    public static void main(String[] args) {
        User user = new Builder().buildName("name")
                .buildSurname("surname")
                .buildAge((byte) 32)
                .buildLogin("login")
                .buildPassword("password")
                .buildActivated(true)
                .buildGender("male")
                .build();
        System.out.println(user);
    }
}
