package fr.exia.insanevehicles.model.element.motionless;

import fr.exia.insanevehicles.model.element.Permeability;
import fr.exia.insanevehicles.model.element.Sprite;

/**
 * <h1>The Tree Class.</h1>
 *
 * @author Jade
 * @version 0.2
 */
class Tree extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('^', "ground.png");

    /**
     * Instantiates a new tree.
     */
    Tree() {
        super(SPRITE, Permeability.PENETRABLE);
    }
}
