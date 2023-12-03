import java.util.Objects;

public class MyMiniList<T> implements MiniList<T> {

    private int size;
    private T[] objectStore;

    // constructor
    public MyMiniList() {
        // initialize size to 0
        size = 0;
        // create a new array of size 10 to store elements
        objectStore = (T[]) new Object[10];
    }

    // add an element to the end of the list
    @Override
    public void add(T element) {
        // check if the array is full
        if (size == objectStore.length) {
            // create a new array of size 2 * current size
            T[] newStore = (T[]) new Object[size * 2];
            // copy the existing elements to the new array
            System.arraycopy(objectStore, 0, newStore, 0, size);
            // update objectStore to point to the new array
            objectStore = newStore;
        }
        // add the new element to the end of the array
        objectStore[size] = element;
        // update the size of the list
        size++;
    }

    // get an element from the list by index
    @Override
    public T get(int index) {
        // check if the index is valid
        Objects.checkIndex(index, size);
        // return the element at the specified index
        return objectStore[index];
    }

    // get the index of the first occurrence of an element in the list
    @Override
    public int getIndex(T element) {
        // iterate through the list
        for (int i = 0; i < size; i++) {
            // check if the current element is equal to the specified element
            if (Objects.equals(element, objectStore[i])) {
                // return the index of the element
                return i;
            }
        }
        // return -1 if the element is not found
        return -1;
    }

    // set an element in the list by index
    @Override
    public void set(int index, T element) {
        // check if the index is valid
        Objects.checkIndex(index, size);
        // set the element at the specified index to the new element
        objectStore[index] = element;
    }

    // get the size of the list
    @Override
    public int size() {
        // return the size of the list
        return size;
    }

    // remove an element from the list by index
    @Override
    public T remove(int index) {
        // check if the index is valid
        Objects.checkIndex(index, size);
        // get the element to be removed
        T removedElement = objectStore[index];
        // shift the remaining elements down one index
        System.arraycopy(objectStore, index + 1, objectStore, index, size - index - 1);
        // update the size of the list
        size--;
        // return the removed element
        return removedElement;
    }

    // remove the first occurrence of an element from the list
    @Override
    public boolean remove(T element) {
        // get the index of the element to be removed
        int index = getIndex(element);
        // check if the element is not found in the list
        if (index == -1) {
            return false;
        } else {
            // remove the element at the specified index
            remove(index);
            // return true to indicate that the element has been removed
            return true;
        }
    }

    @Override
// The `clear()` method is used to remove all elements from the list.
// It accomplishes this by resetting the `size` of the list to 0,
// indicating that the list is now empty, and by creating a new array
// of size 10 to store elements. The new array effectively replaces the
// existing array, which is no longer needed since all elements have been removed.
    public void clear() {
        size = 0;
        objectStore = (T[]) new Object[10];
    }
}