package prj5;

import student.TestCase;
// import static org.junit.jupiter.api.Assertions.*;
// import org.junit.jupiter.api.Test;

/**
 * 
 * @author Omarh8
 * @version 11.16.2018
 *          This is the compare class
 *
 */
public class CompareSongsTest extends TestCase {

    private Song testA;
    private Song testB;
    private Song testC;
    private Song testD;
    // private Song testE;
    private Song same;
    private Song testNullSong;


    /**
     * 
     */
    public void setUp() {
        testA = new Song("SongName", "Genre", "Artist", 2018);
        testNullSong = null;
        same = new Song("SongName", "Genre", "Artist", 2018);
        testB = new Song("Different", "Genre", "Artist", 2018);
        testC = new Song("SongName", "Different", "Artist", 2018);
        testD = new Song("SongName", "Genre", "Different", 2018);
        // Song testE = new Song("SongName", "Genre", "Artist", 2018);
        // testE = "SongName", "Genre", "Artist", 2018);
        @SuppressWarnings("unused")
        CompareSongs compare = new CompareSongs();
    }

    // private void testE(String string, String string2, String string3, int i)
    // {
    // TODO Auto-generated method stub

    // }


    /**
     * 
     */
    public void testCompareNull() {
        Exception e = null;
        try {
            CompareSongs.compareArtist(testA, testNullSong);
        }
        catch (Exception exception) {
            e = exception;
        }
        e = null;
        try {
            CompareSongs.compareArtist(testNullSong, testA);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    /**
     * 
     */
    public void testArtistCompareSame() {
        assertEquals(0, CompareSongs.compareArtist(testA, same));
    }


    /**
     * 
     */
    public void testArtistCompareDiffrent() {
        assertEquals(-3, CompareSongs.compareArtist(testA, testD));
        assertEquals(3, CompareSongs.compareArtist(testD, testA));

    }


    /**
     * 
     */
    public void testTitleCompareNull() {
        Exception e = null;
        try {
            CompareSongs.compareTitleSong(testA, testNullSong);
        }
        catch (Exception exception) {
            e = exception;
        }
        e = null;
        try {
            CompareSongs.compareTitleSong(testNullSong, testA);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    /**
     * 
     */
    public void testTitleCompareSame() {
        assertEquals(0, CompareSongs.compareTitleSong(testA, same));
    }


    /**
     * 
     */
    public void testTitleCompareDiffrent() {
        assertEquals(15, CompareSongs.compareTitleSong(testA, testB));
        assertEquals(-15, CompareSongs.compareTitleSong(testB, testA));
    }


    /**
     * 
     */
    public void testGenreCompareNull() {
        Exception e = null;
        try {
            CompareSongs.compareGenre(testA, testNullSong);
        }
        catch (Exception exception) {
            e = exception;
        }
        e = null;
        try {
            CompareSongs.compareGenre(testNullSong, testA);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    /**
     * 
     */
    public void testGenreCompareSame() {
        assertEquals(0, CompareSongs.compareTitleSong(testA, same));
    }


    /**
     * 
     */
    public void testGenreeCompareDiffrent() {
        assertEquals(3, CompareSongs.compareGenre(testA, testC));
        assertEquals(-3, CompareSongs.compareGenre(testC, testA));
    }

    /**
     * 
     * public void testDateCompareNull() {
     * Exception e = null;
     * try {
     * int x = CompareSongs.compareDate(testA, testNullSong);
     * }
     * catch (Exception exception) {
     * e = exception;
     * }
     * assertTrue(e instanceof IllegalArgumentException);
     * }
     * 
     * public void testDateCompareSame() {
     * int x = CompareSongs.compareDate(testA, same);
     * assertEquals(0, x);
     * }
     * 
     * public void testDateCompareDiffrent() {
     * int x = CompareSongs.compareDate(testA, testE);
     * int y = CompareSongs.compareDate(testE, testA);
     * assertEquals(-1, x);
     * assertEquals(1, y);
     * }
     */
}
