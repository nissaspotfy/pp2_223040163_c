package pertemuan7.BiodataSaya.src.dao;


import db.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Biodata;

public class BiodataDao {
  public int insert(Member member) {
    int result = -1;
    try {
      Connection connection = MySqlConnection.getInstance().getConnection();
      PreparedStatement statement = connection
          .prepareStatement("insert into biodata (nama, tanggal_lahir, jenis_kelamin,no_hp) values (?,?, ?, ?) ");
      statement.setString(1, biodata.getNama());
      statement.setString(2, biodata.getTanggalLahir());
      statement.setString(3, biodata.getJenisKelamin());
      statement.setString(3, biodata.getNoHandphone());
     

      result = statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  public int update(Biodata biodata) {
    int result = -1;
    try {
      Connection connection = MySqlConnection.getInstance().getConnection();
      PreparedStatement statement = connection
          .prepareStatement(
              "update biodata set  (nama =?, tanggal_lahir =?, jenis_kelamin =? ,no_hp =? where id = ");
      statement.setString(1, biodata.getNama());
      statement.setString(2, biodata.getTanggalLahir());
      statement.setString(3, biodata.getJenisKelamin());
      statement.setString(3, biodata.getNoHandphone());
   

      result = statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  public int delete(Biodata biodata) {
    int result = -1;
    try {
      Connection connection = MySqlConnection.getInstance().getConnection();
      PreparedStatement statement = connection.prepareStatement("delete from biodata where id = ?");
      statement.setString(1, biodata.getId());

      result = statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  public List<Biodata> findAll() {
    List<Biodata> list = new ArrayList<>();
    try {
      Connection connection = MySqlConnection.getInstance().getConnection();
      PreparedStatement statement = connection.prepareStatement(
          "select id, nama, tanggal_lahir, jenis_kelamin, no_hp from biodata");
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        Biodata biodata = new Biodata();
        biodata.setId(resultSet.getString("id"));
        biodata.setNama(resultSet.getString("nama"));
        biodata.setTanggalLahir(resultSet.getString("tanggal_lahir"));
        biodata.setJenisKelamin(resultSet.getString("jenis_kelamin"));
        biodata.setNoHandphone(resultSet.getString("no_hp"));


        list.add(biodata);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return list;
  }
}
