package abdi.andreas.wheel.game.components;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.google.common.base.Optional;

import abdi.andreas.wheel.engine.graphics.GameView;
import abdi.andreas.wheel.engine.logic.Component;
import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.engine.objects.GameObjectCollection;

public class GraphicsComponent implements Component {
    private final GameView gameView;
    private final GameModel gameModel;

    public GraphicsComponent(GameView gameView, GameModel gameModel) {
        this.gameView = gameView;
        this.gameModel = gameModel;
    }

    @Override
    public void update(long fps) {
        Optional<Canvas> canvas = gameView.drawTo();
        if(canvas.isPresent()) {
            Paint paint = new Paint();
            for(GameObjectCollection collection : gameModel.values()) {
                collection.draw(canvas.get(), paint);
            }
            gameView.unlock();
        }
    }
}
