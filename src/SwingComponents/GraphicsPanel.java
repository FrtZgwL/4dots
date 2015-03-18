package SwingComponents;

import GameClasses.Dot;
import GameClasses.GameColors;
import GameClasses.RotatingDot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: cedrictonyedjon
 * Date: 3/13/15
 * Time: 8:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class GraphicsPanel extends JPanel implements GameColors, ActionListener {

    ////////////////////////////
    //  --- Enumerations ---  //
    ////////////////////////////

    private enum GameState {
        STARTMENU, INGAME, PAUSE
    }

    /////////////////////////
    //  --- Constants ---  //
    /////////////////////////

    /* how many dots show up every second */
    //private final int difficulty;

    /** Sorry but I'm to bad to write this stuff dynamic so I had to hardcode the size. */
    private static final Dimension GP_SIZE = new Dimension(394, 336);


    //////////////////////////////////
    //  --- Instance Variables ---  //
    //////////////////////////////////

    /** This keeps kicking out events so we can have animation */
    Timer update;

    /** This remembers what state the game is in (STARTMENU for the play button, INGAME for gameplay) */
    GameState state;


    // --- Graphics Objects --- //

    /** The 4 dots in the corners that you are supposed to swipe all the other ones to */
    RotatingDot[] cornerDots;

    /** Linked list containing the intractable Dots in the game */
    LinkedList<Dot> gameDots;


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

        cornerDots = new RotatingDot[4];
        cornerDots[0] = new RotatingDot(GameColors.COLORS[0]);
        cornerDots[1] = new RotatingDot(GameColors.COLORS[1]);
        cornerDots[2] = new RotatingDot(GameColors.COLORS[2]);
        cornerDots[3] = new RotatingDot(GameColors.COLORS[3]);

         // put them things in the right positions
        double x = GP_SIZE.getWidth()/2;
        double y = GP_SIZE.getHeight()/2;
        for(int i = 0; i < 4; i++) {
            cornerDots[i].getEllipse().setFrameFromCenter(
                    x, y - 100,
                    x - cornerDots[i].getEllipse().getWidth()/2,
                    y - cornerDots[i].getEllipse().getHeight()/2 - 100
            );
            cornerDots[i].setRotationCenter(new Point((int) x, (int) y));
        }

        // start update timer
        update.start();
    }

    /**
     * !!! This is the interesting part !!!
     * Overriding the paintComponent method of JPanel to make custom graphics
     * All the graphics of the game is drawn here. (The logic is somewhere else though!)
     * @param g Graphics Object that is magically given to us by Java. used to draw n stuff.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.drawString("I am " + getWidth() + "W, " + getHeight() + "H Big!", 150, 100);

        switch (state) {
            case STARTMENU:
            // draw the start menu:
                // draw the corner dots
                for(int i = 0; i < 4; i++) {
                    g2.setColor(cornerDots[i].getColor());
                    g2.fill(cornerDots[i].getEllipse());
                }
                // draw a start Button
                break;
            case INGAME:
            // draw the game:
                // draw the corner dots
                // draw the dot list
                // draw a pause button
                break;
        }
    }

    /**
     * This is constantly being triggered by the update Timer and it creates the new frames
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
                    for(int i = 0; i < 4; i++)
                        cornerDots[i].setRotation(i*.5*Math.PI);

                    break;
                case INGAME:
                    // animate the game
                    break;
            }

            repaint();
        }
    }
}
