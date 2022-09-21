/**
 * Generic version of the Queue class.
 *
 * @param <T> the type of the value
 */

class MyQueue<T> {

    /**
     * Head node contains front node in the queue
     */

    Node<T> head;

    /**
     * Tail node contains last node in the queue
     */

    Node<T> tail;

    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Add node item to the tail of the queue
     *
     * @param item item to be added to the tail of the queue
     */
    void enqueue(T item) {
        Node<T> newNode = new Node<>(item, null);
        if (this.head == null) {
            //Nếu danh sách rỗng, thêm node mới và gắn vào head và tail
            this.head = newNode;
            this.tail = newNode;

            return;
        }

        //Trường hợp danh sách không rỗng, chèn node mới vào đuôi của danh sách
        //Gán tail của danh sách bằng node mới
        this.tail.setNext(newNode);
        this.tail = newNode;
    }

    /**
     * remove node item out of the head of the queue
     *
     * @return the node item of the head of the queue
     * @throws Exception
     */
    public Object dequeue() throws Exception {
        if (isEmpty()) throw new Exception();
        Object x = head.info;
        head = head.next;
        if (head == null) tail = null;
        return (x);
    }

}