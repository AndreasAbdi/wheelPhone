package abdi.andreas.wheel.game.components.logic;

import abdi.andreas.wheel.engine.logic.LogicComponent;
import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.engine.objects.GameObjectCollection;

public class LogicComponentImpl implements LogicComponent {

    private GameModel gameModel;
    private boolean running;
    private boolean initialized;
    private final CollisionLogicHandler collisionLogicHandler;

    public LogicComponentImpl(GameModel gameModel) {
        this.gameModel = gameModel;
        running = true;
        initialized = false;
        this.collisionLogicHandler = new CollisionLogicHandler(gameModel, this);
    }

    @Override
    public void start() {
        running = true;
    }

    @Override
    public void stop(){
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public void update(long deltaTime, long currentTime) {
        if(running) {
            runInitializationSequence();
            runUpdateSequence(deltaTime, currentTime);
            runCollisionHandlingSequence();
            runClearSequence();
        }
    }

    void reset() {
        this.initialized = false;
    };

    private void runClearSequence() {
        for(GameObjectCollection collection : gameModel.values()) {
            collection.clearObjects();
        }
    }

    private void runUpdateSequence(long deltaTime, long currentTime) {
        for(GameObjectCollection collection : gameModel.values()) {
            collection.update(deltaTime);
        }
    }

    private void runInitializationSequence() {
        if(!initialized) {
            GameObjectBuilder.initializeComponents(gameModel);
            initialized = true;
        }
    }


    private void runCollisionHandlingSequence() {
        collisionLogicHandler.handleCollisionEvents();
    }
}
