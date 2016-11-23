package abdi.andreas.wheel.game.states;


import abdi.andreas.wheel.engine.graphics.GameView;
import abdi.andreas.wheel.engine.logic.components.StateComponentFactory;
import abdi.andreas.wheel.engine.logic.states.StateBuilder;
import abdi.andreas.wheel.engine.logic.states.State;
import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.game.states.gamestate.components.GameStateStateComponentFactoryImpl;

public class StateFactory {
    private void StateFactory() {}

    public static State buildGameState(GameView gameView, GameModel gameModel) {
        StateComponentFactory stateComponentFactory = new GameStateStateComponentFactoryImpl(gameView, gameModel);
        StateBuilder stateBuilder = new StateBuilder(stateComponentFactory);
        return stateBuilder
                .withGraphicsComponent()
                .withLogicComponent()
                .withControlComponent()
                .build();
    }

    //TODO
    public static State buildMenuState(GameView gameView, GameModel gameModel) {
        StateComponentFactory stateComponentFactory = new GameStateStateComponentFactoryImpl(gameView, gameModel);
        StateBuilder stateBuilder = new StateBuilder(stateComponentFactory);
        return stateBuilder
                .withGraphicsComponent()
                .withLogicComponent()
                .withControlComponent()
                .build();
    }

}
