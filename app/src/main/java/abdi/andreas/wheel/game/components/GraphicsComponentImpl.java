package abdi.andreas.wheel.game.components;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.google.common.base.Optional;

import abdi.andreas.wheel.engine.graphics.GameView;
import abdi.andreas.wheel.engine.logic.GraphicsComponent;
import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.engine.objects.GameObjectCollection;

public class GraphicsComponentImpl implements GraphicsComponent {
    private final GameView gameView;
    private final GameModel gameModel;

    public GraphicsComponentImpl(GameView gameView, GameModel gameModel) {
        this.gameView = gameView;
        this.gameModel = gameModel;
    }

    @Override
    public void update(long deltaTime, long currentTime) {
        Optional<Canvas> canvas = gameView.drawTo();
        if(canvas.isPresent()) {
            canvas.get().drawColor(Color.BLACK);
            Paint paint = new Paint();
            for(GameObjectCollection collection : gameModel.values()) {
                collection.draw(canvas.get(), paint);
            }
            gameView.unlock();
        }
    }
}
