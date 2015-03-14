import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: cedrictonyedjon
 * Date: 3/13/15
 * Time: 7:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class mainFrame extends JFrame implements ActionListener {

    /////////////////////////
    //  --- Constants ---  //
    /////////////////////////

    /** how many dots show up per second */
    private static final int DIFFICULTY = 10;


    //////////////////////////////////
    //  --- Instance Variables ---  //
    //////////////////////////////////

    /**
     * main panel to hold ALLLL the stuff
     */
    private JPanel p;

    /**
     * button that can be clicked to
     *  display the options menu
     */
    private JButton optionsBtn;

    /**
     * panel that displays all the game
     * graphics.also handles events and
     * every thing this basically IS the game.
     */
    private GraphicsPanel graphicsPanel;

    private OptionsPanel optionsPanel;

    ///////////////////////
    //  --- Methods ---  //
    ///////////////////////

    public mainFrame() {

        /* set up main frame: */
        setResizable(false);
        setSize(new Dimension(400, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        /* initialize all the instance variables */
        p = new JPanel(new BorderLayout());
        graphicsPanel = new GraphicsPanel(DIFFICULTY);
        optionsPanel = new OptionsPanel();

        optionsBtn = new JButton("Options");


        /* add all the things */
        JPanel temp = new JPanel();
        temp.add(optionsBtn);

        p.add(temp, BorderLayout.SOUTH);
        p.add(graphicsPanel, BorderLayout.CENTER);

        getContentPane().add(p);


        /* set up event handling */
        optionsBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == optionsBtn) {
            //TODO Make Options panel appear
        }
    }

    /**
     * Main method for 4dots (java swing edition)
     * @param args Command line arguments for main program
     */
    public static void main(String[] args) {

        mainFrame main = new mainFrame();

    }
}
