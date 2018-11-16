package prj5;

/**
 * 
 * @author Omarh8
 * @version 11.16.2018
 * This is the compare class
 *
 */
public class CompareSongs {
    /**
     * @param songA
     *            It is first type
     * @param songB
     *            It is second type
     * @return It returns a value
     */
    public static int compareTitleSong(Song songA, Song songB) {
        if (songA == null || songB == null) {
            throw new IllegalArgumentException();
        }
        if (songA.equals(songB)) {
            return 0;
        }
        return songA.getTitle().compareTo(songB.getTitle());
    }


    /**
     * @param songA
     *            It is first type
     * @param songB
     *            It is first type
     * @return returns the compare artist
     */
    public static int compareArtist(Song songA, Song songB) {
        if (songA == null || songB == null) {
            throw new IllegalArgumentException();
        }
        if (songA.equals(songB)) {
            return 0;
        }
        return songA.getArtist().compareTo(songB.getArtist());
    }


    /**
     * @param songA
     *            It is first type
     * @param songB
     *            It is second type
     * @return returns the compare artist
     */
    public static int compareGenre(Song songA, Song songB) {
        if (songA == null || songB == null) {
            throw new IllegalArgumentException();
        }
        if (songA.equals(songB)) {
            return 0;
        }
        return songA.getGenre().compareTo(songB.getGenre());
    }


    /**
     * @param songA
     *            It is first type
     * @param songB
     *            It is second type
     * @return returns the compare date
     */
    public static int compareDate(Song songA, Song songB) {
        if (songA == null || songB == null) {
            throw new IllegalArgumentException();
        }
        if (songA.equals(songB)) {
            return 0;
        }
        else if (songA.getDate() > songB.getDate()) {
            return 1;
        }
        else {

            return -1;
        }
    }
}
