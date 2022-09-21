/**
 * Generic version of the LinkedList class.
 *
 * @param <T> the type of the value
 */

public class MyList<T> {

    /**
     * Head node, default is null
     */

    Node<T> head;

    /**
     * Tail node, default is null
     */

    Node<T> tail;

    /**
     * Default constructor
     */

    public MyList() {
        head = tail = null;
    }

    /**
     * Constructor with head and tail
     *
     * @param head Head node of this list
     * @param tail Tail node of this list
     */

    public MyList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    /**
     * Insert an item to the tail of this list
     *
     * @param item The item to be inserted
     */

    public void insertToTail(T item) {
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
     * Deleting the head of this list
     */

    public void deleteHead() {
        this.head = head.getNext();
    }

    /**
     * Deleting the tail of this list
     */

    public void deleteTail() {
        Node<T> current = this.head;
        while (current.getNext() != null) {
            if (current.getNext().getNext() == null) {
                this.tail = current;//Gán tail bằng node phía trước của nó
                this.tail.setNext(null);
                break;
            }
            current = current.getNext();
        }
    }

    /**
     * Searching and deleting an item from this list by comparing the ID of items
     *
     * @param item The item to be deleted
     */

    public void deleteElement(T item) {
        Node<T> current = this.head;
        while (current.getNext() != null) {
            if (current.getNext().getInfo() == item)
                current.setNext(current.getNext().getNext());//Nếu info next node của current trùng với element item thì set next node của current bằng next node của next node của current tức là bỏ qua node có info trùng với item
            current = current.getNext();
        }
    }

}