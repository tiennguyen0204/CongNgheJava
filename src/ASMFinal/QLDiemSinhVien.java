/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASMFinal;

import ASMFinal.connectDB.SqlServerConnector;
import ASMFinal.model.DiemSinhVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class QLDiemSinhVien extends javax.swing.JFrame {

    SqlServerConnector connection;
    Connection conn = connection.connectToDatabase();

    private String header[] = {"Mã SV", "Họ Tên", "Tiếng Anh", "Tin học", "GDTC", "Điểm TB"};
    private DefaultTableModel tblmodel = new DefaultTableModel(header, 0);
    ArrayList<DiemSinhVien> list = new ArrayList<DiemSinhVien>();
    private int current = -1;

    /**
     * Creates new form QLDiemSinhVien
     */
    public QLDiemSinhVien() {
        initComponents();
        setLocationRelativeTo(null);
        LoadData();
        LoadDataToTable();
    }

    public void LoadDataToTable() {
        Statement stmt = null;
        try {
            tblmodel.setRowCount(0);
            stmt = conn.createStatement();
            String sql = "select STUDENTS.MASV,Hoten,TiengAnh,TinHoc,GDTC,(TiengAnh+TinHoc+GDTC)/3 as DiemTB from GRADE,STUDENTS where STUDENTS.MASV=GRADE.MASV";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getString(4));
                row.add(rs.getString(5));
                row.add(rs.getString(6));
                tblmodel.addRow(row);
            }
            tblBang.setModel(tblmodel);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void LoadData() {
        Statement st = null;
        try {
            st = conn.createStatement();
            String sql = "select ID,GRADE.MASV,Hoten,TiengAnh,TinHoc,GDTC from GRADE,STUDENTS where GRADE.MASV=STUDENTS.MASV";
            ResultSet rs = st.executeQuery(sql);
            list.clear();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String MASV = rs.getString("MASV");
                String Hoten = rs.getString("Hoten");
                int TiengAnh = rs.getInt("TiengAnh");
                int TinHoc = rs.getInt("TinHoc");
                int GDTC = rs.getInt("GDTC");
                double DiemTB = (TiengAnh + TinHoc + GDTC) / 3;
                DiemSinhVien diemsv = new DiemSinhVien(ID, MASV, Hoten, TiengAnh, TinHoc, GDTC, DiemTB);
                list.add(diemsv);
            }
            current = 0;
            hienthi();
            rs.close();
            st.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void DiemTB() {
        int ta = Integer.parseInt(txtAnhVan.getText());
        int th = Integer.parseInt(txtTinHoc.getText());
        int gdtc = Integer.parseInt(txtGDTC.getText());
        float diemtb = (ta + th + gdtc) / 3;
        lblDiemTB.setText(diemtb + "");
    }

    public void hienthi() {
        DiemSinhVien diemsv = list.get(current);
        txtMa.setText(diemsv.MaSV + "");
        lbTen.setText(diemsv.HoTen + "");
        txtAnhVan.setText(diemsv.TiengAnh + "");
        txtTinHoc.setText(diemsv.TinHoc + "");
        txtGDTC.setText(diemsv.GDTC + "");
        DiemTB();
    }

    public boolean KiemTra() {
        float av = Float.parseFloat(txtAnhVan.getText());
        float th = Float.parseFloat(txtTinHoc.getText());
        float gd = Float.parseFloat(txtGDTC.getText());
        if ((av < 0 || av > 10) || (th < 0 || th > 10) || (gd < 0 || gd > 10)) {
            JOptionPane.showMessageDialog(rootPane, "Bạn nhập sai định dạng điểm hoặc điểm không hợp lệ");
            return false;
        }
        if (txtMa.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Bạn Chưa Nhập MSSV");
            return false;
        }
        if (txtAnhVan.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập điểm Anh Văn");
            return false;
        }
        if (txtTinHoc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập điểm tin học");
            return false;
        }
        if (txtGDTC.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập điểm giáo dục thể chất");
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        panelHoTen = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtAnhVan = new javax.swing.JTextField();
        txtTinHoc = new javax.swing.JTextField();
        txtGDTC = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lblDiemTB = new javax.swing.JLabel();
        lbTen = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBang = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Quản Lý Điểm Sinh Viên");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Tìm Kiếm");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Mã số sinh viên:");

        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search (1).png"))); // NOI18N
        btnTim.setText("Search");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });
        tblBang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        panelHoTen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setText("Họ tên SV:");

        jLabel5.setText("Mã SV:");

        jLabel6.setText("Tiếng Anh:");

        jLabel7.setText("Tin Học:");

        jLabel8.setText("Giác Dục TC:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 255));
        jLabel10.setText("Điểm TB:");

        lblDiemTB.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblDiemTB.setForeground(new java.awt.Color(51, 51, 255));

        lbTen.setForeground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout panelHoTenLayout = new javax.swing.GroupLayout(panelHoTen);
        panelHoTen.setLayout(panelHoTenLayout);
        panelHoTenLayout.setHorizontalGroup(
            panelHoTenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHoTenLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelHoTenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(panelHoTenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAnhVan, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(txtTinHoc)
                    .addComponent(txtGDTC)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHoTenLayout.createSequentialGroup()
                        .addComponent(lbTen, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtMa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(panelHoTenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDiemTB, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        panelHoTenLayout.setVerticalGroup(
            panelHoTenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHoTenLayout.createSequentialGroup()
                .addGroup(panelHoTenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHoTenLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelHoTenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9)))
                    .addGroup(panelHoTenLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbTen, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelHoTenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelHoTenLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtMa, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                    .addGroup(panelHoTenLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelHoTenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAnhVan, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelHoTenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHoTenLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelHoTenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGDTC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtTinHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
            .addGroup(panelHoTenLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDiemTB, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/them.png"))); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/save.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xoa.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/last.png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/next.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/first.png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        tblBang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã SV", "Họ Tên SV", "Tiếng Anh", "Tin Học", "GDTC", "Điểm TB"
            }
        ));
        jScrollPane1.setViewportView(tblBang);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Danh Sách Điểm Sinh Viên :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnFirst)
                                                .addGap(100, 100, 100)
                                                .addComponent(btnBack)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnNext)
                                                .addGap(100, 100, 100)
                                                .addComponent(btnLast))
                                            .addComponent(panelHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(46, 46, 46)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnNew, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel12)))
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNew)
                        .addGap(39, 39, 39)
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete)
                        .addGap(36, 36, 36)
                        .addComponent(btnUpdate))
                    .addComponent(panelHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLast)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnNext)
                        .addComponent(btnFirst, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(btnBack, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        current = 0;
        hienthi();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        current = list.size() - 1;
        hienthi();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        current++;
        if (current >= list.size()) {
            JOptionPane.showMessageDialog(this, "Đang ở cuối danh sách");
            current = list.size() - 1;
            return;
        }
        hienthi();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        current--;
        if (current < 0) {
            JOptionPane.showMessageDialog(this, "Đang ở đầu danh sách");
            current = 0;
            return;
        }
        hienthi();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        try {
            // TODO add your handling code here:
            String sql = "select GRADE.MASV,Hoten,TiengAnh,TinHoc,GDTC from GRADE,STUDENTS where GRADE.MASV=STUDENTS.MASV and GRADE.MASV=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, txtTim.getText().trim());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                lbTen.setText(rs.getString("Hoten"));
                txtMa.setText(rs.getString("MASV"));
                txtAnhVan.setText(rs.getString("TiengAnh"));
                txtTinHoc.setText(rs.getString("TinHoc"));
                txtGDTC.setText(rs.getString("GDTC"));
                DiemTB();
                JOptionPane.showMessageDialog(this, "Đã tìm thấy sinh viên");
            } else {
                JOptionPane.showMessageDialog(this, "Mã sinh viên không hợp lệ hoặc sinh viên chưa có điểm");
            }
        } catch (SQLException ex) {
            Logger.getLogger(QLDiemSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        txtMa.setText("");
        txtAnhVan.setText("");
        txtGDTC.setText("");
        txtTinHoc.setText("");
        lbTen.setText("");
        lblDiemTB.setText("");
        txtTim.setText("");
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "delete from grade where masv=?";
            PreparedStatement ps = null;
            ps = conn.prepareStatement(sql);
            ps.setString(1, txtMa.getText().trim());
            ps.execute();
            JOptionPane.showMessageDialog(this, "xóa thành công");
            LoadDataToTable();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "xóa không thành công");
        }
        LoadData();
        LoadDataToTable();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (KiemTra() == true) {
            try {
                String sql = "update GRADE set TiengAnh=?,TinHoc=?,GDTC=? where MASV=?";
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setString(1, txtAnhVan.getText().trim());
                stm.setString(2, txtTinHoc.getText().trim());
                stm.setString(3, txtGDTC.getText().trim());
                stm.setString(4, txtMa.getText().trim());
                stm.executeUpdate();
                stm.close();
                LoadData();
                LoadDataToTable();
                hienthi();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String ma = txtMa.getText();
        for( DiemSinhVien x : list ){
            if(ma.equalsIgnoreCase(x.MaSV)){
                JOptionPane.showMessageDialog(this,"Mã sinh viên đã tồn tại");
                return;
            }
        }
        try {
            if (KiemTra() == true) {
                String sql = "insert into GRADE(MASV,TiengAnh,TinHoc,GDTC) values(?,?,?,?)";
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setString(1, txtMa.getText().trim());
                stm.setString(2, txtAnhVan.getText().trim());
                stm.setString(3, txtTinHoc.getText().trim());
                stm.setString(4, txtGDTC.getText().trim());
                stm.executeUpdate();
                stm.close();
                LoadData();
                LoadDataToTable();
                hienthi();

            }
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(rootPane, "Mã sinh viên không tồn tại");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QLDiemSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLDiemSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLDiemSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLDiemSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLDiemSinhVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTen;
    private javax.swing.JLabel lblDiemTB;
    private javax.swing.JPanel panelHoTen;
    private javax.swing.JTable tblBang;
    private javax.swing.JTextField txtAnhVan;
    private javax.swing.JTextField txtGDTC;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTim;
    private javax.swing.JTextField txtTinHoc;
    // End of variables declaration//GEN-END:variables

    private void tblBangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangMouseClicked
        // TODO add your handling code here:
        int row = tblBang.getSelectedRow();
        Dodulieu(row);
    }

    public void Dodulieu(int row) {
        if (row < 0) {
            return;
        }
        txtMa.setText(tblBang.getValueAt(row, 0).toString());
        lbTen.setText(tblBang.getValueAt(row, 1).toString());
        txtAnhVan.setText(tblBang.getValueAt(row, 2).toString());
        txtTinHoc.setText(tblBang.getValueAt(row, 3).toString());
        txtGDTC.setText(tblBang.getValueAt(row, 4).toString());
        lblDiemTB.setText(tblBang.getValueAt(row, 5).toString());
    }


}
