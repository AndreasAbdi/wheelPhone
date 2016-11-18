package abdi.andreas.wheel.engine.logic;

import android.util.Log;

import java.util.ArrayList;

public class GameLoop implements Runnable {

    private Thread gameThread;
    private volatile boolean running = false;
    private long fps;
    private long timeElapsedInFrame;

    private final ArrayList<Component> components;

    public GameLoop(ArrayList<Component> components) {
        this.components = components;
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
            long startTime = System.currentTimeMillis();

            for(Component component : components) {
                component.update(fps);
            }

            timeElapsedInFrame = System.currentTimeMillis() - startTime;
            if(timeElapsedInFrame >=1) {
                fps = 1000/ timeElapsedInFrame;
            }

        }
    }
}
