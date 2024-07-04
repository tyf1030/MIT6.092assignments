import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
public class DrawGraphics {
    ArrayList<Mover> movers;

    /** Initializes this class for drawing. */
    public DrawGraphics() {
        movers = new ArrayList<>();
        movers.add(new Bouncer(100, 170, new Rectangle(15, 20, Color.BLUE)));
        movers.add(new Bouncer(200, 0, new Oval(100, 50, Color.CYAN)));
        movers.add(new StraightMover(160, 160, new Rectangle(15, 20, Color.BLUE)));
        movers.add(new StraightMover(10, 32, new Oval(100, 50, Color.CYAN)));
        for (Mover mover: movers){
            mover.setMovementVector(3, 1);
        }
    }

    /** Draw the contents of the window on surface. */
    public void draw(Graphics surface) {
        for (Mover mover: movers){
            mover.draw(surface);
        }
    }
    }

