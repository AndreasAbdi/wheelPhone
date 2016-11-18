package abdi.andreas.wheel.engine.objects;

import java.util.HashMap;

public class GameModel extends HashMap<Integer, GameObjectCollection> {
    private int height;
    private int width;

    public GameModel(int width, int height) {
        super();
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }
}
