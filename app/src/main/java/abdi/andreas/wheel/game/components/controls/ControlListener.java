package abdi.andreas.wheel.game.components.controls;


import android.view.MotionEvent;
import android.view.View;

import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.game.objects.ObjectKeys;
import abdi.andreas.wheel.game.objects.wheelCharacter.WheelCharacter;

class ControlListener implements View.OnTouchListener {
    private final GameModel model;

    public ControlListener(GameModel model) {
        this.model = model;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            handleTouchDown(view, motionEvent);
        } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            handleTouchRelease();
        }
        return true;
    }

    private void handleTouchDown(View view, MotionEvent motionEvent) {
        if(!model.isRunning()) {
            model.start();
        } else {
            if(motionEvent.getX() > view.getWidth()/2) {
                handleRightSideTouch();
            } else {
                handleLeftSideTouch();
            }
        }
    }

    private void handleLeftSideTouch() {
        updateWheelSpeed(-1f);
    }

    private void handleRightSideTouch() {
        updateWheelSpeed(1f);
    }

    private void handleTouchRelease() {
        updateWheelSpeed(0f);
    }

    private void updateWheelSpeed(float speed) {
        WheelCharacter wheel = (WheelCharacter) model.get(ObjectKeys.WHEEL).get(0);
        wheel.updateSpeed(speed);
    }

}
