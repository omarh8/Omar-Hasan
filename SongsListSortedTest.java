package prj5;

import student.TestCase;
// import org.junit.jupiter.api.Test;

/**
 * 
 * @author Omarh8
 * @version 11.15.2018
 *
 */

public class SongsListSortedTest extends TestCase {
    private LinkedList<Song> testSongs;
    private SongsListSorted testSortedList;


    /**
     * setup method
     */
    public void setUp() {
        testSongs = new LinkedList<Song>();
        Song testSong1 = new Song("a", "b", "c", 1);
        Song testSong2 = new Song("d", "e", "f", 2);
        Song testSong3 = new Song("g", "h", "i", 3);
        Song testSong4 = new Song("a", "b", "c", 1);
        testSongs.add(testSong1);
        testSongs.add(testSong2);
        testSongs.add(testSong3);
        testSongs.add(testSong4);
        testSortedList = new SongsListSorted(testSongs);
    }


    /**
     * getters method
     */
    public void testGetters() {
        assertEquals(testSongs, testSortedList.getSongsList());
    }


    /**
     * sort methods
     */
    public void testSortByMethod() {
        testSortedList.sortByArtist();
        Song song1 = testSortedList.getSongsList().getEntry(0);
        Song song2 = testSortedList.getSongsList().getEntry(1);
        Song song3 = testSortedList.getSongsList().getEntry(2);

        assertEquals(0, CompareSongs.compareArtist(song1, song2));
        assertEquals(-3, CompareSongs.compareArtist(song2, song3));
        assertEquals(-3, CompareSongs.compareArtist(song1, song3));

        testSortedList.sortByTitle();
        Song song5 = testSortedList.getSongsList().getEntry(0);
        Song song6 = testSortedList.getSongsList().getEntry(1);
        Song song7 = testSortedList.getSongsList().getEntry(2);
        Song song8 = testSortedList.getSongsList().getEntry(3);

        assertEquals(0, CompareSongs.compareTitleSong(song5, song6));
        assertEquals(-3, CompareSongs.compareTitleSong(song6, song7));
        assertEquals(-3, CompareSongs.compareTitleSong(song7, song8));

        testSortedList.sortByGenre();
        Song song9 = testSortedList.getSongsList().getEntry(0);
        Song song10 = testSortedList.getSongsList().getEntry(1);
        Song song11 = testSortedList.getSongsList().getEntry(2);
        Song song12 = testSortedList.getSongsList().getEntry(3);

        assertEquals(0, CompareSongs.compareGenre(song9, song10));
        assertEquals(-3, CompareSongs.compareGenre(song10, song11));
        assertEquals(3, CompareSongs.compareGenre(song12, song11));

        testSortedList.sortByDate();
        Song song13 = testSortedList.getSongsList().getEntry(0);
        Song song14 = testSortedList.getSongsList().getEntry(1);
        Song song15 = testSortedList.getSongsList().getEntry(2);
        Song song16 = testSortedList.getSongsList().getEntry(3);

        assertEquals(0, CompareSongs.compareDate(song13, song14));
        assertEquals(-1, CompareSongs.compareDate(song14, song15));
        assertEquals(-1, CompareSongs.compareDate(song15, song16));
    }
}
