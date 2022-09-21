
/**
 * Generic version of the Node class.
 *
 * @param <T> the type of the value
 */

public class Node<T> {

    /**
     * The info of this node
     */

    T info;

    /**
     * The next node
     */

    Node next;

    /**
     * Default constructor
     */

    public Node() {

    }

    /**
     * Constructor with info and next node
     *
     * @param info The info of this node
     * @param next The next Node of this node
     */

    public Node(T info, Node next) {
        this.info = info;
        this.next = next;

    }

    /**
     * Return the info of this node
     *
     * @return info
     */
    public T getInfo() {
        return info;
    }

    /**
     * Set the info of this node
     *
     * @param info The info of this node
     */
    public void setInfo(T info) {
        this.info = info;
    }

    /**
     * Return the next node of this node
     *
     * @return next node
     */
    public Node getNext() {
        return next;
    }

    /**
     * Set the next node of this node
     *
     * @param next next node
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Overriding to convert this node to String
     */

    @Override

    public String toString() {
        return "" + this.info;
    }

}