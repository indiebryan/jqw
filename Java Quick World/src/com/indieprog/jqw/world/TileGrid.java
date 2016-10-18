package com.indieprog.jqw.world;

import static com.indieprog.jqw.gfx.Artist.QuickLoad;
import static com.indieprog.jqw.gfx.Artist.SCREENHEIGHT;
import static com.indieprog.jqw.gfx.Artist.SCREENWIDTH;
import static com.indieprog.jqw.gfx.Artist.TILESIZE;

import org.newdawn.slick.opengl.Texture;

public class TileGrid {
	
	private int tilesWide, tilesHigh;
	private Texture defaultTexture;
	private Tile[][] grid;
	
	public TileGrid() {
		this.tilesWide = SCREENWIDTH / TILESIZE;
		this.tilesHigh = SCREENHEIGHT / TILESIZE;
		this.defaultTexture = QuickLoad("default_texture_tile");
		populateGrid();
	}
	
	private void populateGrid() {
		grid = new Tile[tilesWide][tilesHigh];
		for (int i = 0; i < tilesWide; i++) {
			for (int j = 0; j < tilesHigh; j++) {
				grid[i][j] = new Tile(i * TILESIZE, j * TILESIZE, defaultTexture);
			}
		}
	}
	
	public void draw() {
		for (int i = 0; i < tilesWide; i++) {
			for (int j = 0; j < tilesHigh; j++) {
				grid[i][j].draw();
			}
		}
	}

}
