package qa.com;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestBoard {
    @Test
    public void test_board_getDimension (){
        // ARRANGE
        int value = 8;
        int expectedValue = 8;
        // ACT
        Board board = new Board();
        try { board.setDimensions(value); }
        catch (BoardSizeException e) { e.printStackTrace(); }

        int actualValue = board.getDimensions();
        // ASSERT
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void test_board_setDimension_7 () throws BoardSizeException {
        // ARRANGE
        Board board = new Board();
        int value = 7;
        int expectedValue = 7;
        // ACT
        board.setDimensions(value);
        int actualValue = board.getDimensions();
        // ASSERT
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void test_board_setDimension_89 () throws BoardSizeException {
        // This dimension is over specified max dimension of 10, therefore should return exception.
        // ARRANGE
        Board board = new Board();
        int value = 89;
        int expectedValue = 0;  // Exception occur & dimension not set, hence  = 0
        // ACT
        try { board.setDimensions(value); }
        catch(BoardSizeException e) { System.out.println(e.getMessage()); }
        int actualValue = board.getDimensions();
        // ASSERT
//        assertThrows(BoardSizeException.class, () -> board.setDimensions(value));
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void test_board_generate_random_position (){
        // Test that method generate int in selected board size..
        // ARRANGE
        Board board = new Board();
        int value = 15;
        try { board.setDimensions(value); }
        catch (BoardSizeException e) { System.out.println(e.getMessage()); }

        // ACT
        int[] actualValues = new int[100];
        for (int i = 0 ; i < actualValues.length ; i++) {
            int x = board.generateRandomBoardPosition();
//            if (x == 1) { System.out.println("Error with x = " + x + " at i = " + i); }
        }
        // ASSERT
//        assertEquals(x,value); // TO BE AMENDED
    }

// TESTING CONSTRUCTOR:

    @Test
    public void test_board_constructor_with_size_12 () throws BoardSizeException {
        // Testing initialising board using constructor.
        // ARRANGE
        int value = 12;
        Board board =  new Board(value);
        int expectedValue = value;

        // ACT
        int actualValue = board.getDimensions();

        // ASSERT
//        assertThrows(BoardSizeException.class, () -> board.setDimensions(value));
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void test_board_constructor_with_size_89 () throws BoardSizeException {
        // ARRANGE
        int value = 89;
        int expectedValue = 0; // value too large hence dimension not set.

        // ACT
        Board board =  new Board(value);
        int actualValue = board.getDimensions();

        // ASSERT
//        assertThrows(BoardSizeException.class, () -> board.setDimensions(value));
        assertEquals(expectedValue, actualValue);
    }
}
