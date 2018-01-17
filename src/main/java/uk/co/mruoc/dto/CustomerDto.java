package uk.co.mruoc.dto;

import java.lang.Byte;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Short;
import java.lang.String;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class CustomerDto {
  private long id;

  private String firstName;

  private String lastName;

  private LocalDate dateOfBirth;

  private boolean premium;

  private BigDecimal balance;

  private double doubleVal;

  private Integer integerVal;

  private float floatVal;

  private Short shortVal;

  private char charVal;

  private Byte byteVal;

  private Object object;

  private Date date;

  private LocalDateTime localDateTime;

  private MyCustomClass customClass;

  public CustomerDto(CustomerDtoBuilder builder) {
    this.id = builder.getId();
    this.firstName = builder.getFirstName();
    this.lastName = builder.getLastName();
    this.dateOfBirth = builder.getDateOfBirth();
    this.premium = builder.isPremium();
    this.balance = builder.getBalance();
    this.doubleVal = builder.getDoubleVal();
    this.integerVal = builder.getIntegerVal();
    this.floatVal = builder.getFloatVal();
    this.shortVal = builder.getShortVal();
    this.charVal = builder.getCharVal();
    this.byteVal = builder.getByteVal();
    this.object = builder.getObject();
    this.date = builder.getDate();
    this.localDateTime = builder.getLocalDateTime();
    this.customClass = builder.getCustomClass();
  }

  public long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public boolean isPremium() {
    return premium;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public double getDoubleVal() {
    return doubleVal;
  }

  public Integer getIntegerVal() {
    return integerVal;
  }

  public float getFloatVal() {
    return floatVal;
  }

  public Short getShortVal() {
    return shortVal;
  }

  public char getCharVal() {
    return charVal;
  }

  public Byte getByteVal() {
    return byteVal;
  }

  public Object getObject() {
    return object;
  }

  public Date getDate() {
    return date;
  }

  public LocalDateTime getLocalDateTime() {
    return localDateTime;
  }

  public MyCustomClass getCustomClass() {
    return customClass;
  }
}
