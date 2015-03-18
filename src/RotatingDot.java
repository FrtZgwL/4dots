import java.awt.*;

/**
 * Created by Cedric on 17.03.2015.
 */
public class RotatingDot extends Dot {

    /////////////////////////////////
    //  --- Instance Variables --- //
    /////////////////////////////////

    /** Used (in Animations) to store the center point to float around for rotating motions */
    private Point rotationCenter;


    //////////////////////
    //  --- Methods --- //
    //////////////////////

    //  --- Constructors ---  //

    public RotatingDot() {
        super();
    }

    public RotatingDot(Color color) {
        super(color);
    }

    public RotatingDot(Point rotationCenter) {
        super();
        this.rotationCenter = rotationCenter;
    }

    public RotatingDot(Color color, Point rotationCenter) {
        super(color);
        this.rotationCenter = rotationCenter;
    }


    //  --- Getters & Setters ---  //

    public Point getRotationCenter() {
        return rotationCenter;
    }

    public void setRotationCenter(Point rotationCenter) {
        this.rotationCenter = rotationCenter;
    }

    // (int) ( getHeight()/2 + Math.cos( i* (.5 * Math.PI)) * 100 )
    // ( rotationCenter.getY()   +    Math.cos( rotation ) * distance )

    /**
     * Sets the rotation in relation to the rotation center
     * @param rotation Rotation in radian's
     */
    public void setRotation(double rotation) {
        //TODO This is kinda buggy i dunno whats wrong but dots don't show up on screen and are all over the place in memory
        // start by calculating the distances on x and y axis
        double distanceX = Math.abs(rotationCenter.getX() - getEllipse().getCenterX());
        double distanceY = Math.abs(rotationCenter.getY() - getEllipse().getCenterY());

        // use the pythagorean theorem to get the real distance
        double distance = Math.sqrt(Math.pow(distanceX, 2.0) + Math.pow(distanceY, 2.0));

        // use sin & cos to find the correct x and y positions
        double x = rotationCenter.getX() + Math.sin(rotation) * distance;
        double y = rotationCenter.getY() + Math.cos(rotation) * distance;

        // apply the new values
        getEllipse().setFrameFromCenter(
                x, y,
                x - getEllipse().getWidth() / 2,
                y - getEllipse().getHeight() / 2
        );
    }

    /**
     * Gets the current rotation in relation to the rotation
     * center in radian's
     */
    public double getRotation() {
        double x = Math.abs(rotationCenter.getX() - getEllipse().getCenterX());
        return .0;
    }
}
