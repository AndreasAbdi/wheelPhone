package abdi.andreas.wheel.engine.logic.components;


public interface StateComponentFactory {
    public GraphicsComponent buildGraphicsComponent();
    public LogicComponent buildLogicComponent();
    public ControlComponent buildControlComponent();
}
