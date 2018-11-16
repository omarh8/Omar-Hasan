package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;

/**
 * 
 * @author Omarh8
 * @version 11.12.19
 * @param <T>
 */

public class LinkedList<T> implements ListInterface<T> {

    /**
     * 
     */
    private Node head;
    private int size;


    /**
     * 
     */
    public LinkedList() {
        head = null;
        size = 0;
    }


    /**
     * 
     */
    @Override
    public int getLength() {
        return size;
    }


    /**
     * @param index
     *            it is the index
     * @return this node
     */
    private Node getReferenceAt(int index) {
        Node thisNode = head;
        // int i = 0;
        for (int i = 0; i < index;) {
            thisNode = thisNode.getNext();
            i++;
        }
        return thisNode;
    }


    /**
     * 
     */
    @Override
    public void add(int index, T obj) {
        if (index >= 0 && index <= size + 1) {
            Node newObj = new Node(obj);
            if (index == 0) {
                add(obj);
            }

            else {
                Node previousNode = getReferenceAt(index - 1);
                Node nextNode = previousNode.getNext();
                previousNode.next = newObj;
                newObj.next = nextNode;
                size++;
            }
        }

        else {
            throw new IndexOutOfBoundsException("index out of bounds");
        }
    }


    /**
     * 
     */
    @Override
    public void add(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object is Null");
        }
        Node current = new Node(obj);

        if (!isEmpty()) {
            current.next = head;
        }
        head = current;
        size++;
    }


    /**
     * 
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 
     */
    @Override
    public T remove(T obj) {
        if (!this.contains(obj)) {
            return null;
        }

        if (this.getLength() == 1) {
            T data = head.getData();
            head = null;
            size--;
            return data;
        }

        if (head.getData().equals(obj)) {
            T data = head.getData();
            head = head.getNext();
            size--;
            return data;
        }

        Node nextNode = head.getNext();
        Node previousNode = head;
        T nodeToRemove = null;

        while (nextNode != null) {
            if (obj.equals(nextNode.data)) {
                previousNode.next = nextNode.getNext();
                nodeToRemove = obj;
                nextNode = null;
            }

            else if (nextNode.hasNext()) {
                previousNode = nextNode;
                nextNode = nextNode.getNext();
            }
        }
        size--;
        return nodeToRemove;
    }


    /**
     * 
     */
    @Override
    public T remove(int index) {
        if (this.getEntry(index) == null) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        if (index != 0) {
            Node previousNode = getReferenceAt(index - 1);
            Node nextNode = previousNode.getNext();
            T current = nextNode.getData();
            previousNode.next = nextNode.getNext();
            nextNode = null;
            size--;
            return current;
        }

        else {
            T data = head.getData();
            head = head.next;
            size--;
            return data;
        }
    }


    /**
     *  
     */
    @Override
    public T replace(int index, T obj) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index out of bounds");
        }
        Node current = this.getReferenceAt(index);
        T data = current.getData();
        current.data = obj;
        return data;
    }


    /**
     * it is a class
     * 
     * @param index
     *            It is the object
     * @return returns data
     */
    @Override
    public T getEntry(int index) {
        if (index >= size || index < 0) {
            return null;
        }

        Node current = this.getReferenceAt(index);
        return current.data;
    }


    /**
     * it is a class
     * 
     * @param obj
     *            It is the object
     * @return returns firstIndex
     */
    @Override
    public boolean contains(T obj) {
        if (isEmpty() || obj == null) {
            return false;
        }
        Node current = head;
        while (current != null) {
            if (obj.equals(current.getData())) {
                return true;
            }
            if (current.hasNext()) {
                current = current.getNext();
            }
            else {
                current = null;
            }
        }
        return false;
    }


    /**
     * it is a class
     * for clearing.
     * 
     * 
     * 
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }


    /**
     * it is a class
     * 
     * @param obj
     *            It is the object
     * @return returns firstIndexOf
     */
    public int firstIndexOf(T obj) {
        int firstIndex = -1;
        Node current = head;
        int currentIndex = 0;
        for (; currentIndex < size;) {
            if (obj.equals(current.getData())) {
                firstIndex = currentIndex;
            }

            currentIndex++;
            current = current.getNext();
        }
        return firstIndex;
    }


    /**
     * @return
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        Node current = head;
        while (current != null) {
            str.append(current.getData().toString());
            current = current.getNext();
        }
        str.append("]");
        return str.toString();
    }


    /**
     * @param category
     *            it is the category
     * @return toString
     *         it is toString
     *
     */
    public String toString(String category) {
        StringBuilder str = new StringBuilder();

        Node current = head;
        while (current != null) {
            Song x = (Song)current.getData();
            str.append(x.toString(category));

            current = current.getNext();
            if (current != null) {
                str.append("\n");
            }
        }

        return str.toString();
    }


    /**
     * @return array it is the array
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[this.size];
        Node current = head;
        // int count = 0;
        for (int count = 0; count < size;) {
            array[count] = current.getData();
            current = current.getNext();
            count++;
        }
        return array;
    }


    /**
     * @param obj
     *            Object
     * @return result
     *         it is the result
     */
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj == null) {
            return result;
        }
        if (obj == this) {
            return true;
        }
        if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            LinkedList<T> other = ((LinkedList<T>)obj);
            result = Arrays.equals(other.toArray(), this.toArray());
        }
        return result;
    }


    /**
     * @return LinkedList
     */
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }


    /**
     * it is a node
     */
    private class Node {

        /**
         * data
         */
        private T data;

        /**
         * next
         */
        private Node next;


        /**
         * @param dataPortion
         */
        private Node(T dataPortion) {
            next = null;
            data = dataPortion;
        }


        /**
         * @param nextNode
         */
        private void setNext(Node nextNode) {
            next = nextNode;
        }


        /**
         * 
         * @return nextNode
         */
        private Node getNext() {
            return next;
        }


        /**
         * @param newData
         *
         */
        private void setData(T newData) {
            data = newData;
        }


        /**
         * @return data. It is the data
         */
        private T getData() {
            return data;
        }


        /**
         * @return next method
         */
        private boolean hasNext() {
            return next != null;
        }
    }


    /**
     * thisNode with iterator
     */
    private class LinkedListIterator implements Iterator<T> {
        private Node thisNode;


        /**
         * thisNode with iterator
         */
        public LinkedListIterator() {
            thisNode = head;
        }


        /**
         * @return getData
         * @throws NoSuchElementException
         */
        @Override
        public T next() {
            if (hasNext()) {
                Node node = thisNode;
                thisNode = thisNode.getNext();
                return node.getData();
            }
            else {
                throw new NoSuchElementException("Illegal to next(); "
                    + "iterator is after the end of the list.");
            }
        }


        /**
         * @return thisNode.
         */
        public boolean hasNext() {
            return thisNode != null;
        }
    }
}
