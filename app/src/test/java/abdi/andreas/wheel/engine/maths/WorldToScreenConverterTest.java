package abdi.andreas.wheel.engine.maths;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WorldToScreenConverterTest {

    @Test
    public void shouldReturnModifiedAngleWhenGivenRectangularWorldCoordinates() {
        Vector unit45 = new Vector(1,1);
        Vector squareScreen = new Vector(100,200);
        float angle = WorldToScreenConverter.getClockwiseAngleInScreenCoordinates(unit45, squareScreen);
        Assert.assertEquals(296.56, angle, 0.1);
    }

    @Test
    public void shouldReturnSameAngleWhenGivenSquareWorldCoordinates() {
        Vector unit45 = new Vector(1,1);
        Vector squareScreen = new Vector(100,100);

        float angle = WorldToScreenConverter.getClockwiseAngleInScreenCoordinates(unit45, squareScreen);
        Assert.assertEquals(315, angle, 0.1);
    }

}
