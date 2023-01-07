package ru.job4j.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class College {

    public static void main(String[] args) throws Exception {
        Student student = new Student();
        student.setFullName("Petr Petrov");
        student.setGroup("FOIT");
        student.setAdmissionDate(LocalDate.parse("09-10-2013",
                DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.UK)));
        System.out.println("Full name: " + student.getFullName()
                + " Group : " + student.getGroup()
                + " Admission date : "
                + student.getAdmissionDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }
}
