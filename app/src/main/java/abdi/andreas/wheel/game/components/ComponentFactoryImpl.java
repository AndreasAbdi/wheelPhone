package abdi.andreas.wheel.game.components;

import abdi.andreas.wheel.engine.graphics.GameView;
import abdi.andreas.wheel.engine.logic.components.ControlComponent;
import abdi.andreas.wheel.engine.logic.components.GraphicsComponent;
import abdi.andreas.wheel.engine.logic.components.LogicComponent;
import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.game.components.controls.ControlComponentImpl;
import abdi.andreas.wheel.game.components.graphics.GraphicsComponentImpl;
import abdi.andreas.wheel.game.components.logic.LogicComponentImpl;
import abdi.andreas.wheel.engine.logic.components.ComponentFactory;

public class ComponentFactoryImpl implements ComponentFactory {

    private GameModel gameModel;
    private GameView gameView;
    private LogicComponent logicComponent;

    public ComponentFactoryImpl(GameView gameView, GameModel gameModel){
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
