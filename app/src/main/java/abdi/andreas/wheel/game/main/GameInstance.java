package abdi.andreas.wheel.game.main;

import abdi.andreas.wheel.engine.graphics.GameView;
import abdi.andreas.wheel.engine.logic.GameLoop;
import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.game.components.GraphicsComponent;
import abdi.andreas.wheel.game.components.LogicComponent;

public class GameInstance {
    GameLoop gameLoop;
    GameView view;

    public GameInstance(GameView view) {
        this.view = view;
        GameModel model = new GameModel();
        LogicComponent logicComponent = new LogicComponent(model);
        GraphicsComponent graphicsComponent = new GraphicsComponent(view, model);
    }

    public void pause(){
        gameLoop.resume();
    }

    public void resume() {
        gameLoop.pause();
    }
}
