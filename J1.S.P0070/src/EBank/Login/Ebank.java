package Login;

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Ebank {

    public static final int MAX_LENGTH_CAPTCHA = 6;
    public static final String REGEX_ACCOUNT_NUMBER = "^\\d{10}$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,31}$";
    public static final char[] CHARS = "QWERTYUIOPLKJHGFDSAZXCVBNM0912345678".toCharArray();

    public Ebank() {
    }

    public void setLocale(Locale locale) {
        Locale.setDefault(locale);
    }

    public void login() {
        Scanner sc = new Scanner(System.in);
        do {
            print("enterAccountNumber");
        } while (print(checkAccountNumber(sc.nextLine())));

        do {
            print("enterPassword");
        } while (print(checkPassword(sc.nextLine())));

        String captchaGenerate = generateCaptcha();
        System.out.println("Captcha: " + captchaGenerate);
        do {
            print("enterCaptcha");
        } while (print(checkCaptcha(sc.nextLine(), captchaGenerate)));
        print("loginSuccessfully");
    }

    public String checkAccountNumber(String accountNumber) {
        if (accountNumber.matches(REGEX_ACCOUNT_NUMBER)) {
            return null;
        }
        return "errorAccount";
    }

    public String checkPassword(String password) {
        if (password.matches(REGEX_PASSWORD)) {
            return null;
        }
        return "errorPassword";
    }

    public String checkCaptcha(String captchaInput, String captchaGenerate) {
        if (captchaInput.matches(captchaGenerate)) {
            return null;
        }
        return "errorCaptcha";
    }

    public String generateCaptcha() {
        Random random = new Random();
        StringBuilder captcha = new StringBuilder();
        while (captcha.length() < MAX_LENGTH_CAPTCHA) {
            captcha.append(CHARS[random.nextInt(CHARS.length)]);
        }
        return captcha.toString();
    }

    boolean print(String key) {
        if (key == null) {
            return false;
        }
        ResourceBundle bundle = ResourceBundle.getBundle("Language/messages");
        System.out.print(bundle.getString(key));
        return true;
    }
}
