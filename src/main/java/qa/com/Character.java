package qa.com;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private int[] gridPosition = new int[2];
    // CONSTRUCTORS:
    public Character(int x, int y) {
        gridPosition[0] = x;
        gridPosition[1] = y;
    }

    public Character(){}

    // SETTER:
    public void setPosition(int xPosition, int yPosition) {
        this.gridPosition[0] = xPosition;
        this.gridPosition[1] = yPosition;
    }

    // GETTERS:
    public int get_xPosition() { return gridPosition[0]; }
    public int get_yPosition() { return gridPosition[1]; }
    public int[] getGridPosition() { return gridPosition;}

    // METHODS
    // Method to place character at random position on board, and check if position is valid.

    public boolean placeOnBoard(Board board, List<Character> boardOccupiers) {
        int xPosition = board.generateRandomBoardPosition();
        int yPosition = board.generateRandomBoardPosition();
//        Character monster = new Monster();
        this.setPosition(xPosition, yPosition);

        boolean characterAddedToBoard = false;
        boolean positionAvailable = true;

        if (!boardOccupiers.isEmpty()) {
            for (Character boardOccupier : boardOccupiers) {
                if ((xPosition == boardOccupier.get_xPosition()) && (yPosition == boardOccupier.get_yPosition())) {
                    positionAvailable = false;
                }
            }
        }
        if (positionAvailable) {
            boardOccupiers.add(this);
            characterAddedToBoard = true;
        }

        return characterAddedToBoard;
    }
}
