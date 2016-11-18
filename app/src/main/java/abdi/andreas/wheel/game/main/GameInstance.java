package abdi.andreas.wheel.game.main;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.util.ArrayList;

import abdi.andreas.wheel.engine.graphics.GameView;
import abdi.andreas.wheel.engine.logic.Component;
import abdi.andreas.wheel.engine.logic.GameLoop;
import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.engine.objects.GameObjectCollection;
import abdi.andreas.wheel.game.components.GraphicsComponent;
import abdi.andreas.wheel.game.components.LogicComponent;
import abdi.andreas.wheel.game.objects.Ball;

public class GameInstance {
    private GameLoop gameLoop;
    private GameView view;

    private GameModel model;
    private ArrayList<Component> components;

    private int screenX;
    private int screenY;

    public GameInstance(GameView view) {
        this.view = view;
        model = new GameModel();

        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        screenY = metrics.heightPixels;
        screenX = metrics.widthPixels;

        setupModel();
        setupComponents();
        gameLoop = new GameLoop(components);
    }

    public void pause(){
        gameLoop.pause();
    }

    public void resume() {
        gameLoop.resume();
    }

    //TODO: set this up.
    private void setupModel() {
        Ball ball = new Ball(screenX/2, screenY/2, 10, 0);
        GameObjectCollection<Ball> balls = new GameObjectCollection<>();

        balls.add(ball);
        model.put(0, balls);

    }

    //TODO: set this up.
    private void setupComponents() {
        GraphicsComponent graphicsComponent = new GraphicsComponent(view, model);
        LogicComponent logicComponent = new LogicComponent(model);

        components = new ArrayList<>();
        components.add(graphicsComponent);
        components.add(logicComponent);

    }

}
