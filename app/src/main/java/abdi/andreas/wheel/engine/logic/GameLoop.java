package abdi.andreas.wheel.engine.logic;

import android.util.Log;

public class GameLoop implements Runnable {

    private Thread gameThread;
    private volatile boolean running = false;

    private final GraphicsComponent graphicsComponent;
    private final LogicComponent logicComponent;

    long deltaTime = 10;
    long simulationTime = 0;
    long accumulator = 0;
    long currentTime = System.currentTimeMillis();

    public GameLoop(GraphicsComponent graphicsComponent, LogicComponent logicComponent) {
        this.graphicsComponent = graphicsComponent;
        this.logicComponent = logicComponent;
    }

    public void pause(){
        running = false;
        try {
            gameThread.join();
        } catch(InterruptedException e) {
            Log.e("Error:", "Interrupted joining the game thread");
        }
    }

    public void resume() {
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while(running) {
            updateCurrentTimeAndAccumulator();
            runSimulationSteps();
            handleTemporalAlias();
            drawToScreen();
        }
    }

    private void updateCurrentTimeAndAccumulator() {
        long newTime = System.currentTimeMillis();
        long frameTime = newTime - currentTime;
        //TODO: update this with some numerical interval numerical analysis.
        if(frameTime > 250) {
            frameTime = 250;
        }
        currentTime = newTime;

        accumulator += frameTime;
    }

    private void runSimulationSteps() {
        while(accumulator >= deltaTime) {
            logicComponent.update(deltaTime, simulationTime);
            accumulator -= deltaTime;
            simulationTime += deltaTime;
        }

    }

    private void drawToScreen() {
        graphicsComponent.update(deltaTime, simulationTime);
    }

    //TODO: switch to states to handle temporal alias.
    //TODO: this probably needs
    private void handleTemporalAlias() {

    }
}
