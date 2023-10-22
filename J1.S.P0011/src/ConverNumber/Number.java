package ConverNumber;

import java.math.BigInteger;

/**
 *
 * @author Admin
 */
public class Number {

    private String value;
    private int base;

    public Number(String value, int base) {
        if (checkBaseNumber(value, base)) {
            this.value = value;
            this.base = base;
        }
    }

    public void setValueAndBase(String value, int base) {
        if (checkBaseNumber(value, base)) {
            this.value = value;
            this.base = base;
        }
    }

    public int getBase() {
        return base;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + '(' + base + ')';
    }

    public Number convertTo(int newBase) {
        if (base == newBase) {
            return new Number(value, base);
        }

        // convert to dec first
        String newValue = (base == 10) ? value : fromBaseToDec(value, base);

        // covert dec to new base
        newValue = (newBase == 10) ? newValue : fromDecToBase(newValue, newBase);

        // return new base number
        return new Number(newValue, newBase);
    }

    private static final char[] BASE_DIGIT = { '0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
            'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

    private static String fromDecToBase(String value, int base) {
        BigInteger n = new BigInteger(value);
        BigInteger k = BigInteger.valueOf(base);
        StringBuilder data = new StringBuilder();

        while (n.compareTo(BigInteger.ZERO) != 0) {
            BigInteger[] r = n.divideAndRemainder(k);
            n = r[0];
            data.append(BASE_DIGIT[Integer.parseInt(r[1].toString())]);
        }

        return (data.length() != 0) ? data.reverse().toString() : "0";
    }

    private static String fromBaseToDec(String n, int k) {
        BigInteger bigNum = new BigInteger("0");
        BigInteger p = new BigInteger("1");
        BigInteger val = BigInteger.valueOf(k);
        int temp;

        for (int i = n.length() - 1; i >= 0; i--) {
            char c = n.charAt(i);
            // 'A'=65, '0'=48
            temp = c > 64 ? c - 55 : c - 48;
            bigNum = bigNum.add(p.multiply(BigInteger.valueOf(temp)));
            p = p.multiply(val);
        }

        return bigNum.toString();
    }

    private static final String BASE_CHARACTER = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static boolean checkBaseNumber(String value, int base) {
        String p = "[" + BASE_CHARACTER.substring(0, base) + "]+";
        return value.matches(p);
    }

}
