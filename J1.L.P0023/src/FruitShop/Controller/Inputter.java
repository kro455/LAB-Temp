package Controller;

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
        String data = getStringWithPattern(msg, "[YynN]");
        return data.matches("[Yy]");
    }

    /**
     * phương thức trả về một số nguyên trong khoảng [min, max].
     *
     * @param enterName
     * @param min
     * @param max
     * @return
     */
    public static int getInt(String enterName, int min, int max) {
        while (true) {
            int data = getInt(enterName);
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
     * @param enterName
     * @param min
     * @return
     */
    public static int getInt(String enterName, int min) {
        while (true) {
            int data = getInt(enterName);
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
     * @param enterName
     * @return
     */
    public static int getInt(String enterName) {
        while (true) {
            try {
                System.out.print("Enter " + enterName + ": ");
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.err.println("pls Enter Integer number!");
            }
        }
    }

    /**
     * phương thức trả về một chuỗi không rỗng.
     *
     * @param enterName
     * @return
     */
    public static String getNonBlankString(String enterName) {
        String data;
        do {
            System.out.print("Enter " + enterName + ": ");
            data = sc.nextLine().trim();
            if (data.isEmpty()) {
                System.out.println(enterName + " cannot empty!");
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
