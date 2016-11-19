package abdi.andreas.wheel.game.components;

import abdi.andreas.wheel.engine.logic.LogicComponent;
import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.engine.objects.GameObjectCollection;
import abdi.andreas.wheel.game.objects.Ball;
import abdi.andreas.wheel.game.objects.MetaInfo;
import abdi.andreas.wheel.game.objects.Torpedo;
import abdi.andreas.wheel.game.objects.WheelCharacter;

public class LogicComponentImpl implements LogicComponent {

    private GameModel gameModel;
    private boolean running;
    private boolean initialized;

    public LogicComponentImpl(GameModel gameModel) {
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
    public void update(long deltaTime, long currentTime) {
        if(running) {
            runInitializationSequence();
            runUpdateSequence(deltaTime, currentTime);
            runCollisionHandlingSequence();
        }
    }

    private void runUpdateSequence(long deltaTime, long currentTime) {
        for(GameObjectCollection collection : gameModel.values()) {
            collection.update(deltaTime);
        }
    }

    private void runInitializationSequence() {
        if(!initialized) {
            gameModel.put(new Ball(gameModel.width/2 + 500, gameModel.height/2, 10, 0), 0);
            gameModel.put(new WheelCharacter(gameModel.width/2, gameModel.height/2, 150, 0), 1);
            gameModel.put(new MetaInfo(100, 100, 0, 1), 2);
            gameModel.put(new Torpedo(gameModel.width/2 - 500, gameModel.height/2, 200, 10, 0, 100),3);
            initialized = true;
        }
    }

    private void runCollisionHandlingSequence() {}





}
