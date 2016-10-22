package com.indieprog.jqw.ui;

import static com.indieprog.jqw.gfx.Artist.*;

public class Button {
	
	private int x, y, width, height;
	private String name;
	
	public Button(String name, int x, int y, int width, int height) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public boolean isHighlighted(int mouseX, int mouseY) {
		int trueMouseY = SCREENHEIGHT - mouseY - 1;
		//System.out.println("mousex: " + mouseX + "    mousey: " + trueMouseY + "   x: " + x + "    y: " + y);
		if (mouseX >= x && mouseX <= x + width && trueMouseY >= y && trueMouseY <= y + height)
			return true;
		return false;
	}
	
	public void click() {
		System.out.println(name);
	}
	
	public void highlight() {
		DrawQuadTex(QuickLoad("default_texture_button_highlight"), x, y, width, height);
	}
	
	public void draw() {
		DrawQuadTex(QuickLoad("default_texture_button"), x, y, width, height);
	}

}
