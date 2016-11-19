package abdi.andreas.wheel.engine.maths;


import java.util.AbstractMap;

public class Vector extends AbstractMap.SimpleImmutableEntry<Float, Float>{

    public Vector(float x, float y) {
        super(x,y);
    }

    public Float x() {
        return this.getKey() == null ? 0 : this.getKey();
    }

    public Float y() {
        return this.getValue() == null ? 0 : this.getValue();
    }
}
