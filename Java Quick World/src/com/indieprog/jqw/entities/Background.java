package com.indieprog.jqw.entities;

public class Background extends ControllableEntity	{

	public Background(int x, int y) {
		super(x, y);
		this.setTexture("background_logo");
		this.width = 2000;
		this.height = 800;
	}

}
