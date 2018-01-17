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

public class CustomerDtoBuilder {
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

  public long getId() {
    return id;
  }

  public CustomerDtoBuilder setId(long id) {
    this.id = id;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public CustomerDtoBuilder setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public CustomerDtoBuilder setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public CustomerDtoBuilder setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  public boolean isPremium() {
    return premium;
  }

  public CustomerDtoBuilder setPremium(boolean premium) {
    this.premium = premium;
    return this;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public CustomerDtoBuilder setBalance(BigDecimal balance) {
    this.balance = balance;
    return this;
  }

  public double getDoubleVal() {
    return doubleVal;
  }

  public CustomerDtoBuilder setDoubleVal(double doubleVal) {
    this.doubleVal = doubleVal;
    return this;
  }

  public Integer getIntegerVal() {
    return integerVal;
  }

  public CustomerDtoBuilder setIntegerVal(Integer integerVal) {
    this.integerVal = integerVal;
    return this;
  }

  public float getFloatVal() {
    return floatVal;
  }

  public CustomerDtoBuilder setFloatVal(float floatVal) {
    this.floatVal = floatVal;
    return this;
  }

  public Short getShortVal() {
    return shortVal;
  }

  public CustomerDtoBuilder setShortVal(Short shortVal) {
    this.shortVal = shortVal;
    return this;
  }

  public char getCharVal() {
    return charVal;
  }

  public CustomerDtoBuilder setCharVal(char charVal) {
    this.charVal = charVal;
    return this;
  }

  public Byte getByteVal() {
    return byteVal;
  }

  public CustomerDtoBuilder setByteVal(Byte byteVal) {
    this.byteVal = byteVal;
    return this;
  }

  public Object getObject() {
    return object;
  }

  public CustomerDtoBuilder setObject(Object object) {
    this.object = object;
    return this;
  }

  public Date getDate() {
    return date;
  }

  public CustomerDtoBuilder setDate(Date date) {
    this.date = date;
    return this;
  }

  public LocalDateTime getLocalDateTime() {
    return localDateTime;
  }

  public CustomerDtoBuilder setLocalDateTime(LocalDateTime localDateTime) {
    this.localDateTime = localDateTime;
    return this;
  }

  public MyCustomClass getCustomClass() {
    return customClass;
  }

  public CustomerDtoBuilder setCustomClass(MyCustomClass customClass) {
    this.customClass = customClass;
    return this;
  }

  public CustomerDto build() {
    return new CustomerDto(this);
  }
}
