package abdi.andreas.wheel.engine.logic.components;

import abdi.andreas.wheel.engine.logic.components.Component;

public interface LogicComponent extends Component {
    public void start();
    public void stop();
    public boolean isRunning();
}
