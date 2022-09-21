import java.io.*;//Nạp Package chứa class xử lý đầu vào và đầu ra trong java.

import java.util.Scanner;//Nạp Package chứa class lấy đầu vào từ người dùng

public class AS2_Main {

    static final Scanner sc = new Scanner(System.in);

    /**
     * Hàm hiển thị menu có ít nhất 10 chức năng theo yêu cầu
     */
    public static void showMenu() {

        System.out.println("\nChoose one of this options:");

        System.out.println("Product list:");

        System.out.println("1. Load data from file and display");

        System.out.println("2. Input & add to the end.");

        System.out.println("3. Display data");

        System.out.println("4. Save product list to file.");

        System.out.println("5. Search by ID");

        System.out.println("6. Delete by ID");

        System.out.println("7. Sort by ID.");

        System.out.println("8. Convert to Binary");

        System.out.println("9. Load to stack and display");

        System.out.println("10. Load to queue and display.");

        System.out.println("0. Exit\n");
    }

    /**
     * Hàm xử lý chính của chương trình
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws Exception {
        // Scanner sc = new Scanner(System.in);
        int choice;//Biến lưu lựa chọn chức năng của người dùng
        OperationToProduct operation = new OperationToProduct();//Tạo đối tượng để sử dụng các phương thức trong lớp OperationToProduct
        MyList<Product> list = new MyList<>();//Tạo đối tượng linkedlist
        MyStack<Product> stack = new MyStack<>();//Tạo đối tượng stack
        MyQueue<Product> queue = new MyQueue<>();//Tạo đối tượng queue

        //Tạo đối tượng để ghi luồng dữ liệu trên giao diện console
        PrintStream file = new PrintStream("console_output.txt");
        CustomPrintStream custom = new CustomPrintStream(System.out, file);
        System.setOut(custom);

        do {
            showMenu();
            System.out.print("Choice=");
            choice = sc.nextInt();
            file.append(String.valueOf(choice) + "\n");//Ghi biến nhập từ người dùng vào file console_output
            switch (choice) {

                //Chức năng 1: Đọc dữ liệu có sẵn từ file đã tự tạo và lưu vào danh sách móc nối và hiển thị danh sách ra màn hình
                case 1:
                    operation.getAllItemsFromFile("Data.txt", list);//Đọc dữ liệu có sẵn từ file đã tự tạo và lưu vào danh sách móc nối
                    System.out.printf("%-10s %s %-10s %s %-10s %s %-10s\n", "ID", "|", "Title", "|", "Quantity", "|", "Price");
                    System.out.printf("%s\n", "--------------------------------------------");
                    operation.displayAll(list);//hiển thị danh sách ra màn hình
                    break;

                //Chức năng 2: Nhập và thêm một sản phẩm vào cuối của danh sách móc nối
                case 2:
                    operation.addLast(list, file);
                    break;

                //Chức năng 3: Hiển thị thông tin của các sản phẩm trong danh sách móc nối
                case 3:
                    System.out.printf("%-10s %s %-10s %s %-10s %s %-10s\n", "ID", "|", "Title", "|", "Quantity", "|", "Price");//Hiển thị tiêu đề trong danh sách.
                    System.out.printf("%s\n", "--------------------------------------------");//Phân cách tiêu đề và nội dung.
                    operation.displayAll(list);
                    break;

                //Chức năng 4: Lưu danh sách móc nối các sản phẩm vào file
                case 4:
                    operation.writeAllItemsToFile("Data.txt", list);
                    break;

                //Chức năng 5: Tìm kiếm thông tin của sản phẩm theo ID
                case 5:
                    operation.searchByCode(list, file);
                    break;

                //Chức năng 6: Xóa sản phẩm trong danh sách theo ID
                case 6:
                    operation.deleteByCode(list, file);
                    break;

                //Chức năng 7: Sắp xếp các sản phẩm  trong danh sách móc nối theo ID
                case 7:
                    operation.sortByCode(list.head, list.tail);
                    System.out.println("Successfully!");
                    break;

                //Chức năng 8: Biểu diễn số lượng sản phẩm (đang ở hệ đếm cơ số 10) của phần tử đầu tiên trong Linked List ra hệ đếm nhị phân bằng phương pháp đệ quy.
                case 8:
                    int i = list.head.getInfo().getQuantity();//số lượng của phần tử đầu tiên
                    System.out.print("Quantity=" + i + "=>(");
                    System.out.print(operation.convertToBinary(i));
                    System.out.println(")");
                    break;

                //Chức năng 9: Đọc dữ liệu từ file chứa các sản phẩm rồi lưu vào stack. Hiển thị ra màn hình các sản phẩm có trong stack.
                case 9:
                    operation.getAllItemsFromFile("Data.txt", stack);
                    System.out.printf("%-10s %s %-10s %s %-10s %s %-10s\n", "ID", "|", "Title", "|", "Quantity", "|", "Price");
                    System.out.printf("%s\n", "--------------------------------------------");
                    operation.displayAll(stack);
                    break;

                //Chức năng 10: Đọc dữ liệu từ file chứa các sản phẩm lưu vào queue. Hiển thị ra màn hình các sản phẩm có trong queue.
                case 10:
                    operation.getAllItemsFromFile("Data.txt", queue);
                    System.out.printf("%-10s %s %-10s %s %-10s %s %-10s\n", "ID", "|", "Title", "|", "Quantity", "|", "Price");
                    System.out.printf("%s\n", "--------------------------------------------");
                    operation.displayAll(queue);
                    break;
            }

        } while (choice != 0);

    }

}