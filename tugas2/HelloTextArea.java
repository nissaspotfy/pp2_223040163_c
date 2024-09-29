package PrakProm2.tugas2;

import java.awt.event.*;
import javax.swing.*;

public class HelloTextArea extends JFrame {

  public HelloTextArea() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel labelInput = new JLabel("Input Nama:");
    labelInput.setBounds(130, 40, 100, 10); // Adjusted position

    JTextField textField = new JTextField();
    textField.setBounds(130, 60, 100, 30); // Adjusted position

    JButton button = new JButton("klik");
    button.setBounds(130, 100, 100, 40); // Adjusted position

    JTextArea txtOutput = new JTextArea(); // Changed from JLabel to JTextArea
    txtOutput.setBounds(130, 150, 100, 100); // Adjusted position

    button.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          String nama = textField.getText();
          txtOutput.append("Hello " + nama + "\n"); // Updated to append text
          textField.setText(""); // Clear the text field after input
        }
      }
    );

    this.add(button);
    this.add(textField);
    this.add(labelInput);
    this.add(txtOutput); // Added JTextArea to the frame

    this.setSize(400, 500);
    this.setLayout(null);
  }

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(
      new Runnable() {
        public void run() {
          HelloTextArea h = new HelloTextArea(); // Updated class name
          h.setVisible(true);
        }
      }
    );
  }
}
