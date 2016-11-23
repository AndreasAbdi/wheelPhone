package abdi.andreas.wheel.game.components.states.gamestate;


import abdi.andreas.wheel.engine.logic.components.ControlComponent;
import abdi.andreas.wheel.engine.logic.components.GraphicsComponent;
import abdi.andreas.wheel.engine.logic.components.LogicComponent;
import abdi.andreas.wheel.engine.logic.components.ComponentFactory;

public class GameStateBuilder {
    private final ComponentFactory componentFactory;

    private boolean shouldBuildGraphicsComponent = false;
    private boolean shouldBuildControlComponent = false;
    private boolean shouldBuildLogicComponent = false;

    private GraphicsComponent graphicsComponent;
    private LogicComponent logicComponent;
    private ControlComponent controlComponent;

    public GameStateBuilder(ComponentFactory componentFactory) {
        this.componentFactory = componentFactory;
    }

    public GameStateBuilder withGraphicsComponent() {
        this.shouldBuildGraphicsComponent = true;
        return this;
    }

    public GameStateBuilder withLogicComponent() {
        this.shouldBuildLogicComponent = true;
        return this;
    }

    public GameStateBuilder withControlComponent() {
        this.shouldBuildLogicComponent = true;
        return this;
    }

    public GameState build() {
        if(shouldBuildGraphicsComponent) {
            graphicsComponent = componentFactory.buildGraphicsComponent();
        }

        if(shouldBuildLogicComponent) {
            logicComponent = componentFactory.buildLogicComponent();
        }

        if(shouldBuildControlComponent) {
            controlComponent = componentFactory.buildControlComponent();
        }

        return new GameState(graphicsComponent, logicComponent, controlComponent);
    }
}
