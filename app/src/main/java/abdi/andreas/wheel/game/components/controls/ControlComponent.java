package abdi.andreas.wheel.game.components.controls;


import android.view.View;

import abdi.andreas.wheel.engine.logic.LogicComponent;
import abdi.andreas.wheel.engine.objects.GameModel;

public class ControlComponent {
    private final GameModel model;
    private final LogicComponent logicComponent;
    public ControlComponent(GameModel model, LogicComponent logicComponent) {

        this.model = model;
        this.logicComponent = logicComponent;
    }


    public void attachControlsToView(View view) {

        ControlListener listener = new ControlListener(model, logicComponent);
        view.setOnTouchListener(listener);
    }
}
