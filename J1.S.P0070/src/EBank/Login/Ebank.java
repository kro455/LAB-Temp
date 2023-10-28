package Login;

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Ebank {

    public static final int MAX_LENGTH_CAPTCHA = 6;
    public static final String REGEX_ACCOUNT_NUMBER = "^\\d{10}$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,31}$";
    public static final char[] CHARS = "QWERTYUIOPLKJHGFDSAZXCVBNM0912345678".toCharArray();

    public void setLocale(Locale locale) {
        Locale.setDefault(locale);
    }

    public void login() {
        while (print(checkAccountNumber(getString("enterAccountNumber"))));
        while (print(checkPassword(getString("enterPassword"))));
        String captchaGenerate = generateCaptcha();
        System.out.println("Captcha: " + captchaGenerate);
        while (print(checkCaptcha(getString("enterCaptcha"), captchaGenerate)));
        print("loginSuccessfully");
    }

    String getString(String msg){
        Scanner sc = new Scanner(System.in);
        print(msg);
        return sc.nextLine();
    }

    String checkAccountNumber(String accountNumber) {
        return accountNumber.matches(REGEX_ACCOUNT_NUMBER) ? null : "errorAccount";
    }

    String checkPassword(String password) {
        return password.matches(REGEX_PASSWORD) ? null : "errorPassword";
    }

    String checkCaptcha(String captchaInput, String captchaGenerate) {
        return captchaInput.equals(captchaGenerate) ? null : "errorCaptcha";
    }

    String generateCaptcha() {
        Random random = new Random();
        StringBuilder captcha = new StringBuilder();
        while (captcha.length() < MAX_LENGTH_CAPTCHA) {
            captcha.append(CHARS[random.nextInt(CHARS.length)]);
        }
        return captcha.toString();
    }

    boolean print(String key) {
        if (key != null) {
            ResourceBundle bundle = ResourceBundle.getBundle("Language/messages");
            System.out.print(bundle.getString(key));
        }
        return (key != null);
    }
}