package abdi.andreas.wheel.game.components;


import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import abdi.andreas.wheel.engine.graphics.GameView;
import abdi.andreas.wheel.engine.objects.GameModel;

@RunWith(MockitoJUnitRunner.class)
public class ComponentFactoryImplTest {

    @Mock
    GameView gameView;

    @Mock
    GameModel model;

    @Test
    public void shouldNotReturnNull() throws Exception {
        ComponentFactoryImpl componentFactory = new ComponentFactoryImpl(gameView, model);
        Assert.assertNotNull(componentFactory.buildLogicComponent());
        Assert.assertNotNull(componentFactory.buildGraphicsComponent());
        Assert.assertNotNull(componentFactory.buildControlComponent());
    }
}
