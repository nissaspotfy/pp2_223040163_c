package pertemuan7.BiodataSaya.src.view;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Biodata;
import dao.biodataDao;

public class BiodataButtonSimpanActionListener implements ActionListener {
  private BiodataFrame biodataFrame;
  private biodataDao biodataDao;

  public BiodataButtonSimpanActionListener(BiodataFrame biodataFrame, biodataDao biodataDao) {
    this.biodataFrame = biodataFrame;
    this.biodataDao = biodataDao;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String nama = biodataFrame.getNama();
    String tanggalLahir = biodataFrame.getTanggalLahir();
    String jenisKelamin = biodataFrame.getJenisKelamin();
    String noHandphone = biodataFrame.getNoHandphone();
  
    

    if (nama.isEmpty() || tanggalLahir.isEmpty() || jenisKelamin.isEmpty() || noHandphone.isEmpty()) {
      biodataFrame.showAlert("Semua field harus diisi!");
      return;
    }

    Biodata biodata = new Biodata();
    biodata.setNama(nama);
    biodata.setTanggalLahir(tanggalLahir);
    biodata.setJenisKelamin(jenisKelamin);
    biodata.setNoHandphone(noHandphone);

    if (biodataDao.insert(biodata) > 0) {
      biodataFrame.addBiodata(biodata);
      biodataFrame.showAlert("Biodata berhasil disimpan.");
    } else {
      biodataFrame.showAlert("Gagal menyimpan biodata.");
    }
  }
}
