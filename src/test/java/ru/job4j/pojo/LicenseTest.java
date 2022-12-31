package ru.job4j.pojo;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.assertj.core.api.Assertions.assertThat;

class LicenseTest {

    @Test
    public void eqName() {
        License first = new License();
        first.setCode("audio");
        License second = new License();
        second.setCode("audio");
        assertThat(first).isEqualTo(second);
    }

    @Test
    public void fullyEqualInstance() throws ParseException {
        License first = new License();
        first.setCode("TIS");
        first.setModel("Tesla");
        first.setOwner("Tesla");
        first.setCreated(new SimpleDateFormat("dd-MM-yyyy").parse("09-10-2013"));
        License second = new License();
        second.setCode("TIS");
        second.setModel("Tesla");
        second.setOwner("Tesla");
        second.setCreated(new SimpleDateFormat("dd-MM-yyyy").parse("09-10-2013"));
        assertThat(first).isEqualTo(second);
    }
}