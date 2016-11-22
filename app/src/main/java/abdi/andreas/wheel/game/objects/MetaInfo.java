package abdi.andreas.wheel.game.objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;

import abdi.andreas.wheel.engine.objects.GameObject;
import abdi.andreas.wheel.game.objects.wheelCharacter.WheelCharacter;

public class MetaInfo implements GameObject {

    float x;
    float y;
    WheelCharacter wheelCharacter;

    public MetaInfo(float x, float y, WheelCharacter wheelCharacter) {
        this.x = x;
        this.y = y;
        this.wheelCharacter = wheelCharacter;
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        String text = "Score: " + wheelCharacter.getScore() + "\n" +
                "Lives: " + wheelCharacter.getLives();
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(Color.BLUE);
        textPaint.setTextSize(50);
        StaticLayout mTextLayout = new StaticLayout(text, textPaint, canvas.getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);

        canvas.save();
        canvas.translate(x, y);
        mTextLayout.draw(canvas);
        canvas.restore();
    }

    @Override
    public boolean collidesWith(GameObject gameObject) {
        return false;
    }

    @Override
    public void update(long fps) {

    }

    @Override
    public boolean disabled() {
        return false;
    }
}
