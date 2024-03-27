package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StringOperationUtilsTest {

    @Test
    void testRemove3TimesRepeatedCharFromString() {
        String input = "aabcccbbad";

        String output = StringOperationUtils.remove3TimesRepeatedCharFromString(input);
        assertEquals("d", output);

        input = "aabcccbbadeeefdh";
        output = StringOperationUtils.remove3TimesRepeatedCharFromString(input);
        assertEquals("dfdh", output);

        input = "";
        output = StringOperationUtils.remove3TimesRepeatedCharFromString(input);
        assertEquals("", output);

        input = "aa";
        output = StringOperationUtils.remove3TimesRepeatedCharFromString(input);
        assertEquals("aa", output);

        input = "aaa";
        output = StringOperationUtils.remove3TimesRepeatedCharFromString(input);
        assertEquals("", output);
    }

    @Test
    void testReplace3TimesRepeatedCharByPrevCharFromString() {
        String input = "abcccbad";

        String output = StringOperationUtils.replace3TimesRepeatedCharByPrevCharFromString(input);
        assertEquals("d", output);

        input = "abcccbaddeeeff";
        output = StringOperationUtils.replace3TimesRepeatedCharByPrevCharFromString(input);
        assertEquals("cff", output);

        input = "";
        output = StringOperationUtils.replace3TimesRepeatedCharByPrevCharFromString(input);
        assertEquals("", output);

        input = "aa";
        output = StringOperationUtils.replace3TimesRepeatedCharByPrevCharFromString(input);
        assertEquals("aa", output);

        input = "aaa";
        output = StringOperationUtils.replace3TimesRepeatedCharByPrevCharFromString(input);
        assertEquals("", output);

        input = "bbb";
        output = StringOperationUtils.replace3TimesRepeatedCharByPrevCharFromString(input);
        assertEquals("a", output);
    }
}
