package ru.job4j.oop;

public class Local {

    private String name = "Petr";

    public Local(String name) {
        this.name = name;
    }

    /**
     * We cannot change local variable define in
     * local class. But can change variable of upper class.
     */
    public void getFullName() {
        final String surname = "Arsentev";

        class FullName {

            public void printFullName() {
                Local.this.name = "Changed name from local class";
                System.out.println(name + " " + surname);
            }
        }

        FullName fullName = new FullName();
        fullName.printFullName();
    }

    public static void main(String[] args) {
        Local local = new Local("Roman");
        local.getFullName();
        local.name = "New name";
        local.getFullName();
    }
}
