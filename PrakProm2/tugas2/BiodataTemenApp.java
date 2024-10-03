package PrakProm2.tugas2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BiodataTemenApp {
  public static void main(String[] args) {

    JFrame frame = new JFrame("Biodata Temanku");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 400);
    frame.setLayout(new BorderLayout());

    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5);
    gbc.fill = GridBagConstraints.HORIZONTAL;

    JLabel labelNama = new JLabel("Nama:");
    JTextField textNama = new JTextField(20);

    JLabel labelHP = new JLabel("Nomor HP:");
    JTextField textHP = new JTextField(20);

    JButton buttonSimpan = new JButton("Simpan");

    JTextArea outputArea = new JTextArea(5, 35);
    outputArea.setFont(new Font("Consolas", Font.PLAIN, 12));
    outputArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(outputArea);

    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    panel.add(labelNama, gbc);

    gbc.gridy = 1;
    gbc.gridwidth = 2;
    panel.add(textNama, gbc);

    gbc.gridy = 2;
    gbc.gridwidth = 2;
    panel.add(labelHP, gbc);

    gbc.gridy = 3;
    panel.add(textHP, gbc);

    gbc.gridy = 7;
    panel.add(buttonSimpan, gbc);

    frame.add(panel, BorderLayout.NORTH);
    frame.add(scrollPane, BorderLayout.CENTER);

    buttonSimpan.addActionListener((ActionEvent e) -> {
      String nama = textNama.getText();
      String hp = textHP.getText();

      if (nama.isEmpty() || hp.isEmpty()) {
        JOptionPane.showMessageDialog(frame, "Semua data harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
      }

      outputArea.append(String.format(
          "Nama         : %s\nNomor HP     : %s\n============================================\n",
          nama, hp));
      textNama.setText("");
      textHP.setText("");
    });

    frame.setVisible(true);
  }
}
