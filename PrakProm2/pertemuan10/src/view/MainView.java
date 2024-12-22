package view;

import controller.BookController;
import model.BookModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainView extends JFrame {
  private BookController controller;
  private JTable table;
  private DefaultTableModel tableModel;

  public MainView() {
    controller = new BookController();

    setTitle("Book Store");
    setSize(800, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    // Table
    tableModel = new DefaultTableModel(new String[] { "ID", "Title", "Author", "Price", "Genre" }, 0);
    table = new JTable(tableModel);
    loadBooks();

    JScrollPane scrollPane = new JScrollPane(table);
    add(scrollPane, BorderLayout.CENTER);

    // Form
    JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
    JTextField titleField = new JTextField();
    JTextField authorField = new JTextField();
    JTextField priceField = new JTextField();
    JTextField genreField = new JTextField();

    JButton addButton = new JButton("Add");
    JButton updateButton = new JButton("Update");
    JButton deleteButton = new JButton("Delete");

    formPanel.add(new JLabel("Title:"));
    formPanel.add(titleField);
    formPanel.add(new JLabel("Author:"));
    formPanel.add(authorField);
    formPanel.add(new JLabel("Price:"));
    formPanel.add(priceField);
    formPanel.add(new JLabel("Genre:"));
    formPanel.add(genreField);
    formPanel.add(addButton);
    formPanel.add(updateButton);
    formPanel.add(deleteButton);

    add(formPanel, BorderLayout.SOUTH);

    // Button Listeners
    addButton.addActionListener(e -> {
      controller.addBook(
          titleField.getText(),
          authorField.getText(),
          Double.parseDouble(priceField.getText()),
          genreField.getText());
      loadBooks();
    });

    updateButton.addActionListener(e -> {
      int selectedRow = table.getSelectedRow();
      if (selectedRow != -1) {
        int id = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
        controller.updateBook(
            id,
            titleField.getText(),
            authorField.getText(),
            Double.parseDouble(priceField.getText()),
            genreField.getText());
        loadBooks();
      }
    });

    deleteButton.addActionListener(e -> {
      int selectedRow = table.getSelectedRow();
      if (selectedRow != -1) {
        int id = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
        controller.deleteBook(id);
        loadBooks();
      }
    });
  }

  private void loadBooks() {
    tableModel.setRowCount(0);
    List<BookModel> books = controller.getAllBooks();
    for (BookModel book : books) {
      tableModel.addRow(new Object[] {
          book.getId(),
          book.getTitle(),
          book.getAuthor(),
          book.getPrice(),
          book.getGenre()
      });
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new MainView().setVisible(true));
  }
}
