package abdi.andreas.wheel.game.components;

import abdi.andreas.wheel.engine.logic.Component;
import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.engine.objects.GameObjectCollection;
import abdi.andreas.wheel.game.objects.Ball;
import abdi.andreas.wheel.game.objects.MetaInfo;
import abdi.andreas.wheel.game.objects.Torpedo;
import abdi.andreas.wheel.game.objects.WheelCharacter;

public class LogicComponent implements Component {

    private GameModel gameModel;
    private boolean running;
    private boolean initialized;

    public LogicComponent(GameModel gameModel) {
        this.gameModel = gameModel;
        running = true;
        initialized = false;
    }

    public void start() {
        running = true;
    }

    public void stop(){
        running = false;
    }

    @Override
    public void update(long fps) {
        if(running) {
            runInitializationSequence();
            runUpdateSequence(fps);
            runCollisionHandlingSequence();
        }
    }

    private void runUpdateSequence(long fps) {
        for(GameObjectCollection collection : gameModel.values()) {
            collection.update(fps);
        }
    }

    private void runInitializationSequence() {
        if(!initialized) {
            gameModel.put(new Ball(gameModel.width/2 + 500, gameModel.height/2, 10, 0), 0);
            gameModel.put(new WheelCharacter(gameModel.width/2, gameModel.height/2, 100, 0), 1);
            gameModel.put(new MetaInfo(100, 100, 0, 1), 2);
            gameModel.put(new Torpedo(gameModel.width/2 - 500, gameModel.height/2, 10, 10, 0),3);
            initialized = true;
        }
    }

    private void runCollisionHandlingSequence() {}





}
