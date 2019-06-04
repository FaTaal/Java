package fr.exia.insanevehicles.model.element.mobile;

import java.awt.Point;

import fr.exia.insanevehicles.model.IRoad;
import fr.exia.insanevehicles.model.element.Element;
import fr.exia.insanevehicles.model.element.Permeability;
import fr.exia.insanevehicles.model.element.Sprite;
import fr.exia.showboard.IBoard;
import fr.exia.insanevehicles.model.element.mobile.IMobile;

/**
 * <h1>The Mobile Class.</h1>
 *
 * @author Jade
 * @version 0.3
 */
abstract class Mobile extends Element implements IMobile {

    /**
     * The x.
     */
	
	public static final Sprite macadam          = new Sprite(' ', "underground.png");
	
    private Point   position;
    
    public Boolean leftWall = false;
    
    public Boolean rightWall = false;
    
    public Boolean upWall = false;
    
    public Boolean downWall = false;

    /** The alive. */
    private Boolean alive = true;

    /** The road. */
    private IRoad   road;

    /** The board. */
    private IBoard  board;

    /**
     * Instantiates a new mobile.
     *
     * @param sprite
     *            the sprite
     * @param road
     *            the road
     * @param permeability
     *            the permeability
     */
    Mobile(final Sprite sprite, final IRoad road, final Permeability permeability) {
        super(sprite, permeability);
        this.setRoad(road);
        this.position = new Point();
    }

    /**
     * Instantiates a new mobile.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param sprite
     *            the sprite
     * @param road
     *            the road
     * @param permeability
     *            the permeability
     */
    Mobile(final int x, final int y, final Sprite sprite, final IRoad road, final Permeability permeability) {
        this(sprite, road, permeability);
        this.setX(x);
        this.setY(y);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveUp()
     */
    
    public void caseWalked() {
    	this.getRoad().getOnTheRoadXY(this.getX() , this.getY()).setSprite(" ");	
    }
    
    public Boolean wallOnTheLeft() {
    	if(this.getRoad().getOnTheRoadXY(this.getX() - 1, this.getY()).getPermeability() == Permeability.BLOCKING) {
    		return this.leftWall = true;
    	}
    	else {
    		return this.leftWall = false;
    	}
    }
    
    public Boolean wallOnTheRight() {
    	if(this.getRoad().getOnTheRoadXY(this.getX() + 1, this.getY()).getPermeability() == Permeability.BLOCKING) {
    		return this.rightWall = true;
    	}
    	else {
    		return this.rightWall = false;
    	}
    }
    
    public Boolean wallOnTheUp() {
    	if(this.getRoad().getOnTheRoadXY(this.getX(), this.getY() - 1).getPermeability() == Permeability.BLOCKING) {
    		return this.upWall = true;
    	}
    	else {
    		return this.upWall = false;
    	}
    }
    
    public Boolean wallOnTheDown() {
    	if(this.getRoad().getOnTheRoadXY(this.getX(), this.getY() + 1).getPermeability() == Permeability.BLOCKING) {
    		return this.downWall = true;
    	}
    	else {
    		return this.downWall = false;
    	}
    }
    	
    @Override
    public void moveUp() {
        this.setY(this.getY() - 1);
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveLeft()
     */
    @Override
    public void moveLeft() {
        this.setX(this.getX() - 1);
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveDown()
     */
    @Override
    public void moveDown() {
        this.setY(this.getY() + 1);
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveRight()
     */
    @Override
    public void moveRight() {
        this.setX(this.getX() + 1);
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#doNothing()
     */
    @Override
    public void doNothing() {
        this.setHasMoved();
    }

    /**
     * Sets the has moved.
     */
    private void setHasMoved() {
        this.getRoad().setMobileHasChanged();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#getX()
     */
    @Override
    public final int getX() {
        return this.getPosition().x;
    }

    /**
     * Sets the x.
     *
     * @param x
     *            the new x
     */
    public final void setX(final int x) {
        this.getPosition().x = x;
        if (this.isCrashed()) {
            this.die();
        }
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#getY()
     */
    @Override
    public final int getY() {
        return this.getPosition().y;
    }

    /**
     * Sets the y.
     *
     * @param y
     *            the new y, as the road is an infinite loop, there's a modulo
     *            based on the road height.
     */
    public final void setY(final int y) {
        this.getPosition().y = (y + this.getRoad().getHeight()) % this.getRoad().getHeight();
        if (this.isCrashed()) {
            this.die();
        }
    }

    /**
     * Gets the road.
     *
     * @return the road
     */
    public IRoad getRoad() {
        return this.road;
    }

    /**
     * Sets the road.
     *
     * @param road
     *            the new road
     */
    private void setRoad(final IRoad road) {
        this.road = road;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#isAlive()
     */
    @Override
    public Boolean isAlive() {
        return this.alive;
    }

    /**
     * Dies.
     */
    protected void die() {
        this.alive = false;
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#isCrashed()
     */
    @Override
    public Boolean isCrashed() {
        return this.getRoad().getOnTheRoadXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.IPawn#getPosition()
     */
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#getPosition()
     */
    @Override
    public Point getPosition() {
        return this.position;
    }

    /**
     * Sets the position.
     *
     * @param position
     *            the position to set
     */
    public void setPosition(final Point position) {
        this.position = position;
    }

    /**
     * Gets the board.
     *
     * @return the board
     */
    protected IBoard getBoard() {
        return this.board;
    }

}
