package abdi.andreas.wheel.engine.logic.components;

public interface LogicComponent extends Component {
    public void start();
    public void stop();
    public boolean isRunning();
}
