package PrakProm2.tugas3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BookTablePanel extends JPanel {
    private DefaultTableModel tableModel;
    private JTable bookTable;

    public BookTablePanel() {
        setLayout(new BorderLayout());

        // Definisikan kolom untuk JTable
        String[] columns = {"Judul", "Penulis", "Genre", "Deskripsi", "Fiksi", "Bahasa", "Tersedia"};
        tableModel = new DefaultTableModel(columns, 0);
        bookTable = new JTable(tableModel);

        // Tambahkan JScrollPane agar JTable memiliki scrollbar
        JScrollPane scrollPane = new JScrollPane(bookTable);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Metode untuk menambah buku ke JTable
    public void addBookToTable(String title, String author, String genre, String description, String type, String language, boolean available) {
        tableModel.addRow(new Object[]{title, author, genre, description, type, language, available ? "Ya" : "Tidak"});
    }

    // Metode untuk mengakses model tabel (untuk digunakan dari kelas lain jika diperlukan)
    public DefaultTableModel getTableModel() {
        return tableModel;
    }
}
