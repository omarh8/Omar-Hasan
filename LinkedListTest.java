package prj5;

import student.TestCase;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Omar
 * @version 11.15.2018
 */

public class LinkedListTest extends TestCase {

    private LinkedList<String> testList;
    private LinkedList<String> testList2;
    private String nullString;


    /**
     * 
     */
    public void setUp() {
        testList = new LinkedList<String>();
        testList2 = new LinkedList<String>();
        nullString = null;
    }


    /**
     * 
     */
    public void testGetLength() {
        assertEquals(0, testList.getLength());
        testList.add("a");
        assertEquals(1, testList.getLength());
        testList.add("b");
        assertEquals(2, testList.getLength());
    }


    /**
     * 
     * test add method
     * 
     */
    public void testAdd2() {
        assertEquals(0, testList.getLength());
        testList.add("a");
        assertEquals(1, testList.getLength());
        testList.add(0, "b");
        assertEquals("b", testList.getEntry(0));
        assertEquals("a", testList.getEntry(1));
        assertEquals(2, testList.getLength());
        testList.add(2, "c");
        assertEquals("c", testList.getEntry(2));
        assertEquals("a", testList.getEntry(1));
        assertEquals("c", testList.getEntry(2));
        assertEquals(3, testList.getLength());
        testList.add(3, "d");
        assertEquals("d", testList.getEntry(3));
        assertEquals(4, testList.getLength());

        Exception exception = null;
        try {
            testList.add(0, null);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);
    }


    /**
     * 
     */
    public void testAddAnotherOne() {
        assertEquals(0, testList.getLength());
        testList.add("a");
        assertEquals(1, testList.getLength());
        testList.add("b");
        assertEquals("b", testList.getEntry(0));
        assertEquals("a", testList.getEntry(1));
        assertEquals(2, testList.getLength());
        testList.add("c");
        assertEquals("c", testList.getEntry(0));
        assertEquals("b", testList.getEntry(1));
        assertEquals("a", testList.getEntry(2));
        assertEquals(3, testList.getLength());

        Exception exception = null;
        try {
            testList.add(null);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);

        testList2.add("a");
        Exception exception2 = null;
        try {
            testList2.add(3, "b");
        }
        catch (Exception e) {
            exception2 = e;
        }
        assertNotNull(exception2);
        assertTrue(exception2 instanceof IndexOutOfBoundsException);

        exception2 = null;
        try {
            testList2.add(-3, "b");
        }
        catch (Exception e) {
            exception2 = e;
        }
        assertNotNull(exception2);
        assertTrue(exception2 instanceof IndexOutOfBoundsException);
    }


    /**
     * 
     */
    public void testIsEmpty() {
        testList2.add("a");
        assertTrue(testList.isEmpty());
        assertFalse(testList2.isEmpty());
    }


    /**
     * 
     */
    public void testRemove() {
        testList.add("a");
        testList.add("b");
        testList.add("c");
        testList.add("d");
        testList.add("e");
        assertEquals(null, testList.remove(nullString));
        assertEquals(5, testList.getLength());
        assertEquals("e", testList.getEntry(0));
        assertEquals("d", testList.getEntry(1));
        assertEquals("c", testList.getEntry(2));
        assertEquals("a", testList.remove("a"));
        assertEquals("b", testList.remove("b"));
        assertNull(testList.remove("z"));
    }


    /**
     * 
     */
    public void testRemove2() {
        testList.add("a");
        testList.add("b");
        testList.add("c");
        assertEquals(3, testList.getLength());
        assertEquals("c", testList.remove(0));
        assertEquals(2, testList.getLength());
        assertEquals("a", testList.remove(1));
        assertEquals(1, testList.getLength());
        testList.clear();
        assertEquals(0, testList.getLength());

        Exception exception = null;
        try {
            testList.remove(0);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);

        Exception exception2 = null;
        try {
            testList2.remove(0);

        }
        catch (Exception e) {
            exception2 = e;
        }
        assertNotNull(exception2);
        assertTrue(exception2 instanceof IndexOutOfBoundsException);

        testList.add("a");
        testList.add("b");

        Exception exception3 = null;
        try {
            testList2.remove(3);

        }
        catch (Exception e) {
            exception3 = e;
        }
        assertNotNull(exception3);
        assertTrue(exception3 instanceof IndexOutOfBoundsException);

        exception3 = null;
        try {
            testList.remove(-3);
        }
        catch (Exception e) {
            exception3 = e;
        }
        assertNotNull(exception3);
        assertTrue(exception3 instanceof IndexOutOfBoundsException);
    }


    /**
     * getEntry
     */
    public void testGetEntry() {
        assertNull(testList.getEntry(-1));
        assertNull(testList.getEntry(1));
        assertNull(testList.getEntry(-1));
        assertNull(testList.getEntry(1));
        testList.add("a");
        testList.add("b");
        testList.add("c");
        assertEquals("a", testList.getEntry(2));
        assertEquals("b", testList.getEntry(1));
        assertEquals("c", testList.getEntry(0));

    }


    /**
     * clear method
     */
    public void testClear() {
        testList.add("a");
        testList.add("b");
        testList.add("c");
        testList.clear();
        assertEquals(0, testList.getLength());
    }


    /**
     * contains method
     */
    public void testContains() {
        testList.add("a");
        testList.add("b");
        testList.add("c");
        testList.add("d");
        assertTrue(testList.contains("a"));
        assertTrue(testList.contains("b"));
        assertTrue(testList.contains("c"));
        assertTrue(testList.contains("d"));
        assertFalse(testList.contains("z"));
        assertFalse(testList.contains(nullString));
        assertFalse(testList2.contains("a"));
    }


    /**
     * replace method
     */
    public void testReplace() {
        testList.add("a");
        assertEquals(1, testList.getLength());
        // assertEquals("a", testList.getLength());

        Exception exception = null;
        Exception exception2 = null;
        try {
            testList.replace(-1, "b");
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);

        try {
            testList.replace(2, "b");
        }
        catch (Exception e) {
            exception2 = e;
        }
        assertNotNull(exception2);
        assertTrue(exception2 instanceof IndexOutOfBoundsException);
    }


    /**
     * 
     */

    public void testEquals() {
        Object testList3 = new LinkedList<String>();
        assertFalse(testList2.equals(nullString));
        assertTrue(testList2.equals(testList2));
        assertTrue(testList.equals(testList));
        assertTrue(testList.equals(testList2));
        assertTrue(testList.equals(testList3));
        assertTrue(testList2.equals(testList3));
        LinkedList<String> testList4 = null;
        assertFalse(testList.equals(testList4));
        assertFalse(testList2.equals(testList4));
        testList.add("a");
        testList.add("b");
        testList.add("c");
        testList.add("a");
        assertFalse(testList.equals(testList2));
        testList2.add("a");
        testList2.add("b");
        testList2.add("c");
        testList2.add("a");
        assertTrue(testList.equals(testList2));
    }


    /**
     * 
     */
    public void testToString() {
        testList.add("a");
        testList.add("b");
        testList.add("c");
        assertEquals("[cba]", testList.toString());
        assertEquals("[]", testList2.toString());

    }


    /**
     * 
     */
    public void testToArray() {
        testList.add("a");
        testList.add("b");
        testList.add("c");
        testList.add("d");
        testList.add("e");
        testList.add("f");
        assertEquals(6, testList.getLength());
        Object[] listArray = testList.toArray();
        assertEquals("f", listArray[0]);
        assertEquals("e", listArray[1]);
        assertEquals("d", listArray[2]);
        assertEquals("c", listArray[3]);
        assertEquals("b", listArray[4]);
        assertEquals("a", listArray[5]);
        assertEquals(6, listArray.length);
    }


    /**
     * 
     */
    public void testIterator() {
        testList.add("a");
        testList.add("b");
        testList.add("c");
        Iterator<String> listIterator = testList.iterator();
        assertTrue(listIterator.hasNext());
        assertEquals("c", listIterator.next());
        listIterator.next();
        assertEquals("a", listIterator.next());
        assertFalse(listIterator.hasNext());

        Exception exception = null;
        try {
            listIterator.next();
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof NoSuchElementException);

        Exception exception2 = null;
        try {
            testList.replace(7, "b");
        }
        catch (Exception e) {
            exception2 = e;
        }
        assertNotNull(exception2);
        assertTrue(exception2 instanceof IndexOutOfBoundsException);
    }


    /**
     * 
     */
    public void testToString2() {
        Song testSong = new Song("title", "artist", "genre", 1);
        testSong.increaseHeardSongs(1);
        testSong.increaseHeardSongs(1);
        testSong.increaseTotal1(1);
        testSong.increaseTotal1(1);
        LinkedList<Song> testList0 = new LinkedList<>();
        testList0.add(testSong);
        // testList0.add(testSong);
        // testList0.add(testSong);

        String str = "Song Title: title\n" + "Song Artist: genre\n"
            + "Song Genre: artist\n" + "Song Year: 1\n" + "Heard\n"
            + "reading0 art100 sports0 music0\n" + "Likes\n"
            + "reading0 art0 sports0 music0\n";
        System.out.println(str);
        /*
         * String str2 = str + "\nSong Title: title\n" + "Song Artist: genre\n"
         * + "Song Genre: artist\n" + "Song Year: 1\n" + "Heard\n"
         * + "reading0 art100 sports0 music0\n" + "Likes\n"
         * + "reading0 art0 sports0 music0\n";
         * System.out.println(str);
         * 
         * String str3 = str2 + "\nSong Title: title\n" + "Song Artist: genre\n"
         * + "Song Genre: artist\n" + "Song Year: 1\n" + "Heard\n"
         * + "reading0 art100 sports0 music0\n" + "Likes\n"
         * + "reading0 art0 sports0 music0\n";
         */
        assertEquals(str, testList0.toString("hobby"));

    }

}
