package prj5;

import java.io.File;
import java.io.File.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Omarh8
 *
 */

public class Input {
    private LinkedList<Song> list;
    public static void main(String[] args) throws FileNotFoundException {
        SongsListSorted temp;
        if (args.length > 0) {
            temp = new SongsListSorted(args[0], args[1]);
        }
            else {
                temp = new SongsListSorted("MusicSurveyDataTest1.csv","SongListTest1.csv");
            }
            temp.sortByGenre();
            System.out.println(temp.getSongsList().toString("hobby"));
            temp.sortByTitle();
            System.out.println(temp.getSongsList().toString("hobby"));
        }
    
    
    /**
     * 
     */
    public Input(String peopleFile, String songFile)
    throws FileNotFoundException {
        list = new LinkedList<Song>();
        readSurvey(peopleFile, songFile);
    }
    
    private void readSurvey(String peopleFile, String songFile)
    throws FileNotFoundException {
        Scanner scanSong = new Scanner(new File(songFile));
        scanSong.nextLine();
        while (scanSong.hasNextLine()) {
            String line = scanSong.nextLine();
            String[] split = line.split(",");
            Song newSong = new Song(split[0], split[3], split[1], Integer.valueOf(split[2]));
            list.add(newSong);
        }
        scanSong.close();
        
        Scanner scan = new Scanner(new File(peopleFile));
        scan.nextLine();
        int index = 0;
        while (scan.hasNextLine()) {
            index = list.getLength() -1;
            String line = scan.nextLine();
            line = line.replaceAll(",,",",something,");
            //if (line.endsWith(",")) {
            //    line = line + "something";
            //}
            String[] split = line.split(",", -1);
            int hobby = 12;
            int region = 12;
            int major = 12;
            
            if (split.length == 2) {
                line = scan.nextLine();
                line = line.replaceAll(",,"," ,something,");
                split = line.split(",");
            }
            if (split[4].equals("reading")) {
                hobby = 0;
            }
            
            else if (split[4].equals("art")) {
                hobby = 1;
            }
            else if (split[4].equals("sports")) {
                hobby = 2;
            }
            else if (split[4].equals("music")) {
                hobby = 3;
            }
            
            if (split[2].equals("Computer Science")) {
                major = 4;
            }
            
            else if (split[2].equals("Math or CMDA")) {
                major = 6;
            }
            
            else if (split[2].equals("Other Engineering")) {
                major = 5;
            }
            
            else if (split[2].equals("Other")) {
                major = 7;
            }
            
            if (split[3].equals("Southeast")) {
                region = 9;
               
            }
            else if (split[3].equals("Northeast")) {
                region = 8;
            }
            
            else if (split[3].equals("United States"
                + "(Other than Southeast or Northeast)")) {
                region = 10;
            }
            
            else if (split[3].equals(" Outside of United States")) {
                region = 11;
            }
            
            for (int i = 5; i < split.length -1; i += 2) {
                if (split[i].equals("Yes")) {
                    list.getEntry(index).increaseHeardSongs(hobby);
                    list.getEntry(index).increaseHeardSongs(major);
                    list.getEntry(index).increaseHeardSongs(region);
                    list.getEntry(index).increaseTotal1(hobby);
                    list.getEntry(index).increaseTotal1(major);
                    list.getEntry(index).increaseTotal1(region);

                }
                
                else if (split[i].equals("No")) {
                    //list.getEntry(index).increaseHeardSongs(hobby);
                    //list.getEntry(index).increaseHeardSongs(major);
                    //list.getEntry(index).increaseHeardSongs(region);
                    list.getEntry(index).increaseTotal1(hobby);
                    list.getEntry(index).increaseTotal1(major);
                    list.getEntry(index).increaseTotal1(region);

                }
                
                if (split[i + 1].equals("Yes")) {
                    list.getEntry(index).increaseLikedSongs(hobby);
                    list.getEntry(index).increaseLikedSongs(major);
                    list.getEntry(index).increaseLikedSongs(region);
                    list.getEntry(index).increaseTotal2(hobby);
                    list.getEntry(index).increaseTotal2(major);
                    list.getEntry(index).increaseTotal2(region);
                    
                }
                
                else if (split[i + 1].equals("No")) {
                    list.getEntry(index).increaseTotal2(hobby);
                    list.getEntry(index).increaseTotal2(major);
                    list.getEntry(index).increaseTotal2(region);
                }
                index--;
            }
        }
        scan.close();
    }
     
    /**
     * @return list 
     * it is the field.
     */
    public LinkedList<Song> getList() {
        return list;
    }
} 