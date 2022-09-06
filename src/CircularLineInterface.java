/**
 * This interface provides the methods that need to be implemented in Circular Line and PriorityCircularLine.
 * @author dastanbauyrzhan
 * @param <T> generic
 */
public interface CircularLineInterface<T> {
    /**
     * This method inserts a newData into the array.
     * @param newData new entry
     */
    public void insert(T newData);

    /**
     * This method removes and returns the element at the start.
     * @return removed element.
     * @throws NoElementException array empty exception
     */
    public T remove() throws NoElementException;

    /**
     * This method removes all the elements by setting all of it to null.
     * @throws NoElementException array empty exception
     */
    public void removeAll() throws NoElementException;

    /**
     * Returns the element at the start without removing it.
     * @return element at the start.
     * @throws NoElementException array empty exception
     */
    public T getFront() throws NoElementException;

    /**
     * Returns the element at the end without removing it.
     * @return element at the end.
     * @throws NoElementException array empty exception
     */
    public T getBack() throws NoElementException;

    /**
     * Returns the capacity of the array.
     * @return capacity
     */
    public int getCapacity();

    /**
     * Returns the size of the array.
     * @return size
     */
    public int size();

    /**
     * returns True if the array is empty, False otherwise.
     * @return T or F
     */
    public boolean isEmpty();

    /**
     * returns True if the array is full, False otherwise.
     * @return T or F
     */
    public boolean isFull();

}
