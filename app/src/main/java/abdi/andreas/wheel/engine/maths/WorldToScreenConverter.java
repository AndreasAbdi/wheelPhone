package abdi.andreas.wheel.engine.maths;


public final class WorldToScreenConverter {
    private WorldToScreenConverter() {}

    public static final Vector convertToScreenCoordinates(Vector point, Vector screenSize) {
        float x = (float)(point.x() + 1)/2 * screenSize.x();
        float y = (float)(1 - point.y())/2 * screenSize.y();
        return new Vector(x,y);
    }

    public static final float getAngleInScreenCoordinates(Vector point, Vector screenSize) {
        double aspectRatio = screenSize.y()/screenSize.x();
        return -(float)Math.toDegrees(Math.atan(point.y()/point.x()*aspectRatio));
    }
}
