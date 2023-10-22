package ConverNumber;

/**
 *
 * @author Admin
 */
public class ConvertNumber {

    public static final int MIN_BASE = 2;
    public static final int MAX_BASE = 36;

    private Number inputNumber;
    private Number outputNumber;

    public void setInputNumber() {
        int baseInput = Inputter.getInt("Input base", MIN_BASE, MAX_BASE);
        String value = Inputter.getValue("Input value: ", baseInput);
        inputNumber = new Number(value, baseInput);
    }

    public void setOutputNumber() {
        if (inputNumber == null) {
            System.out.println("Input number to convert first!");
            setInputNumber();
        }
        int baseOutput = Inputter.getInt("Conver to base", MIN_BASE, MAX_BASE);
        outputNumber = inputNumber.convertTo(baseOutput);
        display();
    }

    public void display() {
        System.out.println("Input Number  : " + inputNumber);
        System.out.println("Result convert: " + outputNumber);
        Inputter.askEnter();
    }

}
