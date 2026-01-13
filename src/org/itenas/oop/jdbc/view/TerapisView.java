package org.itenas.oop.jdbc.view;

import javax.swing.JOptionPane;
import org.itenas.oop.jdbc.model.Terapis;
import org.itenas.oop.jdbc.repository.TerapisController;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import org.itenas.oop.jdbc.model.Layanan;

/**
 *
 * @author HP
 */
public class TerapisView extends javax.swing.JFrame {

    private TerapisController controller = new TerapisController();
    private String mode;
    private DefaultTableModel model;

    public TerapisView() {
        initComponents();
        initTable();
        setFormKosong();
        setFormEnabled(false);
    }

    private String getJKValue() {
        int index = cbJK.getSelectedIndex();
        if (index == 1) {
            return "Perempuan";
        } else if (index == 2) {
            return "Laki - Laki";
        }
        return null;
    }

    private void initTable() {
    model = new DefaultTableModel(
        new Object[]{"ID TERAPIS", "NAMA TERAPIS", "NO TELP", "JENIS KELAMIN"}, 0
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    tblTerapis.setModel(model);
    tblTerapis.setFocusable(false);
    loadData();
    }
    
    private void setFormEnabled(boolean status) {
        txtNamaTerapis.setEnabled(status);
        txtNoTelp.setEnabled(status);
        cbJK.setEnabled(status);
        btnProses.setEnabled(status);
    }
    
    private boolean validasiForm() {
        boolean valid = true;

        if (txtNamaTerapis.getText().trim().isEmpty()) {
            txtNamaTerapis.setBackground(java.awt.Color.PINK);
            valid = false;
        } else {
            txtNamaTerapis.setBackground(java.awt.Color.WHITE);
        }

        if (txtNoTelp.getText().trim().isEmpty()) {
            txtNoTelp.setBackground(java.awt.Color.PINK);
            valid = false;
        } else {
            txtNoTelp.setBackground(java.awt.Color.WHITE);
        }

        if (cbJK.getSelectedIndex() == 0) {
            cbJK.setBackground(java.awt.Color.PINK);
            valid = false;
        } else {
            cbJK.setBackground(java.awt.Color.WHITE);
        }

        if (!valid) {
            JOptionPane.showMessageDialog(this, "Field merah wajib diisi!");
        }
        
        return valid;
    }
    
    private void setFormKosong() {
        txtId.setText("AUTO");
        txtId.setEnabled(false);
        txtNamaTerapis.setText("");
        txtNoTelp.setText("");
        cbJK.setSelectedIndex(0);
    }
    
    private void loadData() {
    model.setRowCount(0);
    for (Terapis t : controller.getAllTerapis()) {
        model.addRow(new Object[]{
            t.getIdTerapis(),
            t.getNamaTerapis(),
            t.getNoTelp(),
            t.getJenisKelamin()
        });
    }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblLogout = new javax.swing.JLabel();
        lblMT = new javax.swing.JLabel();
        lblML = new javax.swing.JLabel();
        lblTransaksi = new javax.swing.JLabel();
        lblLaporan = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        MT = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblTerapis = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        txtNamaTerapis = new javax.swing.JTextField();
        lblNo = new javax.swing.JLabel();
        lblJK = new javax.swing.JLabel();
        btnProses = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTerapis = new javax.swing.JTable();
        txtId = new javax.swing.JTextField();
        txtNoTelp = new javax.swing.JTextField();
        cbJK = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(157, 186, 168));

        lblLogout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(248, 243, 237));
        lblLogout.setText("Logout");
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
        });

        lblMT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMT.setForeground(new java.awt.Color(248, 243, 237));
        lblMT.setText("Manajemen Terapis");
        lblMT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMTMouseClicked(evt);
            }
        });

        lblML.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblML.setForeground(new java.awt.Color(248, 243, 237));
        lblML.setText("Manajemen Layanan");
        lblML.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMLMouseClicked(evt);
            }
        });

        lblTransaksi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTransaksi.setForeground(new java.awt.Color(248, 243, 237));
        lblTransaksi.setText("Transaksi");
        lblTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTransaksiMouseClicked(evt);
            }
        });

        lblLaporan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLaporan.setForeground(new java.awt.Color(248, 243, 237));
        lblLaporan.setText("Laporan");
        lblLaporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLaporanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLaporan)
                    .addComponent(lblTransaksi)
                    .addComponent(lblMT)
                    .addComponent(lblML)
                    .addComponent(lblLogout))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(lblMT)
                .addGap(18, 18, 18)
                .addComponent(lblML)
                .addGap(18, 18, 18)
                .addComponent(lblTransaksi)
                .addGap(18, 18, 18)
                .addComponent(lblLaporan)
                .addGap(18, 18, 18)
                .addComponent(lblLogout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(168, 116, 69));
        jLabel9.setText("SPADMIN");

        MT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        MT.setForeground(new java.awt.Color(168, 116, 69));
        MT.setText("Manajemen Terapis");

        btnTambah.setBackground(new java.awt.Color(157, 186, 168));
        btnTambah.setForeground(new java.awt.Color(248, 243, 237));
        btnTambah.setText("TAMBAH");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(157, 186, 168));
        btnUpdate.setForeground(new java.awt.Color(248, 243, 237));
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(157, 186, 168));
        btnDelete.setForeground(new java.awt.Color(248, 243, 237));
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblTerapis.setForeground(new java.awt.Color(168, 116, 69));
        lblTerapis.setText("ID TERAPIS");

        lblNama.setForeground(new java.awt.Color(168, 116, 69));
        lblNama.setText("NAMA TERAPIS");

        txtNamaTerapis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaTerapisActionPerformed(evt);
            }
        });

        lblNo.setForeground(new java.awt.Color(168, 116, 69));
        lblNo.setText("NO TELPON");

        lblJK.setForeground(new java.awt.Color(168, 116, 69));
        lblJK.setText("JENIS KELAMIN");

        btnProses.setBackground(new java.awt.Color(157, 186, 168));
        btnProses.setForeground(new java.awt.Color(248, 243, 237));
        btnProses.setText("Proses");
        btnProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesActionPerformed(evt);
            }
        });

        tblTerapis.setBackground(new java.awt.Color(242, 242, 242));
        tblTerapis.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblTerapis.setForeground(new java.awt.Color(168, 116, 69));
        tblTerapis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Terapis", "Nama Terapis", "No Telpon", "Jenis Kelamin"
            }
        ));
        tblTerapis.setGridColor(new java.awt.Color(179, 179, 75));
        jScrollPane1.setViewportView(tblTerapis);

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtNoTelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoTelpActionPerformed(evt);
            }
        });

        cbJK.setForeground(new java.awt.Color(168, 116, 69));
        cbJK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "Perempuan", "Laki - Laki" }));
        cbJK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MT)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNama)
                                    .addComponent(lblTerapis)
                                    .addComponent(lblNo)
                                    .addComponent(lblJK))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbJK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNoTelp)
                                    .addComponent(btnProses, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnTambah)
                                        .addGap(36, 36, 36)
                                        .addComponent(btnUpdate)
                                        .addGap(41, 41, 41)
                                        .addComponent(btnDelete))
                                    .addComponent(txtId)
                                    .addComponent(txtNamaTerapis))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(MT)
                        .addGap(100, 100, 100)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTambah)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTerapis)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNamaTerapis, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNama))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNo))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbJK, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblJK))
                        .addGap(7, 7, 7)
                        .addComponent(btnProses))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        mode = "TAMBAH";
        setFormKosong();
        setFormEnabled(true);
        txtNamaTerapis.requestFocus();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        mode = "UPDATE";
        setFormKosong();

        txtId.setEnabled(true);
        txtId.setText("");
        txtId.requestFocus();

        txtNamaTerapis.setEnabled(false);
        txtNoTelp.setEnabled(false);
        cbJK.setEnabled(false);

        btnProses.setEnabled(true);

        JOptionPane.showMessageDialog(this,
                "Masukkan ID terapis lalu klik PROSES");
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
    mode = "DELETE";
    setFormKosong();
    txtId.setEnabled(true);
    txtId.setText("");
    txtId.requestFocus();

    txtNamaTerapis.setEnabled(false);
    txtNoTelp.setEnabled(false);
    cbJK.setEnabled(false);

    btnProses.setEnabled(true);

    JOptionPane.showMessageDialog(this,
        "Masukkan ID terapis yang ingin dihapus lalu klik PROSES");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtNamaTerapisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaTerapisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaTerapisActionPerformed

    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesActionPerformed
        try {
        if (mode.equals("UPDATE")) {

            // STEP 1: CEK ID
            if (!txtNamaTerapis.isEnabled()) {
                int id = Integer.parseInt(txtId.getText());
                Terapis t = controller.getById(id);

                if (t == null) {
                    JOptionPane.showMessageDialog(this,
                            "ID terapis tidak ditemukan!");
                    return;
                }

                txtNamaTerapis.setEnabled(true);
                txtNoTelp.setEnabled(true);
                cbJK.setEnabled(true);

                txtNamaTerapis.setText(t.getNamaTerapis());
                txtNoTelp.setText(t.getNoTelp());
                cbJK.setSelectedItem(t.getJenisKelamin());

                JOptionPane.showMessageDialog(this,
                        "ID valid, silakan edit lalu klik PROSES lagi");
                return;
            }

            // STEP 2: SIMPAN UPDATE
            if (!validasiForm()) return;

            Terapis t = new Terapis();
            t.setIdTerapis(Integer.parseInt(txtId.getText()));
            t.setNamaTerapis(txtNamaTerapis.getText());
            t.setNoTelp(txtNoTelp.getText());
            t.setJenisKelamin(getJKValue());

            controller.updateTerapis(t);
            JOptionPane.showMessageDialog(this,
                    "Data terapis berhasil diupdate!");

        } 
        else if (mode.equals("TAMBAH")) {

            if (!validasiForm()) return;

            Terapis t = new Terapis();
            t.setNamaTerapis(txtNamaTerapis.getText());
            t.setNoTelp(txtNoTelp.getText());
            t.setJenisKelamin(getJKValue());

            controller.insert(t);
            JOptionPane.showMessageDialog(this,
                    "Terapis berhasil ditambahkan!");

        } 
        else if (mode.equals("DELETE")) {

            int id = Integer.parseInt(txtId.getText());
            Terapis t = controller.getById(id);

            if (t == null) {
                JOptionPane.showMessageDialog(this,
                        "ID terapis tidak ditemukan!");
                return;
            }

            int konfirmasi = JOptionPane.showConfirmDialog(
                    this,
                    "Yakin ingin menghapus terapis:\n" + t.getNamaTerapis() + " ?",
                    "Konfirmasi Hapus",
                    JOptionPane.YES_NO_OPTION
            );

            if (konfirmasi == JOptionPane.YES_OPTION) {
                controller.nonaktifkanTerapis(id);
                JOptionPane.showMessageDialog(this,
                        "Terapis berhasil dinonaktifkan!");
            }
        }

        loadData();
        setFormKosong();
        setFormEnabled(false);
        mode = "";

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this,
                "ID harus berupa angka!");
    }    
    }//GEN-LAST:event_btnProsesActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed

    }//GEN-LAST:event_txtIdActionPerformed

    private void txtNoTelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoTelpActionPerformed

    }//GEN-LAST:event_txtNoTelpActionPerformed

    private void cbJKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJKActionPerformed

    }//GEN-LAST:event_cbJKActionPerformed

    private void lblMTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMTMouseClicked
        new TerapisView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblMTMouseClicked

    private void lblMLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMLMouseClicked
        new LayananView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblMLMouseClicked

    private void lblTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTransaksiMouseClicked
        new TransaksiView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblTransaksiMouseClicked

    private void lblLaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLaporanMouseClicked
        new LaporanView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblLaporanMouseClicked

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        new LoginView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblLogoutMouseClicked

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
            java.util.logging.Logger.getLogger(TerapisView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TerapisView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TerapisView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TerapisView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TerapisView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MT;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnProses;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbJK;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblJK;
    private javax.swing.JLabel lblLaporan;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblML;
    private javax.swing.JLabel lblMT;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblNo;
    private javax.swing.JLabel lblTerapis;
    private javax.swing.JLabel lblTransaksi;
    private javax.swing.JTable tblTerapis;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNamaTerapis;
    private javax.swing.JTextField txtNoTelp;
    // End of variables declaration//GEN-END:variables
}