package com.indieprog.jqw;

import java.util.ArrayList;

import com.indieprog.jqw.entities.Background;
import com.indieprog.jqw.entities.Villager;
import com.indieprog.jqw.math.Vector2f;

public class CustomCode implements CustomCodeReq {
	
	private ArrayList<Villager> villagers;
	private ArrayList<Projectile> projectiles;
	private Background bg;
	
	public CustomCode() {
	}

	public void init() {
		this.villagers = new ArrayList<Villager>();
		villagers.add(new Villager(0, 64 * 10));
		villagers.add(new Villager(64 * 6, 0));
		bg = new Background(0, 0);
		
		this.projectiles = new ArrayList<Projectile>();
	}

	public void start() {
		villagers.get(0).patrol(new Vector2f(0, 0));
		villagers.get(1).patrol(new Vector2f(0, 0));
		
	}

	public void update(int delta) {
		for (Villager v : villagers)
			v.update(delta);
		
		for (Projectile p : projectiles)
			p.update(delta);
		
		bg.update(delta);
		//projectiles.add(new Projectile(550, 10, villagers.get(0).getPosition()));
		//projectiles.add(new Projectile(550, 340, villagers.get(1).getPosition()));
	}

	public void draw() {
		bg.draw();
		
		for (Villager v : villagers)
			v.draw();
		
		for (Projectile p : projectiles)
			p.draw();
		
	}
	
}
