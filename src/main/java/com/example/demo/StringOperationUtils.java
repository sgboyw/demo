package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StringOperationUtils {
    private static Pattern pattern = Pattern.compile("([a-z])\\1{2}");
    private static final Logger logger = LoggerFactory.getLogger(StringOperationUtils.class);

    private StringOperationUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static String remove3TimesRepeatedCharFromString (String input) {
        logger.info("input string: {}", input);
        List<String> list = find3TimesRepeatedCharFromString(input);
        String output = input;
        int count = 0;
        while (!list.isEmpty()) {
            count++;
            for (int i = 0; i < list.size(); i++) {
                output = output.replaceAll(list.get(i), "");
                logger.info("output{}: {}", count, input);
            }
            list = find3TimesRepeatedCharFromString(output);
        }

        logger.info("final output: {}", output);
        return output;
    }

    public static String replace3TimesRepeatedCharByPrevCharFromString(String input) {
        logger.info("input string: {}", input);
        
        List<String> list = find3TimesRepeatedCharFromString(input);
        String output = input;
        int count = 0;

        while (!list.isEmpty()) {
            count++;
            for (int i = 0; i < list.size(); i++) {
                char repeatedLetter = list.get(i).charAt(0);
                String replacedLetter = repeatedLetter - 1 < 'a' ? "" : String.valueOf((char) (repeatedLetter - 1));
                output = output.replaceAll(list.get(i), replacedLetter);
                logger.info("output{}: {}", count, output);
            }
            list = find3TimesRepeatedCharFromString(output);
        }

        logger.info("final output: {}", output);
        return output;
    }

    private static List<String> find3TimesRepeatedCharFromString(String input) {
        List<String> list = new ArrayList<>();
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }
}
