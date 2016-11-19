package abdi.andreas.wheel.game.objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import abdi.andreas.wheel.engine.objects.GameObject;

public class Torpedo implements GameObject {
    private float x;
    private float y;
    private float length;
    private float width;
    private float angle;

    private RectF rectangle;

    public Torpedo(float x, float y, float width, float length, float angle) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.angle = angle;
        generateRectangle();
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(Color.argb(255, 255, 0, 0));
        canvas.drawRect(rectangle, paint);
    }

    @Override
    public void update(long fps) {
        generateRectangle();
    }

    private void generateRectangle() {
        float left = x - length/2;
        float right = x + length/2;
        float top = y - length/2;
        float bottom = y + length/2;
        rectangle = new RectF(left,top,right,bottom);
    }
}
