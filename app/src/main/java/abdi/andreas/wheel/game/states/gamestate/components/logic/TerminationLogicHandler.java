package abdi.andreas.wheel.game.states.gamestate.components.logic;


import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.game.objects.wheelCharacter.WheelCharacter;

import static abdi.andreas.wheel.game.objects.ObjectKeys.WHEEL;

//TODO
class TerminationLogicHandler {
    private GameModel gameModel;
    private LogicComponentImpl logicComponent;

    TerminationLogicHandler(GameModel gameModel, LogicComponentImpl logicComponent) {
        this.gameModel = gameModel;
        this.logicComponent = logicComponent;
    }

    void handleTerminationLogic() {
        WheelCharacter wheelCharacter = (WheelCharacter)gameModel.get(WHEEL).get(0);

        if(wheelCharacter.getLives() == 0) {
            logicComponent.reset();
            logicComponent.stop();
        }

    }
}
