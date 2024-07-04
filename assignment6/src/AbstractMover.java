import java.awt.Graphics;

public abstract class AbstractMover implements Mover{
    protected int x;
    protected int y;
    protected int xDirection;
    protected int yDirection;
    protected Sprite sprite;

    /** Create a Bouncer that positions sprite at (startX, startY). */
    public AbstractMover(int startX, int startY, Sprite sprite) {
        x = startX;
        y = startY;
        this.sprite = sprite; 
    }

    /** Starts moving the object in the direction (xIncrement, yIncrement). */
    public void setMovementVector(int xIncrement, int yIncrement) {
        this.xDirection = xIncrement;
        this.yDirection = yIncrement;
    }

    public abstract void draw(Graphics surface);
}
