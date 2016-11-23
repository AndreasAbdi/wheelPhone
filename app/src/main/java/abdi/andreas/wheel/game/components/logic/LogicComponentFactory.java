package abdi.andreas.wheel.game.components.logic;


import java.util.ArrayList;

import abdi.andreas.wheel.engine.logic.LogicComponent;
import abdi.andreas.wheel.engine.logic.LogicHandler;
import abdi.andreas.wheel.engine.objects.GameModel;

public class LogicComponentFactory {
    private LogicComponentFactory() {}

    public static LogicComponent buildLogicComponent(GameModel gameModel) {
        ArrayList<LogicHandler> logicHandlers = new ArrayList<>();
        logicHandlers.add(new InitializationLogicHandler(gameModel));
        logicHandlers.add(new UpdateLogicHandler(gameModel));
        logicHandlers.add(new TimeLogicHandler(gameModel));
        logicHandlers.add(new CollisionLogicHandler(gameModel));
        logicHandlers.add(new ObjectTerminationLogicHandler(gameModel));
        logicHandlers.add(new TerminationLogicHandler(gameModel));

        return new LogicComponent(gameModel, logicHandlers);
    }

}
