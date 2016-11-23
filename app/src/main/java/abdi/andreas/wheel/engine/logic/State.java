package abdi.andreas.wheel.engine.logic;


public interface State {

    public State update(long fps, long currentTime);

    public void render(long fps, long currentTime);

    public void activate();

    public void deactivate();
}
