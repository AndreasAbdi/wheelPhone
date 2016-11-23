package abdi.andreas.wheel.game.states.menustate.strategy;


import abdi.andreas.wheel.engine.logic.states.State;
import abdi.andreas.wheel.engine.logic.states.StateDecisionStrategy;

public class MenuStateDecisionStrategy implements StateDecisionStrategy {
    @Override
    public State getNextState() {
        return null;
    }

    @Override
    public boolean shouldGetNextState() {
        return false;
    }
}
