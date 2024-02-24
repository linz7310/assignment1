package datastructure.stack;

import java.util.LinkedList;

/**
 * Implementation of the Stack interface using a LinkedList
 * @param <T> The type of elements held in this stack
 */
public class Mystack<T> implements Stack<T> {
    private LinkedList<T> list = new LinkedList<>();

    @Override
    public void push(T element) {
        list.addFirst(element);
    }

    @Override
    public T pop() {
        return list.removeFirst();
    }

    @Override
    public T peek() {
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }
}
