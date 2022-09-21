import java.io.IOException;//Nạp Package chứa class xử lý lỗi
import java.io.OutputStream;//Nạp Package chứa class xử lý đầu ra
import java.io.PrintStream;//Nạp Package chứa class ghi dữ liệu vào một stream khác

public class CustomPrintStream extends PrintStream {

    private final PrintStream second;

    public CustomPrintStream(OutputStream main, PrintStream second) {
        super(main);
        this.second = second;
    }

    /**
     * Đóng luồng chính.
     * luồng thứ hai của chỉ được ghi nhưng không đóng lại.
     */
    @Override
    public void close() {
        super.close();
    }

    /**
     * xả dữ liệu của một stream và gửi nó vào một stream khác
     */
    @Override
    public void flush() {
        super.flush();
        second.flush();
    }

    @Override
    public void write(byte[] buf, int off, int len) {
        super.write(buf, off, len);
        second.write(buf, off, len);
    }

    @Override
    public void write(int b) {
        super.write(b);
        second.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        super.write(b);
        second.write(b);
    }
}
