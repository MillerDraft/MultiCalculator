import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// Parent Class
public abstract class Calculator implements ActionListener {
    protected JFrame frame;
    protected JTextField textField;
    protected JButton[] numberButton;
    protected JButton[] functionButton;
    protected JButton addButton, subButton, mulButton, divButton;
    protected JButton delButton, equButton, decButton, clrButton, negButton;
    protected JButton squButton, sRootButton, percButton;
    protected JPanel panel;
    protected double num1 = 0, num2 = 0, result = 0;
   protected char operator;

    protected Font myFont = new Font("Arial", Font.ITALIC, 20);

    public Calculator() {
    }
// method to start the program
    public void init() {
        setFrame();
        setTextField();
        setButtons();
        setPanel();

        addComponentsToFrame();

    }
    // Frame method
    public void setFrame() {
        frame = new JFrame();
        frame.setSize(420, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

    }
    // Text Field method
    public void setTextField() {
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);
    }
    // Panel method
    public void setPanel() {
        panel = new JPanel();
        panel.setBounds(50, 180, 300, 300);
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        panel.add(percButton);
        panel.add(squButton);
        panel.add(sRootButton);
        panel.add(divButton);

        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);

        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);

        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(mulButton);

        panel.add(negButton);
        panel.add(numberButton[0]);
        panel.add(decButton);
        panel.add(equButton);

    }
    // Set Font method
    public void setMyFont(Font myFont) {
        this.myFont = myFont;
    }

    // Add element to frame
    public void addComponentsToFrame() {
        frame.add(textField);
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.setVisible(true);
    }
    // Button method
    public void setButtons() {
        numberButton = new JButton[10];
        functionButton = new JButton[12];

        // Function buttons
        addButton = new JButton("+");
        subButton = new JButton("–");
        mulButton = new JButton("*");
        divButton = new JButton("÷");
        equButton = new JButton("=");
        decButton = new JButton(".");
        negButton = new JButton("+/-");
        delButton = new JButton("←");
        clrButton = new JButton("C");
        squButton = new JButton("×²");
        sRootButton = new JButton("²√×");
        percButton = new JButton("%");

        // Adding buttons to Array
        functionButton[0] = addButton;
        functionButton[1] = subButton;
        functionButton[2] = mulButton;
        functionButton[3] = divButton;
        functionButton[4] = equButton;
        functionButton[5] = decButton;
        functionButton[6] = negButton;
        functionButton[7] = delButton;
        functionButton[8] = clrButton;
        functionButton[9] = squButton;
        functionButton[10] = sRootButton;
        functionButton[11] = percButton;
        // receive notification when the button in selected,
        // setting button font and focusable status
        for (int i = 0; i < 12; i++) {
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(myFont);
            functionButton[i].setFocusable(false);
        }
        // Position of this button on the frame
        delButton.setBounds(250, 110, 100, 50);
        clrButton.setBounds(50, 110, 100, 50);
        clrButton.setBackground(Color.PINK);
        // Create number buttons and receive notification when the button in selected,
        // setting button font and focusable status
        for (int i = 0; i < 10; i++) {
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(myFont);
            numberButton[i].setFocusable(false);
        }
    }
    // Method to receive and handle operations when buttons are selected
    @Override
    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();
         for (int i = 0; i < 10; i++){
             if (button == numberButton[i]){
                 textField.setText(textField.getText().concat(String.valueOf(i)));
             }
         }
         if (button == decButton){
             if (textField.getText().isEmpty()){
                 textField.setText("0.");
             }
             if (!textField.getText().contains(".")){
                 textField.setText(textField.getText().concat("."));
             }

         }
         else if (button == addButton){
             num1 = Double.parseDouble(textField.getText());
             operator = '+';
             textField.setText("");
         }
         else if (button == subButton){
             num1 = Double.parseDouble(textField.getText());
             operator = '-';
             textField.setText("");
         }
         else if (button == mulButton){
             num1 = Double.parseDouble(textField.getText());
             operator = '*';
             textField.setText("");
         }
         else if (button == divButton){
             num1 = Double.parseDouble(textField.getText());
             operator = '/';
             textField.setText("");
         }
         else if (button == equButton){
             num2 = Double.parseDouble(textField.getText());
             switch (operator){
                 case '+':
                     result = num1 + num2;
                     break;
                 case '-':
                     result = num1 - num2;
                     break;
                 case '*':
                     result = num1 * num2;
                     break;
                 case '/':
                     if (num2 != 0){
                         result = num1 / num2;
                         break;
                     }
                     else{
                         textField.setText("Error Zero division");
                         break;
                     }
             }
             num1 = result;
             int temp = (int)Math.floor(result);
             if (result == Math.floor(result)){
                 textField.setText(String.valueOf(temp));
             }
             else {
                 textField.setText(String.valueOf(result));
             }

         }
         else if (button == clrButton){
             textField.setText("");
             result = 0;
             num1 = 0;
             num2 = 0;
         }
         else if (button == delButton){
             String str = textField.getText();
             textField.setText(str.substring(0, str.length() - 1));
         }
         else if (button == negButton){
             double temp = Double.parseDouble(textField.getText());
             temp *= -1;
             textField.setText(String.valueOf(temp));
         }
         else if (button == squButton){
             num1 = Double.parseDouble(textField.getText());
             textField.setText(String.valueOf(num1 * num1));
         }
         else if (button == sRootButton){
             num1 = Double.parseDouble(textField.getText());
             textField.setText(String.valueOf(Math.sqrt(num1)));
         }
         else if (button == percButton){
             num1 = Double.parseDouble(textField.getText());
             textField.setText(String.valueOf(num1 / 100));
         }

    }
}