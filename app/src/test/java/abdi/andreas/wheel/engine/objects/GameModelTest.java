package abdi.andreas.wheel.engine.objects;


import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Iterator;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameModelTest {

    @Mock
    GameObject gameObject;

    @Mock
    ArrayList<GameObject> gameObjectArrayList;

    @Mock
    Iterator arrayIterator;

    @Before
    public void setup() {
        when(gameObjectArrayList.iterator()).thenReturn(arrayIterator);
        when(arrayIterator.hasNext()).thenReturn(true, false);
        when(arrayIterator.next()).thenReturn(gameObject);
    }

    @Test
    public void ShouldAddElementToMapWithSingleGameObject() {
        GameModel model = new GameModel(0,0);
        model.put(gameObject, 0);
        Assert.assertTrue(model.size() == 1);
        Assert.assertEquals(model.get(0).get(0), gameObject);
    }

}
