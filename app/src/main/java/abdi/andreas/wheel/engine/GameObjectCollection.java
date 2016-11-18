package abdi.andreas.wheel.engine;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

import abdi.andreas.wheel.engine.GameObject;

public class GameObjectCollection<T extends GameObject> extends ArrayList<T> {

    public void draw(Canvas canvas, Paint paint) {
        for(GameObject object : this) {
            object.draw(canvas, paint);
        }
    }

    public void update(long fps) {
        for(GameObject object : this) {
            object.update(fps);
        }
    }
}
