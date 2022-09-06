/**
 * This class implements an array representing a waiting line with first come first serve.
 * @param <T> generic
 */
public class CircularLine<T> implements CircularLineInterface<T> {
    /**
     * Array of type T.
     */
    private T[] arr;
    /**
     * integer set to 0.
     */
    private int start = 0;
    /**
     * declaration of integer named end.
     */
    private int end;

    /**
     * Constructor.
     */
    public CircularLine(){
        arr = (T[])new Object[50];
        end = arr.length-1;
    }

    /**
     * Constructor.
     * @param capacity capacity
     */
    public CircularLine(int capacity){
        arr = (T[])new Object[capacity];
        end = arr.length-1;
    }

    /**
     * This method doubles the capacity.
     */
    public void doubleCapacity() {
        if (isFull()){
            int k = 0;
            T[] arr2 = arr;
            arr = (T[]) new Object[2 * arr2.length];
            if((start == 0 && end == arr2.length - 2) || (start == 1 && end == arr2.length - 1)){
                for(int i = start; i <= end; i++){
                    arr[k] = arr2[i];
                    k++;
                }
            } else {
                for(int i = start; i < arr2.length; i++){
                    arr[k] = arr2[i];
                    k++;
                }
                for(int i = 0; i <= end; i++){
                    arr[k] = arr2[i];
                    k++;
                }
            }
            start = 0;
            end = k - 1;
        }
    }

    /**
     * Returns the start.
     * @return start
     */
    public int getStart(){
        return start;
    }

    /**
     * Returns the end.
     * @return end
     */
    public int getEnd(){
        return end;
    }

    /**
     * toString method.
     * @return String
     */
    public String toString(){
        String s = "[";
        int k = start;
        for(int i=0; i<size(); i++){
            if(arr[k] != null) {
                if(k == end){
                    s += arr[k];
                } else {
                    s += arr[k] + ",";
                }
            }
            k++;
            if(k == arr.length){
                k = 0;
            }
        }
        s += "]";
        return s;
    }

    /**
     * This method inserts a newData into the end of the waiting line.
     */
    @Override
    public void insert(T newData) {
        if(isFull()){
            doubleCapacity();
            arr[end + 1] = newData;
            end++;
        } else if(end == arr.length - 1){
            end = 0;
            arr[end] = newData;
        } else {
            arr[end + 1] = newData;
            end++;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T remove() throws NoElementException {
        if(isEmpty()){
            throw new NoElementException();
        } else {
            T arr2 = arr[start];
            arr[start] = null;
            start++;
            return arr2;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeAll() throws NoElementException {
        if(isEmpty()){
            throw new NoElementException();
        } else {
            for(int i = 0; i < arr.length; i++){
                arr[i] = null;
            }
            start = 0;
            end = arr.length - 1;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T getFront() throws NoElementException {
        if(isEmpty()){
            throw new NoElementException();
        } else {
            return arr[start];
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T getBack() throws NoElementException {
        if(isEmpty()){
            throw new NoElementException();
        } else {
            return arr[end];
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCapacity() {
        return arr.length - 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        if(isEmpty()){
            return 0;
        } else if(isFull()){
            return arr.length - 1;
        } else if(start > end){
            return (arr.length - start) + (end + 1);
        } else {
            return end - start + 1;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        if(start == 0 && end == arr.length - 1)
            return true;
        else if(start - end == 1)
            return true;
        else return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isFull() {
        if(start > end && start - end == 2)
            return true;
        else if((start == 0 && end == arr.length - 2) || (start == 1 && end == arr.length - 1))
            return true;
        else return false;
    }
}
