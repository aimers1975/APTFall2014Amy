/**
 * Excerpted from the book, "Pragmatic Unit Testing"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

import junit.framework.*;
import java.util.ArrayList;

public class TestMp3Player extends TestCase {

  protected Mp3Player mp3;
  protected ArrayList list = new ArrayList();

  public void setUp() {
    mp3 = new MockMp3Player();

    list = new ArrayList();
    list.add("Bill Chase -- Open Up Wide");
    list.add("Jethro Tull -- Locomotive Breath");
    list.add("The Boomtown Rats -- Monday");
    list.add("Carl Orff -- O Fortuna");
  }

  public void testPlay() {
    System.out.println("Starting test play.");
    
    mp3.loadSongs(list);
    assertFalse(mp3.isPlaying());
    mp3.play();
    assertTrue(mp3.isPlaying());
    assertTrue(mp3.currentPosition() != 0.0);
    mp3.pause();
    assertTrue(mp3.currentPosition() != 0.0);
    mp3.stop();
    assertEquals(mp3.currentPosition(), 0.0, 0.1);
    System.out.println("Test play complete.");

  }

  public void testPlayNoList() {
    System.out.println("Starting test no list.");
    // Don't set the list up
    assertFalse(mp3.isPlaying());
    mp3.play();
    assertFalse(mp3.isPlaying());
    assertEquals(mp3.currentPosition(), 0.0, 0.1);
    mp3.pause();
    assertEquals(mp3.currentPosition(), 0.0, 0.1);
    assertFalse(mp3.isPlaying());
    mp3.stop();
    assertEquals(mp3.currentPosition(), 0.0, 0.1);
    assertFalse(mp3.isPlaying());
    System.out.println("Test no list complete.");
  }

  public void testAdvance() {
    System.out.println("Starting test advance.");

    mp3.loadSongs(list);

    mp3.play();
    assertTrue(mp3.isPlaying());

    mp3.prev();
    assertEquals(mp3.currentSong(), list.get(0));
    assertTrue(mp3.isPlaying());

    mp3.next();
    assertEquals(mp3.currentSong(), list.get(1));
    mp3.next();
    assertEquals(mp3.currentSong(), list.get(2));
    mp3.prev();

    assertEquals(mp3.currentSong(), list.get(1));
    mp3.next();
    assertEquals(mp3.currentSong(), list.get(2));
    mp3.next();
    assertEquals(mp3.currentSong(), list.get(3));
    mp3.next();
    assertEquals(mp3.currentSong(), list.get(3));
    assertTrue(mp3.isPlaying());
    System.out.println("Test advance complete.");
  }

}