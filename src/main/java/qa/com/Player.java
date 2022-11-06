package qa.com;

public class Player extends Character {
    private String name;

    // CONSTRUCTOR:
    public Player(int x, int y, String name) {
        super(x, y);
        this.name = name;
    }
    public Player(String name) {
        super();
        this.name = name;
    }
    public Player() {
        super();
        this.name = "Player";
    }

    // GETTERS & SETTERS
    public String getName(){ return name; }

    public void moveRight(Board board) {
        try {
            if (get_xPosition() < board.getDimensions()) {
                this.setPosition(get_xPosition() + 1, get_yPosition());
            }
            else throw new MovementException("Not allowed, your are on the right limit of the board.");
        }
        catch (MovementException e) { System.out.println(e.getMessage()); }
    }

    public void moveLeft(Board board) {
        try {
            if (get_xPosition() > 1) {
                this.setPosition(get_xPosition() - 1, get_yPosition());
            }
            else throw new MovementException("Not allowed, your are on the left limit of the board.");
        }
        catch (MovementException e) { System.out.println(e.getMessage()); }
    }

    public void moveUp(Board board) {
        try {
            if (get_yPosition() < board.getDimensions()) {
                this.setPosition(get_xPosition(), get_yPosition() + 1);
            }
            else throw new MovementException("Not allowed, your are on the upper limit of the board.");
        }
        catch (MovementException e) { System.out.println(e.getMessage()); }
    }

    public void moveDown(Board board) {
        try {
            if (get_yPosition() > 1 ) {
                this.setPosition(get_xPosition(), get_yPosition() - 1);
            }
            else throw new MovementException("Not allowed, your are on the lower limit of the board.");
        }
        catch (MovementException e) { System.out.println(e.getMessage()); }
    }
}
