package abdi.andreas.wheel.engine.objects;

import java.util.HashMap;

public class GameModel extends HashMap<Integer, GameObjectCollection> {
    public final int height;
    public final int width;

    public GameModel(int width, int height) {
        super();
        this.height = height;
        this.width = width;
    }

    public <T extends GameObject> void put(T gameObject, int index) {

        GameObjectCollection<T> collection = new GameObjectCollection<T>();
        collection.add(gameObject);
        put(index, collection);
    }

}
