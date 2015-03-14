import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: cedrictonyedjon
 * Date: 3/13/15
 * Time: 8:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class GraphicsPanel extends JPanel {

    /////////////////////////
    //  --- Constants ---  //
    /////////////////////////

    /** how many dots show up every second */
    //private final int difficulty;


    //////////////////////////////////
    //  --- Instance Variables ---  //
    //////////////////////////////////

    ///////////////////////
    //  --- Methods ---  //
    ///////////////////////

    /**
     * Constructor for main graphics handling thing form 4dots (swing edition)
     * @param difficulty difficulty provided by main frame
     */
    public GraphicsPanel(int difficulty) {
        super();
        //this.difficulty = difficulty;
    }

    /**
     * !!! This is the interesting part !!!
     * Overriding the paintComponent method of JPanel to make custom graphics
     * All the graphics of the game is drawn here.
     * @param g Graphics Object that is magically given to us by Java. used to draw n stuff.
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawString("We're running!", 200, 200);
    }
}
