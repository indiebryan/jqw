package com.indieprog.jqw;

import com.indieprog.jqw.entities.ControllableEntity;
import com.indieprog.jqw.entities.Person;
import com.indieprog.jqw.ui.UI;
import com.indieprog.jqw.world.World;

/**
 * The overarching class that stores, updates and draws everything shown on the screen 
 * such as Entities, UI's, Worlds, etc.
 * 
 * @author indieprogrammer.com/bryan
 */
public class Game {
	
	private World world;
	private ControllableEntity player;
	private UI ui;
	private CustomCode customCode;
	
	public Game() {
		this.world = new World();
		this.player = new Person(0, 0);
		this.ui = new UI();
		this.customCode = new CustomCode();
		this.customCode.init();
		this.customCode.start();
	}
	
	public void update(int delta) {
		world.update(delta);
		player.update(delta);
		ui.update();
		customCode.update(delta);
		draw();
	}
	
	/**
	 * Called from the update() method.  Cannot draw a new frame without updating.
	 */
	private void draw() {
		world.draw();
		player.draw();
		ui.draw();
		customCode.draw();
	}
	
	public void setWorld(World world) {
		this.world = world;
	}
	
	public void setPlayer(ControllableEntity player) {
		this.player = player;
	}
	
	public void setUI(UI ui) {
		this.ui = ui;
	}

}
