package PrakProm2.pertemuan3;

import javax.swing.*;
import java.awt.*;

public class BiodataSaya {
  public static void main(String[] args) {
    // Membuat frame
    JFrame frame = new JFrame("Form Biodata");
    frame.setSize(400, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new GridBagLayout());

    // Membuat GridBagConstraints
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5); // Mengatur jarak antar komponen

    // Membuat label judul
    JLabel labelTitle = new JLabel("Form Biodata", JLabel.CENTER);
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 4; // Mengatur agar judul berada di tengah, menggunakan 4 kolom
    frame.add(labelTitle, gbc);

    // Membuat label dan input untuk Nama
    JLabel labelNama = new JLabel("Nama:");
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 1; // Mengisi 1 kolom untuk label
    gbc.anchor = GridBagConstraints.WEST;
    frame.add(labelNama, gbc);

    JTextField textNama = new JTextField(15);
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 2; // Input mengisi 2 kolom
    frame.add(textNama, gbc);

    // Membuat label dan input untuk Nomor HP
    JLabel labelHP = new JLabel("Nomor HP:");
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.gridwidth = 1;
    frame.add(labelHP, gbc);

    JTextField textHP = new JTextField(15);
    gbc.gridx = 0;
    gbc.gridy = 4;
    gbc.gridwidth = 2;
    frame.add(textHP, gbc);

    // Membuat label untuk Jenis Kelamin
    JLabel labelGender = new JLabel("Jenis Kelamin:");
    gbc.gridx = 2;
    gbc.gridy = 1;
    gbc.gridwidth = 1;
    frame.add(labelGender, gbc);

    // Membuat radio button untuk jenis kelamin
    JRadioButton rbLaki = new JRadioButton("Laki-Laki");
    JRadioButton rbPerempuan = new JRadioButton("Perempuan");

    // Membuat ButtonGroup untuk jenis kelamin
    ButtonGroup genderGroup = new ButtonGroup();
    genderGroup.add(rbLaki);
    genderGroup.add(rbPerempuan);

    // Menempatkan radio button jenis kelamin
    gbc.gridx = 2;
    gbc.gridy = 2;
    frame.add(rbLaki, gbc);

    gbc.gridx = 3;
    gbc.gridy = 2;
    frame.add(rbPerempuan, gbc);

    // Membuat checkbox untuk Warga Negara Asing
    JCheckBox cbWna = new JCheckBox("Warga Negara Asing");
    gbc.gridx = 2;
    gbc.gridy = 3;
    gbc.gridwidth = 2;
    frame.add(cbWna, gbc);

    // Membuat tombol Simpan
    JButton btnSimpan = new JButton("Simpan");
    gbc.gridx = 0;
    gbc.gridy = 5;
    gbc.gridwidth = 4; // Mengatur agar tombol berada di tengah bawah
    gbc.anchor = GridBagConstraints.CENTER; // Memposisikan tombol di tengah
    frame.add(btnSimpan, gbc);

    // Menambahkan action listener pada tombol Simpan
    btnSimpan.addActionListener(e -> {
      String nama = textNama.getText();
      String gender = rbLaki.isSelected() ? "Laki-Laki" : "Perempuan";
      String nomorHP = textHP.getText();
      boolean isWna = cbWna.isSelected();

      JOptionPane.showMessageDialog(frame,
          "Nama: " + nama + "\nGender: " + gender + "\nNomor HP: " + nomorHP + "\nWNA: " + isWna);
    });

    // Menampilkan frame
    frame.setVisible(true);
  }
}
