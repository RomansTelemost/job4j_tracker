package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book[] books = new Book[5];
        books[0] = new Book("Clean code", 400);
        books[1] = new Book("Java 8", 500);
        books[2] = new Book("Concurrency in Java", 600);
        books[3] = new Book("Fairy tails", 150);
        for (int i = 0; i < books.length; i++) {
            System.out.println("Book name : " + books[i].getName() + ". Number of page : " + books[i].getNumberOfPage());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book book: books) {
            System.out.println("Book name : " + book.getName() + ". Number of page : " + book.getNumberOfPage());
        }
        for (Book book: books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println("Book name : " + book.getName() + ". Number of page : " + book.getNumberOfPage());
            }
        }
    }
}
