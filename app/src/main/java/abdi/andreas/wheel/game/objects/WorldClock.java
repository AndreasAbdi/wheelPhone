package abdi.andreas.wheel.game.objects;


import android.graphics.Canvas;
import android.graphics.Paint;

import abdi.andreas.wheel.engine.objects.GameObject;

//TODO: Make this class into one where we can abstract the game time to.
public class WorldClock implements GameObject {
    boolean isRunning;

    @Override
    public void draw(Canvas canvas, Paint paint) {

    }

    @Override
    public void update(long fps) {

    }

    @Override
    public boolean disabled() {
        return false;
    }

    @Override
    public boolean collidesWith(GameObject gameObject) {
        return false;
    }
}
