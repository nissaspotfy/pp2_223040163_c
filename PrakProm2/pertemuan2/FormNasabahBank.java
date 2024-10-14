package PrakProm2.pertemuan2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormNasabahBank {
  public static void main(String[] args) {
  
    JFrame frame = new JFrame("Form Pendaftaran Nasabah Bank");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 500);

    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5);
    gbc.fill = GridBagConstraints.HORIZONTAL;

    panel.setBackground(new Color(0x00CCDD));
    gbc.gridx = 0;
    gbc.gridy = 0;

    JLabel labelNama = new JLabel("Nama:");
    JTextField textNama = new JTextField(20);
    addComponent(panel, labelNama, textNama, gbc);

    JLabel labelJenisTabungan = new JLabel("Jenis Tabungan:");
    String[] jenisTabungan = { "Tabungan Reguler", "Tabungan Berjangka", "Tabungan Pendidikan", "Tabungan Investasi" };

    JList<String> listJenisTabungan = new JList<>(jenisTabungan);
    listJenisTabungan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 

    JScrollPane scrollJenisTabungan = new JScrollPane(listJenisTabungan);
    scrollJenisTabungan.setPreferredSize(new Dimension(150, 70));
    addComponent(panel, labelJenisTabungan, scrollJenisTabungan, gbc);

    JLabel labelFrekuensi = new JLabel("Frekuensi Transaksi/Bulan:");
    JSpinner spinnerFrekuensi = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
    addComponent(panel, labelFrekuensi, spinnerFrekuensi, gbc);

    JLabel labelPassword = new JLabel("Password:");
    JPasswordField passwordField = new JPasswordField(20);
    addComponent(panel, labelPassword, passwordField, gbc);

    JLabel labelConfirmPassword = new JLabel("Konfirmasi Password:");
    JPasswordField confirmPasswordField = new JPasswordField(20);
    addComponent(panel, labelConfirmPassword, confirmPasswordField, gbc);

    JLabel labelTanggalLahir = new JLabel("Tanggal Lahir:");
    JSpinner spinnerTanggalLahir = new JSpinner(new SpinnerDateModel());
    spinnerTanggalLahir.setEditor(new JSpinner.DateEditor(spinnerTanggalLahir, "dd/MM/yyyy"));
    addComponent(panel, labelTanggalLahir, spinnerTanggalLahir, gbc);

    JButton buttonSimpan = new JButton("Simpan");
    gbc.gridx = 1;
    gbc.gridy++;
    panel.add(buttonSimpan, gbc);

    JTextArea outputArea = new JTextArea(4, 30);
    outputArea.setEditable(false);
    outputArea.setBackground(new Color(0x7CF5FF));
    outputArea.setFont(new Font("Consolas", Font.PLAIN, 12));
    JScrollPane scrollPane = new JScrollPane(outputArea);
    scrollPane.setPreferredSize(new Dimension(350, 100));

    buttonSimpan.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String nama = textNama.getText();

        String jenisTabungan = listJenisTabungan.getSelectedValue();
        if (jenisTabungan == null) {
          JOptionPane.showMessageDialog(frame, "Harap pilih jenis tabungan.", "Error", JOptionPane.ERROR_MESSAGE);
          return;
        }

        int frekuensi = (int) spinnerFrekuensi.getValue();
        String tanggalLahir = ((JSpinner.DateEditor) spinnerTanggalLahir.getEditor()).getFormat()
            .format(spinnerTanggalLahir.getValue());
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (!password.equals(confirmPassword)) {
          JOptionPane.showMessageDialog(frame, "Password tidak cocok!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
          outputArea.append("Nama               : " + nama + "\n");
          outputArea.append("Jenis Tabungan     : " + jenisTabungan + "\n");
          outputArea.append("Frekuensi/Bulan    : " + frekuensi + "\n");
          outputArea.append("Password Cocok     : Ya\n");
          outputArea.append("Tanggal Lahir      : " + tanggalLahir + "\n");
          outputArea.append("============================================\n");

          textNama.setText("");
          listJenisTabungan.clearSelection();
          passwordField.setText("");
          confirmPasswordField.setText("");
          spinnerFrekuensi.setValue(1);
          spinnerTanggalLahir.setValue(new java.util.Date());
        }
      }
    });

    JMenuBar menuBar = new JMenuBar();
    JMenu menuFile = new JMenu("Menu");

    JMenuItem menuReset = new JMenuItem("Reset");
    menuReset.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
   
        textNama.setText("");
        listJenisTabungan.clearSelection();
        spinnerFrekuensi.setValue(1);
        passwordField.setText("");
        confirmPasswordField.setText("");
        spinnerTanggalLahir.setValue(new java.util.Date());
        outputArea.setText("");
      }
    });


    JMenuItem menuExit = new JMenuItem("Exit");
    menuExit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    menuFile.add(menuReset);
    menuFile.add(menuExit);

    menuBar.add(menuFile);
    frame.setJMenuBar(menuBar);

    frame.add(panel, BorderLayout.NORTH);
    frame.add(scrollPane, BorderLayout.CENTER);
    frame.setVisible(true);
  }

  private static void addComponent(JPanel panel, JLabel label, JComponent input, GridBagConstraints gbc) {
    gbc.gridx = 0;
    panel.add(label, gbc);
    gbc.gridx = 1;
    panel.add(input, gbc);
    gbc.gridy++;
  }
}
