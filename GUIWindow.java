package prj5;

import java.awt.Color;
//import java.awt.Color;
import java.awt.color.*;
//import
import java.io.FileNotFoundException;
import CS2114.Button;
import CS2114.Window;
import CS2114.WindowSide;
import CS2114.Shape;
import CS2114.TextShape;

/**
 * 
 * @author Omarh8
 * @version
 *
 */
public class GUIWindow {
    private Window window;
    private final int dataheight = 10;
    private final int pegwidht = 10;

    private Shape[] pegs;

    private boolean categorize;
    private boolean sortType;

    private boolean setUp;

    private int sortNum;
    private int sortTitle;
    private int index;

    private String topClicked;
    private SongsListSorted musicList;
    private LinkedList<Shape> legendItems;
    private LinkedList<Shape> dataBars;

    private Button previous;
    private Button next;
    private int pegwidth;


    public static void main(String[] args) throws FileNotFoundException {
        new GUIWindow("MusicSurveyDataTest2.csv", "SongListTest2.csv");
    }


    /**
     * @param peopleFile
     *          survey file
     * @param songFile
     *          songFile
     * @throws FileNotFoundException
     */
    
    public GUIWindow(String peopleFile, String songFile)
    throws FileNotFoundException {
        window = new Window();
        window.setTitle("Project 5");
        
        pegs = new Shape[9];
        
        previous = new Button("<-- Previous");
        previous.onClick(this, "clickedPrevious");
        window.addButton(previous, WindowSide.NORTH);
        
        
        Button sortByArtist = new Button("Sort By Artist Name");
        sortByArtist.onClick(this, "clickedSortByArtist");
        window.addButton(sortByArtist, WindowSide.NORTH);
        
        
        Button sortByTitle = new Button("Sort By Song Title");
        sortByTitle.onClick(this, "clickedSortByTitle");
        window.addButton(sortByTitle, WindowSide.NORTH);
        
        
        Button sortByYear = new Button("Sort By Release Year");
        sortByYear.onClick(this, "clickedSortByYear");
        window.addButton(sortByYear, WindowSide.NORTH);
        
        
        Button sortByGenre = new Button("Sort By Genre");
        sortByGenre.onClick(this, "clickedSortByGenre");
        window.addButton(sortByGenre, WindowSide.NORTH);
        
        next = new Button("Next -->");
        next.onClick(this, "clickedNext");
        window.addButton(next, WindowSide.NORTH);
        
        
        Button repByHobby = new Button("Represent Hobby");
        repByHobby.onClick(this, "clickedRepByHobby");
        window.addButton(repByHobby, WindowSide.SOUTH);
        
        
        Button repByMajor = new Button("Represent Major");
        repByMajor.onClick(this, "clickedRepByMajor");
        window.addButton(repByMajor, WindowSide.SOUTH);
        
        Button repByRegion = new Button("Represent Region");
        repByRegion.onClick(this, "clickedRepByRegion");
        window.addButton(repByRegion, WindowSide.SOUTH);
        
        
        Button quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");
        window.addButton(quit, WindowSide.SOUTH);
        
        categorize = false;
        sortType = false;
        setUp = false;
        
        legendItems = new LinkedList<Shape>();
        dataBars = new LinkedList<Shape>();
        
        sortNum = 0;
        sortTitle = 0;
        index = 0;
        musicList = new SongsListSorted(peopleFile, songFile);
            
        this.clickedSortByTitle(sortByTitle);
        
        this.resetButtons();
        
    }


    /**
     * 
     */
    private void resetButtons() {
        previous.disable();

        if (musicList.getSongsList().getLength() <= 9) {
            next.disable();
        }
        else {
            next.enable();
        }
    }


    /**
     * 
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * @param button
     *            Button
     * 
     */
    public void clickedNext(Button button) {
        if (setUp) {
            previous.enable();
            clearBars();
            barsSetup(sortNum);

            if (musicList.getSongsList().getLength() == index) {
                next.disable();
            }

        }

    }


    /**
     * 
     * @param button
     */
    public void clickedPrevious(Button button) {
        if (setUp) {
            // previous.enable();
            clearBars();
            // barsSetUp(sortNum);

            if (index == musicList.getSongsList().getLength()) {
                index = index - ((musicList.getSongsList()).getLength() % 9
                    + 9);
                // next.disable();
            }
            else {
                index -= 18;
            }
            barsSetup(sortNum);

            if (index == 9) {
                previous.disable();
            }
            next.enable();

        }

    }


    /**
     * @param button
     */
    public void clickedSortByArtist(Button button) {
        this.resetButtons();
        sortType = true;
        sortTitle = 1;
        index = 0;
        update();
        musicList.sortByArtist();
        if (setUp) {
            clearBars();
            barsSetup(sortNum);
        }
    }


    /**
     * @param button
     */
    public void clickedSortByTitle(Button button) {
        this.resetButtons();
        sortType = true;
        sortTitle = 1;
        index = 0;
        update();
        musicList.sortByTitle();
        if (setUp) {
            clearBars();
            barsSetup(sortNum);
        }
    }


    /**
     * 
     */
    public void clickedSortByYear(Button button) {
        this.resetButtons();
        sortType = true;
        sortTitle = 0;
        index = 0;
        update();
        musicList.sortByDate();
        if (setUp) {
            clearBars();
            barsSetup(sortNum);
        }
    }


    /**
     * @param button
     */

    public void clickedSortByGenre(Button button) {
        this.resetButtons();
        sortType = true;
        sortTitle = 2;
        index = 0;
        update();
        musicList.sortByGenre();
        if (setUp) {
            clearBars();
            barsSetup(sortNum);
        }
    }


    /**
     * @param button
     */
    public void clickedRepByHobby(Button button) {
        topClicked = "Hobby";
        categorize = true;
        sortNum = 1;

        if (index == musicList.getSongsList().getLength()) {
            index = index - (musicList.getSongsList().getLength() % 9);
        }

        else if (index != 0) {
            index = index - 9;
        }

        if (sortType && !setUp) {
            update();
        }
        if (setUp) {
            legendSetUp();
            clearBars();
            barsSetup(sortNum);
        }
    }


    /**
     * @param button
     */
    public void clickedRepByMajor(Button button) {

        topClicked = "Major";
        categorize = true;
        sortNum = 2;

        if (index == musicList.getSongsList().getLength()) {
            index = index - (musicList.getSongsList().getLength() % 9);
        }

        else if (index != 0) {
            index = index - 9;
        }

        if (sortType && !setUp) {
            update();
        }
        if (setUp) {
            legendSetUp();
            clearBars();
            barsSetup(sortNum);
        }

    }


    /**
     * @param button
     */
    public void clickedRepByRegion(Button button) {
        topClicked = "Region";
        categorize = true;
        sortNum = 3;

        if (index == musicList.getSongsList().getLength()) {
            index = index - (musicList.getSongsList().getLength() % 9);
        }

        else if (index != 0) {
            index = index - 9;
        }

        if (sortType && !setUp) {
            update();
        }
        if (setUp) {
            legendSetUp();
            clearBars();
            barsSetup(sortNum);
        }

    }


    /**
     * updates pegs and legends
     */
    private void update() {
        if (categorize && sortType && !setUp) {
            this.clearPegs();
            this.addPegs();
            legendSetUp();
            setUp = true;
        }
    }


    /**
     * @param sortNumber
     *            Add by naming it setGlyph
     */
    private void barsSetup(int sortNumber) {
        int x = 1;
        int y = 1;
        int maxlength = 9;
        if (musicList.getSongsList().getLength() < index + 9) {
            maxlength = musicList.getSongsList().getLength() - index;
        }
        for (int i = 0; i < maxlength; i++) {
            setGlyph(musicList.getSongsList().getEntry(index)
                .percentOfHeardSongs(), musicList.getSongsList().getEntry(index)
                    .percentOfLikedSongs(), sortNumber, x, y, musicList
                        .getSongsList().getEntry(index));
            x = (x + 1) % 4;
            if (x == 0) {
                y++;
                x++;
            }
            index = (index + 1);
        }
    }


    /**
     * @param heard
     * @param liked
     * @param sortNumber
     * @param x
     * @param y
     * @param song
     * 
     */
    private void setGlyph(
        int[] heard,
        int[] liked,
        int sortNumber,
        int x,
        int y,
        Song song) {
         x = 210 * (x - 1) + 101;
         x = 90 * (y - 1) + 85;
         
         Shape barM1 = new Shape(x - heard[((sortNumber - 1) * 4)], y - 30,
             heard[((sortNumber - 1) * 4)], dataheight, Color.MAGENTA);
         Shape barN1 = new Shape(x + 10,  y - 30, liked[((sortNumber - 1) * 4)],
              dataheight, Color.MAGENTA);
         Shape barM2 = new Shape(x - heard[((sortNumber - 1) * 4)], y - 20,
             heard[1 + ((sortNumber - 1) * 4)], dataheight, Color.BLUE);
         Shape barN2 = new Shape(x + 10, y - 20, liked[1 + ((sortNumber - 1) * 4)],
             dataheight, Color.BLUE);
         Shape barM3 = new Shape(x - heard[2 + ((sortNumber - 1) * 4)], y - 10,
             heard[2 + ((sortNumber - 1) * 4)], dataheight, Color.ORANGE);
         Shape barN3 = new Shape(x + 10, y - 10, liked[2 + ((sortNumber - 1) * 4)],
             dataheight, Color.ORANGE);
         Shape barM4 = new Shape(x - heard[3 + ((sortNumber - 1) * 4)], y,
             heard[3 + ((sortNumber - 1) * 4)], dataheight, Color.GREEN);
         Shape barN4 = new Shape(x + 10, y, liked[3 + ((sortNumber - 1) * 4)],
             dataheight, Color.GREEN);
         
         
         window.addShape(barM1);
         window.addShape(barN1);
         window.addShape(barM2);
         window.addShape(barN2);
         window.addShape(barM3);
         window.addShape(barN3);
         window.addShape(barM4);
         window.addShape(barN4);
         
         dataBars.add(barM1);
         dataBars.add(barN1);
         dataBars.add(barM2);
         dataBars.add(barN2);
         dataBars.add(barM3);
         dataBars.add(barN3);
         dataBars.add(barM4);
         dataBars.add(barN4);
         
         String title = song.getTitle();
         
         if (title.length() > 26) {
             String secondTitle = title.substring(21);
             title = title.substring(0,  21);
             Shape songTitle = new TextShape(x - 100, y - 80, title);
             window.addShape(songTitle);
             songTitle.setBackgroundColor(Color.WHITE);
             dataBars.add(songTitle);
             Shape songTitle2 = new TextShape(x - 100, y - 65, secondTitle);
             window.addShape(songTitle2);
             songTitle2.setBackgroundColor(Color.WHITE);
             dataBars.add(songTitle2);
         }
         
         else {
             Shape songTitle = new TextShape(x - 100, y - 65, song.getTitle());
             window.addShape(songTitle);
             songTitle.setBackgroundColor(Color.WHITE);
             dataBars.add(songTitle);
         }
         
         if (sortTitle == 1) {
             Shape songArtist = new TextShape(x - 100, y - 50, "by, " + song
                 .getArtist());
             window.addShape(songArtist);
             songArtist.setBackgroundColor(Color.WHITE);
             dataBars.add(songArtist);
             
         }
         
         else if (sortTitle == 2) {
             Shape songGenre = new TextShape(x - 100, y - 50, "Genre, " + song
                 .getGenre());
             window.addShape(songGenre);
             songGenre.setBackgroundColor(Color.WHITE);
             dataBars.add(songGenre);
             
         }
         
         else {
             Shape songReleased = new TextShape(x - 100, y - 50, "Released: " + song
                 .getDate());
             window.addShape(songReleased);
             songReleased.setBackgroundColor(Color.WHITE);
             dataBars.add(songReleased);
         }
    }


    /**
     * add the pegs on window
     */
    private void addPegs() {
        int windowwidth = window.getWidth();
        int windowheight = window.getHeight();

        pegs[0] = new Shape((windowwidth / 2) - 290, windowheight - 345,
            pegwidth , 40, Color.BLACK);
        pegs[0].setBackgroundColor(Color.BLACK);
        window.addShape(pegs[0]);

        pegs[1] = new Shape((windowwidth / 2) - 80, windowheight - 345,
            pegwidth, 40, Color.BLACK);
        pegs[1].setBackgroundColor(Color.BLACK);
        window.addShape(pegs[1]);

        pegs[2] = new Shape((windowwidth / 2) + 130, windowheight - 345,
            pegwidth, 40, Color.BLACK);
        pegs[2].setBackgroundColor(Color.BLACK);
        window.addShape(pegs[2]);

        pegs[3] = new Shape((windowwidth / 2) - 290, windowheight - 255,
            pegwidth, 40, Color.BLACK);
        pegs[3].setBackgroundColor(Color.BLACK);
        window.addShape(pegs[3]);

        pegs[4] = new Shape((windowwidth / 2) - 80, windowheight - 255,
            pegwidth, 40, Color.BLACK);
        pegs[4].setBackgroundColor(Color.BLACK);
        window.addShape(pegs[4]);

        pegs[5] = new Shape((windowwidth / 2) + 130, windowheight - 255,
            pegwidth, 40, Color.BLACK);
        pegs[5].setBackgroundColor(Color.BLACK);
        window.addShape(pegs[5]);

        pegs[6] = new Shape((windowwidth / 2) - 290, windowheight - 165,
            pegwidth, 40, Color.BLACK);
        pegs[6].setBackgroundColor(Color.BLACK);
        window.addShape(pegs[6]);

        pegs[7] = new Shape((windowwidth / 2) - 80, windowheight - 165,
            pegwidth, 40, Color.BLACK);
        pegs[7].setBackgroundColor(Color.BLACK);
        window.addShape(pegs[7]);

        pegs[8] = new Shape((windowwidth / 2) + 130, windowheight - 165,
            pegwidth, 40, Color.BLACK);
        pegs[8].setBackgroundColor(Color.BLACK);
        window.addShape(pegs[8]);

    }

    /**
     * @param Represent
     *            orgs type
     * @param one
     *            first legend name
     * @param two
     *            second legend name
     * @param three
     *            third legend name
     * @param four
     *            fourth legend name
     */
    
    private void LegendHelper(
        String Represent,
        String one,
        String two,
        String three,
        String four) {
            int windowwidth = window.getWidth();
            int windowheight = window.getHeight();
            
            TextShape legendtitle = new TextShape(windowwidth - 130, windowheight 
                -290, Represent + "Legend", Color.BLACK);
            legendtitle.setBackgroundColor(Color.WHITE);
            window.addShape(legendtitle);
            
            TextShape sort1 = new TextShape(windowwidth - 130, windowheight 
                -270, one, Color.MAGENTA);
            sort1.setBackgroundColor(Color.WHITE);
            window.addShape(sort1);
            
            TextShape sort2 = new TextShape(windowwidth - 130, windowheight 
                -250, two, Color.BLUE);
            sort2.setBackgroundColor(Color.WHITE);
            window.addShape(sort2);
            
            
            TextShape sort3 = new TextShape(windowwidth - 130, windowheight 
                -230, three, Color.ORANGE);
            sort3.setBackgroundColor(Color.WHITE);
            window.addShape(sort3);
            
            TextShape sort4 = new TextShape(windowwidth - 130, windowheight 
                -210, four, Color.GREEN);
            sort4.setBackgroundColor(Color.WHITE);
            window.addShape(sort4);
            
            
            TextShape songTitle = new TextShape(windowwidth - 110, windowheight 
                -190, "Song Title", Color.BLACK);
            songTitle.setBackgroundColor(Color.WHITE);
            window.addShape(songTitle);
            
            
            TextShape heard = new TextShape(windowwidth - 130, windowheight 
                -150, "Heard", Color.BLACK);
            heard.setBackgroundColor(Color.WHITE);
            window.addShape(heard);
            
            
            TextShape likes = new TextShape(windowwidth - 60, windowheight 
                -150, "Likes", Color.BLACK);
            likes.setBackgroundColor(Color.WHITE);
            window.addShape(likes);
            
            
            
            //int pegwidth;
            Shape peg = new Shape(windowwidth - 75, windowheight - 160, pegwidth,
                40, Color.BLACK);
            peg.setBackgroundColor(Color.BLACK);
            window.addShape(peg);
            
            
            Shape legendbox = new Shape(windowwidth - 140, windowheight - 300, 120,
                190, Color.BLACK);
            legendbox.setBackgroundColor(Color.WHITE);
            window.addShape(legendbox);
            
            
            legendItems.add(legendtitle);
            legendItems.add(sort1);
            legendItems.add(sort2);
            legendItems.add(sort3);
            legendItems.add(sort4);
            legendItems.add(songTitle);
            legendItems.add(heard);
            legendItems.add(likes);
            legendItems.add(peg);
            legendItems.add(legendbox);
            
            addPegs();
            
        }


    /**
     * determines the field the legend
     * will set into
     */
    private void legendSetUp() {
        if (setUp) {
            clearLegend();
        }

        if (topClicked.equals("Hobby")) {
            this.LegendHelper(topClicked, "Read", "Art", "sports", "Music");
        }

        else if (topClicked.equals("Major")) {
            this.LegendHelper(topClicked, "Comp Sci", "Other Eng", "Math/CMDA",
                "Other");
        }

        else {
            this.LegendHelper("Region", "Northeast US", "Southeast US",
                " the rest of US", "outside the US");
        }
    }


    /**
     * remove shapes
     */
    private void clearLegend() {
        for (int i = 0; i < legendItems.getLength(); i++) {
            window.removeShape(legendItems.getEntry(i));
        }

        legendItems.clear();

    }


    /**
     * remove bar shapes
     */
    private void clearBars() {
        for (int i = 0; i < dataBars.getLength(); i++) {
            window.removeShape(dataBars.getEntry(i));
        }

        dataBars.clear();

    }


    /**
     * remove bar shapes
     */
    private void clearPegs() {
        for (int i = 0; i < pegs.length; i++) {
            if (pegs[i] != null) {
                window.removeShape(pegs[i]);
            }
        }
    }
}


