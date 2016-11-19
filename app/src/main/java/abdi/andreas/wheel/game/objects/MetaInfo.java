package abdi.andreas.wheel.game.objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;

import abdi.andreas.wheel.engine.objects.GameObject;

public class MetaInfo implements GameObject {

    float x;
    float y;

    int score;
    int lives;

    public MetaInfo(float x, float y, int score, int lives) {
        this.x = x;
        this.y = y;
        this.score = score;
        this.lives = lives;
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        String text = "Score: " + score + "\n" +
                "Lives: " + lives;
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
    public void update(long fps) {

    }
}
