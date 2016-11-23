package abdi.andreas.wheel.game.states.gamestate.components.logic;


import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.engine.objects.GameObjectCollection;
import abdi.andreas.wheel.game.objects.Torpedo;
import abdi.andreas.wheel.game.objects.wheelCharacter.WheelCharacter;

import static abdi.andreas.wheel.game.objects.ObjectKeys.TORPEDO;
import static abdi.andreas.wheel.game.objects.ObjectKeys.WHEEL;

class CollisionLogicHandler {
    private GameModel gameModel;
    private LogicComponentImpl logicComponent;

    CollisionLogicHandler(GameModel gameModel, LogicComponentImpl logicComponent) {
        this.gameModel = gameModel;
        this.logicComponent = logicComponent;
    }

    void handleCollisionEvents() {
        GameObjectCollection<Torpedo> torpedos = gameModel.get(TORPEDO);

        WheelCharacter wheelCharacter = (WheelCharacter)gameModel.get(WHEEL).get(0);
        boolean torpedoHit = false;
        for(Torpedo torpedo : torpedos) {
            torpedoHit = torpedoHit || wheelCharacter.collidesWith(torpedo);
        }
        if (torpedoHit) {
            torpedos.add(GameObjectFactory.generateTorpedo());
        }
    }
}