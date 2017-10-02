/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import banalytics.Banalyser;
import banalytics.ExceptionDevoir2;
import banalytics.Media;

/**
 * @author Bebo
 *
 */
public class BanalyserUnit
{
    Media music, video;
    Banalyser analyser1, analyser2;

    @Before
    public void setUp1()
    {
        music = new Media("The Space Explorers", "Big Falcon Rocket", ".mp3", 180000);

        analyser1 = new Banalyser(music);

        analyser1.start(0);
        analyser1.pause(30000);
        analyser1.resume(10000);
        analyser1.move(102000);
        analyser1.resume(1000);
        analyser1.buffer(150000);
        analyser1.resume(5000);
        analyser1.stop(180000);

        analyser2 = new Banalyser(music);

        analyser2.start(0);
        analyser2.pause(30000);
        analyser2.resume(10000);
        analyser2.move(102000);
        analyser2.resume(1000);
        analyser2.buffer(150000);
        analyser2.resume(5000);
        analyser2.stop(180000);
    }

    /**
     * Test de la methode equals de la classe Banalyser avec une music
     */
    @Test
    public void testMusic()
    {
        assertTrue(analyser1.equals(analyser2));
    }

    @Before
    public void setUp2()
    {
        video = new Media("ESA Channel", "The Beagle hasn't landed", ".mov", 953000);

        analyser1 = new Banalyser(video);

        analyser1.start(0);
        analyser1.buffer(5000);
        analyser1.resume(60000);
        analyser1.pause(30000);
        analyser1.resume(105000);
        analyser1.move(570000);
        analyser1.resume(1000);
        analyser1.stop(900000);

        analyser2 = new Banalyser(video);

        analyser2.start(0);
        analyser2.buffer(5000);
        analyser2.resume(60000);
        analyser2.pause(30000);
        analyser2.resume(105000);
        analyser2.move(570000);
        analyser2.resume(1000);
        analyser2.stop(900000);
    }

    /**
     * Test de la methode equals de la classe Banalyser avec une video
     */
    @Test
    public void testVideo()
    {
        assertTrue(analyser1.equals(analyser2));
    }

    @Before
    public void setUp3()
    {
        video = new Media("Remy Channel", "The Framakey", ".mov", 953000);
        analyser1 = new Banalyser(video);

        analyser1.start(0);
        analyser1.buffer(5000);
        analyser1.resume(10000);
        analyser1.move(70000);
        analyser1.resume(1000);
        analyser1.pause(100000);
        analyser1.resume(2000);
        analyser1.stop(140000);

        analyser2 = new Banalyser(video);

        analyser2.start(0);
        analyser2.buffer(5000);
        analyser2.resume(10000);
        analyser2.move(70000);
        analyser2.resume(1000);
        analyser2.pause(100000);
        analyser2.resume(2000);
        analyser2.stop(140000);
    }

    /**
     * Test de la classe equals avec une autre sequence d'evenement
     */
    @Test
    public void testVideo2()
    {
        assertTrue(analyser1.equals(analyser2));
    }

    @Before
    public void setUp4()
    {
        video = new Media("Remy Channel", "The Framakey", ".mov", 953000);
        analyser1 = new Banalyser(video);

        analyser1.start(0);
        analyser1.pause(100000);
    }

    /**
     * Interdiction de mettre deux fois un etat a PAUSED de manière séquentielle
     */
    @Test(expected = ExceptionDevoir2.class)
    public void testVideoSituationAnormale1()
    {
        analyser1.buffer(5000);
    }

    @Before
    public void setUp5()
    {
        video = new Media("Remy Channel", "The Framakey", ".mov", 953000);
        analyser1 = new Banalyser(video);

        analyser1.start(0);
        analyser1.buffer(5000);
        analyser1.resume(1000);
    }

    /**
     * Interdiction de mettre deux fois un etat a PLAYING de manière
     * séquentielle
     */
    @Test(expected = ExceptionDevoir2.class)
    public void testVideoSituationAnormale2()
    {
        analyser1.resume(1000);
    }

    @Before
    public void setUp6()
    {
        video = new Media("Remy Channel", "The Framakey", ".mov", 953000);
        analyser1 = new Banalyser(video);

        analyser1.start(0);
        analyser1.buffer(1000);
        analyser1.resume(1000);
        analyser1.buffer(1000);

    }

    /**
     * Interdiction de mettre deux fois un etat a PAUSED de manière séquentielle
     */
    @Test(expected = ExceptionDevoir2.class)
    public void testVideoSituationAnormale3()
    {
        analyser1.buffer(1000);
    }

    @Before
    public void setUp7()
    {
        video = new Media("Remy Channel", "The Framakey", ".mov", 953000);
        analyser1 = new Banalyser(video);

        analyser1.start(0);
        analyser1.stop(1000);

    }

    /**
     * Interdiction de mettre deux fois un etat a STOPPED de manière
     * séquentielle
     */
    @Test(expected = ExceptionDevoir2.class)
    public void testVideoSituationAnormale4()
    {
        analyser1.stop(2000);
    }
}