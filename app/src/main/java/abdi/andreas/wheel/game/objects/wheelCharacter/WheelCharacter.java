package abdi.andreas.wheel.game.objects.wheelCharacter;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import abdi.andreas.wheel.engine.maths.Vector;
import abdi.andreas.wheel.engine.objects.GameObject;
import abdi.andreas.wheel.game.objects.Torpedo;

public class WheelCharacter implements GameObject {
    Vector center;
    float sweepAngle;
    float startAngle;
    float radius;
    float speedInClockwise;

    int score;
    int lives;

    private RectF rectangle;
    private final WheelCharacterCollisionHandler collisionHandler;

    public WheelCharacter(Vector center, float radius, float startAngle, float sweepAngle, float speedInClockwise, int lives) {
        this.center = center;
        this.radius = radius;
        this.startAngle = startAngle;
        this.sweepAngle = sweepAngle;
        this.speedInClockwise = speedInClockwise;

        score = 0;
        this.lives = lives;
        this.collisionHandler = new WheelCharacterCollisionHandler(this);
        generateRectangle();
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        generateRectangle();
        paint.setColor(Color.argb(255, 0, 0, 255));
        canvas.drawOval(rectangle, paint);
        paint.setColor(Color.MAGENTA);
        canvas.drawArc(rectangle,startAngle, sweepAngle, true, paint);
    }

    @Override
    public void update(long fps) {
        this.rotate(speedInClockwise);
    }

    public boolean collidesWith(Torpedo torpedo) {
        return collisionHandler.collidesWith(torpedo);
    }

    public float getSpeed() {
        return this.speedInClockwise;
    }

    public float getScore() { return this.score;}

    public float getLives() { return this.lives;}

    public void updateSpeed(float speedInClockWise) {
        this.speedInClockwise = speedInClockWise;
    }

    public void rotate(float angleInDegreesClockWise) {
        float newAngle = (this.startAngle +  angleInDegreesClockWise) % 360;
        startAngle = newAngle >= 0 ? newAngle : 360 - Math.abs(newAngle);
    }

    @Override
    public boolean collidesWith(GameObject gameObject) {
        return collisionHandler.collidesWith(gameObject);
    }

    @Override
    public boolean disabled() {
        //unimplemented.
        return false;
    }

    private void generateRectangle() {
        float left = center.x() - radius;
        float right = center.x() + radius;
        float top = center.y() - radius;
        float bottom = center.y() + radius;
        rectangle = new RectF(left,top,right,bottom);
    }
}
