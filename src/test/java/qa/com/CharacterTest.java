package qa.com;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CharacterTest {
    @Test
    public void test_player_position() throws BoardSizeException {
        // ARRANGE
        int value = 15;
        Board board = new Board(value);
        Character character = new Character();

        for (int i = 0; i < 1000; i++) {
            // ACT
            int x = board.generateRandomBoardPosition();
            int y = board.generateRandomBoardPosition();
            character.setPosition(x, y);
            // ASSERT
            int testMaxValue = value;
            if (character.get_xPosition() < 1 || character.get_xPosition() > testMaxValue || character.get_yPosition() < 1 || character.get_yPosition() > testMaxValue)
                System.out.println(i + " - Error with Position: " + character.get_xPosition() + " ; " + character.get_yPosition());
        }
    }

    @Test
    public void test_one_monster_place_board() throws BoardSizeException {
        // ARRANGE
        Board board = new Board(16);
        List<Character> characters = new ArrayList<>();
        Monster monster = new Monster();

        // ACT
        monster.placeOnBoard(board, characters);
        System.out.println("There are " + characters.size() + " monsters.");

        // ASSERT
    }

    @Test
    public void test_adding_six_monsters_place_board() throws BoardSizeException {
        // ARRANGE
        Board board = new Board(16);
        List<Character> characters = new ArrayList<>();

        // ACT
        for (int i = 0 ; i <6 ; i++) {
            Monster monster = new Monster();
            boolean monsterAdded =  monster.placeOnBoard(board, characters);
            System.out.print("Monster Added? " + monsterAdded + " | Position: ");
            System.out.println(monster.getGridPosition()[0] + " ; " + monster.getGridPosition()[1]);
            if (!monsterAdded) { i--; }
        }

        // ASSERT
        System.out.println("There are " + characters.size() + " monsters.");
    }
    @Test
    public void test_adding_six_monsters_and_treasure_onto_board() throws BoardSizeException {
        // ARRANGE
        Board board = new Board(16);
        List<Character> characters = new ArrayList<>();

        // ACT
        for (int i = 0 ; i <6 ; i++) {
            Monster monster = new Monster();
            boolean monsterAdded =  monster.placeOnBoard(board, characters);
            System.out.print("Monster Added? " + monsterAdded + " | Position: ");
            System.out.println(monster.getGridPosition()[0] + " ; " + monster.getGridPosition()[1]);
            if (!monsterAdded) { i--; }
        }
        Treasure treasure = new Treasure();
        boolean treasureAdded;
        do {
            treasureAdded = treasure.placeOnBoard(board, characters);
            System.out.print("Teasure Added? " + treasureAdded + " | Position: ");
            System.out.println(treasure.getGridPosition()[0] + " ; " + treasure.getGridPosition()[1]);
        } while (!treasureAdded);

        // ASSERT
        System.out.println("There are " + characters.size() + " intems.");
    }
}
