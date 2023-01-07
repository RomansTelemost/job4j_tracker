package ru.job4j.inheritance;

public class User extends Base {

    public User() {
        super();
    }

    public User(int sum) {
        super(sum);
    }

    public static void main(String[] args) {
        User user = new User();
        User userWithSum = new User(10);
    }
}
