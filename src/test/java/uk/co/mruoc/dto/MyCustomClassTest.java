package uk.co.mruoc.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyCustomClassTest {

    @Test
    public void shouldSetNumber() {
        int number = 10;
        MyCustomClass myCustomClass = new MyCustomClass(number);
        assertThat(myCustomClass.getNumber()).isEqualTo(10);
    }

}
