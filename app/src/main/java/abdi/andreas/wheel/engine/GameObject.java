package abdi.andreas.wheel.engine;

import android.graphics.Canvas;
import android.graphics.Paint;

public interface GameObject {
    public void draw(Canvas canvas, Paint paint);
    public void update(long fps);
}
