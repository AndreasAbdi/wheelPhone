package abdi.andreas.wheel.game.objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import abdi.andreas.wheel.engine.maths.Vector;
import abdi.andreas.wheel.engine.objects.GameObject;
import abdi.andreas.wheel.game.objects.wheelCharacter.WheelCharacter;

import static abdi.andreas.wheel.engine.maths.WorldToScreenConverter.convertToScreenCoordinates;
import static abdi.andreas.wheel.engine.maths.WorldToScreenConverter.getClockwiseAngleInScreenCoordinates;


public class Torpedo implements GameObject {
    Vector screenCoordinates;
    float angleInDegreesClockwise;

    float worldX;
    float worldY;
    Float worldAngle;

    float height;
    float width;

    float speedX;
    float speedY;
    private RectF rectangle;
    boolean disabled;

    public Torpedo(float worldX, float worldY, float width, float height, float worldAngle, float speedX,float speedY) {
        //TODO: change this to position class.
        this.worldX = worldX;
        this.worldY = worldY;
        this.worldAngle = worldAngle;

        this.height = height;
        this.width = width;
        //TODO: change this to vector class.
        this.speedX = speedX;
        this.speedY = speedY;

        generateRectangle();
        disabled = false;
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        Vector worldCoords = new Vector(worldX,worldY);
        Vector screenSize = new Vector(canvas.getWidth(), canvas.getHeight());
        screenCoordinates = convertToScreenCoordinates(worldCoords, screenSize);
        angleInDegreesClockwise = getClockwiseAngleInScreenCoordinates(worldCoords, screenSize);

        canvas.save();
        canvas.translate(screenCoordinates.x(), screenCoordinates.y());
        canvas.rotate(angleInDegreesClockwise);
        paint.setColor(Color.argb(255, 255, 0, 0));
        generateRectangle();
        canvas.drawRect(rectangle, paint);
        paint.setColor(Color.CYAN);
        canvas.drawRect(new RectF(-width/2, height/2, -width/2+10, -height/2), paint);
        canvas.restore();
    }

    @Override
    public void update(long deltaTime) {
        this.worldX += deltaTime/1000.0 * speedX;
        this.worldY += deltaTime/1000.0 * speedY;
    }

    public void collisionOccured(WheelCharacter wheelCharacter) {
        this.disabled = true;
    }

    @Override
    public boolean collidesWith(GameObject gameObject) {
        return false;
    }

    @Override
    public boolean disabled() {
        return disabled;
    }

    public Vector getScreenCoordinates() {
        return this.screenCoordinates;
    }

    public float getWidth() {
        return this.width;
    }

    public float getAngleInDegreesClockwise() {
        return this.angleInDegreesClockwise;
    }
    private void generateRectangle() {
        float left = -width/2;
        float right = width/2;
        float top = -height/2;
        float bottom = height/2;
        rectangle = new RectF(left,top,right,bottom);
    }
}
