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
            wheelCharacter.score++;
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

    //all torpedos go to center, otherwise we have do line point distance.
    private double distanceBetweenClosestPoints(Torpedo torpedo) {
        //TODO: shift this class to world coords.
        if(torpedo.screenCoordinates == null) {
            return Double.MAX_VALUE;
        }

        Vector2D position = new Vector2D(
                torpedo.screenCoordinates.x(),
                torpedo.screenCoordinates.y()
        );

        Vector2D ourPosition = new Vector2D(wheelCharacter.center.x(),wheelCharacter.center.y());
        double distanceBetweenCenters = position.subtract(ourPosition).getNorm();
        double effectiveCombinedLength = wheelCharacter.radius + torpedo.width/2;
        return distanceBetweenCenters - effectiveCombinedLength;
    }

    private boolean torpedoAngleWithinArcSweep(Torpedo torpedo) {
        float angleOfTorpedo = torpedo.angleInDegreesClockwise;
        float minimumAngle = wheelCharacter.startAngle;
        float maximumAngle = wheelCharacter.startAngle + wheelCharacter.sweepAngle;
        if((angleOfTorpedo >= minimumAngle) && (angleOfTorpedo <= maximumAngle)) {
            return true;
        }
        return false;
    }
}
