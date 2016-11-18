package abdi.andreas.wheel.game.components;

import android.graphics.Canvas;
import android.graphics.Paint;

import abdi.andreas.wheel.engine.graphics.GameView;
import abdi.andreas.wheel.engine.logic.Component;
import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.engine.objects.GameObjectCollection;

public class GraphicsComponent implements Component {
    private final GameView gameView;
    private final GameModel model;

    public GraphicsComponent(GameView gameView, GameModel model) {
        this.gameView = gameView;
        this.model = model;
    }

    public void update() {
        Canvas canvas = gameView.drawTo();
        Paint paint = new Paint();
        for(GameObjectCollection collection : model) {
            collection.draw(canvas, paint);
        }
        gameView.unlock();
    }
}
