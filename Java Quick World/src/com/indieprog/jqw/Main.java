package com.indieprog.jqw;

import static com.indieprog.jqw.gfx.Artist.BeginSession;
import static com.indieprog.jqw.utils.Time.getDelta;

import org.lwjgl.opengl.Display;

import com.indieprog.jqw.entities.Villager;
import com.indieprog.jqw.math.Vector2f;
import com.indieprog.jqw.ui.UI;
import com.indieprog.jqw.world.World;

public class Main {
	
	public Main() {
		BeginSession();
		
		World world = new World();
		Villager v = new Villager(0, 0);
		world.spawnCreature(v);
		v.move(new Vector2f(192, 140));
		
		UI ui = new UI();
		ui.addButton("a", 64, 140, 64, 64);
		ui.addButton("b", 128, 140, 64, 64);
		ui.addButton("c", 64 * 3, 140, 64, 64);
		ui.addButton("d", 64 * 4, 140, 64, 64);
		ui.addButton("e", 64 * 5, 140, 64, 64);
		int delta;
		while(!Display.isCloseRequested()) {
			if ((delta = getDelta()) > 20)
				delta = 20;
			
			world.update(delta);
			world.draw();
			
			ui.draw();
			
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
	}
	
	public static void main(String[] agrs) {
		new Main();
	}

}
