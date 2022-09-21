/**
 * Product class
 */

public class Product {

    //Variables Declaration
    private String bcode;//Product's bar code
    private String title;//Product's title
    private int quantity;//Product's quantity
    private double price;//Product's price

    /**
     * Default constructor
     */

    public Product() {

    }

    /**
     * Constructor method to initialize a product
     *
     * @param bcode    Product's bar code
     * @param title    Product's title
     * @param quantity Product's quantity
     * @param price    Product's price
     */

    public Product(String bcode, String title, int quantity, double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Return bar code of the product
     *
     * @return bar code of the product
     */
    public String getBcode() {
        return bcode;
    }

    /**
     * Return quantity of the product
     *
     * @return quantity of the Product
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Convert this product to String for printing
     */

    @Override

    public String toString() {
        return String.format("%-10s %s %-10s %s %-10s %s %-10s\n", bcode, "|", title, "|", quantity, "|", price);//Hiển thị sản phẩm theo yêu cầu đề bài
    }

}