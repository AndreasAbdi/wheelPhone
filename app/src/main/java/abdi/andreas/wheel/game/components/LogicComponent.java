package abdi.andreas.wheel.game.components;

import abdi.andreas.wheel.engine.logic.Component;
import abdi.andreas.wheel.engine.objects.GameModel;

public class LogicComponent implements Component {

    private GameModel gameModel;

    public LogicComponent(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    @Override
    public void update() {

    }
}
