package abdi.andreas.wheel.engine.logic.states;


import abdi.andreas.wheel.engine.logic.components.ControlComponent;
import abdi.andreas.wheel.engine.logic.components.GraphicsComponent;
import abdi.andreas.wheel.engine.logic.components.LogicComponent;

public class State {
    private final GraphicsComponent graphicsComponent;
    private final LogicComponent logicComponent;
    private final StateDecisionStrategy nextStateStrategy;

    private ControlComponent controlComponent;

    State(GraphicsComponent graphicsComponent,
          LogicComponent logicComponent,
          ControlComponent controlComponent,
          StateDecisionStrategy stateDecisionStrategy) {
        this.graphicsComponent = graphicsComponent;
        this.logicComponent = logicComponent;
        this.controlComponent = controlComponent;
        this.nextStateStrategy = stateDecisionStrategy;
    }

    public State update(long deltaTime, long currentTime) {
        this.logicComponent.update(deltaTime, currentTime);
        if(this.nextStateStrategy.shouldGetNextState()) {
            return nextStateStrategy.getNextState();
        } else {
            return this;
        }
    }

    public void render(long deltaTime, long currentTime) {
        this.graphicsComponent.update(deltaTime, currentTime);
    }

    public void activate() {
        this.controlComponent.activate();
    }

    public void deactivate() {
        this.controlComponent.deactivate();
    }


}
