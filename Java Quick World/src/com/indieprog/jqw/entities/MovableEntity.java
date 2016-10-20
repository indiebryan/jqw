package com.indieprog.jqw.entities;

import com.indieprog.jqw.math.Vector2f;

/**
 * An abstract class to be extended by entities that need to be able to move around the world.  Implements methods
 * of movement such as move(), teleport() and patrol().
 * 
 * @author IndieProgrammer.com/bryan
 */
public abstract class MovableEntity extends DrawableEntity {
	
	private boolean moving, patrolling;
	private float speed;
	private Vector2f location, direction, patrolOrigin;
	
	public MovableEntity(int x, int y) {
		super(x, y);
		this.speed = 0.5f;
		this.moving = false;
		this.patrolling = false;
		this.location = new Vector2f();
		this.direction = new Vector2f();
		this.patrolOrigin = new Vector2f();
	}
	
	public void move(Vector2f location) {
		this.moving = true;
		this.location = location;
		this.direction = calculateDirection();
	}
	
	public void patrol(Vector2f location) {
		this.moving = true;
		this.patrolling = true;
		this.location = location;
		this.direction = calculateDirection();
		this.patrolOrigin = new Vector2f(x, y);
	}
	
	/**
	 * Changes the MovableEntity's x and y values to match those passed in a Vector2f.  Sets the moving and patrolling boolean values to false;
	 * 
	 * @param location A Vector2f representing where the MovableEntity will be teleported to.
	 */
	public void teleport(Vector2f location) {
		this.x = location.x;
		this.y = location.y;
		this.moving = false;
		this.patrolling = false;
	}
	
	public void update(int delta) {
		if (moving) {
			if (!isLocationReached()) {
				x += direction.x * speed * delta;
				y += direction.y * speed * delta;
			} else if (patrolling){
				Vector2f temp = location;
				location = patrolOrigin;
				//Setting to temp instead of just x and y position because otherwise
				//the patrols would get closer and closer until the entity eventually stops moving.
				patrolOrigin = temp;
				direction = calculateDirection();
			} else {
				moving = false;
			}
		}
	}
	
	private Vector2f calculateDirection() {
		Vector2f dir = new Vector2f();
		float xD = Math.abs(location.x - x);
		float yD = Math.abs(location.y - y);
		float totalDistance = xD + yD;
		dir.x = xD / totalDistance;
		dir.y = yD / totalDistance;
		if (x > location.x)
			dir.x *= -1;
		if (y > location.y)
			dir.y *= -1;
		return dir;
	}
	
	private boolean isLocationReached() {
		boolean reached = false;
		if (x >= location.x - speed * 20 && x <= location.x + speed * 20 && 
				y >= location.y - speed * 20 && y <= location.y + speed * 20)
			reached = true;
		return reached;
	}

}
