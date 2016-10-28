package com.indieprog.jqw;

public interface CustomCodeReq {
	
	/**
	 * Initialize all variables
	 */
	public void init();
	
	/**
	 * Perform actions one time before the update loop begins
	 */
	public void start();
	
	/**
	 * Actions to be executed every time the game updates
	 * @param delta is the number of milliseconds that have passed since the last update; used for timing
	 */
	public void update(int delta);
	
	/**
	 * Draw calls go in this method
	 */
	public void draw();

}
