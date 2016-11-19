package abdi.andreas.wheel.game.main;

import abdi.andreas.wheel.engine.graphics.GameView;
import abdi.andreas.wheel.engine.logic.GraphicsComponent;
import abdi.andreas.wheel.engine.logic.LogicComponent;
import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.game.components.GraphicsComponentImpl;
import abdi.andreas.wheel.game.components.LogicComponentImpl;

public class ComponentBuilder {

    private ComponentBuilder(){}

    public static LogicComponent buildLogicComponent(GameModel gameModel) {
        return new LogicComponentImpl(gameModel);
    }

    public static GraphicsComponent buildGraphicComponent(GameView gameView, GameModel gameModel) {
        return new GraphicsComponentImpl(gameView, gameModel);

    }

}
