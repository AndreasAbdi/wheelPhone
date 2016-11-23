package abdi.andreas.wheel.engine.logic.components;


import abdi.andreas.wheel.engine.logic.components.ControlComponent;
import abdi.andreas.wheel.engine.logic.components.GraphicsComponent;
import abdi.andreas.wheel.engine.logic.components.LogicComponent;

public interface ComponentFactory {
    public GraphicsComponent buildGraphicsComponent();
    public LogicComponent buildLogicComponent();
    public ControlComponent buildControlComponent();
}
