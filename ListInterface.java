package prj5;

/**
 * 
 * @author Omarh8
 * @version 11.12.19
 * @param <T>
 */
public interface ListInterface<T> {
    /**
     * 
     */
    /**
     * An interface for the ADT deque.
     * 
     * @author Frank M. Carrano
     * @author Timothy M. Henry
     * @version 4.0
     * @param newEntry
     *            generic type for the deque
     */
    public abstract void add(T newEntry);


    /**
     * Adds a new entry to the back of this dequeue.
     * 
     * @param newEntry
     *            An object to be added.
     * @param newPosition
     *            is is a new position
     * @throws IndexOutOfBoundsException
     */
    public abstract void add(int newPosition, T newEntry);


    /**
     * 
     * @param entry
     *            it is the entry
     * 
     * @return reference it is guidLines
     * 
     */
    public abstract T remove(T entry);


    /**
     * Removes and returns the back entry of this dequeue.
     * 
     * @param index
     *            it is the index
     * @return The object at the back of the dequeue.
     *
     */
    public abstract T remove(int index);


    /**
     * Remove all entries from list
     * 
     * 
     */
    public abstract void clear();


    /**
     * @param givenPosition
     *            it is the givenpPosition
     * @param newEntry
     *            it is the newEntry
     * @return True else false.
     */
    public abstract T replace(int givenPosition, T newEntry);


    /**
     * Detects whether this dequeue is empty.
     * 
     * @param givenPosition
     *            it is the position
     * 
     * @return True if the queue is empty, or false otherwise.
     */
    public abstract T getEntry(int givenPosition);


    /**
     * Removes all entries from this dequeue.
     * 
     * @return new located array
     */
    public abstract Object[] toArray();


    /**
     * @param anEntry
     *            it is the entry
     * @return true when list contains anEntry
     */

    public abstract boolean contains(T anEntry);


    /**
     * @return if list contains entry
     */

    public abstract int getLength();


    /**
     * @return is empty
     */
    public abstract boolean isEmpty();
}
