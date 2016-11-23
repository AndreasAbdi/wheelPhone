package abdi.andreas.wheel.game.states.gamestate.components;

import abdi.andreas.wheel.engine.graphics.GameView;
import abdi.andreas.wheel.engine.logic.components.ControlComponent;
import abdi.andreas.wheel.engine.logic.components.GraphicsComponent;
import abdi.andreas.wheel.engine.logic.components.LogicComponent;
import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.game.states.gamestate.components.controls.ControlComponentImpl;
import abdi.andreas.wheel.game.states.gamestate.components.graphics.GraphicsComponentImpl;
import abdi.andreas.wheel.game.states.gamestate.components.logic.LogicComponentImpl;
import abdi.andreas.wheel.engine.logic.components.StateComponentFactory;

public class GameStateStateComponentFactoryImpl implements StateComponentFactory {

    private GameModel gameModel;
    private GameView gameView;
    private LogicComponent logicComponent;

    public GameStateStateComponentFactoryImpl(GameView gameView, GameModel gameModel){
        this.gameView = gameView;
        this.gameModel = gameModel;
    }

    @Override
    public GraphicsComponent buildGraphicsComponent() {
        return new GraphicsComponentImpl(gameView, gameModel);
    }

    @Override
    public LogicComponent buildLogicComponent() {
        this.logicComponent = new LogicComponentImpl(gameModel);
        return this.logicComponent;
    }

    @Override
    public ControlComponent buildControlComponent() {
        if(logicComponent == null) {
            return new ControlComponent() {
                @Override
                public void activate() {}
                @Override
                public void deactivate() {}
            };
        } else {
            return new ControlComponentImpl(gameView, gameModel, logicComponent);
        }
    }
}
