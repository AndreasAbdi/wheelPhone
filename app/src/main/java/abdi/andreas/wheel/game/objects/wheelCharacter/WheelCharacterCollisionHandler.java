package abdi.andreas.wheel.game.objects.wheelCharacter;


import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import abdi.andreas.wheel.engine.objects.GameObject;
import abdi.andreas.wheel.game.objects.Torpedo;

public class WheelCharacterCollisionHandler {
    WheelCharacter wheelCharacter;

    public WheelCharacterCollisionHandler(WheelCharacter wheelCharacter) {
        this.wheelCharacter = wheelCharacter;
    }

    public boolean collidesWith(Torpedo torpedo) {

        boolean collisionOccurs = distanceBetweenClosestPoints(torpedo) <= 0;
        boolean collisionOccursInSweepSpot = collisionOccurs && torpedoAngleWithinArcSweep(torpedo);
        if(collisionOccursInSweepSpot) {
            wheelCharacter.score += 10;
            torpedo.collisionOccured(wheelCharacter);
        } else if (collisionOccurs) {
            wheelCharacter.lives--;
            torpedo.collisionOccured(wheelCharacter);
        }

        return collisionOccurs;
    }

    public boolean collidesWith(GameObject gameObject) {
        return false;
    }

    //all torpedos go to center, otherwise we have to do line point distance.
    private double distanceBetweenClosestPoints(Torpedo torpedo) {
        //TODO: shift this class to world coords.
        if(torpedo.getScreenCoordinates() == null) {
            return Double.MAX_VALUE;
        }

        Vector2D position = new Vector2D(
                torpedo.getScreenCoordinates().x(),
                torpedo.getScreenCoordinates().y()
        );

        Vector2D ourPosition = new Vector2D(wheelCharacter.center.x(),wheelCharacter.center.y());
        double distanceBetweenCenters = position.subtract(ourPosition).getNorm();
        double effectiveCombinedLength = wheelCharacter.radius + torpedo.getWidth()/2;
        return distanceBetweenCenters - effectiveCombinedLength;
    }

    private boolean torpedoAngleWithinArcSweep(Torpedo torpedo) {
        float angleOfTorpedo = torpedo.getAngleInDegreesClockwise();
        float minimumAngle = wheelCharacter.startAngle;
        float maximumAngle = wheelCharacter.startAngle + wheelCharacter.sweepAngle;
        if (maximumAngle > 360) {
            boolean isBetweenMinimumAngleAnd360 = (angleOfTorpedo >= minimumAngle  && angleOfTorpedo <= 360);
            boolean isBetween0AndMaximumMinus360 = (angleOfTorpedo >= 0 && angleOfTorpedo <= maximumAngle - 360);
            return  isBetween0AndMaximumMinus360 || isBetweenMinimumAngleAnd360;
        }
        return (angleOfTorpedo >= minimumAngle) && (angleOfTorpedo <= maximumAngle);
    }
}
