package abdi.andreas.wheel.game.components.controls;


import android.view.MotionEvent;
import android.view.View;

import abdi.andreas.wheel.engine.graphics.GameView;
import abdi.andreas.wheel.engine.logic.ControlComponent;
import abdi.andreas.wheel.engine.objects.GameModel;

public class ControlComponentImpl implements ControlComponent {
    private final GameModel model;
    private final GameView view;

    public ControlComponentImpl(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void activate() {
        ControlListener listener = new ControlListener(model);
        view.setOnTouchListener(listener);
    }

    @Override
    public void deactivate() {
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    @Override
    public void update(long deltaTime, long currentTime) {

    }
}
