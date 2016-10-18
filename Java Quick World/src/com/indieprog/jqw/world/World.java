package com.indieprog.jqw.world;

import java.util.ArrayList;

import com.indieprog.jqw.entities.DrawableEntity;
import com.indieprog.jqw.entities.MovableEntity;
import com.indieprog.jqw.math.Vector2f;

/**
 * The World class holds the TileGrid as well as lists of every Entity in the game.
 * 
 * @author IndieProgrammer.com/bryan
 */
public class World {
	
	private TileGrid grid;
	private ArrayList<DrawableEntity> entities;
	private ArrayList<MovableEntity> creatures;
	
	public World() {
		grid = new TileGrid();
		entities = new ArrayList<DrawableEntity>();
		creatures = new ArrayList<MovableEntity>();
	}
	
	public void spawnCreature(MovableEntity entity) {
		creatures.add(entity);
		entity.patrol(new Vector2f(200, 232));
	}
	
	public void update(int delta) {
		for (MovableEntity e : creatures)
			e.update(delta);
	}
	
	public void draw() {
		grid.draw();
		
		for (DrawableEntity e : entities)
			e.draw();
		
		for (MovableEntity e : creatures)
			e.draw();
	}
	
}
