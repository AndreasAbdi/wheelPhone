package abdi.andreas.wheel.engine.objects;

import java.util.HashMap;

public class GameModel extends HashMap<Integer, GameObjectCollection> {
    public final int height;
    public final int width;
    private boolean running;
    private boolean initialized;

    public GameModel(int width, int height) {
        super();
        this.height = height;
        this.width = width;
        this.initialized = false;
        this.running = false;
    }

    public <T extends GameObject> void put(T gameObject, int index) {

        GameObjectCollection<T> collection = new GameObjectCollection<T>();
        collection.add(gameObject);
        put(index, collection);
    }

    public void start() {
        running = true;
    }

    public void stop(){
        running = false;
    }

    public void initialize() {
        this.initialized = true;
    }

    public void terminate() {
        this.initialized = false;
    }

    public boolean isInitialized() {
        return initialized;
    }

    public boolean isRunning() {
        return running;
    }
}
