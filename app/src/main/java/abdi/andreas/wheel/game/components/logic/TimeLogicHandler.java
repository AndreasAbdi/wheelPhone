package abdi.andreas.wheel.game.components.logic;


import abdi.andreas.wheel.engine.logic.LogicHandler;
import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.engine.objects.GameObjectCollection;
import abdi.andreas.wheel.game.objects.Torpedo;
import abdi.andreas.wheel.game.objects.wheelCharacter.WheelCharacter;

import static abdi.andreas.wheel.game.objects.ObjectKeys.TORPEDO;
import static abdi.andreas.wheel.game.objects.ObjectKeys.WHEEL;

class TimeLogicHandler implements LogicHandler{
    private GameModel gameModel;
    private long initialTime;
    private long timePassed = 0;
    private long torpedoSpawnInterval;

    TimeLogicHandler(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    @Override
    public void run(long deltaTime, long currentTime) {
        if(initialTime == 0) {
            initialTime = currentTime;
        }

        if(gameModel.isRunning()) {
            updateTorpedoSpawnInterval();
            if(timePassed > torpedoSpawnInterval) {
                GameObjectCollection<Torpedo> torpedos = gameModel.get(TORPEDO);
                torpedos.add(GameObjectFactory.generateTorpedo());
                timePassed = 0;
            }
            timePassed += deltaTime;
        }

    }

    private void updateTorpedoSpawnInterval() {
        WheelCharacter wheelCharacter = (WheelCharacter)gameModel.get(WHEEL).get(0);
        torpedoSpawnInterval =(int) (5000 * (1 - (float)wheelCharacter.getScore()/1000));
    }
}
