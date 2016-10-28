package com.indieprog.jqw;

import static com.indieprog.jqw.gfx.Artist.BeginSession;
import static com.indieprog.jqw.utils.Time.getDelta;

import org.lwjgl.opengl.Display;

import com.indieprog.jqw.entities.Person;
import com.indieprog.jqw.entities.Villager;
import com.indieprog.jqw.math.Vector2f;
import com.indieprog.jqw.ui.UI;
import com.indieprog.jqw.world.World;

public class Main {
	
	public Main() {
		BeginSession();
		
		Game game = new Game();
		
		int delta;
		while(!Display.isCloseRequested()) {
			if ((delta = getDelta()) > 20)
				delta = 20;
			
			game.update(delta);
			
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
	}
	
	public static void main(String[] agrs) {
		new Main();
	}

}
