package abdi.andreas.wheel.game.components.logic;


import abdi.andreas.wheel.engine.logic.LogicHandler;
import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.engine.objects.GameObjectCollection;

class UpdateLogicHandler implements LogicHandler {
    private final GameModel gameModel;

    UpdateLogicHandler(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    @Override
    public void run(long deltaTime, long currentTime) {
        if(gameModel.isRunning()) {
            for(GameObjectCollection collection : gameModel.values()) {
                collection.update(deltaTime);
            }
        }
    }
}
