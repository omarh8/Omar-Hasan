package prj5;

import java.io.FileNotFoundException;
import java.util.Iterator;

/**
 * 
 * @author Omarh8
 * @version 11.15.2018
 *
 */

public class SongsListSorted {
    private LinkedList<Song> songsList;


    /**
     * @param songs
     *            it is the songs
     */
    public SongsListSorted(LinkedList<Song> songs) {
        songsList = songs;
    }


    /**
     * @param survey
     *            the data
     * @param songs
     *            can be heard
     * @throws FileNotFoundException
     *             unavailable
     */
    public SongsListSorted(String survey, String songs)
        throws FileNotFoundException {
        songsList = (new Input(survey, songs)).getList();
    }


    /**
     * @return list of songs
     */
    public LinkedList<Song> getSongsList() {
        return this.songsList;
    }


    /**
     * sorts by iterator
     */
    public void sortByArtist() {
        Iterator<Song> currentIterator = songsList.iterator();
        int i = 0;
        for (; i < songsList.getLength(); i++) {
            Song thisSong = currentIterator.next();
            Iterator<Song> nextIterator = songsList.iterator();
            int index = 0;
            for (; index <= i; index++) {
                Song nextSong = nextIterator.next();
                if (CompareSongs.compareArtist(thisSong, nextSong) < 0) {
                    Song replacement = songsList.replace(i, nextSong);
                    thisSong = songsList.replace(index, replacement);
                }

            }
        }
    }


    /**
     * by title
     */

    public void sortByTitle() {
        Iterator<Song> currentIterator = songsList.iterator();
        int i = 0;
        for (; i < songsList.getLength(); i++) {
            Song thisSong = currentIterator.next();
            Iterator<Song> nextIterator = songsList.iterator();
            int index = 0;
            for (; index <= i; index++) {
                Song nextSong = nextIterator.next();
                if (CompareSongs.compareTitleSong(thisSong, nextSong) < 0) {
                    Song replacement = songsList.replace(i, nextSong);
                    thisSong = songsList.replace(index, replacement);
                }

            }
        }
    }


    /**
     * genre by sorting
     */
    public void sortByGenre() {
        Iterator<Song> currentIterator = songsList.iterator();
        int i = 0;
        for (; i < songsList.getLength(); i++) {
            Song thisSong = currentIterator.next();
            Iterator<Song> nextIterator = songsList.iterator();
            int index = 0;
            for (; index <= i; index++) {
                Song nextSong = nextIterator.next();
                if (CompareSongs.compareGenre(thisSong, nextSong) < 0) {
                    Song replacement = songsList.replace(i, nextSong);
                    thisSong = songsList.replace(index, replacement);
                }

            }
        }
    }


    /**
     * sort by date
     */
    public void sortByDate() {
        Iterator<Song> currentIterator = songsList.iterator();
        int i = 0;
        for (; i < songsList.getLength(); i++) {
            Song thisSong = currentIterator.next();
            Iterator<Song> nextIterator = songsList.iterator();
            int index = 0;
            for (; index <= i; index++) {
                Song nextSong = nextIterator.next();
                if (CompareSongs.compareDate(thisSong, nextSong) < 0) {
                    Song replacement = songsList.replace(i, nextSong);
                    thisSong = songsList.replace(index, replacement);
                }

            }
        }
    }

}
