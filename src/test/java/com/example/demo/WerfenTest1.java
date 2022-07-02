package com.example.demo;



import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WerfenTest1 {

	
	
    @Test
    public void testSimple()
    {
        assertTrue(Arrays.equals(new int[] {2,4,6}, WerfenExercise1.divisibleBy(new int[] {1,2,3,4,5,6},2)));
        assertTrue(Arrays.equals(new int[] {3,6}, WerfenExercise1.divisibleBy(new int[] {1,2,3,4,5,6},3)));
        assertTrue(Arrays.equals(new int[] {0,4}, WerfenExercise1.divisibleBy(new int[] {0,1,2,3,4,5,6},4)));
    }
}


