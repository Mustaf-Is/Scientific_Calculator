
import java.awt.event.*;
import javax.swing.JButton;

/**
 * controllerCalculator qe trashegon nga modelCalculator dhe implementon
 * Interfejsin ActionListener, e bene funksionalizimin e te gjith butonave
 */
public class controllerCalculator extends modelCalculator implements ActionListener {

    boolean isPressed = false, state = false;
    int count = 0;
    double num1 = 0, num2 = 0, result = 0;
    String rDouble = "";
    char operator;

    /**
     * controllerCalculator Konstruktori i zbrazet (default)
     */
    public controllerCalculator() {

    }

    /**
     * functionButtons i shtone butonave ActionListener, per ta percktuar
     * funksionin e tyre kur te klikohen
     *
     * @return void
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
     * calculateFactorial metoda per kalkulimin e faktorielit te qfardo numri(
     * qofte me presje dhjetore apo i plote )
     *
     * @param n - vlera te ciles i kalkulohet faktorieli
     * @return double - Rezultati
     */
    public double calculateFactorial(double n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return Math.sqrt(2 * Math.PI * n) * Math.pow(n / Math.E, n);
        }
    }

    /**
     * actionPerformed percakton aksionin qe ndodhe pasi qe ndonjeri nga butonat
     * te jete klikuar
     *
     * @param e - Eventi qe ndodhe pasi butoni te jete klikuar
     * @return void
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton fButton : fButtons) {
            fButton.setEnabled(true);
        }

        for (int i = 0; i < 10; i++) {
            // E kthen eventin qe ndodhe pasi ndonjeri nga numButtons eshte klikuar
            if (e.getSource() == numButtons[i]) {
                if (textField.getText().equals("0")) {
                    textField.setText("");
                    label.setText("");
                }

                if (isPressed == true) {
                    textField.setText("");
                    label.setText("");
                    isPressed = false;
                }
                
                if (state == true) {
                    textField.setText("");
                    state = false;
                }
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }

        }

        // E kthen eventin qe ndodhe pasi decButton eshte klikuar
        if (e.getSource() == decButton) {
            //Butoni per shtimin e presjes dhjetore
            if (isPressed == true) {
                textField.setText("0");
                label.setText("0");
            }

            textField.setText(textField.getText().concat("."));
            decButton.setEnabled(false);
            isPressed = false;

        }

        // E kthen eventin qe ndodhe pasi addButtoni eshte klikuar
        if (e.getSource() == addButton) {
            //Butoni per llogaritjen e shumes
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
        // E kthen eventin qe ndodhe pasi subButtoni eshte klikuar
        if (e.getSource() == subButton) {
            //Butoni per llogaritjen e zbritjes
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
        // E kthen eventin qe ndodhe pasi mulButtoni eshte klikuar
        if (e.getSource() == mulButton) {
            //Butoni per llogaritjen e prodhimit
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
        // E kthen eventin qe ndodhe pasi divButtoni eshte klikuar
        if (e.getSource() == divButton) {
            // Butoni per llogaritjen e pjestimit
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
        // E kthen eventin qe ndodhe pasi sqrButtoni eshte klikuar
        if (e.getSource() == sqrButton) {
            //Butoni per llogaritjen e katrorit te nje numri
            num1 = Double.parseDouble(textField.getText());
            double square = Math.pow(num1, 2);
            String s1 = Double.toString(square);
            if (s1.endsWith(".0")) {
                textField.setText(s1.replace(".0", ""));

            } else {
                textField.setText("");
            }
            label.setText("sqr(" + String.valueOf(num1).replace(".0", "") + ")");
            if (s1.endsWith(".0")) {
                textArea.append(label.getText() + " = " + s1.replace(".0", "") + "\n");
            } else {
                textArea.append(label.getText() + " = " + s1 + "\n");
            }
            isPressed = true;
            decButton.setEnabled(true);
        }
        // E kthen eventin qe ndodhe pasi sqrtButtoni eshte klikuar
        if (e.getSource() == sqrtButton) {
            //Butoni per llogartijen e rrenjes katrore
            num1 = Double.parseDouble(textField.getText());
            double sqrt = Math.sqrt(num1);
            String s1 = String.valueOf(sqrt);
            if (s1.endsWith(".0")) {
                textField.setText(s1.replace(".0", ""));
            }
            if (s1.equals("NaN")) {
                textField.setText("Invalid Input");
                for (JButton fButton : fButtons) {
                    fButton.setEnabled(false);
                    isPressed = true;
                }
            } else {
                textField.setText(s1);
            }
            label.setText("sqrt(" + String.valueOf(num1).replace(".0", "") + ")");

            if (s1.endsWith(".0")) {
                textArea.append(label.getText() + " = " + s1.replace(".0", "") + "\n");
            }
            if (textField.getText().equals("Invalid Input")) {
                textArea.append("");
            } else {
                textArea.append(label.getText() + " = " + s1 + "\n");
            }
            isPressed = true;
            decButton.setEnabled(true);
        }
        // E kthen eventin qe ndodhe pasi reciprButtoni eshte klikuar
        if (e.getSource() == reciprButton) {
            //Butoni per llogaritjen e vleres reciproke te nje numri
            num1 = Double.parseDouble(textField.getText());
            double reciprocal = 1 / num1;
            String s1 = Double.toString(reciprocal);
            decButton.setEnabled(true);
            if (s1.endsWith(".0")) {
                textField.setText(s1.replace(".0", ""));
            }
            if (s1.equals("Infinity")) {
                textField.setText("Can't divide by zero");
                for (JButton fButton : fButtons) {
                    fButton.setEnabled(false);
                    isPressed = true;
                }
            } else {
                textField.setText(s1);
            }
            label.setText("1/(" + String.valueOf(num1).replace(".0", "") + ")");
            if (s1.endsWith(".0")) {
                textArea.append(label.getText() + " = " + s1.replace(".0", "") + "\n");
            }
            if (textField.getText().equals("Can't divide by zero")) {
                textArea.append("");
            } else {
                textArea.append(label.getText() + " = " + s1 + "\n");
            }
            isPressed = true;
        }
        // E kthen eventin qe ndodhe pasi logButtoni eshte klikuar
        if (e.getSource() == logButton) {
            //Butoni per llogaritjen e logaritmit me baze 10
            num1 = Double.parseDouble(textField.getText());
            double log = Math.log10(num1);
            String s1 = String.valueOf(log);
            decButton.setEnabled(true);
            if (s1.endsWith(".0")) {
                textField.setText(s1.replace(".0", ""));
            } else if (s1.equals("-Infinity") || s1.equals("NaN")) {
                textField.setText("Invalid Input");
                for (JButton fButton : fButtons) {
                    fButton.setEnabled(false);
                    isPressed = true;
                }
            } else {
                textField.setText(s1);
            }
            label.setText("log(" + String.valueOf(num1).replace(".0", "") + ")");
            if (s1.endsWith(".0")) {
                textArea.append(label.getText() + " = " + s1.replace(".0", "") + "\n");
            } else if (textField.getText().equals("Invalid Input")) {
                textArea.append("");
            } else {
                textArea.append(label.getText() + " = " + s1 + "\n");
            }
            isPressed = true;
        }
        // E kthen eventin qe ndodhe pasi lnButtoni eshte klikuar  
        if (e.getSource() == lnButton) {
            //Butoni per llogaritje te logaritmit natyrore
            num1 = Double.parseDouble(textField.getText());
            double ln = Math.log(num1);
            String s1 = Double.toString(ln);
            decButton.setEnabled(true);
            if (s1.endsWith(".0")) {
                textField.setText(s1.replace(".0", ""));
            } else if (s1.contains("-Infinity") || s1.equals("NaN")) {
                textField.setText("Invalid Input");
                for (JButton fButton : fButtons) {
                    fButton.setEnabled(false);
                    isPressed = true;
                }
            } else {
                textField.setText(s1);
            }
            label.setText("ln(" + String.valueOf(num1).replace(".0", "") + ")");
            if (s1.endsWith(".0")) {
                textArea.append(label.getText() + " = " + s1.replace(".0", "") + "\n");
            } else if (textField.getText().equals("Invalid Input")) {
                textArea.append("");
            } else {
                textArea.append(label.getText() + " = " + s1 + "\n");
            }
            isPressed = true;
        }
        // E kthen eventin qe ndodhe pasi eButtoni eshte klikuar
        if (e.getSource() == eButton) {
            //Butoni qe e kthen vleren  e numrit e
            String s1 = Double.toString(Math.E);
            textField.setText(s1);
            label.setText(s1);
            decButton.setEnabled(true);
            isPressed = true;
        }
        // E kthen eventin qe ndodhe pasi piButtoni eshte klikuar  
        if (e.getSource() == piButton) {
            //Butoni qe e kthen vleren e numrit pi
            String s1 = Double.toString(Math.PI);
            textField.setText(s1);
            label.setText(s1);
            decButton.setEnabled(true);
            isPressed = true;
        }
        // E kthen eventin qe ndodhe pasi absButtoni eshte klikuar
        if (e.getSource() == absButton) {
            //Butoni per llogaritjen e vleres absolute te nje numri
            num1 = Double.parseDouble(textField.getText());
            double abs = Math.abs(num1);
            String s1 = Double.toString(abs);
            decButton.setEnabled(true);
            if (s1.endsWith(".0")) {
                textField.setText(s1.replace(".0", ""));
            } else {
                textField.setText(s1);
            }
            label.setText("abs(" + String.valueOf(num1).replace(".0", "") + ")");
            if (s1.endsWith(".0")) {
                textArea.append(label.getText() + " = " + s1.replace(".0", "") + "\n");
            } else {
                textArea.append(label.getText() + " = " + s1 + "\n");
            }
            isPressed = true;
        }
        // E kthen eventin qe ndodhe pasi modButtoni eshte klikuar
        if (e.getSource() == modButton) {
            //Butoni per llogaritjen e pjestimit me mbetje
            num1 = Double.parseDouble(textField.getText());
            operator = '%';
            textField.setText("");
            decButton.setEnabled(true);
            String s1 = String.valueOf(num1);
            label.setText(s1.replace(".0", "") + " mod ");

        }
        // E kthen eventin qe ndodhe pasi ceilButtoni eshte klikuar
        if (e.getSource() == ceilButton) {
            //Butoni per llogaritje te pjeses se plote te siperme te nje numri
            num1 = Double.parseDouble(textField.getText());
            double ceil = Math.ceil(num1);
            String s1 = Double.toString(ceil);
            decButton.setEnabled(true);
            if (s1.endsWith(".0")) {
                textField.setText(s1.replace(".0", ""));
            }
            label.setText("ceil(" + String.valueOf(num1).replace(".0", "") + ")");
            if (s1.endsWith(".0")) {
                textArea.append(label.getText() + " = " + s1.replace(".0", "") + "\n");
            } else {
                textArea.append(label.getText() + " = " + s1 + "\n");
            }
            isPressed = true;
        }
        // E kthen eventin qe ndodhe pasi floorButoni eshte klikuar
        if (e.getSource() == floorButton) {
            //Butoni per llogaritje te pjeses se plote te poshtme te nje numri
            num1 = Double.parseDouble(textField.getText());
            double floor = Math.floor(num1);
            String s1 = Double.toString(floor);
            decButton.setEnabled(true);
            if (s1.endsWith(".0")) {
                textField.setText(s1.replace(".0", ""));
            }
            label.setText("floor(" + String.valueOf(num1).replace(".0", "") + ")");
            if (s1.endsWith(".0")) {
                textArea.append(label.getText() + " = " + s1.replace(".0", "") + "\n");
            } else {
                textArea.append(label.getText() + " = " + s1 + "\n");
            }
            isPressed = true;
        }
        // E kthen eventin qe ndodhe pasi factorialButtoni eshte klikuar
        if (e.getSource() == factorialButton) {
            //Butoni per llogaritjen e faktorielit te nje numri
            num1 = Double.parseDouble(textField.getText());
            double factorial = calculateFactorial(num1); // Invokimi i metodes calculateFactorial
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
            }
            if (textField.getText().equals("Overflow") || textField.getText().equals("Invalid Input")) {
                textArea.append("");
            } else {
                textArea.append(label.getText() + " = " + s1 + "\n");
            }
            isPressed = true;
        }
        // E kthen eventin qe ndodhe pasi poweryButtoni eshte klikuar
        if (e.getSource() == poweryButton) {
            //Butoni per llogaritjen e fuqise se qfardoshme te nje numri te qfardoshem
            num1 = Double.parseDouble(textField.getText());
            operator = '^';
            textField.setText("");
            decButton.setEnabled(true);
            String s1 = String.valueOf(num1);
            label.setText(s1.replace(".0", "") + " ^ ");

        }
        // E kthen eventin qe ndodhe pasi tenpowxbuttoni eshte klikuar
        if (e.getSource() == tenpowxbuttton) {
            //Butoni per llogaritjen e fuqive te numrit 10
            num1 = Double.parseDouble(textField.getText());
            double tenpow = Math.pow(10, num1);
            String s1 = Double.toString(tenpow);
            decButton.setEnabled(true);
            if (s1.endsWith(".0")) {
                textField.setText(s1.replace(".0", ""));
            } else {
                textField.setText(s1);
            }
            label.setText("10^(" + String.valueOf(num1).replace(".0", "") + ")");
            if (s1.endsWith(".0")) {
                textArea.append(label.getText() + " = " + s1.replace(".0", "") + "\n");
            } else {
                textArea.append(label.getText() + " = " + s1 + "\n");
            }
            isPressed = true;
        }
        // E kthen eventin qe ndodhe pasi sinButtoni eshte klikuar   
        if (e.getSource() == sinButton) {
            //Butoni per llogaritjen e sinusit
            num1 = Double.parseDouble(textField.getText());
            double sin = Math.sin(num1);
            String s1 = Double.toString(sin);
            decButton.setEnabled(true);
            if (s1.endsWith(".0")) {
                textField.setText(s1.replace(".0", ""));
            } else {
                textField.setText(s1);
            }
            label.setText("sin(" + String.valueOf(num1).replace(".0", "") + ")");
            if (s1.endsWith(".0")) {
                textArea.append(label.getText() + " = " + s1.replace(".0", "") + "\n");
            } else {
                textArea.append(label.getText() + " = " + s1 + "\n");
            }
            isPressed = true;
        }
        // E kthen eventin qe ndodhe pasi cosButtoni eshte klikuar
        if (e.getSource() == cosButton) {
            //Butoni per llogaritje te cosinusit
            num1 = Double.parseDouble(textField.getText());
            double cos = Math.cos(num1);
            String s1 = Double.toString(cos);
            decButton.setEnabled(true);
            if (s1.endsWith(".0")) {
                textField.setText(s1.replace(".0", ""));
            } else {
                textField.setText(s1);
            }
            label.setText("cos(" + String.valueOf(num1).replace(".0", "") + ")");
            if (s1.endsWith(".0")) {
                textArea.append(label.getText() + " = " + s1.replace(".0", "") + "\n");
            } else {
                textArea.append(label.getText() + " = " + s1 + "\n");
            }
            isPressed = true;
        }
        // E kthen eventin qe ndodhe pasi tanButoni eshte klikuar
        if (e.getSource() == tanButton) {
            //Butoni per llogaritje te tangjentit
            num1 = Double.parseDouble(textField.getText());
            double tan = Math.tan(num1);
            String s1 = Double.toString(tan);
            decButton.setEnabled(true);
            if (s1.endsWith(".0")) {
                textField.setText(s1.replace(".0", ""));
            } else {
                textField.setText(s1);
            }
            label.setText("tan(" + String.valueOf(num1).replace(".0", "") + ")");
            if (s1.endsWith(".0")) {
                textArea.append(label.getText() + " = " + s1.replace(".0", "") + "\n");
            } else {
                textArea.append(label.getText() + " = " + s1 + "\n");
            }
            isPressed = true;
        }
        // E kthen eventin qe ndodhe pasi cotButtoni eshte klikuar
        if (e.getSource() == cotButton) {
            //Butoni per llogaritje te cotangjentit
            num1 = Double.parseDouble(textField.getText());
            double cot = 1 / Math.tan(num1);
            String s1 = Double.toString(cot);
            negativeButton.setEnabled(true);
            if (s1.endsWith(".0")) {
                textField.setText(s1.replace(".0", ""));
            } else {
                textField.setText(s1);
            }
            label.setText("cot(" + String.valueOf(num1).replace(".0", "") + ")");
            if (s1.endsWith(".0")) {
                textArea.append(label.getText() + " = " + s1.replace(".0", "") + "\n");
            } else {
                textArea.append(label.getText() + " = " + s1 + "\n");
            }
            isPressed = true;
        }
        // E kthen eventin qe ndodhe pasi negativeButtoni eshte klikuar
        if (e.getSource() == negativeButton) {
            //Butoni per ta caktuar shenjen( +/- ) e numrit
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
        // E kthen eventin qe ndodhe pasi eqButtoni eshte klikuar
        if (e.getSource() == eqButton) {
            //Butoni per ta gjetur barazimin (rezultatin) e kalkulimeve (+, -, *, /, %, ^)
            num2 = Double.parseDouble(textField.getText());
            String s2 = String.valueOf(num2);

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
            }

            if (label.getText().contains("=")) {
                label.setText(label.getText());
            } else {
                label.setText(label.getText().concat(s2.replace(".0", "") + " ="));
            }

            if (textField.getText().equals("Can't divide by zero") || textField.getText().equals("Undefined")) {
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
        // E kthen eventin qe ndodhe pasi clrButtoni eshte klikuar
        if (e.getSource() == clrButton) {
            // Butoni per ta fshir gjithqka qfar kemi shtypur dhe per ta kthyer gjendjen fillestare
            textField.setText("0");
            label.setText("");
            decButton.setEnabled(true);
            count = 0;
        }
        // E kthen eventin qe ndodhe pasi delButtoni eshte klikuar
        if (e.getSource() == delButton) {
            //Butoni per ta fshir vetem nje numer 
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
        // E kthen eventin qe ndodhe pasi clearHistoryButoni eshte klikuar
        if (e.getSource() == clearHistoryButton) {
            //Butoni qe fshin tere historin e kalkulimeve
            textArea.setText("");
        }
    }
}
