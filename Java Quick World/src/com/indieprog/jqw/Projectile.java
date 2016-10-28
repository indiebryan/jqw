package com.indieprog.jqw;

import com.indieprog.jqw.entities.MovableEntity;
import com.indieprog.jqw.math.Vector2f;

public class Projectile extends MovableEntity {

	public Projectile(int x, int y, Vector2f target) {
		super(x, y);
		this.move(target);
	}

}
