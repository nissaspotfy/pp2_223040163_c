package view.member;

import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import dao.MemberDao;
import dao.JenisMemberDao;
import model.Member;
import model.JenisMember;

public class MemberFrame extends JFrame {
  private List<JenisMember> jenisMemberList;
  private List<Member> memberList;
  private JComboBox<String> comboJenis;
  private JTextField textFieldNama;
  private MemberTableModel tableModel;
  private MemberDao memberDao;
  private JenisMemberDao jenisMemberDao;

  public MemberFrame(MemberDao memberDao, JenisMemberDao jenisMemberDao) {
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.memberDao = memberDao;
    this.jenisMemberDao = jenisMemberDao;

    this.memberList = this.memberDao.findAll();
    this.jenisMemberList = this.jenisMemberDao.findAll();

    JLabel labelInput = new JLabel("Nama:");
    labelInput.setBounds(15, 40, 10, 10);

    textFieldNama = new JTextField();
    textFieldNama.setBounds(15, 60, 350, 30);

    JLabel labelJenis = new JLabel("Jenis Member:");
    labelJenis.setBounds(15, 100, 100, 10);

    JComboBox<JenisMember> comboJenis = new JComboBox<>();
    for (JenisMember jenis : jenisMemberList) {
      comboJenis.addItem(jenis);
    }
    comboJenis.setBounds(15, 120, 350, 30);

    // Additional UI components and layout setup can be added here

    this.add(labelInput);
    this.add(textFieldNama);
    this.add(labelJenis);
    this.add(comboJenis);

    this.setSize(400, 500);
    this.setLayout(null);
    this.setVisible(true);
  }

  public void populateComboJenis()
  {
    this.jenisMemberList = this.jenisMemberDao.findAll();
    comboJenis.removeAllItems();
    for (JenisMember jenisMember: this.jenisMemberList)
    {
      comboJenis.addItem(jenisMember.getNama());
    }
  }

  public String getNama() {
    return textFieldNama.getText();
  }

  public JenisMember getJenisMember() {
    return jenisMemberList.get(comboJenis.getSelectedIndex());
  }

  public void addMember(Member member) {
    tableModel.add(member);
    textFieldNama.setText("");
  }

public void showAlert(String message) {
    JOptionPane.showMessageDialog(this, message);
}
}