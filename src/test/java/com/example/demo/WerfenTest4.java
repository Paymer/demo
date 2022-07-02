package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WerfenTest4 {

	@Test
    public void fixedTests() {
        assertEquals("f", WerfenExercise4.addLetters("a", "b", "c"));
        assertEquals("z", WerfenExercise4.addLetters("z"));
        assertEquals("c", WerfenExercise4.addLetters("a", "b"));
        assertEquals("c", WerfenExercise4.addLetters("c"));
        assertEquals("a", WerfenExercise4.addLetters("z", "a"));
        assertEquals("d", WerfenExercise4.addLetters("y", "c", "b"));
        assertEquals("z", WerfenExercise4.addLetters());
    }

}
