package com.indieprog.jqw.entities;

import static com.indieprog.jqw.gfx.Artist.DrawQuadTex;
import static com.indieprog.jqw.gfx.Artist.QuickLoad;
import static com.indieprog.jqw.gfx.Artist.TILESIZE;

import org.newdawn.slick.opengl.Texture;

import com.indieprog.jqw.gfx.Artist;

/**
 * An abstract class to be extended by any entity which needs to be drawn to the screen.  
 * Stores x, y, width, height and texture values.
 * 
 * @see Entity
 * 
 * @author IndieProgrammer.com/bryan
 */
public abstract class DrawableEntity implements Entity {
	
	protected float x, y, width, height;
	private Texture texture;	
	
	/**
	 * Sets the position and size of a new entity and provides the default texture.
	 * 
	 * @param x The x position of the entity.
	 * @param y The y position of the entity.
	 * @param width The width of the entity.
	 * @param height The height of the entity.
	 */
	public DrawableEntity(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		this.texture = QuickLoad("default_texture");
	}
	
	/**
	 * Sets the position and size of a new entity and provides the default texture.
	 * 
	 * @param x The x position of the entity.
	 * @param y The y position of the entity.
	 * 
	 * Sets the width and height of the entity equal to the TILESIZE value of the Artist class.
	 * @see Artist
	 */
	public DrawableEntity(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = TILESIZE;
		this.height = TILESIZE;
		
		this.texture = QuickLoad("default_texture_entity");
	}
	
	/**
	 * Passes the DrawableEntity's texture, x, y, width and height to DrawQuadTex in the Artist class.
	 */
	public void draw() {
		DrawQuadTex(texture, x, y, width, height);
	}
	
	/**
	 * Calls the QuickLoad() function of the Artist class to set the texture value based on the provided String.
	 * @param textureName The file name of the texture. (Must comply with QuickLoad specifications).
	 * @see Artist#QuickLoad(String)
	 */
	public void setTexture(String textureName) {
		this.texture = QuickLoad(textureName);
	}
	
}
