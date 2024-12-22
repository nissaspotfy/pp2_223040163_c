package controller;

import model.BookModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookController {
  private Connection connection;

  public BookController() {
    try {
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pp2_bookstore", "root", "");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public List<BookModel> getAllBooks() {
    List<BookModel> books = new ArrayList<>();
    try {
      String query = "SELECT * FROM books";
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
        books.add(new BookModel(
            rs.getInt("id"),
            rs.getString("title"),
            rs.getString("author"),
            rs.getDouble("price"),
            rs.getString("genre")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return books;
  }

  public void addBook(String title, String author, double price, String genre) {
    try {
      String query = "INSERT INTO books (title, author, price, genre) VALUES (?, ?, ?, ?)";
      PreparedStatement stmt = connection.prepareStatement(query);
      stmt.setString(1, title);
      stmt.setString(2, author);
      stmt.setDouble(3, price);
      stmt.setString(4, genre);
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void updateBook(int id, String title, String author, double price, String genre) {
    try {
      String query = "UPDATE books SET title = ?, author = ?, price = ?, genre = ? WHERE id = ?";
      PreparedStatement stmt = connection.prepareStatement(query);
      stmt.setString(1, title);
      stmt.setString(2, author);
      stmt.setDouble(3, price);
      stmt.setString(4, genre);
      stmt.setInt(5, id);
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void deleteBook(int id) {
    try {
      String query = "DELETE FROM books WHERE id = ?";
      PreparedStatement stmt = connection.prepareStatement(query);
      stmt.setInt(1, id);
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
