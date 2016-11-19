package abdi.andreas.wheel.game.main;

import android.util.DisplayMetrics;

import abdi.andreas.wheel.engine.graphics.GameView;
import abdi.andreas.wheel.engine.logic.GameLoop;
import abdi.andreas.wheel.engine.logic.GraphicsComponent;
import abdi.andreas.wheel.engine.logic.LogicComponent;
import abdi.andreas.wheel.engine.objects.GameModel;

public class GameInstance {
    private GameLoop gameLoop;

    public GameInstance(GameView view) {
        DisplayMetrics metrics = view.getResources().getDisplayMetrics();
        int screenY = metrics.heightPixels;
        int screenX = metrics.widthPixels;
        GameModel model = ModelBuilder.buildModel(screenX, screenY);
        GraphicsComponent graphicsComponent = ComponentBuilder.buildGraphicComponent(view, model);
        LogicComponent logicComponent = ComponentBuilder.buildLogicComponent(model);
        gameLoop = new GameLoop(graphicsComponent, logicComponent);
    }

    public void pause(){
        gameLoop.pause();
    }

    public void resume() {
        gameLoop.resume();
    }
}
