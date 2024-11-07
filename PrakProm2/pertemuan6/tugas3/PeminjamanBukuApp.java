package PrakProm2.tugas3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PeminjamanBukuApp {
  private static DaftarBukuPanel daftarBukuPanel; // Panel daftar buku
  private static JTextField textNama, textJudulBuku, textPenulis;
  private static JSpinner spinnerTanggalPeminjaman, spinnerDurasiPinjam;
  private static JComboBox<String> comboBoxGenre;
  private static JList<String> listBahasa;

  public static void main(String[] args) {
    JFrame frame = new JFrame("Perpustakaan UNPAS");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 600);

    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5);
    gbc.fill = GridBagConstraints.HORIZONTAL;

    panel.setBackground(new Color(0x00FF9C));
    gbc.gridx = 0;
    gbc.gridy = 0;

    JLabel labelNama = new JLabel("Nama Peminjam:");
    textNama = new JTextField(20);
    addComponent(panel, labelNama, textNama, gbc);

    JLabel labelJudulBuku = new JLabel("Judul Buku:");
    textJudulBuku = new JTextField(20);
    addComponent(panel, labelJudulBuku, textJudulBuku, gbc);

    JLabel labelPenulis = new JLabel("Penulis:");
    textPenulis = new JTextField(20);
    addComponent(panel, labelPenulis, textPenulis, gbc);

    JLabel labelTanggalPeminjaman = new JLabel("Tanggal Peminjaman:");
    spinnerTanggalPeminjaman = new JSpinner(new SpinnerDateModel());
    spinnerTanggalPeminjaman.setEditor(new JSpinner.DateEditor(spinnerTanggalPeminjaman, "dd/MM/yyyy"));
    addComponent(panel, labelTanggalPeminjaman, spinnerTanggalPeminjaman, gbc);

    JLabel labelDurasiPinjam = new JLabel("Durasi Peminjaman (hari):");
    spinnerDurasiPinjam = new JSpinner(new SpinnerNumberModel(1, 1, 30, 1));
    addComponent(panel, labelDurasiPinjam, spinnerDurasiPinjam, gbc);

    JLabel labelGenre = new JLabel("Genre Buku:");
    String[] genres = { "Fiksi", "Non-Fiksi", "Sejarah", "Sains", "Fantasi" };
    comboBoxGenre = new JComboBox<>(genres);
    addComponent(panel, labelGenre, comboBoxGenre, gbc);

    JLabel labelBahasa = new JLabel("Bahasa Buku:");
    listBahasa = new JList<>(new String[] { "Indonesia", "Inggris", "Mandarin", "Jepang" });
    listBahasa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    JScrollPane scrollBahasa = new JScrollPane(listBahasa);
    scrollBahasa.setPreferredSize(new Dimension(150, 70));
    addComponent(panel, labelBahasa, scrollBahasa, gbc);

    JButton buttonSimpan = new JButton("Simpan");
    gbc.gridx = 1;
    gbc.gridy++;
    panel.add(buttonSimpan, gbc);

    // Panel daftar buku
    daftarBukuPanel = new DaftarBukuPanel();

    // Menambahkan panel ke frame
    frame.add(panel, BorderLayout.NORTH);

    buttonSimpan.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String nama = textNama.getText();
        String judulBuku = textJudulBuku.getText();
        String penulis = textPenulis.getText();
        String tanggalPeminjaman = ((JSpinner.DateEditor) spinnerTanggalPeminjaman.getEditor()).getFormat()
            .format(spinnerTanggalPeminjaman.getValue());
        int durasiPinjam = (int) spinnerDurasiPinjam.getValue();
        String genre = (String) comboBoxGenre.getSelectedItem();
        String bahasa = listBahasa.getSelectedValue();

        // Menambahkan data buku ke panel daftar buku
        daftarBukuPanel.addBook(nama, judulBuku, penulis, tanggalPeminjaman, durasiPinjam, genre, bahasa);

        // Clear the fields
        textNama.setText("");
        textJudulBuku.setText("");
        textPenulis.setText("");
        spinnerDurasiPinjam.setValue(1);
        spinnerTanggalPeminjaman.setValue(new java.util.Date());
        listBahasa.clearSelection();
      }
    });

    JMenuBar menuBar = new JMenuBar();
    JMenu menuFile = new JMenu("Menu");

    JMenuItem menuReset = new JMenuItem("Reset");
    menuReset.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        textNama.setText("");
        textJudulBuku.setText("");
        textPenulis.setText("");
        spinnerDurasiPinjam.setValue(1);
        spinnerTanggalPeminjaman.setValue(new java.util.Date());
        daftarBukuPanel.clearTable(); // Menghapus semua baris dari tabel
        listBahasa.clearSelection();
      }
    });

    JMenuItem menuDaftarBuku = new JMenuItem("Daftar Buku");
    menuDaftarBuku.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Tampilkan daftar buku dalam JOptionPane
        JOptionPane.showMessageDialog(frame, daftarBukuPanel, "Daftar Buku", JOptionPane.PLAIN_MESSAGE);
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
    menuFile.add(menuDaftarBuku);
    menuFile.add(menuExit);

    menuBar.add(menuFile);
    frame.setJMenuBar(menuBar);

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
