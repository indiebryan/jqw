package com.indieprog.jqw;

import static com.indieprog.jqw.gfx.Artist.BeginSession;
import static com.indieprog.jqw.utils.Time.getDelta;

import org.lwjgl.opengl.Display;

import com.indieprog.jqw.entities.Villager;
import com.indieprog.jqw.world.World;

public class Main {
	
	public Main() {
		BeginSession();
		
		World world = new World();
		world.spawnCreature(new Villager(0, 0));
		int delta;
		while(!Display.isCloseRequested()) {
			if ((delta = getDelta()) > 20)
				delta = 20;
			
			world.update(delta);
			world.draw();
			
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
	}
	
	public static void main(String[] agrs) {
		new Main();
	}

}
