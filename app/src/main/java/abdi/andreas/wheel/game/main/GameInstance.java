package abdi.andreas.wheel.game.main;

import android.util.DisplayMetrics;

import java.util.ArrayList;

import abdi.andreas.wheel.engine.graphics.GameView;
import abdi.andreas.wheel.engine.logic.Component;
import abdi.andreas.wheel.engine.logic.GameLoop;
import abdi.andreas.wheel.engine.objects.GameModel;

public class GameInstance {
    private GameLoop gameLoop;

    public GameInstance(GameView view) {
        DisplayMetrics metrics = view.getResources().getDisplayMetrics();
        int screenY = metrics.heightPixels;
        int screenX = metrics.widthPixels;
        GameModel model = ModelBuilder.buildModel(screenX, screenY);
        ArrayList<Component> components = ComponentBuilder.buildComponents(view, model);
        gameLoop = new GameLoop(components);
    }

    public void pause(){
        gameLoop.pause();
    }

    public void resume() {
        gameLoop.resume();
    }
}
