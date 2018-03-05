package uk.co.mruoc.code;

import com.squareup.javapoet.TypeName;

import java.util.HashMap;
import java.util.Map;

public class StringToPrimitiveConverter {

    private static Map<String, TypeName> TYPES = new HashMap<>();

    static {
        TYPES.put("int", TypeName.INT);
        TYPES.put("byte", TypeName.BYTE);
        TYPES.put("short", TypeName.SHORT);
        TYPES.put("long", TypeName.LONG);
        TYPES.put("float", TypeName.FLOAT);
        TYPES.put("double", TypeName.DOUBLE);
        TYPES.put("boolean", TypeName.BOOLEAN);
        TYPES.put("char", TypeName.CHAR);
    }

    public static TypeName toPrimitiveType(String value) {
        if (isPrimitive(value)) {
            return TYPES.get(value);
        }
        throw new IllegalArgumentException("invalid primitive type '" + value + "'");
    }

    public static boolean isPrimitive(String value) {
        return TYPES.containsKey(value);
    }

}
