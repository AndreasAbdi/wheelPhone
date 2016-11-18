package abdi.andreas.wheel.game.main;

import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.engine.objects.GameObject;
import abdi.andreas.wheel.engine.objects.GameObjectCollection;
import abdi.andreas.wheel.game.objects.Ball;

public class ModelBuilder {

    private ModelBuilder() {}

    public static GameModel buildModel(int width, int height) {
        GameModel model = new GameModel(width, height);

        Build ball = (int a, int b) -> {
          return new Ball(width/2, height/2, 50, 0);
        };

        BuildAndConnect buildAndConnecter = delegate(width, height, model);
        buildAndConnecter.connect(ball, 0);

        return model;
    }

    private static BuildAndConnect delegate(int width, int height, GameModel model) {
        RunBuild runner = (int w, int h) -> {
            return (Build builder) -> {
                return builder.build(w,h);
            };
        };

        BuildFold fold = runner.runBuild(width, height);

        WrapToCollection wrapToCollection = (obj) -> {
            GameObjectCollection collection = new GameObjectCollection<>();
            collection.add(obj);
            return collection;
        };

        return (Build b, int c) -> {
            model.put(c, wrapToCollection.wrap(fold.runBuild(b)));
            return model;
        };
    };

    private interface Build<T extends GameObject> {
        T build(int width, int height);
    }

    private interface BuildFold<T extends GameObject> {
        T runBuild(Build build);
    }

    private interface RunBuild<T extends GameObject> {
        BuildFold runBuild(int width, int height);
    }

    private interface WrapToCollection<T extends GameObject> {
        GameObjectCollection<T> wrap(T object);
    }

    private interface BuildAndConnect {
        GameModel connect( Build build, int index);
    }

}
