package abdi.andreas.wheel.game.main;

import java.util.ArrayList;

import abdi.andreas.wheel.engine.graphics.GameView;
import abdi.andreas.wheel.engine.logic.Component;
import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.game.components.GraphicsComponent;
import abdi.andreas.wheel.game.components.LogicComponent;

public class ComponentBuilder {

    private ComponentBuilder(){}

    public static ArrayList<Component> buildComponents(GameView gameView, GameModel model) {

        GraphicsComponent graphicsComponent = new GraphicsComponent(gameView, model);
        LogicComponent logicComponent = new LogicComponent(model);

        ArrayList<Component> components = new ArrayList<>();
        components.add(graphicsComponent);
        components.add(logicComponent);

        return components;
    }
}
