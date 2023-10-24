package StudentManager;

import java.util.Scanner;

/**
 * CLass input dữ liệu đầu vào từ bàn phím.
 *
 * @version 1.0
 * @author Admin
 */
public class Inputter {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * kiểm tra xem người dùng chọn yes hay no.
     *
     * @param msg in ra thông báo cho người dùng
     * @return trả về true nếu người dùng chọn y, ngược lại là false
     */
    public static boolean askYesNo(String msg) {
        String data = getStringWithPattern(msg, "[Y|y|n|N]");
        return data.matches("[Y|y]");
    }

    /**
     * phương thức trả về một số nguyên trong khoảng [min, max].
     *
     * @param msg
     * @param min
     * @param max
     * @return
     */
    public static int getInt(String msg, int min, int max) {
        while (true) {
            int data = getInt(msg);
            if ((data < min) || (data > max)) {
                System.err.println("Enter in range[" + min + ", " + max + "]");
            } else {
                return data;
            }
        }
    }

    /**
     * phương thức trả về một số nguyên > min.
     *
     * @param msg
     * @param min
     * @return
     */
    public static int getInt(String msg, int min) {
        while (true) {
            int data = getInt(msg);
            if (data <= min) {
                System.err.println("Enter number > " + min);
            } else {
                return data;
            }
        }
    }

    /**
     * phương thức trả về một số nguyên.
     *
     * @param msg
     * @return
     */
    public static int getInt(String msg) {
        while (true) {
            try {
                System.out.print("Enter " + msg + ": ");
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.err.println("pls Enter Integer number!");
            }
        }
    }

    /**
     * phương thức trả về một chuỗi không rỗng.
     *
     * @param msg
     * @return
     */
    public static String getNonBlankString(String msg) {
        String data;
        do {
            System.out.print("Enter " + msg + ": ");
            data = sc.nextLine().trim();
            if (data.isEmpty()) {
                System.out.println(msg + " cannot empty!");
            } else {
                return data;
            }
        } while (true);
    }

    /**
     * trả về một chuỗi khớp với Pattern.
     *
     * @param msg
     * @param pattern
     * @return
     */
    public static String getStringWithPattern(String msg, String pattern) {
        String data;
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();
        } while (!data.matches(pattern));
        return data;
    }

    /**
     * xoá hàng khởi tạo mặc định, class này không có hàm khởi tạo.
     */
    private Inputter() {
    }

}
