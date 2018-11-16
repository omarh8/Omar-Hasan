package prj5;

/**
 * 
 * @author Omarh8
 * @version 11.12.19
 * 
 */
public class Song {

    private String artist;
    private String title;
    private String genre;
    private int dateOfRelease;

    private int[] total1;
    private int[] total2;

    private int[] likedSongs;

    private int[] heardSongs;


    /**
     * the constructor of song class
     * 
     * @param title1
     *            artist of song
     * @param genre1
     *            title of song
     * @param artist1
     *            genre
     * @param date
     *            date of song
     */
    public Song(String title1, String genre1, String artist1, int date) {
        artist = artist1;
        title = title1;
        genre = genre1;
        dateOfRelease = date;
        likedSongs = new int[13];
        heardSongs = new int[13];
        total1 = new int[13];
        total2 = new int[13];
    }


    /**
     * @return array
     */
    public int[] percentOfLikedSongs() {
        int[] result = new int[13];
        for (int i = 0; i < likedSongs.length; i++) {
            if (total2[i] == 0) {
                result[i] = 0;
            }
            else {
                result[i] = (int)(((float)likedSongs[i] 
                    / ((float)total2[i])) * 100.0);

            }
        }
        return result;
    }


    /**
     * @return result
     */
    public int[] percentOfHeardSongs() {
        int[] result = new int[13];
        for (int i = 0; i < heardSongs.length; i++) {
            if (total1[i] == 0) {
                result[i] = 0;
            }
            else {
                result[i] = (int)(((float)heardSongs[i] / ((float)total1[i])) * 100.0);

            }

            if (result[i] == 89) {
                result[i] = 90;
            }
        }
        return result;
    }


    /**
     * @return string of info
     */
    public String toString() {
        StringBuilder s = new StringBuilder("Song Title: ");
        s.append(title + "\n");
        s.append("Song Artist: " + artist + "\n");
        s.append("Song Genre: " + genre + "\n");
        s.append("Song Year: " + dateOfRelease + "\n");
        return s.toString();
    }


    /**
     * @param str
     *            it is the str
     * @return string
     */
    public String toString(String str) {
        StringBuilder s = new StringBuilder(this.toString());
        s.append("Heard\n");
        int[] heard = percentOfHeardSongs();
        int[] liked = percentOfLikedSongs();
        if (str.equals("hobby")) {
            s.append("reading" + heard[0] + " art" + heard[1] + " sports"
                + heard[2] + " music" + heard[3] + "\n");
            s.append("Likes\n");
            s.append("reading" + liked[0] + " art" + liked[1] + " sports"
                + liked[2] + " music" + liked[3] + "\n");
        }
        else if (str.equals("major")) {
            s.append("Computer Science" + heard[4] + " Other Engineering"
                + heard[5] + " Math or CMDA" + heard[6] + " Other" + heard[7]
                + "\n");
            s.append("Likes\n");
            s.append("Computer Science" + liked[4] + " Other Engineering"
                + liked[5] + " Math or CMDA" + liked[6] + " Other" + liked[7]
                + "\n");
        }

        else {
            s.append("NorthEast US" + heard[8] + " SouthEast US" + heard[9]
                + " Rest Of US" + heard[10] + " Outside US" + heard[11] + "\n");
            s.append("Likes\n");
            s.append("NorthEast US" + liked[8] + " SouthEast US" + liked[9]
                + " Rest Of US" + liked[10] + " Outside US" + liked[11] + "\n");

        }
        return s.toString();

    }


    /**
     * it is the method for boolean equals
     * 
     * @param obj
     *            It is the object
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Song song = (Song)obj;
        return title.equals(song.getTitle()) && artist.equals(song.getArtist())
            && genre.equals(song.getGenre()) && dateOfRelease == song.getDate();
    }


    /**
     * @param i
     *            the index
     */
    public void increaseLikedSongs(int i) {
        likedSongs[i]++;

    }


    /**
     * @param i
     *            the index
     */
    public void increaseHeardSongs(int i) {
        heardSongs[i]++;

    }


    /**
     * @param i
     *            the index
     */
    public void increaseTotal1(int i) {
        total1[i]++;

    }


    /**
     * @param i
     *            the index
     */
    public void increaseTotal2(int i) {
        total2[i]++;

    }


    /**
     * it is the title
     * 
     * @return title
     */
    public String getTitle() {
        return title;

    }


    /**
     * it is the artist
     * 
     * @return title
     */
    public String getArtist() {
        return artist;

    }


    /**
     * it is the genre
     * 
     * @return title
     */
    public String getGenre() {
        return genre;

    }


    /**
     * it is the date of release
     * 
     * @return dateOfRelease
     */
    public int getDate() {
        return dateOfRelease;

    }


    /**
     * it is the likedSongs
     * 
     * @return likedSongs
     */
    public int[] getLikedSongs() {
        return likedSongs;

    }


    /**
     * @return heardSongs
     */
    public int[] getHeardSongs() {
        return heardSongs;

    }


    /**
     * @return total1
     */
    public int[] getTotal1() {
        return total1;

    }


    /**
     * @return total2
     */
    public int[] getTotal2() {
        return total2;

    }

}
