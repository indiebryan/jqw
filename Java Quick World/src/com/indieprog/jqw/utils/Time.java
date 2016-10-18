package com.indieprog.jqw.utils;

import org.lwjgl.Sys;

public class Time {
	
	public static long lastFrame;
	
	/** 
     * Calculate how many milliseconds have passed 
     * since last frame.
     * 
     * @return milliseconds passed since last frame 
     */
    public static int getDelta() {
        long time = getTime();
        int delta = (int) (time - lastFrame);
        lastFrame = time;
      
        return delta;
    }
    
    /**
     * Get the accurate system time
     * 
     * @return The system time in milliseconds
     */
    public static long getTime() {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }

}
