package uk.co.mruoc.code;

import com.squareup.javapoet.JavaFile;

import java.io.IOException;
import java.io.UncheckedIOException;

public class JavaFileContentExtractor {

    public static String extractContent(JavaFile file) {
        try {
            StringBuilder content = new StringBuilder();
            file.writeTo(content);
            return content.toString();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}
