package abdi.andreas.wheel.engine.logic;

import java.util.ArrayList;

import abdi.andreas.wheel.engine.objects.GameModel;

public class LogicComponent implements Component {
    private final ArrayList<LogicHandler> logicHandlers;

    public LogicComponent(GameModel gameModel, ArrayList<LogicHandler> logicHandlers) {
        this.logicHandlers = logicHandlers;
    }

    @Override
    public void update(long deltaTime, long currentTime) {
        for(LogicHandler logicHandler : logicHandlers) {
            logicHandler.run(deltaTime, currentTime);
        }
    }

}
