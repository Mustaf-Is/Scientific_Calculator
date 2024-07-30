
import java.awt.event.*;
import javax.swing.JButton;

/**
 * controllerCalculator controls the functionallity of the application. Decides
 * what action happens after a button is pressed and how the calculations are
 * made.
 *
 * @author Mustafë Ismajli
 * @version 22.0.1
 */
public class controllerCalculator extends modelCalculator implements ActionListener {

    //Declaration of the necessary variables for usage
    boolean isPressed = false, state = false;
    int count = 0;
    double num1 = 0, num2 = 0, result = 0;
    String rDouble = "";
    char operator;

    /**
     * functionButtons - adds an AcctionListener to each button to determine the functionality of buttons.
     */
    public void functionButtons() {
        for (JButton fButton : fButtons) {
            fButton.addActionListener(this);
            fButton.setFocusable(false);
        }
        for (JButton numButton : numButtons) {
            numButton.addActionListener(this);
            numButton.setFocusable(false);
        }
        clearHistoryButton.addActionListener(this);

    }

    /**
     * The method for calculating the factorial of real numbers
     *
     * @param n - the real number n
     * @return - n!. The factorial of n, which is a floating-point number.
     */
    public double calculateFactorial(double n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return Math.sqrt(2 * Math.PI * n) * Math.pow(n / Math.E, n);
        }
    }

    /**
     * actionPerformed - determines what action happens after the button is
     * clicked.
     *
     * @param e The event which indicates that a component-defined action
     * occurred
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton fButton : fButtons) {
            fButton.setEnabled(true);
        }

        for (int i = 0; i < 10; i++) {

            if (e.getSource() == numButtons[i]) {
                if (textField.getText().equals("0")) {
                    textField.setText("");
                    label.setText("");
                } else if (isPressed == true) {
                    textField.setText("");
                    label.setText("");
                    isPressed = false;
                } else if (state == true) {
                    textField.setText("");
                    state = false;
                }
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }

        }

        if (e.getSource() == decButton) {

            if (isPressed == true) {
                textField.setText("0");
                label.setText("0");
            } else {
                textField.setText(textField.getText().concat("."));
                decButton.setEnabled(false);
                isPressed = false;
            }

        }

        if (e.getSource() == addButton) {

            if (count >= 1) {
                num2 = Double.parseDouble(textField.getText());
                result = num1 + num2;
                String s2 = String.valueOf(result);
                if (s2.endsWith(".0")) {
                    textField.setText(s2.replace(".0", ""));
                } else {
                    textField.setText(s2);
                }
                result = num2;
                count = 0;
            }

            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            String s1 = String.valueOf(num1);

            textField.setText(s1.replace(".0", ""));
            label.setText(s1.replace(".0", "") + " + ");
            isPressed = false;
            decButton.setEnabled(true);
            state = true;
            count++;

        }

        if (e.getSource() == subButton) {

            if (count >= 1) {
                num2 = Double.parseDouble(textField.getText());
                result = num1 - num2;
                String s2 = String.valueOf(result);
                if (s2.endsWith(".0")) {
                    textField.setText(s2.replace(".0", ""));
                } else {
                    textField.setText(s2);
                }
                result = num2;

                count = 0;
            }

            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            String s1 = String.valueOf(num1);
            textField.setText(s1.replace(".0", ""));
            label.setText(s1.replace(".0", "") + " - ");
            decButton.setEnabled(true);
            state = true;
            isPressed = false;
            count++;
        }

        if (e.getSource() == mulButton) {

            if (count >= 1) {
                num2 = Double.parseDouble(textField.getText());
                result = num1 * num2;
                String s2 = String.valueOf(result);
                if (s2.endsWith(".0")) {
                    textField.setText(s2.replace(".0", ""));
                } else {
                    textField.setText(s2);
                }
                result = num2;

                count = 0;
            }
            num1 = Double.parseDouble(textField.getText());
            operator = 'x';
            String s1 = String.valueOf(num1);
            textField.setText(s1.replace(".0", ""));
            label.setText(s1.replace(".0", "") + " x ");
            decButton.setEnabled(true);
            count++;
            state = true;
            isPressed = false;
        }

        if (e.getSource() == divButton) {

            if (count >= 1) {
                num2 = Double.parseDouble(textField.getText());
                result = num1 / num2;
                String s2 = String.valueOf(result);
                if (s2.endsWith(".0")) {
                    textField.setText(s2.replace(".0", ""));
                } else {
                    textField.setText(s2);
                }
                result = num2;
                if (textField.getText().equals("Infinity")) {
                    textField.setText("Can't divide by zero");
                    for (JButton fButton : fButtons) {
                        fButton.setEnabled(false);
                        isPressed = true;
                    }
                } else if (textField.getText().equals("NaN")) {
                    textField.setText("Undefined");
                    for (JButton fButton : fButtons) {
                        fButton.setEnabled(false);
                        isPressed = true;
                    }
                }

                count = 0;

            }
            num1 = Double.parseDouble(textField.getText());
            operator = '÷';
            String s1 = String.valueOf(num1);
            textField.setText(s1.replace(".0", ""));
            label.setText(s1.replace(".0", "") + " ÷ ");
            decButton.setEnabled(true);
            count++;
            state = true;
            isPressed = false;
        }

        if (e.getSource() == sqrButton) {

            num1 = Double.parseDouble(textField.getText());
            double square = Math.pow(num1, 2);
            String s1 = Double.toString(square);
            label.setText("sqr(" + String.valueOf(num1).replace(".0", "") + ")");
            if (s1.endsWith(".0")) {
                textField.setText(s1.replace(".0", ""));
                textArea.append(label.getText() + " = " + s1.replace(".0", "") + "\n");

            } else {
                textField.setText("");
                textArea.append(label.getText() + " = " + s1 + "\n");
            }

            isPressed = true;
            decButton.setEnabled(true);
        }

        if (e.getSource() == sqrtButton) {
            num1 = Double.parseDouble(textField.getText());
            double sqrt = Math.sqrt(num1);
            String s1 = String.valueOf(sqrt);
            label.setText("sqrt(" + String.valueOf(num1).replace(".0", "") + ")");
            if (s1.endsWith(".0")) {
                textField.setText(s1.replace(".0", ""));
                textArea.append(label.getText() + " = " + s1.replace(".0", "") + "\n");
            } else if (s1.equals("NaN")) {
                textField.setText("Invalid Input");
                for (JButton fButton : fButtons) {
                    fButton.setEnabled(false);
                    isPressed = true;
                }
            } else if (textField.getText().equals("Invalid Input")) {
                textArea.append("");
            } else {
                textField.setText(s1);
                textArea.append(label.getText() + " = " + s1 + "\n");
            }

            isPressed = true;
            decButton.setEnabled(true);
        }

        if (e.getSource() == reciprButton) {

            num1 = Double.parseDouble(textField.getText());
            double reciprocal = 1 / num1;
            String s1 = Double.toString(reciprocal);
            decButton.setEnabled(true);
            label.setText("1/(" + String.valueOf(num1).replace(".0", "") + ")");
            if (s1.endsWith(".0")) {
                textField.setText(s1.replace(".0", ""));
                textArea.append(label.getText() + " = " + s1.replace(".0", "") + "\n");
            } else if (s1.equals("Infinity")) {
                textField.setText("Can't divide by zero");
                for (JButton fButton : fButtons) {
                    fButton.setEnabled(false);
                    isPressed = true;
                }
            } else if (textField.getText().equals("Can't divide by zero")) {
                textArea.append("");
            } else {
                textField.setText(s1);
                textArea.append(label.getText() + " = " + s1 + "\n");
            }

            isPressed = true;
        }

        if (e.getSource() == logButton) {

            num1 = Double.parseDouble(textField.getText());
            double log = Math.log10(num1);
            String s1 = String.valueOf(log);
            decButton.setEnabled(true);
            label.setText("log(" + String.valueOf(num1).replace(".0", "") + ")");
            if (s1.endsWith(".0")) {
                textField.setText(s1.replace(".0", ""));
                textArea.append(label.getText() + " = " + s1.replace(".0", "") + "\n");
            } else if (s1.equals("-Infinity") || s1.equals("NaN")) {
                textField.setText("Invalid Input");
                for (JButton fButton : fButtons) {
                    fButton.setEnabled(false);
                    isPressed = true;
                }
            } else if (textField.getText().equals("Invalid Input")) {
                textArea.append("");
            } else {
                textField.setText(s1);
                textArea.append(label.getText() + " = " + s1 + "\n");
            }

            isPressed = true;
        }

        if (e.getSource() == lnButton) {

            num1 = Double.parseDouble(textField.getText());
            double ln = Math.log(num1);
            String s1 = Double.toString(ln);
            decButton.setEnabled(true);
            label.setText("ln(" + String.valueOf(num1).replace(".0", "") + ")");
            if (s1.endsWith(".0")) {
                textField.setText(s1.replace(".0", ""));
                textArea.append(label.getText() + " = " + s1.replace(".0", "") + "\n");
            } else if (s1.contains("-Infinity") || s1.equals("NaN")) {
                textField.setText("Invalid Input");
                for (JButton fButton : fButtons) {
                    fButton.setEnabled(false);
                    isPressed = true;
                }
            } else if (textField.getText().equals("Invalid Input")) {
                textArea.append("");
            } else {
                textField.setText(s1);
                textArea.append(label.getText() + " = " + s1 + "\n");
            }

            isPressed = true;
        }

        if (e.getSource() == eButton) {

            String s1 = Double.toString(Math.E);
            textField.setText(s1);
            label.setText(s1);
            decButton.setEnabled(true);
            isPressed = true;
        }

        if (e.getSource() == piButton) {
            String s1 = Double.toString(Math.PI);
            textField.setText(s1);
            label.setText(s1);
            decButton.setEnabled(true);
            isPressed = true;
        }

        if (e.getSource() == absButton) {

            num1 = Double.parseDouble(textField.getText());
            double abs = Math.abs(num1);
            String s1 = Double.toString(abs);
            decButton.setEnabled(true);
            label.setText("abs(" + String.valueOf(num1).replace(".0", "") + ")");
            if (s1.endsWith(".0")) {
                textField.setText(s1.replace(".0", ""));
                textArea.append(label.getText() + " = " + s1.replace(".0", "") + "\n");
            } else {
                textField.setText(s1);
                textArea.append(label.getText() + " = " + s1 + "\n");
            }

            isPressed = true;
        }

        if (e.getSource() == modButton) {

            num1 = Double.parseDouble(textField.getText());
            operator = '%';
            textField.setText("");
            decButton.setEnabled(true);
            String s1 = String.valueOf(num1);
            label.setText(s1.replace(".0", "") + " mod ");

        }

        if (e.getSource() == ceilButton) {

            num1 = Double.parseDouble(textField.getText());
            double ceil = Math.ceil(num1);
            String s1 = Double.toString(ceil);
            decButton.setEnabled(true);
            label.setText("ceil(" + String.valueOf(num1).replace(".0", "") + ")");
            if (s1.endsWith(".0")) {
                textField.setText(s1.replace(".0", ""));
                textArea.append(label.getText() + " = " + s1.replace(".0", "") + "\n");
            } else {
                textArea.append(label.getText() + " = " + s1 + "\n");
            }

            isPressed = true;
        }

        if (e.getSource() == floorButton) {

            num1 = Double.parseDouble(textField.getText());
            double floor = Math.floor(num1);
            String s1 = Double.toString(floor);
            decButton.setEnabled(true);
            label.setText("floor(" + String.valueOf(num1).replace(".0", "") + ")");
            if (s1.endsWith(".0")) {
                textField.setText(s1.replace(".0", ""));
                textArea.append(label.getText() + " = " + s1.replace(".0", "") + "\n");
            } else {
                textArea.append(label.getText() + " = " + s1 + "\n");
            }

            isPressed = true;
        }

        if (e.getSource() == factorialButton) {

            num1 = Double.parseDouble(textField.getText());
            double factorial = calculateFactorial(num1);
            String s1 = Double.toString(factorial);
            decButton.setEnabled(true);
            if (s1.endsWith(".0")) {
                textField.setText(s1.replace(".0", ""));
            }
            switch (s1) {
                case "Infinity" -> {
                    textField.setText("Overflow");
                    for (JButton fButton : fButtons) {
                        fButton.setEnabled(false);
                        isPressed = true;
                    }
                }
                case "NaN" -> {
                    textField.setText("Invalid Input");
                    for (JButton fButton : fButtons) {
                        fButton.setEnabled(false);
                        isPressed = true;
                    }
                }
                default ->
                    textField.setText(s1);
            }
            label.setText("factorial(" + String.valueOf(num1).replace(".0", "") + ")");
            if (s1.endsWith(".0")) {
                textArea.append(label.getText() + " = " + s1.replace(".0", "") + "\n");
            } else if (textField.getText().equals("Overflow") || textField.getText().equals("Invalid Input")) {
                textArea.append("");
            } else {
                textArea.append(label.getText() + " = " + s1 + "\n");
            }
            isPressed = true;
        }

        if (e.getSource() == poweryButton) {

            if (count >= 1) {
                num2 = Double.parseDouble(textField.getText());
                result = Math.pow(num1, num2);
                String s2 = String.valueOf(result);
                if (s2.endsWith(".0")) {
                    textField.setText(s2.replace(".0", ""));
                } else {
                    textField.setText(s2);
                }
                result = num2;

                count = 0;
            }

            num1 = Double.parseDouble(textField.getText());
            operator = '^';
            String s1 = String.valueOf(num1);
            textField.setText(s1.replace(".0", ""));
            label.setText(s1.replace(".0", "") + " ^ ");
            decButton.setEnabled(true);
            count++;
            state = true;
            isPressed = false;

        }

        if (e.getSource() == tenpowxbuttton) {

            num1 = Double.parseDouble(textField.getText());
            double tenpow = Math.pow(10, num1);
            String s1 = Double.toString(tenpow);
            decButton.setEnabled(true);
            label.setText("10^(" + String.valueOf(num1).replace(".0", "") + ")");
            if (s1.endsWith(".0")) {
                textField.setText(s1.replace(".0", ""));
                textArea.append(label.getText() + " = " + s1.replace(".0", "") + "\n");
            } else {
                textField.setText(s1);
                textArea.append(label.getText() + " = " + s1 + "\n");
            }

            isPressed = true;
        }

        if (e.getSource() == sinButton) {

            num1 = Double.parseDouble(textField.getText());
            double sin = Math.sin(num1);
            String s1 = Double.toString(sin);
            decButton.setEnabled(true);
            label.setText("sin(" + String.valueOf(num1).replace(".0", "") + ")");
            if (s1.endsWith(".0")) {
                textField.setText(s1.replace(".0", ""));
                textArea.append(label.getText() + " = " + s1.replace(".0", "") + "\n");
            } else {
                textField.setText(s1);
                textArea.append(label.getText() + " = " + s1 + "\n");
            }

            isPressed = true;
        }

        if (e.getSource() == cosButton) {

            num1 = Double.parseDouble(textField.getText());
            double cos = Math.cos(num1);
            String s1 = Double.toString(cos);
            decButton.setEnabled(true);
            label.setText("cos(" + String.valueOf(num1).replace(".0", "") + ")");
            if (s1.endsWith(".0")) {
                textField.setText(s1.replace(".0", ""));
                textArea.append(label.getText() + " = " + s1.replace(".0", "") + "\n");
            } else {
                textField.setText(s1);
                textArea.append(label.getText() + " = " + s1 + "\n");
            }

            isPressed = true;
        }

        if (e.getSource() == tanButton) {

            num1 = Double.parseDouble(textField.getText());
            double tan = Math.tan(num1);
            String s1 = Double.toString(tan);
            decButton.setEnabled(true);
            label.setText("tan(" + String.valueOf(num1).replace(".0", "") + ")");
            if (s1.endsWith(".0")) {
                textField.setText(s1.replace(".0", ""));
                textArea.append(label.getText() + " = " + s1.replace(".0", "") + "\n");
            } else {
                textField.setText(s1);
                textArea.append(label.getText() + " = " + s1 + "\n");
            }

            isPressed = true;
        }

        if (e.getSource() == cotButton) {

            num1 = Double.parseDouble(textField.getText());
            double cot = 1 / Math.tan(num1);
            String s1 = Double.toString(cot);
            negativeButton.setEnabled(true);
            label.setText("cot(" + String.valueOf(num1).replace(".0", "") + ")");
            if (s1.endsWith(".0")) {
                textField.setText(s1.replace(".0", ""));
                textArea.append(label.getText() + " = " + s1.replace(".0", "") + "\n");
            } else {
                textField.setText(s1);
                textArea.append(label.getText() + " = " + s1 + "\n");
            }
            isPressed = true;
        }

        if (e.getSource() == negativeButton) {

            if (textField.getText().equals("0")) {
                textField.setText("0");
            } else if (label.getText().equals("")) {
                num1 = -1 * Double.parseDouble(textField.getText());
                String s1 = Double.toString(num1);
                if (s1.endsWith(".0")) {
                    textField.setText(s1.replace(".0", ""));
                } else {
                    textField.setText(s1);
                }
            } else {
                num2 = -1 * Double.parseDouble(textField.getText());
                String s1 = Double.toString(num2);
                if (s1.endsWith(".0")) {
                    textField.setText(s1.replace(".0", ""));
                } else {
                    textField.setText(s1);
                }
            }

            decButton.setEnabled(true);

        }

        if (e.getSource() == eqButton) {

            num2 = Double.parseDouble(textField.getText());
            String s2 = String.valueOf(num2);

            if (label.getText().contains("=")) {
                label.setText(label.getText());
            } else {
                label.setText(label.getText().concat(s2.replace(".0", "") + " ="));
            }

            switch (operator) {
                case '+' ->
                    result = num1 + (num2);
                case '-' ->
                    result = num1 - (num2);
                case 'x' ->
                    result = num1 * (num2);
                case '÷' ->
                    result = num1 / (num2);
                case '%' ->
                    result = num1 % (num2);
                case '^' ->
                    result = Math.pow(num1, num2);
            }

            rDouble = String.valueOf(result);
            if (rDouble.equals("-0.0")) {
                textField.setText(rDouble.replace("-0.0", "0"));
                rDouble = "0";
            } else if (rDouble.endsWith(".0")) {
                textField.setText(rDouble.replace(".0", ""));
            } else {
                textField.setText(rDouble);
            }

            if (textField.getText().equals("Infinity")) {
                textField.setText("Can't divide by zero");
                for (JButton fButton : fButtons) {
                    fButton.setEnabled(false);
                    isPressed = true;
                }
            } else if (textField.getText().equals("NaN")) {
                textField.setText("Undefined");
                for (JButton fButton : fButtons) {
                    fButton.setEnabled(false);
                    isPressed = true;
                }
            } else if (textField.getText().equals("Can't divide by zero") || textField.getText().equals("Undefined")) {
                textArea.append("");
            } else if (rDouble.endsWith(".0")) {
                textArea.append(label.getText() + " " + rDouble.replace(".0", "") + "\n");
            } else {
                textArea.append(label.getText() + " " + rDouble + "\n");
            }

            num1 = result;
            isPressed = true;
            decButton.setEnabled(true);
            count = 0;
        }

        if (e.getSource() == clrButton) {

            textField.setText("0");
            label.setText("");
            decButton.setEnabled(true);
            count = 0;
        }

        if (e.getSource() == delButton) {

            String s1 = textField.getText();
            if (s1.length() == 1) {
                textField.setText(textField.getText().replace(s1, "0"));
                label.setText("");
            } else {
                textField.setText("");
            }
            for (int i = 0; i < s1.length() - 1; i++) {
                textField.setText(textField.getText() + s1.charAt(i));
                label.setText(label.getText());
            }

            if (textField.getText().contains(".")) {
                decButton.setEnabled(false);
            } else {
                decButton.setEnabled(true);
            }

        }

        if (e.getSource() == clearHistoryButton) {
            textArea.setText("");
        }
    }
}
