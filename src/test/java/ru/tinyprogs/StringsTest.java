package ru.tinyprogs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by v.yanchenko on 16.10.2016.
 */
public class StringsTest {

    Strings strings = new Strings();

    @Test
    public void testRemoveSpacesBetweenQuestions() {
        assertEquals(strings.removeSpacesBetweenQuestions(""), "");
        assertEquals(strings.removeSpacesBetweenQuestions("?"), "?");
        assertEquals(strings.removeSpacesBetweenQuestions("? "), "? ");
        assertEquals(strings.removeSpacesBetweenQuestions("??"), "??");
        assertEquals(strings.removeSpacesBetweenQuestions("? ?"), "??");
        assertEquals(strings.removeSpacesBetweenQuestions("a? e?c"), "a?e?c");
        assertEquals(strings.removeSpacesBetweenQuestions("a ? e? c "), "a ?e? c ");
        assertEquals(strings.removeSpacesBetweenQuestions("???"), "???");
        assertEquals(strings.removeSpacesBetweenQuestions("?? ?"), "?? ?");
        assertEquals(strings.removeSpacesBetweenQuestions("?v n ? ?"), "?vn? ?");
        assertEquals(strings.removeSpacesBetweenQuestions("?1234?"), "?1234?");
        assertEquals(strings.removeSpacesBetweenQuestions("hello! hi. ? who knows ! ? Goodbye?  Yep?"), "hello! hi. ?whoknows!? Goodbye?  Yep?");
    }

    @Test
    public void testDecimalToNotation() {
        assertEquals(strings.decimalToNotation(12, 3), "110");
        assertEquals(strings.decimalToNotation(120, 3), "11110");
        assertEquals(strings.decimalToNotation(920, 4), "32120");
        assertEquals(strings.decimalToNotation(2324, 5), "33244");
        assertEquals(strings.decimalToNotation(324, 6), "1300");
        assertEquals(strings.decimalToNotation(5903, 12), "34BB");
        assertEquals(strings.decimalToNotation(854, 15), "3BE");
    }
}
