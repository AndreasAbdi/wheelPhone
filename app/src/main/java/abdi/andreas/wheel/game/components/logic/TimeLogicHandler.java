package abdi.andreas.wheel.game.components.logic;


import abdi.andreas.wheel.engine.objects.GameModel;


class TimeLogicHandler {
    private GameModel gameModel;
    private LogicComponentImpl logicComponent;

    private long initialTime;
    private long currentTime;
    private long elapsedTime;

    TimeLogicHandler(GameModel gameModel, LogicComponentImpl logicComponent) {
        this.gameModel = gameModel;
        this.logicComponent = logicComponent;
    }

    void runTimeSequence() {
        //TODO:
    }
}
