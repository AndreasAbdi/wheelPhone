package abdi.andreas.wheel.engine.objects;

import android.graphics.Canvas;
import android.graphics.Paint;

public interface GameObject {
    public void draw(Canvas canvas, Paint paint);
    public void update(long fps);
    public boolean disabled();
    public boolean collidesWith(GameObject gameObject);
}
