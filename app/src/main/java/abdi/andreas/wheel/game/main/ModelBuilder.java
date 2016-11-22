package abdi.andreas.wheel.game.main;

import abdi.andreas.wheel.engine.objects.GameModel;

class ModelBuilder {

    private ModelBuilder() {}

    static GameModel buildModel(int width, int height) {
        return new GameModel(width, height);
    }


}
