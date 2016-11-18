package abdi.andreas.wheel.game.main;


import junit.framework.Assert;

import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import abdi.andreas.wheel.engine.graphics.GameView;
import abdi.andreas.wheel.engine.logic.Component;
import abdi.andreas.wheel.engine.objects.GameModel;

public class ComponentBuilderTest {

    @Mock
    GameView gameView;

    @Mock
    GameModel model;

    @Test
    public void shouldNotReturnNull() throws Exception {
        ArrayList<Component> components = ComponentBuilder.buildComponents(gameView, model);
        Assert.assertNotNull(components);
    }
}
