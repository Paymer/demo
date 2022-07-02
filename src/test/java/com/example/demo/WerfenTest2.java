package com.example.demo;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class WerfenTest2 {
	
	@Test
	  public void testSimpleDirReduc() {
	    assertArrayEquals(
	          new String[]{"WEST"},
	          WerfenExercise2.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}), "\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"");
	    assertArrayEquals(
	          new String[]{},
	          WerfenExercise2.dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"}), "\"NORTH\",\"SOUTH\",\"SOUTH\",\"EAST\",\"WEST\",\"NORTH\"");
	    
	  }

	  @Test
	    public void testSimpleDirReduc2() {
	        assertArrayEquals(
	          new String[]{"WEST"},
	          WerfenExercise2.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}), "\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"");
	        assertArrayEquals(
	          new String[]{},
	          WerfenExercise2.dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"}),
					"\"NORTH\",\"SOUTH\",\"SOUTH\",\"EAST\",\"WEST\",\"NORTH\"");
	        assertArrayEquals(
	          new String[]{"NORTH"},      
	          WerfenExercise2.dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH","NORTH"}),
					"\"NORTH\",\"SOUTH\",\"SOUTH\",\"EAST\",\"WEST\",\"NORTH\",\"NORTH\"");
	        assertArrayEquals(
	          new String[]{"EAST", "NORTH"},
	          WerfenExercise2.dirReduc(new String[]{"EAST", "EAST", "WEST", "NORTH", "WEST", "EAST", "EAST", "SOUTH", "NORTH", "WEST"}),
					"\"EAST\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\", \"EAST\", \"EAST\", \"SOUTH\", \"NORTH\", \"WEST\"");
	        assertArrayEquals(
	          new String[]{"NORTH", "EAST"},
	          WerfenExercise2.dirReduc(new String[]{"NORTH", "EAST", "NORTH", "EAST", "WEST", "WEST", "EAST", "EAST", "WEST", "SOUTH"}),
					"\"NORTH\", \"EAST\", \"NORTH\", \"EAST\", \"WEST\", \"WEST\", \"EAST\", \"EAST\", \"WEST\", \"SOUTH\"");
	        assertArrayEquals(
	          new String[]{"NORTH", "WEST", "SOUTH", "EAST"},
	          WerfenExercise2.dirReduc(new String[]{"NORTH", "WEST", "SOUTH", "EAST"}),
					"\"NORTH\", \"WEST\", \"SOUTH\", \"EAST\"");
	        assertArrayEquals(
	          new String[]{"WEST", "WEST"},
	          WerfenExercise2.dirReduc(new String[]{"EAST", "WEST", "WEST", "WEST"}),
					"\"EAST\", \"WEST\", \"WEST\", \"WEST\"");
	    }

	    String[] randDir(int n) {
	      String[] dirs = new String[]{"NORTH", "SOUTH", "EAST", "WEST"};
	      String[] result = new String[n];
	      for (int i = 0; i < n; ++i) {
	        result[i] = dirs[(int) (Math.random() * 4)];
	      }
	      return result;
	    }

	    public String[] doDirReduc(String[] arr) {
	        if (arr == null) return new String[] {};
	        if (arr.length < 2) return arr;
	        int i = 0;
	        List<String> directions = Arrays.stream(arr).collect(Collectors.toList());
	        do {
	          String tmp = directions.get(i) + directions.get(i + 1);
	          if (tmp.equals("NORTHSOUTH") || tmp.equals("SOUTHNORTH") || tmp.equals("EASTWEST") || tmp.equals("WESTEAST")) {
	            directions.remove(i + 1);
	            directions.remove(i);
	            if (i > 0) i--;
	          } else
	            i++;
	        } while (i < directions.size() - 1);
	        return directions.stream().toArray(String[]::new);
	    }

	    @Test
	    public void testRandomDirReduc() throws Exception {
	      String[] u10 = randDir(10);
	      assertArrayEquals(doDirReduc(u10), WerfenExercise2.dirReduc(u10), "random 10 directions");
	      String[] u15 = randDir(15);
	      assertArrayEquals(doDirReduc(u15), WerfenExercise2.dirReduc(u15), "random 15 directions");
	      String[] u30 = randDir(30);
	      assertArrayEquals(doDirReduc(u30), WerfenExercise2.dirReduc(u30), "random 30 directions");
	    }
	}