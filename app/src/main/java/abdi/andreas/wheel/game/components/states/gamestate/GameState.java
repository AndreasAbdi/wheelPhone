package abdi.andreas.wheel.game.components.states.gamestate;


import abdi.andreas.wheel.engine.logic.State;
import abdi.andreas.wheel.engine.logic.components.ControlComponent;
import abdi.andreas.wheel.engine.logic.components.GraphicsComponent;
import abdi.andreas.wheel.engine.logic.components.LogicComponent;

//TODO: pull this to engine level.
public class GameState implements State {

    private final GraphicsComponent graphicsComponent;
    private final LogicComponent logicComponent;
    private ControlComponent controlComponent;

    GameState(GraphicsComponent graphicsComponent, LogicComponent logicComponent, ControlComponent controlComponent) {
        this.graphicsComponent = graphicsComponent;
        this.logicComponent = logicComponent;
        this.controlComponent = controlComponent;
    }

    @Override
    public State update(long deltaTime, long currentTime) {
        this.logicComponent.update(deltaTime, currentTime);
        return this;
    }

    @Override
    public void render(long deltaTime, long currentTime) {
        this.graphicsComponent.update(deltaTime, currentTime);
    }

    @Override
    public void activate() {
        this.controlComponent.activate();
    }

    @Override
    public void deactivate() {
        this.controlComponent.deactivate();
    }


}
