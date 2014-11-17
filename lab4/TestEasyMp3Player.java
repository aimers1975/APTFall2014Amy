import junit.framework.*;
import static org.easymock.EasyMock.*;
import java.util.ArrayList;

public class TestEasyMp3Player extends TestCase {
  private Mp3Player mockMp3Player;
  private Mp3Player mockMp3Player_control;
  ArrayList<String> list = new ArrayList<String>();

  @Override
  protected void setUp() {
    list = new ArrayList();
    list.add("Bill Chase -- Open Up Wide");
    list.add("Jethro Tull -- Locomotive Breath");
    list.add("The Boomtown Rats -- Monday");
    list.add("Carl Orff -- O Fortuna");
    // Create a control handle to the Mock object
    mockMp3Player_control = createMock(Mp3Player.class);

    // And create the mock object itself
    mockMp3Player = mockMp3Player_control;
  }

  public void testPlay() {

    mockMp3Player.loadSongs(list);
    expectLastCall();
    expect(mockMp3Player.isPlaying()).andReturn(false);
    mockMp3Player.play();
    expectLastCall();
    expect(mockMp3Player.isPlaying()).andReturn(true);
    expect(mockMp3Player.currentPosition()).andReturn(1.0);
    mockMp3Player.pause();
    expectLastCall();
    expect(mockMp3Player.currentPosition()).andReturn(1.0);
    expect(mockMp3Player.isPlaying()).andReturn(false);
    mockMp3Player.stop();
    expectLastCall();
    expect(mockMp3Player.currentPosition()).andReturn(0.0);
    expect(mockMp3Player.isPlaying()).andReturn(false);

    replay( mockMp3Player_control );
    
    mockMp3Player.loadSongs(list);
    assertFalse(mockMp3Player.isPlaying());
    mockMp3Player.play();
    assertTrue(mockMp3Player.isPlaying());
    assertTrue(mockMp3Player.currentPosition() != 0.0);
    mockMp3Player.pause();
    assertTrue(mockMp3Player.currentPosition() != 0.0);
    assertFalse(mockMp3Player.isPlaying());
    mockMp3Player.stop();
    assertEquals(mockMp3Player.currentPosition(), 0.0, 0.1);
    assertFalse(mockMp3Player.isPlaying());

  }


  public void testPlayNoList() {

    expect(mockMp3Player.isPlaying()).andReturn(false);
    mockMp3Player.play();
    expectLastCall();
    expect(mockMp3Player.isPlaying()).andReturn(false);
    expect(mockMp3Player.currentPosition()).andReturn(0.0);
    mockMp3Player.pause();
    expectLastCall();
    expect(mockMp3Player.currentPosition()).andReturn(0.0);
    expect(mockMp3Player.isPlaying()).andReturn(false);
    mockMp3Player.stop();
    expectLastCall();
    expect(mockMp3Player.currentPosition()).andReturn(0.0);
    expect(mockMp3Player.isPlaying()).andReturn(false);

    replay( mockMp3Player_control);

    // Don't set the list up
    assertFalse(mockMp3Player.isPlaying());
    mockMp3Player.play();
    assertFalse(mockMp3Player.isPlaying());
    assertEquals(mockMp3Player.currentPosition(), 0.0, 0.1);
    mockMp3Player.pause();
    assertEquals(mockMp3Player.currentPosition(), 0.0, 0.1);
    assertFalse(mockMp3Player.isPlaying());
    mockMp3Player.stop();
    assertEquals(mockMp3Player.currentPosition(), 0.0, 0.1);
    assertFalse(mockMp3Player.isPlaying());
  }

  public void testAdvance() {
    mockMp3Player.loadSongs(list);
    expectLastCall();
    mockMp3Player.play();
    expectLastCall();
    expect(mockMp3Player.isPlaying()).andReturn(true);
    mockMp3Player.prev();
    expectLastCall();
    expect(mockMp3Player.currentSong()).andReturn(list.get(0));
    expect(mockMp3Player.isPlaying()).andReturn(true);
    mockMp3Player.next();
    expectLastCall();
    expect(mockMp3Player.currentSong()).andReturn(list.get(1));
    mockMp3Player.next();
    expectLastCall();
    expect(mockMp3Player.currentSong()).andReturn(list.get(2));
    mockMp3Player.prev();
    expectLastCall();
    expect(mockMp3Player.currentSong()).andReturn(list.get(1));
    mockMp3Player.next();
    expectLastCall();
    expect(mockMp3Player.currentSong()).andReturn(list.get(2));
    mockMp3Player.next();
    expectLastCall();
    expect(mockMp3Player.currentSong()).andReturn(list.get(3));
    mockMp3Player.next();
    expectLastCall();
    expect(mockMp3Player.currentSong()).andReturn(list.get(3));
    expect(mockMp3Player.isPlaying()).andReturn(true);

    replay(mockMp3Player_control);

    mockMp3Player.loadSongs(list);

    mockMp3Player.play();
    assertTrue(mockMp3Player.isPlaying());

    mockMp3Player.prev();
    assertEquals(mockMp3Player.currentSong(), list.get(0));
    assertTrue(mockMp3Player.isPlaying());

    mockMp3Player.next();
    assertEquals(mockMp3Player.currentSong(), list.get(1));
    mockMp3Player.next();
    assertEquals(mockMp3Player.currentSong(), list.get(2));
    mockMp3Player.prev();

    assertEquals(mockMp3Player.currentSong(), list.get(1));
    mockMp3Player.next();
    assertEquals(mockMp3Player.currentSong(), list.get(2));
    mockMp3Player.next();
    assertEquals(mockMp3Player.currentSong(), list.get(3));
    mockMp3Player.next();
    assertEquals(mockMp3Player.currentSong(), list.get(3));
    assertTrue(mockMp3Player.isPlaying());
  }

}