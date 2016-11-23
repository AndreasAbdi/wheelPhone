package abdi.andreas.wheel.game.components.controls;


import android.view.MotionEvent;
import android.view.View;

import abdi.andreas.wheel.engine.graphics.GameView;
import abdi.andreas.wheel.engine.logic.components.ControlComponent;
import abdi.andreas.wheel.engine.logic.components.LogicComponent;
import abdi.andreas.wheel.engine.objects.GameModel;

public class ControlComponentImpl implements ControlComponent {

    private final GameModel model;
    private final LogicComponent logicComponent;
    private final GameView gameView;

    public ControlComponentImpl(GameView gameView, GameModel model, LogicComponent logicComponent) {
        this.gameView = gameView;
        this.model = model;
        this.logicComponent = logicComponent;
    }

    @Override
    public void activate() {
        ControlListener listener = new ControlListener(model, logicComponent);
        gameView.setOnTouchListener(listener);
    }

    @Override
    public void deactivate() {
        gameView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
    }
}
