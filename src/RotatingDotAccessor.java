import aurelienribon.tweenengine.TweenAccessor;

/**
 * Created by Cedric on 18.03.2015.
 */
public class RotatingDotAccessor implements TweenAccessor<RotatingDot> {

    //  --- Tween Types ---  //
    public static final int XY_POSITION = 0;
    public static final int ROTATION = 1;

    //  --- getters & setters ---  //


    @Override
    public int getValues(RotatingDot rotatingDot, int i, float[] floats) {
        switch (i) {
            case XY_POSITION:
                floats[0] = (float) rotatingDot.getEllipse().getX();
                floats[1] = (float) rotatingDot.getEllipse().getY();
                return 2;
            case ROTATION:
                floats[0] = (float) rotatingDot.getRotation();
                return 1;
            default:
                assert false;
                return 0;
        }
    }

    @Override
    public void setValues(RotatingDot rotatingDot, int i, float[] floats) {
        switch (i) {
            case XY_POSITION:
                rotatingDot.getEllipse().setFrame(
                        floats[0],
                        floats[1],
                        rotatingDot.getEllipse().getWidth(),
                        rotatingDot.getEllipse().getHeight()
                );
                break;
            case ROTATION:
                rotatingDot.setRotation(floats[0]);
                break;
            default:
                assert false;
        }
    }

}
