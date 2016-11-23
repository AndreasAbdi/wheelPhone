package abdi.andreas.wheel.game.main;

import android.util.DisplayMetrics;

import abdi.andreas.wheel.engine.graphics.GameView;
import abdi.andreas.wheel.engine.logic.GameLoop;
import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.game.components.states.StateFactory;

public class GameInstance {
    private GameLoop gameLoop;

    public GameInstance(GameView view) {
        DisplayMetrics metrics = view.getResources().getDisplayMetrics();
        int screenY = metrics.heightPixels;
        int screenX = metrics.widthPixels;
        GameModel model = ModelFactory.buildModel(screenX, screenY);

        gameLoop = new GameLoop(StateFactory.buildGameState(view, model));
    }

    public void pause(){
        gameLoop.pause();
    }

    public void resume() {
        gameLoop.resume();
    }


}
