/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import banalytics.Banalyser;
import banalytics.Media;

/**
 * @author Bebo
 *
 */
public class MediaLogUnit
{
    Media music1;
    Media music2;
    Banalyser musicAnalyser1;
    Banalyser musicAnalyser2;
        
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
        // Musique 1
        music1 = new Media("The Space Explorers", "Big Falcon Rocket", ".mp3",180000);
        
        musicAnalyser1 = new Banalyser(music1);
        
        musicAnalyser1.start(0);
        musicAnalyser1.pause(30000);
        musicAnalyser1.resume(10000);
        musicAnalyser1.move(102000);
        musicAnalyser1.resume(1000);
        musicAnalyser1.buffer(150000);
        musicAnalyser1.resume(5000);
        musicAnalyser1.stop(180000);
        
        // Musique 2
        music2 = new Media("The Space Explorers", "Big Falcon Rocket", ".mp3",180000);
        
        musicAnalyser2 = new Banalyser(music2);
        
        musicAnalyser2.start(0);
        musicAnalyser2.pause(30000);
        musicAnalyser2.resume(10000);
        musicAnalyser2.move(102000);
        musicAnalyser2.resume(1000);
        musicAnalyser2.buffer(150000);
        musicAnalyser2.resume(5000);
        musicAnalyser2.stop(180000);
    }

    @Test
    public void test()
    {
        assertTrue(musicAnalyser1.equals(musicAnalyser2));
    }

}
