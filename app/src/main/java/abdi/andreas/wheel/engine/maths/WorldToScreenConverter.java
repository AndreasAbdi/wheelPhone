package abdi.andreas.wheel.engine.maths;


public final class WorldToScreenConverter {
    private WorldToScreenConverter() {}

    public static final Vector convertToScreenCoordinates(Vector point, Vector screenSize) {
        float x = generateX(point, screenSize);
        float y = generateY(point, screenSize);
        return new Vector(x,y);
    }

    public static final float getClockwiseAngleInScreenCoordinates(Vector point, Vector screenSize) {
        double aspectRatio = screenSize.y()/screenSize.x();
        double angleRadians = Math.atan2(point.y()*aspectRatio, point.x());
        angleRadians = angleRadians > 0 ? angleRadians : 2*Math.PI - Math.abs(angleRadians);
        double angleInScreenCoordinates = Math.toDegrees(angleRadians);
        double angleInCCW = 360 - Math.abs(angleInScreenCoordinates);
        return (float) angleInCCW;
    }

    private static final float generateY(Vector point, Vector screenSize) {
        return (float)(1 - point.y())/2 * screenSize.y();
    }

    private static final float generateX(Vector point, Vector screenSize) {
        return (float)(point.x() + 1)/2 * screenSize.x();
    }
}
