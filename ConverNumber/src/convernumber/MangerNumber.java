/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convernumber;

/**
 *
 * @author Admin
 */
public class MangerNumber {

    private Number inputNumber;
    private Number outputNumber;

    public static final int MIN_BASE = 2;
    public static final int MAX_BASE = 36;

    public void setInputNumber() {
        int baseInput = Input.getInt("Input base", MIN_BASE, MAX_BASE);
        String value = Input.getValue("Input value: ", baseInput);
        inputNumber = new Number(value, baseInput);
    }

    public void setOutputNumber() {
        if (inputNumber == null) {
            System.out.println("Input number to convert first!");
            return;
        }
        int baseOutput = Input.getInt("Conver to base", MIN_BASE, MAX_BASE);
        outputNumber = inputNumber.convertTo(baseOutput);
        display();
    }

    public void display() {
        System.out.println("Input Number  : " + inputNumber);
        System.out.println("Result convert: " + outputNumber);
        Input.askEnter();
    }

}