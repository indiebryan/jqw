package com.indieprog.jqw.ui;

import java.util.ArrayList;

import org.lwjgl.input.Mouse;

/**
 * 
 * The UI class must be instantiated for each new UI-holding screen.  
 * It contains menus, bars, buttons and labels.
 * 
 * @author indieprogrammer.com/bryan
 */
public class UI {
	
	private ArrayList<Button> buttons;
	private boolean leftClickDown;
	
	public UI() {
		this.buttons = new ArrayList<Button>();
		this.leftClickDown = false;
	}
	
	public void update() {
		for (Button b : buttons) {
			
		}
	}
	
	public void addButton(String name, int x, int y, int width, int height) {
		buttons.add(new Button(name, x, y, width, height));
	}
	
	private boolean clicking() {
		if (Mouse.isButtonDown(0)) {
			if (!leftClickDown) {
				leftClickDown = true;
				return true;
			} else {
				return false;
			}
		} else if (leftClickDown) {
			leftClickDown = false;
			return false;
		}
		return false;
	}
	
	public void draw() {
		for (Button b : buttons) {
			b.draw();
			if (b.isHighlighted(Mouse.getX(), Mouse.getY())) {
				b.highlight();
				if (clicking())
					b.click();
			}
		}
	}

}
