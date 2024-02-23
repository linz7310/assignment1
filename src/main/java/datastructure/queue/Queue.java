package datastructure.queue;

/**
 * Queue Interface
 * @param <E> Types of elements in the queue
 */
public interface Queue<E> {

    /**
     * Inserts the specified element into the end of this queue
     *
     * @param value value the element to add
     * @return true if the element was added to this queue, else false
     */
    boolean offer(E value);

    /**
     * Gets the value from the head of queue, and removes it.
     *
     * @return the head of this queue, or null if this queue is empty
     */
    E poll();

    /**
     * Gets the value from the head of queue, without remove it.
     *
     * @return 如the head of this queue, or null if this queue is empty
     */
    E peek();

    /**
     * Checks if the queue is empty.
     *
     * @return true if this queue is empty, else false
     */
    boolean isEmpty();

    /**
     * Checks if the queue is full.
     *
     * @return true if this queue is full, else false
     */
    boolean isFull();
}
