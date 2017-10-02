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
public class BanalyserUnit
{
    Media music1;
    Media music2;
    Media video1;
    Media video2;
    Media video3;
    Media video4;
    Banalyser musicAnalyser1;
    Banalyser musicAnalyser2;
    Banalyser videoAnalyser1;
    Banalyser videoAnalyser2;
    Banalyser videoAnalyser3;
    Banalyser videoAnalyser4;
    
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
        
        // DEBUT - Objet 3
        
        video1 = new Media("ESA Channel", "The Beagle hasn't landed", ".mov",953000);
        videoAnalyser1 = new Banalyser(video1);
        
        // Génération des entries
        videoAnalyser1.start(0);
        videoAnalyser1.buffer(5000);
        videoAnalyser1.resume(60000);
        videoAnalyser1.pause(30000); 
        videoAnalyser1.resume(105000);
        videoAnalyser1.move(570000);     
        videoAnalyser1.resume(1000);
        videoAnalyser1.stop(900000);
                
        System.out.println(videoAnalyser1.getTextLog());
        
        // FIN - Objet 3
        
        // DEBUT - Objet 4
        
        video2 = new Media("ESA Channel", "The Beagle hasn't landed", ".mov",953000);
        videoAnalyser2 = new Banalyser(video2);
        
        videoAnalyser2.start(0);
        videoAnalyser2.buffer(5000);
        videoAnalyser2.resume(60000);
        videoAnalyser2.pause(30000); 
        videoAnalyser2.resume(105000);
        videoAnalyser2.move(570000);
        videoAnalyser2.resume(1000);
        videoAnalyser2.stop(900000);
                
        System.out.println(videoAnalyser2.getTextLog());
        
        // FIN - Objet 4
        
        // DEBUT - Object 5
        
        video3 = new Media("Remy Channel", "The Framakey", ".mov",953000);
        videoAnalyser3 = new Banalyser(video3);
        
        videoAnalyser3.start(0);
        videoAnalyser3.buffer(5000);
        videoAnalyser3.resume(10000);
        videoAnalyser3.move(70000);
        videoAnalyser3.resume(1000);
        videoAnalyser3.pause(100000);
        videoAnalyser3.resume(2000);
        videoAnalyser3.stop(140000);
        
        System.out.println(videoAnalyser3.getTextLog());
        
        // FIN - Object 5
        
        // DEBUT - Object 6
        
        video4 = new Media("Remy Channel", "The Framakey", ".mov",953000);
        videoAnalyser4 = new Banalyser(video4);
        
        videoAnalyser4.start(0);
        videoAnalyser4.buffer(5000);
        videoAnalyser4.resume(10000);
        videoAnalyser4.move(70000);
        videoAnalyser4.resume(1000);
        videoAnalyser4.pause(100000);
        videoAnalyser4.resume(2000);
        videoAnalyser4.stop(140000);
        
        System.out.println(videoAnalyser4.getTextLog());
        
        // FIN - Object 6
    }

    @Test
    public void testMusic()
    {
        assertTrue(musicAnalyser1.equals(musicAnalyser2));
    }
    
    @Test
    public void testVideo()
    {
        assertTrue(videoAnalyser1.equals(videoAnalyser2));
    }
    
    @Test
    public void testVideo2()
    {
        assertTrue(videoAnalyser3.equals(videoAnalyser4));
    }
}
