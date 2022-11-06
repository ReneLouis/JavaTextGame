package qa.com;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PlayerTest {
    @Test
    public void test_creating_player_with_no_name() throws BoardSizeException {
        // ARRANGE
        Board board = new Board(20);

        // ACT
        Player player = new Player();
        int x = board.generateRandomBoardPosition();
        int y = board.generateRandomBoardPosition();
        player.setPosition(x, y);
        // ASSERT
        System.out.println("The player is called " + player.getName() + " and is in position " + player.getGridPosition()[0] + " ; " + player.getGridPosition()[1]);
    }

    @Test
    public void test_creating_player_named_Rene() throws BoardSizeException {
        // ARRANGE
        Board board = new Board(20);

        // ACT
        Player rene = new Player("Rene");
        int x = board.generateRandomBoardPosition();
        int y = board.generateRandomBoardPosition();
        rene.setPosition(x, y);
        // ASSERT
        System.out.println("The player is called " + rene.getName() + " and is in position " + rene.getGridPosition()[0] + " ; " + rene.getGridPosition()[1]);
    }

    // CREATE COLLECTION OF CHARACTERS
    @Test
    public void test_creating_players_into_a_collection() throws BoardSizeException {
        // ARRANGE
        Board board = new Board(20);

        // ACT

        int x = board.generateRandomBoardPosition();
        int y = board.generateRandomBoardPosition();
        Player player = new Player(x, y,"René");
//        player.setPosition(x, y);
        // ASSERT
        System.out.println("The player is called " + player.getName() + " and is in position " + player.getGridPosition()[0] + " ; " + player.getGridPosition()[1]);
    }

    // MOVING THE PLAYER ON THE BOARD
    @Test
    public void moving_player_right_on_board_within_limits() throws BoardSizeException {
        // ARRANGE
        Board board = new Board(20);
        Player player = new Player();
        player.setPosition(19,1);
        int expectedValue = 20;

        // ACT
        player.moveRight(board);
        int actualValue = player.getGridPosition()[0];
        // ASSERT
        System.out.println(player.getGridPosition()[0] + " ; " + player.getGridPosition()[1]);
        assertEquals(expectedValue, actualValue);
    }
    @Test
    public void moving_player_left() throws BoardSizeException {
        // ARRANGE
        Board board = new Board(20);
        Player player = new Player();
        player.setPosition(1,1);
        int expectedValue = 1;

        // ACT
        player.moveLeft(board);
        int actualValue = player.getGridPosition()[0];
        // ASSERT
        System.out.println(player.getGridPosition()[0] + " ; " + player.getGridPosition()[1]);
        assertEquals(expectedValue, actualValue);
    }
    @Test
    public void moving_player_up() throws BoardSizeException {
        // ARRANGE
        Board board = new Board(20);
        Player player = new Player();
        player.setPosition(1,19);
        int expectedValue = 20;

        // ACT
        player.moveUp(board);
        int actualValue = player.getGridPosition()[1];
        // ASSERT
        System.out.println(player.getGridPosition()[0] + " ; " + player.getGridPosition()[1]);
        assertEquals(expectedValue, actualValue);
    }
    @Test
    public void moving_player_down() throws BoardSizeException {
        // ARRANGE
        Board board = new Board(20);
        Player player = new Player();
        player.setPosition(1,1);
        int expectedValue = 1;

        // ACT
        player.moveDown(board);
        int actualValue = player.getGridPosition()[1];
        // ASSERT
        System.out.println(player.getGridPosition()[0] + " ; " + player.getGridPosition()[1]);
        assertEquals(expectedValue, actualValue);
    }
}
