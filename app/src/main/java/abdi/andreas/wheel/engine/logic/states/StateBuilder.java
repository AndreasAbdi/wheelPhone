package abdi.andreas.wheel.engine.logic.states;


import abdi.andreas.wheel.engine.logic.components.ControlComponent;
import abdi.andreas.wheel.engine.logic.components.GraphicsComponent;
import abdi.andreas.wheel.engine.logic.components.LogicComponent;
import abdi.andreas.wheel.engine.logic.components.StateComponentFactory;

public class StateBuilder {
    private final StateDecisionStrategy stateDecisionStrategy;

    private GraphicsComponent graphicsComponent;
    private LogicComponent logicComponent;
    private ControlComponent controlComponent;

    public StateBuilder(StateDecisionStrategy stateDecisionStrategy) {
        this.stateDecisionStrategy = stateDecisionStrategy;
    }

    public StateBuilder withGraphicsComponent(GraphicsComponent graphicsComponent) {
        this.graphicsComponent = graphicsComponent;
        return this;
    }

    public StateBuilder withLogicComponent(LogicComponent logicComponent) {
        this.logicComponent = logicComponent;
        return this;
    }

    public StateBuilder withControlComponent(ControlComponent controlComponent) {
        this.controlComponent = controlComponent;
        return this;
    }

    public State build() {
        if(shouldBuildGraphicsComponent) {
            graphicsComponent = stateComponentFactory.buildGraphicsComponent();
        }

        if(shouldBuildLogicComponent) {
            logicComponent = stateComponentFactory.buildLogicComponent();
        }

        if(shouldBuildControlComponent) {
            controlComponent = stateComponentFactory.buildControlComponent();
        }

        return new State(graphicsComponent, logicComponent, controlComponent, stateDecisionStrategy);
    }
}
