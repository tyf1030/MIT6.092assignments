import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawGraphics {
    ArrayList<BouncingBox> boxes = new ArrayList<>();

    /** Initializes this class for drawing. */
    public DrawGraphics() {
        boxes.add(new BouncingBox(200, 50, Color.RED));
        boxes.add(new BouncingBox(50, 200, Color.RED));
        boxes.add(new BouncingBox(125, 125, Color.RED));
        
        boxes.get(0).setMovementVector(1, 0);
        boxes.get(1).setMovementVector(0, -2);
        boxes.get(2).setMovementVector(2, -1);

    }

    /** Draw the contents of the window on surface. Called 20 times per second. */
    public void draw(Graphics surface) {
        surface.drawLine(50, 50, 250, 250);
        for(BouncingBox box: boxes){
            box.draw(surface);
        }
    }
} 