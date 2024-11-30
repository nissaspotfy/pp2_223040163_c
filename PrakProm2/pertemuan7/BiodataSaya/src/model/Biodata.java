package pertemuan7.BiodataSaya.src.model;


public class Biodata{
  private String id;
  private String nama;
  private String tanggallahir;
  private String jeniskelamin;
  private String nohandphone;
 

  public void setId(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public String getNama() {
    return nama;
  }

  public String getTanggalLahir() {
    return tanggallahir;
  }

  public void setTanggalLahir(String tanggallahir) {
    this.tanggallahir = tanggallahir;
  }

  public String getJenisKelamin() {
    return jeniskelamin;
  }

  public void setJenisKelamin(String jeniskelamin) {
    this.jeniskelamin = jeniskelamin;
  }

  public String getNoHandphone() {
    return nohandphone;
  }

  public void setNoHandphone(String noHandphone) {
    this.nohandphone = noHandphone;
  }

  
}
