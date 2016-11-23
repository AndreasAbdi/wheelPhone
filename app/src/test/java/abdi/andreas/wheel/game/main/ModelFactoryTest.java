package abdi.andreas.wheel.game.main;


import junit.framework.Assert;

import org.junit.Test;

public class ModelFactoryTest {

    @Test
    public void shouldNotReturnNull() {
        Assert.assertNotNull(ModelFactory.buildModel(0,0));
    }
}
