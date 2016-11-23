package abdi.andreas.wheel.game.states.gamestate.components.logic;


import java.util.Random;

import abdi.andreas.wheel.engine.maths.Vector;
import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.game.objects.MetaInfo;
import abdi.andreas.wheel.game.objects.Torpedo;
import abdi.andreas.wheel.game.objects.wheelCharacter.WheelCharacter;

import static abdi.andreas.wheel.game.objects.ObjectKeys.META_INFO;
import static abdi.andreas.wheel.game.objects.ObjectKeys.TORPEDO;
import static abdi.andreas.wheel.game.objects.ObjectKeys.WHEEL;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

final class GameObjectFactory {
    private static final Random RNG = new Random();

    static void initializeComponents(GameModel gameModel) {
        WheelCharacter character = new WheelCharacter(
                new Vector(gameModel.width/2, gameModel.height/2),
                150,
                0,
                30,
                0,
                1);
        gameModel.put(character, WHEEL);
        gameModel.put(new MetaInfo(100, 100, character), META_INFO);
        gameModel.put(generateTorpedo(), TORPEDO);
    }

    static Torpedo generateTorpedo() {
        float rotation = RNG.nextInt(360);
        float distanceFromCenter = RNG.nextFloat()*0.3f + 0.5f;
        double rotationInRadians = Math.toRadians(rotation);
        float length = 200;
        //convert form polar to euclidean.
        //convert from mvp coord to screen cord.
        //translate the position relative to the center of the screen.
        float worldX = (float) (distanceFromCenter*cos(rotationInRadians));
        float worldY = (float) (distanceFromCenter*sin(rotationInRadians));

        float speed = 0.10f;
        float speedRX = -(float)(speed*cos(rotationInRadians));
        float speedRY = -(float)(speed*sin(rotationInRadians));

        return new Torpedo(worldX, worldY, length, 10, rotation, speedRX, speedRY);
    }
}
