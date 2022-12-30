package ru.job4j.ex;

public class FindEl {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Элемент со ключом " + key + " не найден");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] strings = new String[4];
        strings[0] = "A";
        strings[1] = "B";
        strings[2] = "C";
        strings[3] = "D";
        try {
            int result = indexOf(strings, "G");
        } catch (ElementNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
