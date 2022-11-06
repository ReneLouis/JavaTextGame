package qa.com;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws BoardSizeException {
        // Take USER INPUT TO SET BOARD DIMENSION:
        Scanner scanner = new Scanner(System.in);

        System.out.println( "Hello & Welcome!\n\nPlease Enter the board size:");
        int userChosenDimension = scanner.nextInt();
        Board board = new Board(userChosenDimension);
//        Board board = new Board();
//        try {
//            if (userChosenDimension >= board.getMinBoardDimension() && userChosenDimension <= board.getMaxBoardDimension())
//                board.setDimensions(userChosenDimension);
//            else throw new BoardSizeException("Error! " + userChosenDimension + " is invalid: the board dimensions" +
//                    " must be over " + board.getMinBoardDimension() + " and less than " + board.getMaxBoardDimension() + ".");
//        }
//        catch (BoardSizeException e) { e.printStackTrace(); };
        System.out.println(board.getDimensions());

        /* GET 1 monster in 10 cases as Character objects. All those to be Character objects.
        Create a list of all those monsters.
        List to be used to check no two objects on same gridPosition.
        */
        int numberOfMonsters = (int) Math.round((board.getDimensions() * board.getDimensions()) * 0.1) + 1;
                    System.out.println("numberOfMonsters = " + numberOfMonsters);
        List<Character> boardOccupiers = new ArrayList<>();

        for (int i = 0 ; i < numberOfMonsters ; i++) {
            Monster monster = new Monster();
            boolean monsterAdded =  monster.placeOnBoard(board, boardOccupiers);
            System.out.print("Monster Added? " + monsterAdded + " | Position: ");
            System.out.println(monster.getGridPosition()[0] + " ; " + monster.getGridPosition()[1]);
            if (!monsterAdded) { i--; }
        }

        System.out.println("Number of Monsters = " + boardOccupiers.size());

        /* Add a treasure on the board: */
        Character treasure = new Treasure();
        boolean treasureAdded;
        do {
            treasureAdded = treasure.placeOnBoard(board, boardOccupiers);
            System.out.print("Treasure Added? " + treasureAdded + " | Position: ");
            System.out.println(treasure.getGridPosition()[0] + " ; " + treasure.getGridPosition()[1]);
        } while (!treasureAdded);

        System.out.println("Number of items = " + boardOccupiers.size());
    }
}
