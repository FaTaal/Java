package fr.exia.insanevehicles.model.element.mobile;

import java.io.IOException;

import fr.exia.insanevehicles.model.IRoad;
import fr.exia.insanevehicles.model.element.Permeability;
import fr.exia.insanevehicles.model.element.Sprite;

/**
 * <h1>The MyVehicle Class.</h1>
 *
 * @author Jade
 * @version 0.2
 */
public class MyVehicle extends Mobile {
	
    /** The Constant SPRITE. */
    private static final Sprite sprite          = new Sprite('H', "frontplayer.png");

    /** The Constant spriteTurnLeft. */
    private static final Sprite spriteTurnLeft  = new Sprite('H', "turnleftplayer.png");

    /** The Constant spriteTurnRight. */
    private static final Sprite spriteTurnRight = new Sprite('H', "turnrightplayer.png");

    /** The Constant spriteExplode. */
    private static final Sprite spriteExplode   = new Sprite('H', "MyVehicleExplode.png");

    /**
     * Instantiates a new my vehicle.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param road
     *            the road
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public MyVehicle(final int x, final int y, final IRoad road) throws IOException {
        super(x, y, sprite, road, Permeability.BLOCKING);
        spriteTurnLeft.loadImage();
        spriteTurnRight.loadImage();
        spriteExplode.loadImage();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveLeft()
     */
    @Override
    public final void moveLeft() {
    	this.wallOnTheLeft();
    	if(leftWall == true) {
    	super.doNothing();
    	}
    	else {
    	super.moveLeft();
    	this.setSprite(spriteTurnLeft);
    	}
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveRight()
     */
    @Override
    public final void moveRight() {
    	this.wallOnTheRight();
    	if(rightWall == true) {
        	super.doNothing();
        	}
        	else {
        super.moveRight();
        this.setSprite(spriteTurnRight);
        	}
    }

    public final void moveUp() {
    	this.wallOnTheUp();
    	if(upWall == true) {
        	super.doNothing();
        	}
        	else {
        super.moveUp();
        this.setSprite(sprite);
        	}
    }
    
    public final void moveDown() {
    	this.wallOnTheDown();
    	if(downWall == true) {
        	super.doNothing();
        	}
        	else {
        super.moveDown();
        this.setSprite(sprite);
        	}
    }
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#die()
     */
    @Override
    protected final void die() {
        super.die();
        this.setSprite(spriteExplode);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#doNothing()
     */
    @Override
    public final void doNothing() {
        super.doNothing();
        this.setSprite(sprite);
    }
}
