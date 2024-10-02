package PrakProm2.tugas2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BiodataTemanApp {
  public static void main(String[] args) {
    
    JFrame frame = new JFrame("Biodata Temanku");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 400);
    frame.setLayout(new BorderLayout());

    
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5);
    gbc.fill = GridBagConstraints.HORIZONTAL; 

   
    panel.setBackground(Color.LIGHT_GRAY);
    frame.getContentPane().setBackground(Color.LIGHT_GRAY);

    
    JLabel labelNama = new JLabel("Nama:");
    JTextField textNama = new JTextField(20);

    
    JLabel labelHP = new JLabel("Nomor HP:");
    JTextField textHP = new JTextField(20);

    
    JLabel labelJenisKelamin = new JLabel("Jenis Kelamin:");
    JRadioButton rbLakiLaki = new JRadioButton("Laki-Laki");
    JRadioButton rbPerempuan = new JRadioButton("Perempuan");
    ButtonGroup bgJenisKelamin = new ButtonGroup();
    bgJenisKelamin.add(rbLakiLaki);
    bgJenisKelamin.add(rbPerempuan);

    
    JCheckBox cbWNA = new JCheckBox("Warga Negara Asing");

    
    JButton buttonSimpan = new JButton("Simpan");

   
    JTextArea outputArea = new JTextArea(8, 40);
    outputArea.setEditable(false);

    
    outputArea.setBackground(Color.WHITE);

    JScrollPane scrollPane = new JScrollPane(outputArea);

   
    gbc.gridx = 0;
    gbc.gridy = 0;
    panel.add(labelNama, gbc);

    gbc.gridx = 0;
    gbc.gridy = 1;
    panel.add(textNama, gbc);

    gbc.gridx = 0;
    gbc.gridy = 2;
    panel.add(labelHP, gbc);

    gbc.gridx = 0;
    gbc.gridy = 3;
    panel.add(textHP, gbc);

    gbc.gridx = 0;
    gbc.gridy = 4;
    panel.add(labelJenisKelamin, gbc);

    gbc.gridx = 0;
    gbc.gridy = 5;
    panel.add(rbLakiLaki, gbc);

    gbc.gridx = 0;
    gbc.gridy = 6;
    panel.add(rbPerempuan, gbc);

    gbc.gridx = 0;
    gbc.gridy = 7;
    panel.add(cbWNA, gbc);

    gbc.gridx = 0;
    gbc.gridy = 8;
    panel.add(buttonSimpan, gbc);

    
    frame.add(panel, BorderLayout.NORTH);
    frame.add(scrollPane, BorderLayout.CENTER);

  
    buttonSimpan.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String nama = textNama.getText();
        String hp = textHP.getText();
        String jenisKelamin = rbLakiLaki.isSelected() ? "Laki-Laki" : rbPerempuan.isSelected() ? "Perempuan" : "";
        String wna = cbWNA.isSelected() ? "Ya" : "Tidak";

       
        if (nama.isEmpty() || hp.isEmpty() || jenisKelamin.isEmpty()) {
          JOptionPane.showMessageDialog(frame, "Semua data harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
          return;
        }

      
        outputArea.append("Nama         : " + nama + "\n");
        outputArea.append("Nomor HP     : " + hp + "\n");
        outputArea.append("Jenis Kelamin: " + jenisKelamin + "\n");
        outputArea.append("WNA          : " + wna + "\n");
        outputArea.append("============================================\n");

  
        textNama.setText("");
        textHP.setText("");
        bgJenisKelamin.clearSelection();
        cbWNA.setSelected(false);
      }
    });

 
    frame.setVisible(true);
  }
}
