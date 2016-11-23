package abdi.andreas.wheel.game.states.gamestate.strategy;


import abdi.andreas.wheel.engine.logic.states.State;
import abdi.andreas.wheel.engine.logic.states.StateDecisionStrategy;

public class GameStateDecisionStrategy implements StateDecisionStrategy {

    public final State targetState;

    public GameStateDecisionStrategy(State targetState) {
        this.targetState = targetState;
    }

    @Override
    public State getNextState() {
        return targetState;
    }

    @Override
    public boolean shouldGetNextState() {
        return false;
    }
}
