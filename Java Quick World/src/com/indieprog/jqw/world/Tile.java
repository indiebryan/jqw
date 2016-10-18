package com.indieprog.jqw.world;

import static com.indieprog.jqw.gfx.Artist.DrawQuadTex;
import static com.indieprog.jqw.gfx.Artist.QuickLoad;
import static com.indieprog.jqw.gfx.Artist.TILESIZE;

import org.newdawn.slick.opengl.Texture;

import com.indieprog.jqw.math.Vector2f;


public class Tile {
	
	private Vector2f position, dimensions;
	private Texture texture;
	
	public Tile() {
		this.position = new Vector2f();
		this.texture = QuickLoad("default_texture_tile");
		this.dimensions = new Vector2f(TILESIZE);
	}
	
	public Tile(int x, int y) {
		this();
		this.position = new Vector2f(x, y);
	}
	
	public Tile(int x, int y, Texture texture) {
		this(x, y);
		this.texture = texture;
	}
	
	public void draw() {
		DrawQuadTex(texture, position.x, position.y, dimensions.x, dimensions.y);
	}

	public Vector2f getPosition() {
		return position;
	}

	public void setPosition(Vector2f position) {
		this.position = position;
	}

	public Vector2f getDimensions() {
		return dimensions;
	}

	public void setDimensions(Vector2f dimensions) {
		this.dimensions = dimensions;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

}
