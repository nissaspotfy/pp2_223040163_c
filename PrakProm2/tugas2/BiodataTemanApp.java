package PrakProm2.tugas2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BiodataTemanApp {
  public static void main(String[] args) {
    // Membuat frame
    JFrame frame = new JFrame("Biodata Temanku");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 400);
    frame.setLayout(new BorderLayout());

    // Menggunakan GridBagLayout untuk tata letak yang fleksibel
    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5); // Margin di sekitar elemen
    gbc.fill = GridBagConstraints.HORIZONTAL;

    // Komponen form
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

    JTextArea outputArea = new JTextArea(5, 35);
    outputArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(outputArea);

    // Menambahkan komponen ke panel dengan GridBagLayout
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

    gbc.gridy = 4;
    panel.add(labelJenisKelamin, gbc);

    gbc.gridy = 5;
    gbc.gridwidth = 1;
    panel.add(rbLakiLaki, gbc); // Menempatkan Laki-Laki di baris 5

    gbc.gridx = 1;
    panel.add(rbPerempuan, gbc); // Menempatkan Perempuan di baris 5 (sejajar)

    gbc.gridx = 0;
    gbc.gridy = 6;
    gbc.gridwidth = 2;
    panel.add(cbWNA, gbc); // WNA di bawah radio button

    gbc.gridy = 7;
    panel.add(buttonSimpan, gbc); // Tombol Simpan di bawah checkbox

    // Menambahkan panel ke frame
    frame.add(panel, BorderLayout.NORTH);
    frame.add(scrollPane, BorderLayout.CENTER);

    // Aksi ketika tombol simpan ditekan
    buttonSimpan.addActionListener((ActionEvent e) -> {
      String nama = textNama.getText();
      String hp = textHP.getText();
      String jenisKelamin = rbLakiLaki.isSelected() ? "Laki-Laki" : rbPerempuan.isSelected() ? "Perempuan" : "";
      String wna = cbWNA.isSelected() ? "Ya" : "Tidak";

      // Validasi input
      if (nama.isEmpty() || hp.isEmpty() || jenisKelamin.isEmpty()) {
        JOptionPane.showMessageDialog(frame, "Semua data harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
      }

      // Menampilkan output ke JTextArea
      outputArea.append(String.format(
          "Nama         : %s\nNomor HP     : %s\nJenis Kelamin: %s\nWNA          : %s\n============================================\n",
          nama, hp, jenisKelamin, wna));

      // Reset form setelah menyimpan
      textNama.setText("");
      textHP.setText("");
      bgJenisKelamin.clearSelection();
      cbWNA.setSelected(false);
    });

    frame.setVisible(true);
  }
}
