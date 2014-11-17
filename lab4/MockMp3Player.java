import java.util.ArrayList;

public class MockMp3Player implements Mp3Player {

  /** 
   * Begin playing the filename at the top of the
   * play list, or do nothing if playlist 
   * is empty. 
   */

  String state;
  double position = 0;
  ArrayList<String> songs = new ArrayList();
  int songinlist = 0;


  public MockMp3Player() {
  	state = "stopped";
  	position = 0;
    songinlist = 0;
  }
     

  public void play() {
  	if (songs.size() > 0) {
        state = "playing";
        position = 5;
    }
  }

  /** 
   * Pause playing. Play will resume at this spot. 
   */
  public void pause() {
  	if(state.equals("playing")) {
  	    state = "paused";
  	}
  }

  /** 
   * Stop playing. The current song remains at the
   * top of the playlist, but rewinds to the 
   * beginning of the song.
   */
  public void stop() {
  	state = "stopped";
  	position = 0;
  }
  
  /** Returns the number of seconds into 
   * the current song.
   */
  public double currentPosition() {
    return position;
  }


  /**
   * Returns the currently playing file name.
   */
  public String currentSong() {
  	return songs.get(songinlist);
  }

  /** 
   * Advance to the next song in the playlist 
   * and begin playing it.
   */
  public void next() {
  	if(songs.size() > 0) {
	  	if(songinlist < songs.size()-1) {
	  		songinlist++;
	  	} else {
	  	}
	  	state = "playing";
	  	position = 5;
    }
  }

  /**
   * Go back to the previous song in the playlist
   * and begin playing it.
   */
  public void prev() {
  	if(songs.size() > 0) {
	   	if (songinlist == 0)  {
	  		return;
	  	}
	  	if(songinlist > 0) {
	  		songinlist--;
	  	} else {
	  		songinlist = songs.size()-1;
	  	}
	}
  }

  /** 
   * Returns true if a song is currently 
   * being played.
   */
  public boolean isPlaying() {
  	if(state.equals("playing")) {
  		return true;
  	} else {
  		return false;
  	}
  }

  /**
   * Load filenames into the playlist.
   */
  public void loadSongs(ArrayList names) {
  	songs = new ArrayList<String>(names.subList(0,names.size()));
  	}
  }
}