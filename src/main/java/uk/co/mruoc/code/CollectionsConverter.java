package uk.co.mruoc.code;

import java.util.HashMap;
import java.util.Map;

public class CollectionsConverter {

    private static final Map<String, String> IMPLEMENTATIONS = new HashMap<>();

    static {
        IMPLEMENTATIONS.put("java.util.List", "java.util.ArrayList");
        IMPLEMENTATIONS.put("java.util.Map", "java.util.HashMap");
        IMPLEMENTATIONS.put("java.util.Set", "java.util.HashSet");
        IMPLEMENTATIONS.put("java.util.Collection", "java.util.ArrayList");
    }

    public static boolean isCollectionInterface(String name) {
        return IMPLEMENTATIONS.containsKey(removeGenerics(name));
    }

    public static String toImplementation(String name) {
        if (isCollectionInterface(name)) {
            return IMPLEMENTATIONS.get(removeGenerics(name));
        }
        return name;
    }

    private static String removeGenerics(String name) {
        int startIndex = name.indexOf("<");
        if (startIndex > -1) {
            return name.substring(0, startIndex);
        }
        return name;
    }

}
