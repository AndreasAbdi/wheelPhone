package abdi.andreas.wheel.game.states.gamestate.components.logic;

import abdi.andreas.wheel.engine.logic.components.LogicComponent;
import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.engine.objects.GameObjectCollection;

public class LogicComponentImpl implements LogicComponent {

    private GameModel gameModel;
    private boolean running;
    private boolean initialized;
    private final CollisionLogicHandler collisionLogicHandler;
    private final TerminationLogicHandler terminationLogicHandler;

    public LogicComponentImpl(GameModel gameModel) {
        this.gameModel = gameModel;
        running = true;
        initialized = false;
        this.collisionLogicHandler = new CollisionLogicHandler(gameModel, this);
        this.terminationLogicHandler = new TerminationLogicHandler(gameModel, this);
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
            runTimedLogicSequence(deltaTime, currentTime);
            runCollisionHandlingSequence();
            runClearSequence();
            runTerminationSequence();
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
            GameObjectFactory.initializeComponents(gameModel);
            initialized = true;
        }
    }

    private void runTimedLogicSequence(long deltaTime, long currentTime) {
        collisionLogicHandler.handleCollisionEvents();
    }

    private void runCollisionHandlingSequence() {
        collisionLogicHandler.handleCollisionEvents();
    }

    private void runTerminationSequence() {
        terminationLogicHandler.handleTerminationLogic();
    }

}
