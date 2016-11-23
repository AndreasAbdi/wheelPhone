package abdi.andreas.wheel.engine.logic.states;


public interface StateDecisionStrategy {
    State getNextState();
    boolean shouldGetNextState();
}
