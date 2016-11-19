package abdi.andreas.wheel.game.main;

import abdi.andreas.wheel.engine.objects.GameModel;

public class ModelBuilder {

    private ModelBuilder() {}

    public static GameModel buildModel(int width, int height) {
        return new GameModel(width, height);
    }


}
