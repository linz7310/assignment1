package datastructure.stack;

/**
 * Stack Interface
 * @param <T> Type of elements in the stack
 */
public interface Stack<T> {

    /**
     * Pushes an element onto the stack
     *
     * @param element the element to be pushed onto the stack
     */
    void push(T element);

    /**
     * Removes the element at the top of the stack and returns it.
     *
     * @return the element at the top of the stack
     */
    T pop();

    /**
     * Looks at the object at the top of the stack without removing it.
     *
     * @return the element at the top of the stack
     */
    T peek();

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, else false
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the stack.
     *
     * @return the size of the stack
     */
    int size();
}
