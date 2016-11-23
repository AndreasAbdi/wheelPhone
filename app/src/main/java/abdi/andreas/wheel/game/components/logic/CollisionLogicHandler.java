package abdi.andreas.wheel.game.components.logic;


import abdi.andreas.wheel.engine.logic.LogicHandler;
import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.engine.objects.GameObjectCollection;
import abdi.andreas.wheel.game.objects.Torpedo;
import abdi.andreas.wheel.game.objects.wheelCharacter.WheelCharacter;

import static abdi.andreas.wheel.game.objects.ObjectKeys.TORPEDO;
import static abdi.andreas.wheel.game.objects.ObjectKeys.WHEEL;

class CollisionLogicHandler implements LogicHandler{
    private GameModel gameModel;

    CollisionLogicHandler(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    @Override
    public void run(long deltaTime, long currentTime) {
        if(gameModel.isRunning()) {
            GameObjectCollection<Torpedo> torpedos = gameModel.get(TORPEDO);

            WheelCharacter wheelCharacter = (WheelCharacter)gameModel.get(WHEEL).get(0);
            boolean torpedoHit = false;
            for(Torpedo torpedo : torpedos) {
                torpedoHit = torpedoHit || wheelCharacter.collidesWith(torpedo);
            }
        }
    }
}
