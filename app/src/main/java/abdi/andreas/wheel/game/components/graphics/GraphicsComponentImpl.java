package abdi.andreas.wheel.game.components.graphics;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;

import com.google.common.base.Optional;

import abdi.andreas.wheel.engine.graphics.GameView;
import abdi.andreas.wheel.engine.logic.GraphicsComponent;
import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.engine.objects.GameObjectCollection;

class GraphicsComponentImpl implements GraphicsComponent {
    private final GameView gameView;
    private final GameModel gameModel;

    GraphicsComponentImpl(GameView gameView, GameModel gameModel) {
        this.gameView = gameView;
        this.gameModel = gameModel;
    }

    @Override
    public void update(long deltaTime, long currentTime) {
        Optional<Canvas> canvas = gameView.drawTo();
        if(!canvas.isPresent()) {
            return;
        }
        if(gameModel.isRunning()) {
            canvas.get().drawColor(Color.BLACK);
            Paint paint = new Paint();
            for(GameObjectCollection collection : gameModel.values()) {
                collection.draw(canvas.get(), paint);
            }
            gameView.unlock();
        } else {
            drawStartMenu(canvas.get());
            gameView.unlock();
        }
    }

    private void drawStartMenu(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        String text = "WHEEL" + "\n\n" +
                "TOUCH TO BEGIN";
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(Color.BLUE);
        textPaint.setTextSize(200);
        StaticLayout mTextLayout = new StaticLayout(text, textPaint, canvas.getWidth(), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);

        canvas.save();
        canvas.translate(0, canvas.getHeight()/3);
        mTextLayout.draw(canvas);
        canvas.restore();
    }
}
