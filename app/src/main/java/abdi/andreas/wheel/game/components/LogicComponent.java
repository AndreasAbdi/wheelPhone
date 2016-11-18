package abdi.andreas.wheel.game.components;

import abdi.andreas.wheel.engine.logic.Component;
import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.engine.objects.GameObjectCollection;

public class LogicComponent implements Component {

    private GameModel gameModel;
    private boolean running;

    public LogicComponent(GameModel gameModel) {
        this.gameModel = gameModel;
        running = false;
    }

    public void start(){
        running = true;
    }

    public void stop(){
        running = false;
    }

    @Override
    public void update(long fps) {
        if(running) {
            for(GameObjectCollection collection : gameModel.values()) {
                collection.update(fps);
            }
        }
    }
}
