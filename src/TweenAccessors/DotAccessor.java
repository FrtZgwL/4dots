package TweenAccessors;

import GameClasses.Dot;
import aurelienribon.tweenengine.TweenAccessor;

/**
 * Created by Cedric on 17.03.2015.
 *
 * Java Universal Tween Engine - Tween Accessor for GameClasses.Dot
 */
public class DotAccessor implements TweenAccessor<Dot> {

    //  --- Tween Types ---  //
    public static final int XY_POSITION = 0;

    //  --- getters & setters ---  //
    @Override
    public int getValues(Dot dot, int i, float[] floats) {
        switch (i) {
            case XY_POSITION:
                floats[0] = (float) dot.getEllipse().getX();
                floats[1] = (float) dot.getEllipse().getY();
                return 2;
            default:
                assert false;
                return 0;
        }
    }

    @Override
    public void setValues(Dot dot, int i, float[] floats) {
        switch (i) {
            case XY_POSITION:
                dot.getEllipse().setFrame(
                        floats[0],
                        floats[1],
                        dot.getEllipse().getWidth(),
                        dot.getEllipse().getHeight()
                );
                break;
            default:
                assert false;
        }
    }
}
