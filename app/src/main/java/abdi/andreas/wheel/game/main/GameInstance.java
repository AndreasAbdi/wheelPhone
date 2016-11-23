package abdi.andreas.wheel.game.main;

import android.util.DisplayMetrics;

import abdi.andreas.wheel.engine.graphics.GameView;
import abdi.andreas.wheel.engine.logic.GameLoop;
import abdi.andreas.wheel.engine.logic.GraphicsComponent;
import abdi.andreas.wheel.engine.logic.LogicComponent;
import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.game.components.controls.ControlComponentImpl;
import abdi.andreas.wheel.game.components.graphics.GraphicsComponentFactory;
import abdi.andreas.wheel.game.components.logic.LogicComponentFactory;

public class GameInstance {
    private GameLoop gameLoop;

    public GameInstance(GameView view) {
        DisplayMetrics metrics = view.getResources().getDisplayMetrics();
        int screenY = metrics.heightPixels;
        int screenX = metrics.widthPixels;
        GameModel model = ModelFactory.buildModel(screenX, screenY);
        GraphicsComponent graphicsComponent = GraphicsComponentFactory.buildGraphicsComponent(view, model);
        LogicComponent logicComponent = LogicComponentFactory.buildLogicComponent(model);
        ControlComponentImpl controlComponent = new ControlComponentImpl(model, view);
        controlComponent.activate();

        gameLoop = new GameLoop(graphicsComponent, logicComponent);
    }

    public void pause(){
        gameLoop.pause();
    }

    public void resume() {
        gameLoop.resume();
    }
}
