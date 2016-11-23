package abdi.andreas.wheel.game.main;

import abdi.andreas.wheel.engine.objects.GameModel;

class ModelFactory {

    private ModelFactory() {}

    static GameModel buildModel(int width, int height) {
        return new GameModel(width, height);
    }


}
