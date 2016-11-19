package abdi.andreas.wheel.engine.objects;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Iterator;

public class GameObjectCollection<T extends GameObject> extends ArrayList<T> {

    public void draw(Canvas canvas, Paint paint) {
        for(T object : this) {
            object.draw(canvas, paint);
        }
    }

    public void update(long fps) {
        for(T object : this) {
            object.update(fps);
        }
    }

    public void clearObjects() {
        Iterator it = this.iterator();
        while(it.hasNext()) {
            T object = (T)it.next();
            if(object.disabled()) {
                it.remove();
            }
        }
    }
}
