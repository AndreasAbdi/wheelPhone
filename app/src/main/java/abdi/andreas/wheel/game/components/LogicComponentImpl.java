package abdi.andreas.wheel.game.components;

import java.util.Random;

import abdi.andreas.wheel.engine.logic.LogicComponent;
import abdi.andreas.wheel.engine.objects.GameModel;
import abdi.andreas.wheel.engine.objects.GameObjectCollection;
import abdi.andreas.wheel.game.objects.Ball;
import abdi.andreas.wheel.game.objects.MetaInfo;
import abdi.andreas.wheel.game.objects.Torpedo;
import abdi.andreas.wheel.game.objects.WheelCharacter;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class LogicComponentImpl implements LogicComponent {

    private GameModel gameModel;
    private boolean running;
    private boolean initialized;

    private static final int META_INFO = 0;
    private static final int WHEEL = 1;
    private static final int BALL = 2;
    private static final int TORPEDO = 3;
    private static final Random RNG = new Random();

    public LogicComponentImpl(GameModel gameModel) {
        this.gameModel = gameModel;
        running = true;
        initialized = false;
    }

    public void start() {
        running = true;
    }

    public void stop(){
        running = false;
    }

    @Override
    public void update(long deltaTime, long currentTime) {
        if(running) {
            runInitializationSequence();
            runUpdateSequence(deltaTime, currentTime);
            runCollisionHandlingSequence();
        }
    }

    private void runUpdateSequence(long deltaTime, long currentTime) {
        for(GameObjectCollection collection : gameModel.values()) {
            collection.clearObjects();
            collection.update(deltaTime);
        }
    }

    private void runInitializationSequence() {
        if(!initialized) {
            gameModel.put(new Ball(gameModel.width/2 + 500, gameModel.height/2, 10, 0), BALL);
            WheelCharacter character = new WheelCharacter(gameModel.width/2, gameModel.height/2, 150, 0, 1);
            gameModel.put(character, WHEEL);
            gameModel.put(new MetaInfo(100, 100, character), META_INFO);
            gameModel.put(generateTorpedo(), TORPEDO);
            //gameModel.put(new Torpedo(gameModel.width/2 - 500, gameModel.height/2, 200, 10, 45, 100, 0), TORPEDO);
            initialized = true;
        }
    }

    private void runCollisionHandlingSequence() {
        GameObjectCollection<Torpedo> torpedos = gameModel.get(TORPEDO);

        WheelCharacter wheelCharacter = (WheelCharacter)gameModel.get(WHEEL).get(0);

        boolean torpedoHit = false;
        for(Torpedo torpedo : torpedos) {
            torpedoHit = torpedoHit || wheelCharacter.collidesWith(torpedo);
        }
        if (torpedoHit) {
            torpedos.add(generateTorpedo());
        }

    }

    private Torpedo generateTorpedo() {
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
