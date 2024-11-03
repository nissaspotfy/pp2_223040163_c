package PrakProm2.tugas3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class DaftarBukuPanel extends JPanel {
  private JTable table;
  private DefaultTableModel model;

  public DaftarBukuPanel() {
    setLayout(new BorderLayout());
    setBackground(new Color(0xB3E5FC)); // Background color for the panel

    // Initialize the table model
    model = new DefaultTableModel(new Object[] { "No", "Nama Peminjam", "Judul Buku", "Penulis", "Tanggal Peminjaman",
        "Durasi (hari)", "Genre", "Bahasa" }, 0);
    table = new JTable(model);
    table.setFillsViewportHeight(true);
    table.setFont(new Font("Arial", Font.PLAIN, 12));
    table.setBackground(new Color(0xE0F7FA)); // Background color for the table

    // Center align the text in the table cells
    for (int i = 0; i < table.getColumnCount(); i++) {
      table.getColumnModel().getColumn(i).setCellRenderer(new CenterTableCellRenderer());
    }

    // Set header properties
    JTableHeader header = table.getTableHeader();
    header.setBackground(new Color(0x4DD0E1)); // Set the header background color
    header.setForeground(Color.WHITE); // Set the header text color
    header.setFont(new Font("Arial", Font.BOLD, 14)); // Change font for header

    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setPreferredSize(new Dimension(500, 300)); // Set preferred size for the scroll pane
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // Allow horizontal scrolling
                                                                                         // if needed

    add(scrollPane, BorderLayout.CENTER);
  }

  public void addBook(String nama, String judulBuku, String penulis, String tanggalPeminjaman, int durasiPinjam,
      String genre, String bahasa) {
    int rowCount = model.getRowCount();
    model.addRow(
        new Object[] { rowCount + 1, nama, judulBuku, penulis, tanggalPeminjaman, durasiPinjam, genre, bahasa });
  }

  public void clearTable() {
    model.setRowCount(0); // Clear all rows from the table
  }

  // Custom cell renderer for centering text
  private static class CenterTableCellRenderer extends DefaultTableCellRenderer {
    public CenterTableCellRenderer() {
      setHorizontalAlignment(SwingConstants.CENTER); // Center text
    }
  }
}
