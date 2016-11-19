package abdi.andreas.wheel.game.objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import abdi.andreas.wheel.engine.objects.GameObject;

public class WheelCharacter implements GameObject {

    float x;
    float y;
    float radius;
    float angle;
    private RectF rectangle;

    int score;
    int lives;

    public WheelCharacter(float x, float y, float radius, float angle, int lives) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.angle = angle;
        score = 0;
        this.lives = lives;
        generateRectangle();
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(Color.argb(255, 0, 0, 255));
        canvas.drawOval(rectangle, paint);
        paint.setColor(Color.MAGENTA);
        canvas.drawCircle(x,y,5, paint);
    }

    @Override
    public void update(long fps) {
        generateRectangle();
    }

    public boolean collidesWith(Torpedo torpedo) {
        boolean collisionOccurs = distanceBetweenClosestPoints(torpedo) <= 0;
        if(collisionOccurs) {
            this.lives--;
            torpedo.collisionOccured(this);
        }
        return collisionOccurs;
    }

    @Override
    public boolean collidesWith(GameObject gameObject) {
        return false;
    }

    @Override
    public boolean disabled() {
        return false;
    }

    //all torpedos go to center, otherwise we have do line point distance.
    private double distanceBetweenClosestPoints(Torpedo torpedo) {
        //TODO: shift this class to world coords.
        if(torpedo.screenCoordinates == null) {
            return Double.MAX_VALUE;
        }
        
        Vector2D position = new Vector2D(
                torpedo.screenCoordinates.x(),
                torpedo.screenCoordinates.y()
        );
        Vector2D ourPosition = new Vector2D(x,y);
        double distanceBetweenCenters = position.subtract(ourPosition).getNorm();
        double effectiveCombinedLength = this.radius + torpedo.width/2;
        return distanceBetweenCenters - effectiveCombinedLength;
    }

    private void generateRectangle() {
        float left = x - radius;
        float right = x + radius;
        float top = y - radius;
        float bottom = y + radius;
        rectangle = new RectF(left,top,right,bottom);
    }
}
