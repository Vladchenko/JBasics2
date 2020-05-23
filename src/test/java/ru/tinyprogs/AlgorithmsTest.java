package ru.tinyprogs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Влад on 27.08.2016.
 */
public class AlgorithmsTest {

    Algorithms algorithms = new Algorithms();

    @Test
    public void testCountWords() throws Exception {

        assertEquals(algorithms.countWords(""), 0);
        assertEquals(algorithms.countWords(" "), 0);
        assertEquals(algorithms.countWords("  "), 0);
        assertEquals(algorithms.countWords("   "), 0);
        assertEquals(algorithms.countWords("         "), 0);

        assertEquals(algorithms.countWords("q"), 1);
        assertEquals(algorithms.countWords("qwerty"), 1);

        assertEquals(algorithms.countWords(" w"), 1);
        assertEquals(algorithms.countWords(" e "), 1);
        assertEquals(algorithms.countWords(" r  "), 1);
        assertEquals(algorithms.countWords("  t  "), 1);
        assertEquals(algorithms.countWords("  y u  "), 2);
        assertEquals(algorithms.countWords("i o"), 2);
        assertEquals(algorithms.countWords("  a     s  "), 2);
        assertEquals(algorithms.countWords("d     f"), 2);
        assertEquals(algorithms.countWords("g     h "), 2);

        assertEquals(algorithms.countWords("2"), 1);
        assertEquals(algorithms.countWords(" 432.4 "), 1);
    }
}