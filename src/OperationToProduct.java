import java.io.*;
import java.util.Scanner;

/**
 * This class manages all functions relate to the product
 */

public class OperationToProduct {

    static Scanner sc = new Scanner(System.in);

    /**
     * Reading all products from the file and insert them to the list at tail.
     *
     * @param fileName The file name of the file
     * @param list     The Linked List contains all products that read from file
     */

    public void getAllItemsFromFile(String fileName, MyList<Product> list) throws IOException {
        //Đọc dữ liệu theo từng dòng với BufferedReader
        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String line = bufferedReader.readLine();//Đọc từng dòng dữ liệu
        while (line != null) {
            String[] text = line.split("\\s+\\|+\\s+");//Tách từng chuỗi trong dòng với phân cách là khoảng trắng và kí tự |
            Product newNode = new Product(text[0], text[1], Integer.parseInt(text[2]), Double.parseDouble(text[3]));
            //thêm node vào cuối linkedlist
            list.insertToTail(newNode);
            //tách sang dòng tiếp theo
            line = bufferedReader.readLine();
        }
        bufferedReader.close();//Đóng file

    }

    /**
     * Reading all products from the file and insert them to the stack.
     *
     * @param fileName The file name of the file
     * @param stack    The Stack contains all products that read from file
     */

    public void getAllItemsFromFile(String fileName, MyStack<Product> stack) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String line = bufferedReader.readLine();
        while (line != null) {
            String[] text = line.split("\\s+\\|+\\s+");
            Product newNode = new Product(text[0], text[1], Integer.parseInt(text[2]), Double.parseDouble(text[3]));
            //thêm node vào đầu stack
            stack.push(newNode);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();

    }

    /**
     * Reading all products from the file and insert them to the queue.
     *
     * @param fileName The file name of the file
     * @param queue    The Queue contains all products that read from file
     */

    public void getAllItemsFromFile(String fileName, MyQueue<Product> queue) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String line = bufferedReader.readLine();
        while (line != null) {
            String[] text = line.split("\\s+\\|+\\s+");
            Product newNode = new Product(text[0], text[1], Integer.parseInt(text[2]), Double.parseDouble(text[3]));
            //thêm node vào cuối queue
            queue.enqueue(newNode);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();

    }

    /**
     * Adding a product to the list, info of the product input from keyboard.
     *
     * @param list The Linked list
     */

    public void addLast(MyList<Product> list, PrintStream file) {
        System.out.print("Input new ID:");
        String newID = sc.next();//Biến lưu bar code nhập từ người dùng
        sc.nextLine();
        file.append(newID + "\n");
        System.out.print("Input Product's Name:");
        String newTittle = sc.nextLine();//Biến lưu tên sản phẩm nhập từ người dùng
        file.append(newTittle + "\n");
        System.out.print("Input Product's quantity:");
        int newQuantity = sc.nextInt();
        file.append(String.valueOf(newQuantity) + "\n");//Biến lưu sản lượng nhập từ người dùng
        System.out.print("Input Product's price:");
        double newprice = sc.nextDouble();//Biến lưu giá sản phẩm nhập từ người dùng
        file.append(String.valueOf(newprice) + "\n");
        Product newNode = new Product(newID, newTittle, newQuantity, newprice);
        //thêm vào cuối linkedlist
        list.insertToTail(newNode);
    }

    /**
     * Printing all products of the list to console screen
     *
     * @param list
     */

    public void displayAll(MyList<Product> list) {
        Node<Product> current = list.head;

        //Duyệt qua từng node để hiển thị
        while (current != null) {
            System.out.print(current);
            current = current.getNext();
        }
        System.out.println();
        System.out.println("Successfully!");
    }

    /**
     * Printing all products of the stack to console screen
     *
     * @param stack the stack
     */

    public void displayAll(MyStack<Product> stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();
        System.out.println("Successfully!");
    }

    /**
     * Printing all products of the queue to console screen
     *
     * @param queue the queue
     */

    public void displayAll(MyQueue<Product> queue) throws Exception {
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue());
        }
        System.out.println();
        System.out.println("Successfully!");
    }

    /**
     * Writing all products from the list to the file
     *
     * @param fileName Input file name
     * @param list     Input Linked list
     */

    public void writeAllItemsToFile(String fileName, MyList<Product> list) throws IOException {
        //Mở file
        FileWriter writer = new FileWriter(fileName);
        BufferedWriter buffer = new BufferedWriter(writer);

        //Ghi file qua từng node
        Node<Product> current = list.head;
        while (current != null) {
            buffer.write(current.toString());
            current = current.getNext();
        }
        buffer.close();//Đóng file
        System.out.println("Successfully!");
    }

    /**
     * Searching product by ID input from keyboard.
     *
     * @param list
     */

    public void searchByCode(MyList<Product> list, PrintStream file) {
        System.out.print("Input the ID to search=");
        String searchID = sc.next();//Biến lưu bar code mà người dùng search
        file.append(searchID + "\n");
        Node<Product> current = list.head;
        boolean check = false;
        while (current != null) {
            if (current.info.getBcode().equals(searchID)) {
                System.out.println("Result: " + current);
                check = true;
            }
            current = current.getNext();
        }
        if (!check) System.out.println("-1");
    }

    /**
     * Deleting first product that has the ID input from keyboard from the list.
     *
     * @param list
     */

    public void deleteByCode(MyList<Product> list, PrintStream file) {
        System.out.print("Input the bcode to delete=");
        String deleteID = sc.next();//Biến lưu bar code người dùng nhập vào để xoá
        file.append(deleteID + "\n");

        //Trường hợp bar code của node head trùng với bar code người dùng nhập
        if (list.head.getInfo().getBcode().equals(deleteID)) {
            list.deleteHead();
            System.out.println("Deleted!");
            return;
        }

        //Trường hợp bar code của node tail trùng với bar code người dùng nhập
        if (list.tail.getInfo().getBcode().equals(deleteID)) {
            list.deleteTail();
            System.out.println("Deleted!");
            return;
        }

        //Trường hợp bar code của node bên trong linkedlist trùng với bar code người dùng nhập
        Node<Product> current = list.head;
        while (current != null) {
            if (current.getInfo().getBcode().equals(deleteID)) {
                list.deleteElement(current.getInfo());
                System.out.println("Deleted!");
                return;
            }
            current = current.getNext();
        }

    }

    /**
     * This method is used to place the pivot element , which is the last element of the list at it's sorted position. This works by placing all the elements which are smaller than the pivot to it's left and all the elements larger than the pivot at the tail of the list. Returns the element before the pivot.
     *
     * @param start first node
     * @param end   last node
     * @return previous node of pivot
     */
    public Node paritionLast(Node<Product> start, Node<Product> end) {
        if (start == end || start == null || end == null)
            return start;

        Node<Product> pivot_prev = start;
        Node<Product> curr = start;
        Product pivot = end.getInfo();

        // iterate till one before the end,
        // no need to iterate till the end
        // because end is pivot
        while (start != end) {
            if (start.getInfo().getBcode().compareTo(pivot.getBcode()) < 0) {

                // keep tracks of last modified item
                pivot_prev = curr;
                Product temp = curr.getInfo();
                curr.setInfo(start.getInfo());
                start.setInfo(temp);
                curr = curr.next;
            }
            start = start.next;
        }

        // Swap the position of curr i.e.
        // next suitable index and pivot
        Product temp = curr.getInfo();
        curr.setInfo(pivot);
        end.setInfo(temp);

        // Return one previous to current
        // because current is now pointing to pivot
        return pivot_prev;
    }

    /**
     * Sorting products in linked list by ID
     *
     * @param start first node
     * @param end   last node
     */

    public void sortByCode(Node<Product> start, Node<Product> end) {
        if (start == null || start == end
                || start == end.next)
            return;

        // Split list and partition recurse
        Node pivot_prev = paritionLast(start, end);
        sortByCode(start, pivot_prev);

        // If pivot is picked and moved to the head,
        // that means head and pivot is same
        // so pick from next of pivot
        if (pivot_prev != null && pivot_prev == start)
            sortByCode(pivot_prev.next, end);

            // If pivot is in between of the list,
            // start from next of pivot,
            // since we have pivot_prev, so we move two nodes
        else if (pivot_prev != null
                && pivot_prev.next != null)
            sortByCode(pivot_prev.next.next, end);

    }

    /**
     * Convert a decimal to a integer number. Example: input i = 18 -> Output = 10010
     *
     * @param i Input decimal number
     * @return a integer numbers
     */

    public int convertToBinary(int i) {
        if (i == 0) return 0;// dừng đệ quy
        int d = i % 2;
        return d + 10 * convertToBinary(i / 2);//nhân 10 để hiển thị thành số như đề bài
    }

}