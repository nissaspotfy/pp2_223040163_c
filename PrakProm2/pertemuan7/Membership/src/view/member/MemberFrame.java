package view.member;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import dao.MemberDao;
import dao.JenisMemberDao;
import model.Member;
import model.JenisMember;

public class MemberFrame extends JFrame {
  private List<JenisMember> jenisMemberList;
  private List<Member> memberList = new ArrayList<>();
  private JComboBox<String> comboJenis;
  private JTextField textFieldNama;
  private MemberTableModel tableModel;
  private MemberDao memberDao;
  private JenisMemberDao jenisMemberDao;

  public MemberFrame(MemberDao memberDao, JenisMemberDao jenisMemberDao) {
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.memberDao = memberDao;
    this.jenisMemberDao = jenisMemberDao;

   
    this.jenisMemberList = this.jenisMemberDao.findAll();

    JLabel labelInput = new JLabel("Nama:");
    labelInput.setBounds(15, 40, 350, 10);



    textFieldNama = new JTextField();
    textFieldNama.setBounds(15, 60, 350, 30);

    JLabel labelJenis = new JLabel("Jenis Member:");
    labelJenis.setBounds(15, 100, 350, 10);

    comboJenis = new JComboBox <>();
    comboJenis.setBounds(15, 120, 150, 30);
   
    JButton button = new JButton("Simpan");
    button.setBounds(15, 160, 100, 40);

    javax.swing.JTable table = new JTable();
    JScrollPane scrollableTable = new JScrollPane(table);
    scrollableTable.setBounds(15, 220, 350, 200);

    tableModel = new MemberTableModel(memberList);
    table.setModel(tableModel);

    MemberButtonSimpanActionListener actionListener = new MemberButtonSimpanActionListener(this, memberDao);

    button.addActionListener(actionListener);

    // Additional UI components and layout setup can be added here
    this.add(button);
    this.add(labelInput);
    this.add(textFieldNama);
    this.add(labelJenis);
    this.add(comboJenis);
    this.add(scrollableTable);

    this.setSize(400, 500);
    this.setLayout(null);

  }

  public void populateComboJenis()
  {
    this.jenisMemberList = this.jenisMemberDao.findAll();
    if(
      this.comboJenis !=null 
    ){
      comboJenis.removeAllItems();
      for (JenisMember jenisMember : this.jenisMemberList) {
        comboJenis.addItem(jenisMember.getNama());
      }

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