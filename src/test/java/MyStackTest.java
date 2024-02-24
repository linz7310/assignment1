import datastructure.stack.Mystack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyStackTest {
    private Mystack<Integer> stack;

    @Before
    public void setUp() {
        stack = new Mystack<>();
    }

    @Test
    public void testPush() {
        stack.push(1);
        assertEquals(1, stack.size());
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(Integer.valueOf(3), stack.pop());
        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(Integer.valueOf(1), stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPeek() {
        stack.push(1);
        stack.push(2);
        assertEquals(Integer.valueOf(2), stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, stack.size());
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
    }
}


