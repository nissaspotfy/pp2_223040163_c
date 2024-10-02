package PrakProm2.tugas2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormNasabahBank {
  public static void main(String[] args) {
    // Frame utama
    JFrame frame = new JFrame("Form Pendaftaran Nasabah Bank");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 500);

    // Panel utama dengan layout grid
    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5);
    gbc.fill = GridBagConstraints.HORIZONTAL;

    // Background abu-abu untuk panel utama
    panel.setBackground(new Color(0xFEFAE0));

    // Fungsi untuk menambahkan komponen ke panel
    gbc.gridx = 0;
    gbc.gridy = 0;

    // Fungsi untuk menambahkan label dan input
    JLabel labelNama = new JLabel("Nama:");
    JTextField textNama = new JTextField(20);
    addComponent(panel, labelNama, textNama, gbc);

    JLabel labelHP = new JLabel("Nomor HP:");
    JTextField textHP = new JTextField(20);
    addComponent(panel, labelHP, textHP, gbc);

    JLabel labelJenisTabungan = new JLabel("Jenis Tabungan:");
    String[] jenisTabungan = { "Tabungan Reguler", "Tabungan Berjangka", "Tabungan Haji", "Tabungan Investasi" };
    JComboBox<String> comboBoxTabungan = new JComboBox<>(jenisTabungan);
    addComponent(panel, labelJenisTabungan, comboBoxTabungan, gbc);

    JLabel labelFrekuensi = new JLabel("Frekuensi Transaksi/Bulan:");
    JSpinner spinnerFrekuensi = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
    addComponent(panel, labelFrekuensi, spinnerFrekuensi, gbc);

    JLabel labelTanggalLahir = new JLabel("Tanggal Lahir:");
    JSpinner spinnerTanggalLahir = new JSpinner(new SpinnerDateModel());
    spinnerTanggalLahir.setEditor(new JSpinner.DateEditor(spinnerTanggalLahir, "dd/MM/yyyy"));
    addComponent(panel, labelTanggalLahir, spinnerTanggalLahir, gbc);

    JLabel labelPassword = new JLabel("Password:");
    JPasswordField passwordField = new JPasswordField(20);
    addComponent(panel, labelPassword, passwordField, gbc);

    JLabel labelConfirmPassword = new JLabel("Konfirmasi Password:");
    JPasswordField confirmPasswordField = new JPasswordField(20);
    addComponent(panel, labelConfirmPassword, confirmPasswordField, gbc);

    // Tombol Simpan
    JButton buttonSimpan = new JButton("Simpan");
    gbc.gridx = 1;
    gbc.gridy++;
    panel.add(buttonSimpan, gbc);

    // TextArea untuk menampilkan output
    JTextArea outputArea = new JTextArea(4, 30);
    outputArea.setEditable(false);
    outputArea.setBackground(new Color(0xF2EED7));
    outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
    JScrollPane scrollPane = new JScrollPane(outputArea);
     scrollPane.setPreferredSize(new Dimension(350, 100));

    // ActionListener untuk tombol Simpan
    buttonSimpan.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String nama = textNama.getText();
        String hp = textHP.getText();
        String jenisTabungan = comboBoxTabungan.getSelectedItem().toString();
        int frekuensi = (int) spinnerFrekuensi.getValue();
        String tanggalLahir = ((JSpinner.DateEditor) spinnerTanggalLahir.getEditor()).getFormat()
            .format(spinnerTanggalLahir.getValue());
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (!password.equals(confirmPassword)) {
          JOptionPane.showMessageDialog(frame, "Password tidak cocok!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
          outputArea.append("Nama               : " + nama + "\n");
          outputArea.append("Nomor HP           : " + hp + "\n");
          outputArea.append("Jenis Tabungan     : " + jenisTabungan + "\n");
          outputArea.append("Frekuensi/Bulan    : " + frekuensi + "\n");
          outputArea.append("Tanggal Lahir      : " + tanggalLahir + "\n");
          outputArea.append("Password Cocok     : Ya\n");
          outputArea.append("============================================\n");

          // Kosongkan input setelah simpan
          textNama.setText("");
          textHP.setText("");
          passwordField.setText("");
          confirmPasswordField.setText("");
          spinnerFrekuensi.setValue(1);
          spinnerTanggalLahir.setValue(new java.util.Date());
        }
      }
    });

    // Panel utama dan scrollPane untuk output
    frame.add(panel, BorderLayout.NORTH);
    frame.add(scrollPane, BorderLayout.CENTER);
    frame.setVisible(true);
  }

  // Fungsi untuk menambahkan komponen ke panel
  private static void addComponent(JPanel panel, JLabel label, JComponent input, GridBagConstraints gbc) {
    gbc.gridx = 0;
    panel.add(label, gbc);
    gbc.gridx = 1;
    panel.add(input, gbc);
    gbc.gridy++;
  }
}
