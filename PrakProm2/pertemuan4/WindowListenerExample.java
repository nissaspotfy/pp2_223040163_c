package PrakProm2.pertemuan4;

import javax.swing.*;
import java.awt.event.*;

public class WindowListenerExample {
    public static void main(String[] args) {
        // Membuat frame
        JFrame frame = new JFrame("WindowListener Example");

        // Membuat label untuk menampilkan pesan
        JLabel label = new JLabel("Lakukan operasi pada jendela.");
        label.setBounds(50, 50, 300, 30);

        // Menambahkan WindowListener ke frame
        frame.addWindowListener(new WindowListener() {
            // Dijalankan ketika jendela dibuka
            public void windowOpened(WindowEvent e) {
                label.setText("Window Opened.");
            }

            // Dijalankan ketika jendela sedang dalam proses penutupan
            public void windowClosing(WindowEvent e) {
                label.setText("Window Closing.");
                // Bisa menambahkan System.exit(0); jika ingin menghentikan program
            }

            // Metode lain dari WindowListener yang perlu diimplementasikan
            public void windowClosed(WindowEvent e) {}
            public void windowIconified(WindowEvent e) {}
            public void windowDeiconified(WindowEvent e) {}
            public void windowActivated(WindowEvent e) {}
            public void windowDeactivated(WindowEvent e) {}
        });
l
        frame.add(label);
        frame.setSize(400, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

