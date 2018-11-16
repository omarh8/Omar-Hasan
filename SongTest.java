package prj5;

import java.util.Arrays;
import student.TestCase;

/**
 * 
 * @author Omarh8
 * @version 11.15.2018
 *
 */

public class SongTest extends TestCase {
    private Song song;


    /**
     * it si the setup
     */
    public void setUp() {
        song = new Song("SongName", "Genre", "Artist", 2018);

    }


    /**
     * sets parameter
     */
    public void testGetTitle() {
        assertEquals("SongName", song.getTitle());
    }


    /**
     * sets parameter
     */
    public void testArtist() {
        assertEquals("Artist", song.getArtist());
    }


    /**
     * sets parameter
     */
    public void testGenre() {
        assertEquals("Genre", song.getGenre());
    }


    /**
     * sets getData
     */
    public void testGetDataOfRelease() {
        assertEquals(2018, song.getDate());
    }


    /**
     * 
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testEquals() {
        Song song2 = null;
        assertFalse(song.equals(song2));
        Song song3 = song;
        assertTrue(song.equals(song3));
        Song song4 = new Song("SongName", "Genre", "Artist", 2018);
        assertTrue(song.equals(song4));
        Song song5 = new Song("Different", "Genre", "Artist", 2018);
        assertFalse(song.equals(song5));
        Song song6 = new Song("SongName", "Different", "Artist", 2018);
        assertFalse(song.equals(song6));
        Song song7 = new Song("SongName", "Genre", "Different", 2018);
        assertFalse(song.equals(song7));
        Song song8 = new Song("SongName", "Genre", "Artist", 2000);
        assertFalse(song.equals(song8));
        Song song9 = new Song("Diff", "Diff", "Diff", 2998);
        assertFalse(song.equals(song9));
        String str = "test";
        assertFalse(song.equals(str));
    }


    /**
     * get LikedSong
     */
    public void testGetLikedSongs() {
        int[] test = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        assertTrue(Arrays.equals(test, song.getLikedSongs()));
        song.increaseLikedSongs(3);
        assertFalse(Arrays.equals(test, song.getLikedSongs()));
        test[3] = 1;
        assertTrue(Arrays.equals(test, song.getLikedSongs()));
    }


    /**
     * heard songs
     */
    public void testGetTotalSongs() {
        int[] test = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        assertTrue(Arrays.equals(test, song.getTotal1()));
        song.increaseTotal1(3);
        assertFalse(Arrays.equals(test, song.getTotal1()));
        test[3] = 1;
        assertTrue(Arrays.equals(test, song.getTotal1()));
        int[] test1 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        assertTrue(Arrays.equals(test1, song.getTotal2()));
        song.increaseTotal2(3);
        assertFalse(Arrays.equals(test1, song.getTotal2()));
        test1[3] = 1;
        assertTrue(Arrays.equals(test1, song.getTotal2()));
    }


    /**
     * heardsongs
     */
    public void testGetHeardSongs() {

        int[] test = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        assertTrue(Arrays.equals(test, song.getHeardSongs()));
        song.increaseHeardSongs(3);
        assertFalse(Arrays.equals(test, song.getHeardSongs()));
        test[3] = 1;
        assertTrue(Arrays.equals(test, song.getHeardSongs()));

    }


    /**
     * string
     */
    public void testToString() {
        StringBuilder s = new StringBuilder("Song Title: ");
        s.append("SongName\n");
        s.append("Song Artist: " + "Artist" + "\n");
        s.append("Song Genre: " + "Genre" + "\n");
        s.append("Song Year: " + 2018 + "\n");
        assertTrue(song.toString().equals(s.toString()));

        for (int i = 0; i < 90; i++) {
            song.increaseHeardSongs(1);
        }

        song.increaseLikedSongs(1);
        for (int i = 0; i < 100; i++) {
            song.increaseTotal1(1);
        }

        song.increaseTotal2(1);
        song.increaseHeardSongs(1);
        song.increaseLikedSongs(1);
        song.increaseTotal1(1);
        song.increaseTotal2(1);
        s.append("Heard" + "\n" + "reading" + 0 + " art" + 90 + " sports" + 0
            + " music" + 0 + "\n" + "Likes" 
            + "\n" + "reading" + 0 + " art"
            + 100 + " sports" + 0 + " music" + 0 + "\n");

        assertEquals(song.toString("hobby"), s.toString());

        StringBuilder s2 = new StringBuilder("Song Title: ");
        s2.append("SongName\n");
        s2.append("Song Artist: " + "Artist" + "\n");
        s2.append("Song Genre: " + "Genre" + "\n");
        s2.append("Song Year: " + 2018 + "\n");
        // assertTrue(song.toString().equals(s.toString()));
        song.increaseHeardSongs(5);
        song.increaseLikedSongs(5);
        // song.increaseLikedSongs(1);
        song.increaseTotal1(5);
        song.increaseTotal2(5);
        s2.append("Heard" + "\n" + "Computer Science" + 0 + " Other Engineering"
            + 100 + " Math or CMDA" + 0 + " Other" + 0 + "\n" + "Likes" + "\n"
            + "Computer Science" + 0 + " Other Engineering" + 100
            + " Math or CMDA" + 0 + " Other" + 0 + "\n");

        assertEquals(s2.toString(), song.toString("major"));

        StringBuilder s3 = new StringBuilder("Song Title: ");
        s3.append("SongName\n");
        s3.append("Song Artist: " + "Artist" + "\n");
        s3.append("Song Genre: " + "Genre" + "\n");
        s3.append("Song Year: " + 2018 + "\n");
        // assertTrue(song.toString().equals(s.toString()));
        song.increaseHeardSongs(9);
        song.increaseLikedSongs(9);
        // song.increaseLikedSongs(1);
        song.increaseTotal1(9);
        song.increaseTotal2(9);
        s3.append("Heard" + "\n" + "NorthEast US" + 0 + " SouthEast US" + 100
            + " Rest Of US" + 0 + " Outside US" + 0 + "\n" + "Likes" + "\n"
            + "NorthEast US" + 0 + " SouthEast US" + 100 + " Rest Of US" + 0
            + " Outside US" + 0 + "\n");
        System.out.println(s3.toString());
        System.out.println(song.toString("region"));

        assertEquals(song.toString("region"), s3.toString());
    }

}
