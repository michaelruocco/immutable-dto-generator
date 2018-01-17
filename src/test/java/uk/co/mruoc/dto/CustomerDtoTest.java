package uk.co.mruoc.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.Byte;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Short;
import java.lang.String;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
import org.junit.Test;
import org.mockito.Mockito;

public class CustomerDtoTest {
  private CustomerDtoBuilder builder = new CustomerDtoBuilder();

  @Test
  public void shouldSetId() {
    long id = 10;
    CustomerDto customerDto = builder.setId(id).build();
    assertThat(customerDto.getId()).isEqualTo(id);
  }

  @Test
  public void shouldSetFirstName() {
    String firstName = "firstName";
    CustomerDto customerDto = builder.setFirstName(firstName).build();
    assertThat(customerDto.getFirstName()).isEqualTo(firstName);
  }

  @Test
  public void shouldSetLastName() {
    String lastName = "lastName";
    CustomerDto customerDto = builder.setLastName(lastName).build();
    assertThat(customerDto.getLastName()).isEqualTo(lastName);
  }

  @Test
  public void shouldSetDateOfBirth() {
    LocalDate dateOfBirth = LocalDate.of(2018, 1, 17);
    CustomerDto customerDto = builder.setDateOfBirth(dateOfBirth).build();
    assertThat(customerDto.getDateOfBirth()).isEqualTo(dateOfBirth);
  }

  @Test
  public void shouldSetPremium() {
    boolean premium = new Random().nextBoolean();
    CustomerDto customerDto = builder.setPremium(premium).build();
    assertThat(customerDto.isPremium()).isEqualTo(premium);
  }

  @Test
  public void shouldSetBalance() {
    BigDecimal balance = BigDecimal.valueOf(10);
    CustomerDto customerDto = builder.setBalance(balance).build();
    assertThat(customerDto.getBalance()).isEqualTo(balance);
  }

  @Test
  public void shouldSetDoubleVal() {
    double doubleVal = 10;
    CustomerDto customerDto = builder.setDoubleVal(doubleVal).build();
    assertThat(customerDto.getDoubleVal()).isEqualTo(doubleVal);
  }

  @Test
  public void shouldSetIntegerVal() {
    Integer integerVal = 10;
    CustomerDto customerDto = builder.setIntegerVal(integerVal).build();
    assertThat(customerDto.getIntegerVal()).isEqualTo(integerVal);
  }

  @Test
  public void shouldSetFloatVal() {
    float floatVal = 10;
    CustomerDto customerDto = builder.setFloatVal(floatVal).build();
    assertThat(customerDto.getFloatVal()).isEqualTo(floatVal);
  }

  @Test
  public void shouldSetShortVal() {
    Short shortVal = 10;
    CustomerDto customerDto = builder.setShortVal(shortVal).build();
    assertThat(customerDto.getShortVal()).isEqualTo(shortVal);
  }

  @Test
  public void shouldSetCharVal() {
    char charVal = 'a';
    CustomerDto customerDto = builder.setCharVal(charVal).build();
    assertThat(customerDto.getCharVal()).isEqualTo(charVal);
  }

  @Test
  public void shouldSetByteVal() {
    Byte byteVal = 10;
    CustomerDto customerDto = builder.setByteVal(byteVal).build();
    assertThat(customerDto.getByteVal()).isEqualTo(byteVal);
  }

  @Test
  public void shouldSetObject() {
    Object object = new Object();
    CustomerDto customerDto = builder.setObject(object).build();
    assertThat(customerDto.getObject()).isEqualTo(object);
  }

  @Test
  public void shouldSetDate() {
    Date date = new Date();
    CustomerDto customerDto = builder.setDate(date).build();
    assertThat(customerDto.getDate()).isEqualTo(date);
  }

  @Test
  public void shouldSetLocalDateTime() {
    LocalDateTime localDateTime = LocalDateTime.of(2018, 1, 17, 21, 21, 6, 910000000);
    CustomerDto customerDto = builder.setLocalDateTime(localDateTime).build();
    assertThat(customerDto.getLocalDateTime()).isEqualTo(localDateTime);
  }

  @Test
  public void shouldSetCustomClass() {
    MyCustomClass customClass = Mockito.mock(MyCustomClass.class);
    CustomerDto customerDto = builder.setCustomClass(customClass).build();
    assertThat(customerDto.getCustomClass()).isEqualTo(customClass);
  }
}
