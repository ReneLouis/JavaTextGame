package qa.com;

public class Board {
    // INSTANCE VARIABLES:
    private final int minBoardDimension = 4;
    private final int maxBoardDimension = 20;
    private int xAxisDim, yAxisDim;

    // CONSTRUCTOR:
    public Board(int value) throws BoardSizeException{
        try {
            if (value < minBoardDimension || value > maxBoardDimension) {
                xAxisDim = yAxisDim = this.getMaxBoardDimension();
                throw new BoardSizeException("Error! " + value + " is invalid: the board dimensions" +
                        " must be over " + minBoardDimension + " and less than " + maxBoardDimension + ".\n" +
                        "Board dimension were autmotiacally adjusted to " + maxBoardDimension + " by " +
                        maxBoardDimension + ".");
            }
            else {
                System.out.println("dimensions accepted");
                xAxisDim = value;
                yAxisDim = value;
            }
        }
        catch (BoardSizeException e) { System.out.println(e.getMessage()); }
    }
    public Board(){
        xAxisDim = yAxisDim = 0;
    }

    // GETTERS

    public int getMinBoardDimension() { return minBoardDimension; }
    public int getMaxBoardDimension() { return maxBoardDimension; }

    // METHODS:
    public void setDimensions(int value) throws BoardSizeException {
        try {
                if (value < minBoardDimension || value > maxBoardDimension) {
                    throw new BoardSizeException("Error: the board size must be over " +
                            minBoardDimension + " and less than " + maxBoardDimension + ".");
                }
            else {
                xAxisDim = value;
                yAxisDim = value;
                }
            }
        catch (BoardSizeException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getDimensions() { return xAxisDim; }

    public int generateRandomBoardPosition() {
        // GENERATE POSITION x, y AT RANDOM ON BOARD
        return (int) ((Math.random() * xAxisDim) + 1);
    }
}
