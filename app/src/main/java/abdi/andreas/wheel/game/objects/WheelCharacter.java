package abdi.andreas.wheel.game.objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import abdi.andreas.wheel.engine.objects.GameObject;

public class WheelCharacter implements GameObject {
    private float x;
    private float y;
    private float radius;
    private float angle;
    private RectF rectangle;

    public WheelCharacter(float x, float y, float radius, float angle) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.angle = angle;
        generateRectangle();
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(Color.argb(255, 0, 0, 255));
        canvas.drawOval(rectangle, paint);
    }

    @Override
    public void update(long fps) {
        generateRectangle();
    }

    private void generateRectangle() {
        float left = x - radius;
        float right = x + radius;
        float top = y - radius;
        float bottom = y + radius;
        rectangle = new RectF(left,top,right,bottom);
    }
}
