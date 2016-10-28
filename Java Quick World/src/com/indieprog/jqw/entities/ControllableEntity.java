package com.indieprog.jqw.entities;

import org.lwjgl.input.Keyboard;

public abstract class ControllableEntity extends MovableEntity {

	public ControllableEntity(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void update(int delta) {
		super.update(delta);
		handleInput(delta);
	}
	
	private boolean handleInput(int delta) {
		if (Keyboard.isKeyDown(Keyboard.KEY_W))
			y -= speed * delta;
		else if (Keyboard.isKeyDown(Keyboard.KEY_A))
			x -= speed * delta;
		else if (Keyboard.isKeyDown(Keyboard.KEY_S))
			y += speed * delta;
		else if (Keyboard.isKeyDown(Keyboard.KEY_D))
			x += speed * delta;
		else
			return false;
		return true;
	}


}
