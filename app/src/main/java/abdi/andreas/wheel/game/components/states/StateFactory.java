package abdi.andreas.wheel.game.components.states;


import abdi.andreas.wheel.engine.graphics.GameView;
import abdi.andreas.wheel.engine.logic.State;
import abdi.andreas.wheel.engine.logic.components.ComponentFactory;
import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.game.components.ComponentFactoryImpl;
import abdi.andreas.wheel.game.components.states.gamestate.GameStateBuilder;

public class StateFactory {
    private void StateFactory() {}

    public static State buildGameState(GameView gameView, GameModel gameModel) {
        ComponentFactory componentFactory = new ComponentFactoryImpl(gameView, gameModel);
        GameStateBuilder gameStateBuilder = new GameStateBuilder(componentFactory);
        return gameStateBuilder
                .withGraphicsComponent()
                .withLogicComponent()
                .withControlComponent()
                .build();
    }

    //TODO
    public static State buildMenuState() {
        return null;
    }

}
