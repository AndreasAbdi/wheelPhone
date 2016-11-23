package abdi.andreas.wheel.game.components.graphics;


import abdi.andreas.wheel.engine.graphics.GameView;
import abdi.andreas.wheel.engine.logic.GraphicsComponent;
import abdi.andreas.wheel.engine.objects.GameModel;

public class GraphicsComponentFactory {
    private GraphicsComponentFactory() {}

    public static GraphicsComponent buildGraphicsComponent(GameView gameView, GameModel gameModel) {
        return new GraphicsComponentImpl(gameView, gameModel);
    }
}
