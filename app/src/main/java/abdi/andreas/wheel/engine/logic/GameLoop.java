package abdi.andreas.wheel.engine.logic;

import android.util.Log;

import java.util.ArrayList;

public class GameLoop implements Runnable {

    private Thread gameThread = null;
    private volatile boolean running = false;

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
            for(Component component : components) {
                component.update();
            }
        }
    }
}
