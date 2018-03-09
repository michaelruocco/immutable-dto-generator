package uk.co.mruoc.code;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class TestGenerationParams extends DefaultGenerationParams {

    public TestGenerationParams() {
        setPackageName("uk.co.mruoc.dto");
        setDtoClassName("CustomerDto");
        addFieldDefinition("longValue", "long");
        addFieldDefinition("boxedLongValue", "java.lang.Long");
        addFieldDefinition("list1", "java.util.List<MyCustomClass>");
        addFieldDefinition("map1", "java.util.Map<java.lang.String, MyCustomClass>");
        addFieldDefinition("listMap1", "java.util.List<Map<java.lang.String, MyCustomClass>>");
        addFieldDefinition("id", long.class);
        addFieldDefinition("id1", Double.class);
        addFieldDefinition("id2", Float.class);
        addFieldDefinition("id3", Byte.class);
        addFieldDefinition("id4", Short.class);
        addFieldDefinition("firstName", String.class);
        addFieldDefinition("lastName", String.class);
        addFieldDefinition("dateOfBirth", LocalDate.class);
        addFieldDefinition("premium", boolean.class);
        addFieldDefinition("balance", BigDecimal.class);
        addFieldDefinition("doubleVal", double.class);
        addFieldDefinition("integerVal", Integer.class);
        addFieldDefinition("floatVal", float.class);
        addFieldDefinition("shortVal", Short.class);
        addFieldDefinition("charVal", char.class);
        addFieldDefinition("byteVal", Byte.class);
        addFieldDefinition("object", Object.class);
        addFieldDefinition("date", Date.class);
        addFieldDefinition("localDateTime", LocalDateTime.class);
        addFieldDefinition("customClass", MyCustomClass.class);
    }
}
