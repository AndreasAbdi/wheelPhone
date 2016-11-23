package abdi.andreas.wheel.game.components.logic;


import abdi.andreas.wheel.engine.logic.LogicHandler;
import abdi.andreas.wheel.engine.objects.GameModel;

class InitializationLogicHandler implements LogicHandler {
    private final GameModel gameModel;

    InitializationLogicHandler(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    @Override
    public void run(long deltaTime, long currentTime) {
        if(gameModel.isRunning() && !gameModel.isInitialized()) {
            GameObjectFactory.initializeComponents(gameModel);
            gameModel.initialize();
        }
    }
}
