package PrakProm2.tugas3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryApp extends JFrame {
  private JTextField titleField, authorField;
  private JTextArea descriptionArea;
  private JRadioButton fictionRadio, nonFictionRadio;
  private JCheckBox availableCheck;
  private JComboBox<String> genreCombo;
  private JList<String> languageList;
  private BookTablePanel bookTablePanel; // Komponen tabel yang dipisahkan

  public LibraryApp() {
    setTitle("Sistem Peminjaman Buku Perpustakaan");
    setSize(600, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Menu Bar
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Menu");
    JMenuItem addBookMenuItem = new JMenuItem("Tambah Buku");
    JMenuItem exitMenuItem = new JMenuItem("Keluar");

    addBookMenuItem.addActionListener(e -> showAddBookForm());
    exitMenuItem.addActionListener(e -> System.exit(0));

    menu.add(addBookMenuItem);
    menu.add(exitMenuItem);
    menuBar.add(menu);
    setJMenuBar(menuBar);

    // Inisialisasi BookTablePanel dan tambahkan ke frame
    bookTablePanel = new BookTablePanel();
    add(bookTablePanel, BorderLayout.CENTER);
  }

  private void showAddBookForm() {
    // Panel Form
    JPanel formPanel = new JPanel(new GridLayout(8, 2, 5, 5));

    // Judul Buku
    formPanel.add(new JLabel("Judul Buku:"));
    titleField = new JTextField();
    formPanel.add(titleField);

    // Penulis Buku
    formPanel.add(new JLabel("Penulis Buku:"));
    authorField = new JTextField();
    formPanel.add(authorField);

    // Deskripsi
    formPanel.add(new JLabel("Deskripsi:"));
    descriptionArea = new JTextArea(3, 20);
    formPanel.add(new JScrollPane(descriptionArea));

    // Genre
    formPanel.add(new JLabel("Genre:"));
    genreCombo = new JComboBox<>(new String[] { "Fiksi", "Non-Fiksi", "Sejarah", "Ilmu Pengetahuan" });
    formPanel.add(genreCombo);

    // Fiksi atau Non-Fiksi
    formPanel.add(new JLabel("Jenis:"));
    fictionRadio = new JRadioButton("Fiksi");
    nonFictionRadio = new JRadioButton("Non-Fiksi");
    ButtonGroup group = new ButtonGroup();
    group.add(fictionRadio);
    group.add(nonFictionRadio);
    JPanel radioPanel = new JPanel();
    radioPanel.add(fictionRadio);
    radioPanel.add(nonFictionRadio);
    formPanel.add(radioPanel);

    // Bahasa
    formPanel.add(new JLabel("Bahasa:"));
    languageList = new JList<>(new String[] { "Indonesia", "Inggris", "Mandarin", "Jepang" });
    formPanel.add(new JScrollPane(languageList));

    // Tersedia
    formPanel.add(new JLabel("Tersedia:"));
    availableCheck = new JCheckBox("Ya");
    formPanel.add(availableCheck);

    // Tombol Tambah
    JButton addButton = new JButton("Tambah Buku");
    addButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        addBookToTable();
      }
    });

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(addButton);

    // Show Form
    JFrame formFrame = new JFrame("Tambah Buku");
    formFrame.setSize(400, 400);
    formFrame.add(formPanel, BorderLayout.CENTER);
    formFrame.add(buttonPanel, BorderLayout.SOUTH);
    formFrame.setVisible(true);
  }

  private void addBookToTable() {
    String title = titleField.getText();
    String author = authorField.getText();
    String genre = (String) genreCombo.getSelectedItem();
    String description = descriptionArea.getText();
    String type = fictionRadio.isSelected() ? "Fiksi" : "Non-Fiksi";
    String language = languageList.getSelectedValue();
    boolean available = availableCheck.isSelected();

    // Panggil metode addBookToTable dari BookTablePanel untuk menambah data ke
    // JTable
    bookTablePanel.addBookToTable(title, author, genre, description, type, language, available);

    // Clear Form
    titleField.setText("");
    authorField.setText("");
    descriptionArea.setText("");
    genreCombo.setSelectedIndex(0);
    fictionRadio.setSelected(true);
    languageList.clearSelection();
    availableCheck.setSelected(false);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      new LibraryApp().setVisible(true);
    });
  }
}
