package abdi.andreas.wheel.game.components.logic;


import abdi.andreas.wheel.engine.logic.LogicHandler;
import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.game.objects.wheelCharacter.WheelCharacter;

import static abdi.andreas.wheel.game.objects.ObjectKeys.WHEEL;

class TerminationLogicHandler implements LogicHandler {
    private GameModel gameModel;

    TerminationLogicHandler(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    @Override
    public void run(long deltaTime, long currentTime) {
        if(gameModel.isRunning()) {
            WheelCharacter wheelCharacter = (WheelCharacter)gameModel.get(WHEEL).get(0);
            if(wheelCharacter.getLives() == 0) {
                gameModel.stop();
                gameModel.terminate();
            }
        }

    }
}
