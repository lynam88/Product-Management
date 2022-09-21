import java.util.EmptyStackException;

/**
 * Generic version of the Stack class.
 *
 * @param <T> the type of the value
 */

class MyStack<T> {

    /**
     * Head node contains front node in the stack
     */

    Node<T> head;

    /**
     * Default Constructor
     */
    public MyStack() {
        head = null;
    }

    /**
     * @return boolean value to check whether the stack is empty or not
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * push node item into the head of the stack
     *
     * @param item the item to be pushed to stack
     */
    void push(T item) {
        head = new Node<>(item, head);
    }

    /**
     * pop node item out of the head of the stack
     *
     * @return return the info of the node head
     * @throws EmptyStackException
     */
    public Object pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        Object x = head.info;
        head = head.next;
        return (x);
    }

}