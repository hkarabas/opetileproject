package com.utils;

import com.main.Main;

import java.io.*;
import java.util.stream.Collectors;

public class ResourceUtils {

    private ResourceUtils() {

    }


    public static String getResourceAsString(String resourceName) throws IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        try (InputStream is = classLoader.getResourceAsStream(resourceName)) {
            if (is == null)
                throw new FileNotFoundException(String.format("Resource %s is not found!", resourceName));
            try (InputStreamReader isr = new InputStreamReader(is);
                 BufferedReader reader = new BufferedReader(isr)) {
                return reader.lines().collect(Collectors.joining(System.lineSeparator()));
            }
        }
    }

    public static  File getResourceFile(String fileName) throws FileNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
            if (file == null) {
                throw new FileNotFoundException(String.format("File %s is not found!", fileName));

            }
        return file;
    }




}
