package view.member;

import java.awt.event.*;
import java.util.UUID;
import dao.MemberDao;
import model.Member;
import model.JenisMember;

public class MemberButtonSimpanActionListener implements ActionListener {
  private MemberFrame memberFrame;
  private MemberDao memberDao;

  public MemberButtonSimpanActionListener(MemberFrame memberFrame, MemberDao memberDao) {
    this.memberFrame = memberFrame;
    this.memberDao = memberDao;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String nama = this.memberFrame.getNama();
    if (nama.isEmpty()) {
      this.memberFrame.showAlert("Nama tidak boleh kosong");
    } else {
      JenisMember jenisMember = this.memberFrame.getJenisMember();
      Member member = new Member();
      member.setId(UUID.randomUUID().toString());
      member.setNama(nama);
  

      this.memberFrame.addMember(member);
      this.memberDao.insert(member);
      
    }
  }
}