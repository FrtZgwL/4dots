import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: cedrictonyedjon
 * Date: 3/13/15
 * Time: 8:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class GraphicsPanel extends JPanel implements ActionListener {

    ////////////////////////////
    //  --- Enumerations ---  //
    ////////////////////////////

    private enum GameState {
        STARTMENU, INGAME
    }

    /////////////////////////
    //  --- Constants ---  //
    /////////////////////////

    /* how many dots show up every second */
    //private final int difficulty;


    //////////////////////////////////
    //  --- Instance Variables ---  //
    //////////////////////////////////

    /** This keeps kicking out events so we can have animation */
    Timer update;

    /** This remembers what state the game is in (STARTMENU for the play button, INGAME for gameplay) */
    GameState state;


    ///////////////////////
    //  --- Methods ---  //
    ///////////////////////

    /**
     * Constructor for main graphics handling thing form 4dots (swing edition)
     * @param difficulty difficulty provided by main frame
     */
    public GraphicsPanel(int difficulty) {
        super();

        // Initialize everything
        update = new Timer(10, this);
        state = GameState.STARTMENU;
    }

    /**
     * !!! This is the interesting part !!!
     * Overriding the paintComponent method of JPanel to make custom graphics
     * All the graphics of the game is drawn here. (The logic is somewhere else though!)
     * @param g Graphics Object that is magically given to us by Java. used to draw n stuff.
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawString("I am " + getWidth() + "W, " + getHeight() + "H Big!", 150, 100);

        switch (state) {
            case STARTMENU:
                // draw the start menu
                break;
            case INGAME:
                // draw the game
                break;
        }
    }

    /**
     * This is constantly being triggert by the update Timer and it creates the new frames
     * that will then be drawn by the paintComponent method.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == update) {
            // make a new frame

            switch (state) {
                case STARTMENU:
                    // animate the start menu
                    break;
                case INGAME:
                    // animate the game
                    break;
            }

            repaint();
        }
    }
}
