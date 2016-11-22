package abdi.andreas.wheel.game.components.logic;


import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.engine.objects.GameObjectCollection;
import abdi.andreas.wheel.game.objects.Torpedo;
import abdi.andreas.wheel.game.objects.wheelCharacter.WheelCharacter;

import static abdi.andreas.wheel.game.objects.ObjectKeys.TORPEDO;
import static abdi.andreas.wheel.game.objects.ObjectKeys.WHEEL;

class CollisionLogicHandler {
    private GameModel gameModel;
    private LogicComponentImpl logicComponent;

    public CollisionLogicHandler(GameModel gameModel, LogicComponentImpl logicComponent) {
        this.gameModel = gameModel;
        this.logicComponent = logicComponent;
    }

    public void handleCollisionEvents() {
        GameObjectCollection<Torpedo> torpedos = gameModel.get(TORPEDO);

        WheelCharacter wheelCharacter = (WheelCharacter)gameModel.get(WHEEL).get(0);
        boolean torpedoHit = false;
        for(Torpedo torpedo : torpedos) {
            torpedoHit = torpedoHit || wheelCharacter.collidesWith(torpedo);
        }
        if (torpedoHit) {
            torpedos.add(GameObjectBuilder.generateTorpedo());
        }

        //TODO: pull this out to separate class.
        if(wheelCharacter.getLives() == 0) {
            logicComponent.reset();
            logicComponent.stop();
        }

    }
}
