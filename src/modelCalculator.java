import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * @author Mustafë Ismajli
 * @version Java 22
 * modelCalculator modulates tha main components
 */
public class modelCalculator extends JFrame {

    //Variablat e fushes te nevojshme per modelim
    JFrame frame;
    JTextField textField;
    JTextArea textArea;
    JScrollPane scrollPane;
    JButton[] numButtons = new JButton[10];
    JButton[] fButtons = new JButton[28];
    JButton addButton, subButton, mulButton, divButton, sqrButton, reciprButton, sqrtButton, piButton, eButton, absButton, modButton, factorialButton, poweryButton, tenpowxbuttton, logButton, lnButton, sinButton, cosButton, tanButton, cotButton,
            ceilButton, floorButton, signumButton, negativeButton, decButton, eqButton, delButton, clrButton, clearHistoryButton;
    JLabel label = new JLabel();
    JLabel stringLabel;
    JPanel panel, panel1;
    Dimension screenSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getSize();
    Font buttonsFont = new Font("SF Pro", Font.TRUETYPE_FONT, 17);
    Font textFieldFont = new Font("Bahnschrift", Font.CENTER_BASELINE, 55);
    Font labeFont = new Font("Palatino Linotype", Font.TRUETYPE_FONT, 20);
    Color fbuttonsColor = new Color(44, 45, 46);
    Color numbuttonsColor = new Color(61, 61, 61);
    Color numbuttonsHoverColor = new Color(44, 45, 46);
    Color hoverBackground = new Color(56, 56, 56);
    Color hoverForeground = new Color(156, 147, 146);

    /**
     * modelCalculator Konstruktori i zbrazet (default)
     */
    public modelCalculator() {

    }

    /**
     * settingFrame Krijon frejmin(dritaren) duke i dhene emer dhe dimensionet e caktuara
     */
    public void settingFrame() {

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(screenSize.width + 13, screenSize.height + 7);
        frame.setLocation(-6, 0);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.black); //Ngjyros prapvine me te zeze
        frame.setResizable(false); //E bene frejmin te pazmadhueshem

        //Ne raste se ikona deshton te lexohet kape nje excpetion te tipit IOException, duke dhene nje mesazh!
        try {
            Image iconImage = ImageIO.read(modelCalculator.class.getResource("./Icon.png"));
            frame.setIconImage(iconImage); //E vendos ikonen e frejmit
        } catch (IOException e) {
            System.out.println("Ikona e frame-it nuk mund te ngarkohet: " + e.getMessage());
        }

    }
    
    /**
     * numbuttonsMouseAdapter kthene si rezultat nje MouseAdapter dhe vendos
     * MouseEvent per butonat qe permbajne numra
     *
     * @param index - indexi i numButonit
     * @return MouseAdapter
     */
    public MouseAdapter numbuttonsMouseAdapter(int index) {
        return new MouseAdapter() {
            /**
             * mouseEntered Kur e vendosim mousin mbi butonin me index te
             * caktuar i ndrrojm prapavijen dhe ngjyren e fontit
             *
             * @param e - MouseEventi
             * @return void
             */
            @Override
            public void mouseEntered(MouseEvent e) {

                numButtons[index].setBackground(numbuttonsHoverColor);
                numButtons[index].setForeground(hoverForeground);
                
            }

            /**
             * mouseExited Kur e largojme mousin nga butoni me index te caktuar,
             * ngjyra e prapavise dhe fontit kthehen ne gjendjen fillestare
             *
             * @param e - MouseEventi
             * @return void
             */
            @Override
            public void mouseExited(MouseEvent e) {

                numButtons[index].setBackground(numbuttonsColor);
                numButtons[index].setForeground(Color.white);

            }

        };
    }

    /**
     * fButtonsMouseAdapter kthene si rezultat nje MouseAdapter dhe vendos
     * MouseEvent per butonat qe permbajne funksione (p.sh =, + ...)
     *
     * @param index - indexi i fButtonit
     * @return MouseAdapter
     */
    public MouseAdapter fbuttonsMouseAdapter(int index) {
        return new MouseAdapter() {
            /**
             * mouseEntered Kur e vendosim mousin mbi butonin me index te
             * caktuar i ndrrojm prapavijen dhe ngjyren e fontit
             *
             * @param e - MouseEventi
             */
            @Override
            public void mouseEntered(MouseEvent e) {

                fButtons[index].setBackground(hoverBackground);
                fButtons[index].setForeground(hoverForeground);

            }

            /**
             * mouseExited Kur e largojme mousin nga butoni me index te caktuar,
             * ngjyra e prapavise dhe fontit kthehen ne gjendjen fillestare
             *
             * @param e - MouseEventi
             */
            @Override
            public void mouseExited(MouseEvent e) {

                fButtons[index].setBackground(fbuttonsColor);
                fButtons[index].setForeground(Color.white);

            }
        };

    }

    /**
     * drawButtons e bene ngjyrosjen, caktimin e fontit dhe madhesine e butonave
     *
     * @return void
     */
    public void drawButtons() {
        //Krijimi i butonave per funksione 
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("÷");
        decButton = new JButton(".");
        eqButton = new JButton("=");
        delButton = new JButton("\u232B");
        clrButton = new JButton("C");
        sqrButton = new JButton("x\u00B2");
        reciprButton = new JButton("x\u207B\u00B9");
        sqrtButton = new JButton("\u221A");
        piButton = new JButton("π");
        eButton = new JButton("e");
        absButton = new JButton("|x|");
        modButton = new JButton("mod");
        factorialButton = new JButton("x!");
        poweryButton = new JButton("x\u207F");
        tenpowxbuttton = new JButton("10\u207F");
        logButton = new JButton("log");
        lnButton = new JButton("ln");
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");
        cotButton = new JButton("cot");
        ceilButton = new JButton("\u2308x\u2309");
        floorButton = new JButton("\u230Ax\u230B");
        signumButton = new JButton("sgn");
        negativeButton = new JButton("(-)");
        clearHistoryButton = new JButton("🗑");

        //Vendosja e butonave per funksione ne Vargun fButtons(ne te cilin ruhen te gjitha butonat per funksione)
        fButtons[0] = ceilButton;
        fButtons[1] = floorButton;
        fButtons[2] = eButton;
        fButtons[3] = piButton;
        fButtons[4] = absButton;
        fButtons[5] = sqrButton;
        fButtons[6] = reciprButton;
        fButtons[7] = modButton;
        fButtons[8] = sqrtButton;
        fButtons[9] = factorialButton;
        fButtons[10] = poweryButton;
        fButtons[11] = tenpowxbuttton;
        fButtons[12] = logButton;
        fButtons[13] = lnButton;
        fButtons[14] = divButton;
        fButtons[15] = sinButton;
        fButtons[16] = mulButton;
        fButtons[17] = cosButton;
        fButtons[18] = subButton;
        fButtons[19] = tanButton;
        fButtons[20] = addButton;
        fButtons[21] = cotButton;
        fButtons[22] = negativeButton;
        fButtons[23] = decButton;
        fButtons[24] = eqButton;
        fButtons[25] = signumButton;
        fButtons[26] = clrButton;
        fButtons[27] = delButton;

        clearHistoryButton.setBounds(1484, 37, 50, 50);
        clearHistoryButton.setBackground(Color.black);
        clearHistoryButton.setFont(new Font("Segoe UI Symbol", Font.TRUETYPE_FONT, 40));
        clearHistoryButton.setBorder(null);
        clearHistoryButton.setFocusable(false);
        clearHistoryButton.setForeground(Color.white);
        clearHistoryButton.addMouseListener(new MouseAdapter() {
            /**
             * mouseEntered Kur e vendosim mousin mbi butonin clearHistoryButton
             * i ndrrojm prapavijen dhe ngjyren e fontit
             *
             * @param e - MouseEventi
             * @return void
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                clearHistoryButton.setBackground(new Color(59, 1, 11));
                clearHistoryButton.setForeground(hoverForeground);
                clearHistoryButton.setToolTipText("Clear all history");
            }

            /**
             * mouseExited Kur e largojme mousin nga butoni clearHistoryButton,
             * ngjyra e prapavise dhe fontit kthehen ne gjendjen fillestare
             *
             * @param e - MouseEventi
             * @return void
             */
            @Override
            public void mouseExited(MouseEvent e) {
                clearHistoryButton.setBackground(Color.black);
                clearHistoryButton.setForeground(Color.white);
            }
        });

        for (int i = 0; i < fButtons.length; i++) {
            fButtons[i].setBackground(fbuttonsColor); //Ngjyrosja e prapavise te fButttons
            //Tre butonat eqButton(=), clrButton(c) dhe delButton(del) kane ngjyre te ndryshme te prapavise per tu vequar nga butonat e tjere
            eqButton.setBackground(new Color(191, 146, 10));
            clrButton.setBackground(new Color(71, 2, 14));
            delButton.setBackground(new Color(125, 44, 4));
            fButtons[i].setForeground(Color.white); //Ngjyrosja e fontit
            fButtons[i].setFont(buttonsFont); //Caktimi i lloit te fontit
            clrButton.setFont(new Font("SF Pro", Font.TYPE1_FONT, 25));
            delButton.setFont(new Font("SF Pro", Font.TYPE1_FONT, 25));
            fButtons[i].addMouseListener(fbuttonsMouseAdapter(i)); //Invokimi i metodes fbuttonsMouseAdapter
            //Tre butonat eqButton(=), clrButton(c) dhe delButton(del) marrin ngjyra te ndryshme te prapavise kur ta vendosim mousin mbi to
            clrButton.addMouseListener(new MouseAdapter() {
                /**
                 * mouseEntered Kur e vendosim mousin mbi butonin clrButton i
                 * ndrrojm prapavijen dhe ngjyren e fontit
                 *
                 * @param e - MouseEventi
                 * @return void
                 */
                @Override
                public void mouseEntered(MouseEvent e) {
                    clrButton.setBackground(new Color(59, 1, 11));
                    clrButton.setForeground(hoverForeground);
                }

                /**
                 * mouseExited Kur e largojme mousin nga butoni clrButton,
                 * ngjyra e prapavise dhe fontit kthehen ne gjendjen fillestare
                 *
                 * @param e - MouseEventi
                 * @return void
                 */
                @Override
                public void mouseExited(MouseEvent e) {
                    clrButton.setBackground(new Color(71, 2, 14));
                    clrButton.setForeground(Color.white);
                }
            });
            eqButton.addMouseListener(new MouseAdapter() {
                /**
                 * mouseEntered Kur e vendosim mousin mbi butonin eqButton i
                 * ndrrojm prapavijen dhe ngjyren e fontit
                 *
                 * @param e - MouseEventi
                 * @return void
                 */
                @Override
                public void mouseEntered(MouseEvent e) {
                    eqButton.setBackground(new Color(120, 93, 11));
                    eqButton.setForeground(hoverForeground);
                }

                /**
                 * mouseExited Kur e largojme mousin nga butoni eqButton, ngjyra
                 * e prapavise dhe fontit kthehen ne gjendjen fillestare
                 *
                 * @param e - MouseEventi
                 * @return void
                 */
                @Override
                public void mouseExited(MouseEvent e) {
                    eqButton.setBackground(new Color(191, 146, 10));
                    eqButton.setForeground(Color.white);
                }
            });
            delButton.addMouseListener(new MouseAdapter() {
                /**
                 * mouseEntered Kur e vendosim mousin mbi butonin delButton i
                 * ndrrojm prapavijen dhe ngjyren e fontit
                 *
                 * @param e - MouseEventi
                 * @return void
                 */
                @Override
                public void mouseEntered(MouseEvent e) {
                    delButton.setBackground(new Color(99, 35, 3));
                    delButton.setForeground(hoverForeground);
                }

                /**
                 * mouseExited Kur e largojme mousin nga butoni delButton,
                 * ngjyra e prapavise dhe fontit kthehen ne gjendjen fillestare
                 *
                 * @param e - MouseEventi
                 * @return void
                 */
                @Override
                public void mouseExited(MouseEvent e) {
                    delButton.setBackground(new Color(125, 44, 4));
                    delButton.setForeground(Color.white);
                }
            });
            fButtons[i].setBorder(null); // E fshin kornizen e buttonave
            fButtons[i].setFocusable(false); // E ndryshon gjendjen e fokusshmerise ne false
        }

        for (int i = 0; i < numButtons.length; i++) {
            numButtons[i] = new JButton(i + "");
            numButtons[i].setBackground(numbuttonsColor); //Ngjyrosja e prapavise se butonave
            numButtons[i].setForeground(Color.WHITE); //Ngyrosja e Fontit
            numButtons[i].setFont(buttonsFont); //Ndryshimi i llojit te fontit
            numButtons[i].addMouseListener(numbuttonsMouseAdapter(i)); //Invokimi i metodes numbuttonsMouseAdapter
            numButtons[i].setBorder(null); // E fshin kornizen e buttonave
            numButtons[i].setFocusable(false); // E ndryshon gjendjen e fokusshmerise ne false
        }
    }

    /**
     * addComponets Bene shtimin e komponenteve ne frame
     */
    public void addComponents() {
        // Percaktimi i labelit per paraqitje tekstuale te kalkulimeve
        label.setBounds(2, 20, 1192, 100);
        label.setForeground(Color.WHITE);
        label.setFont(labeFont);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setFocusable(false);

        // label per emertimin e Historise te kalkulimeve
        stringLabel = new JLabel("History " + '\u21BB');
        stringLabel.setFont(new Font("SF Pro", Font.BOLD, 35));
        stringLabel.setBounds(1215, 20, 200, 80);
        stringLabel.setFocusable(false);
        stringLabel.setBackground(Color.BLACK);
        stringLabel.setForeground(Color.white);

        //paneli per vendosjen e butonave 
        panel = new JPanel();
        panel.setBounds(0, 300, 1200, 480);
        panel.setLayout(new GridLayout(7, 5, 4, 4)); //Paraqitja ne formen grid, ku butonat kane madhesi si dhe largesi te njejte
        panel.setBackground(Color.black);
        //panel1 per vendosjen e clrButton-it dhe delButton-it
        panel1 = new JPanel();
        panel1.setBounds(2, 200, 1198, 95);
        panel1.setLayout(new GridLayout(1, 2, 5, 4));
        panel1.setBackground(Color.black);

        //Percaktimi i Textfield per parqitjen e numrave te shtypur
        textField = new JTextField();
        textField.setBounds(2, 90, 1195, 105);
        textField.setBackground(new Color(30, 30, 31));
        textField.setForeground(Color.WHITE);
        textField.setBorder(null);
        textField.setFont(textFieldFont);
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setFocusable(false);
        textField.setText("0");

        //TextArea per shfaqjene Historise se kalkulimeve
        textArea = new JTextArea();
        textArea.setBounds(1205, 90, 327, 695);
        textArea.setBackground(new Color(30, 30, 31));
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new Font("Arial", Font.TRUETYPE_FONT, 25));
        textArea.setEditable(false);
        textArea.setMargin(new Insets(15, 20, 10, 10));
        // Ne momentin kur textArea kalon dimensionet e caktuara vertikale dhe horizontale athere 
        // scrollPane krijon scrollBars per ti shfaqur te dhenat qe kalojn jasht dimensioneve 
        // 
        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(1205, 90, 327, 690);
        scrollPane.setBackground(new Color(30, 30, 31));
        scrollPane.setForeground(Color.WHITE);
        scrollPane.setFont(new Font("Arial", Font.TRUETYPE_FONT, 20));
        scrollPane.setBorder(null);
        scrollPane.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
        scrollPane.setAlignmentY(JTextArea.TOP_ALIGNMENT);

        //Futja e butonave brenda Panelit
        panel1.add(clrButton);
        panel1.add(delButton);
        for (int i = 0; i <= 14; i++) {
            panel.add(fButtons[i]);
        }
        panel.add(fButtons[15]);
        for (int i = 1; i < 4; i++) {
            panel.add(numButtons[i]);

        }
        panel.add(fButtons[16]);
        panel.add(fButtons[17]);
        for (int i = 4; i < 7; i++) {
            panel.add(numButtons[i]);
        }
        panel.add(fButtons[18]);
        panel.add(fButtons[19]);
        for (int i = 7; i < 10; i++) {
            panel.add(numButtons[i]);
        }
        panel.add(fButtons[20]);
        panel.add(fButtons[21]);
        panel.add(fButtons[22]);
        panel.add(numButtons[0]);
        panel.add(fButtons[23]);
        panel.add(fButtons[24]);
        //Shtimi i komponenteve ne frame
        frame.add(panel);
        frame.add(panel1);
        frame.add(label);
        frame.add(clearHistoryButton);
        frame.add(stringLabel);
        frame.add(scrollPane);
        frame.add(textField);
        frame.setVisible(true); //Shfaqja e Frejmit(Dritares)
    }

}
