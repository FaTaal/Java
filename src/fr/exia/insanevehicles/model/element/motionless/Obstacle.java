package fr.exia.insanevehicles.model.element.motionless;

import fr.exia.insanevehicles.model.element.Permeability;
import fr.exia.insanevehicles.model.element.Sprite;

/**
 * <h1>The Obstacle Class.</h1>
 *
 * @author Jade
 * @version 0.2
 */
class Obstacle extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('X', "Obstacle.jpg");

    /**
     * Instantiates a new obstacle.
     */
    Obstacle() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
