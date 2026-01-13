package org.itenas.oop.jdbc.view;

import org.itenas.oop.jdbc.repository.LayananController;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.itenas.oop.jdbc.model.Layanan;

/**
 *
 * @author HP
 */
public class LayananView extends javax.swing.JFrame {

    private DefaultTableModel model;
    private String mode = "";
    private LayananController controller = new LayananController();

    public LayananView() {
        initComponents();
        initTable();
        loadData();
        setFormKosong();
        setFormEnabled(false);
    }
    
    private void initTable() {
        model = new DefaultTableModel(
                new Object[]{"ID Layanan", "Nama Layanan", "Harga", "Durasi"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        TBLAYANAN.setModel(model);
        TBLAYANAN.setFocusable(false);

    }

    private void setFormEnabled(boolean status) {
        TXNAMA.setEnabled(status);
        TXHARGA.setEnabled(status);
        TXDURASI.setEnabled(status);
        BTPROSES.setEnabled(status);
    }

    private boolean validasiForm() {
        boolean valid = true;

        if (TXNAMA.getText().trim().isEmpty()) {
            TXNAMA.setBackground(java.awt.Color.PINK);
            valid = false;
        } else {
            TXNAMA.setBackground(java.awt.Color.WHITE);
        }

        if (TXHARGA.getText().trim().isEmpty()) {
            TXHARGA.setBackground(java.awt.Color.PINK);
            valid = false;
        } else {
            TXHARGA.setBackground(java.awt.Color.WHITE);
        }

        if (TXDURASI.getText().trim().isEmpty()) {
            TXDURASI.setBackground(java.awt.Color.PINK);
            valid = false;
        } else {
            TXDURASI.setBackground(java.awt.Color.WHITE);
        }

        if (!valid) {
            JOptionPane.showMessageDialog(this, "Field merah wajib diisi!");
        }

        return valid;
    }

    private void setFormKosong() {
        TXID.setText("AUTO");
        TXID.setEnabled(false);
        TXNAMA.setText("");
        TXHARGA.setText("");
        TXDURASI.setText("");
    }

    private void loadData() {
        model.setRowCount(0);

        for (Layanan l : controller.getAllLayanan()) {
            model.addRow(new Object[]{
                l.getIdLayanan(),
                l.getNamaLayanan(),
                l.getHarga(),
                l.getDurasi()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblLaporan = new javax.swing.JLabel();
        lblML = new javax.swing.JLabel();
        lblMT = new javax.swing.JLabel();
        lblTransaksi = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();
        ML = new javax.swing.JLabel();
        BTTAMBAH = new javax.swing.JButton();
        BTUPDATE = new javax.swing.JButton();
        BTDELETE = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBLAYANAN = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        BTPROSES = new javax.swing.JButton();
        BTID = new javax.swing.JLabel();
        BTNAMA = new javax.swing.JLabel();
        BTHARGA = new javax.swing.JLabel();
        BTDURASI = new javax.swing.JLabel();
        TXNAMA = new javax.swing.JTextField();
        TXID = new javax.swing.JTextField();
        TXHARGA = new javax.swing.JTextField();
        TXDURASI = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(157, 186, 168));

        lblLaporan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLaporan.setForeground(new java.awt.Color(248, 243, 237));
        lblLaporan.setText("Laporan");
        lblLaporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLaporanMouseClicked(evt);
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

        lblMT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMT.setForeground(new java.awt.Color(248, 243, 237));
        lblMT.setText("Manajemen Terapis");
        lblMT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMTMouseClicked(evt);
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

        lblLogout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(248, 243, 237));
        lblLogout.setText("Logout");
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMT)
                    .addComponent(lblLogout)
                    .addComponent(lblML)
                    .addComponent(lblTransaksi)
                    .addComponent(lblLaporan))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(154, 154, 154)
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

        ML.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ML.setForeground(new java.awt.Color(168, 116, 69));
        ML.setText("Manajemen Layanan");

        BTTAMBAH.setBackground(new java.awt.Color(157, 186, 168));
        BTTAMBAH.setForeground(new java.awt.Color(248, 243, 237));
        BTTAMBAH.setText("TAMBAH");
        BTTAMBAH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTTAMBAHActionPerformed(evt);
            }
        });

        BTUPDATE.setBackground(new java.awt.Color(157, 186, 168));
        BTUPDATE.setForeground(new java.awt.Color(248, 243, 237));
        BTUPDATE.setText("UPDATE");
        BTUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTUPDATEActionPerformed(evt);
            }
        });

        BTDELETE.setBackground(new java.awt.Color(157, 186, 168));
        BTDELETE.setForeground(new java.awt.Color(248, 243, 237));
        BTDELETE.setText("DELETE");
        BTDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTDELETEActionPerformed(evt);
            }
        });

        TBLAYANAN.setBackground(new java.awt.Color(242, 242, 242));
        TBLAYANAN.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TBLAYANAN.setForeground(new java.awt.Color(168, 116, 69));
        TBLAYANAN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Layanan", "Nama Layanan", "Harga", "Durasi (Menit)"
            }
        ));
        TBLAYANAN.setGridColor(new java.awt.Color(179, 179, 75));
        jScrollPane1.setViewportView(TBLAYANAN);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(168, 116, 69));
        jLabel9.setText("SPADMIN");

        BTPROSES.setBackground(new java.awt.Color(157, 186, 168));
        BTPROSES.setForeground(new java.awt.Color(248, 243, 237));
        BTPROSES.setText("Proses");
        BTPROSES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTPROSESActionPerformed(evt);
            }
        });

        BTID.setForeground(new java.awt.Color(168, 116, 69));
        BTID.setText("ID LAYANAN");

        BTNAMA.setForeground(new java.awt.Color(168, 116, 69));
        BTNAMA.setText("NAMA LAYANAN");

        BTHARGA.setForeground(new java.awt.Color(168, 116, 69));
        BTHARGA.setText("HARGA");

        BTDURASI.setForeground(new java.awt.Color(168, 116, 69));
        BTDURASI.setText("DURASI");

        TXNAMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXNAMAActionPerformed(evt);
            }
        });

        TXID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXIDActionPerformed(evt);
            }
        });

        TXHARGA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXHARGAActionPerformed(evt);
            }
        });

        TXDURASI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXDURASIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ML)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(BTPROSES))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(BTID)
                                                .addComponent(BTNAMA, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addComponent(BTHARGA)
                                            .addComponent(BTDURASI))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(TXDURASI, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TXNAMA, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TXHARGA, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(BTTAMBAH)
                                                .addGap(38, 38, 38)
                                                .addComponent(BTUPDATE)
                                                .addGap(36, 36, 36)
                                                .addComponent(BTDELETE))
                                            .addComponent(TXID, javax.swing.GroupLayout.Alignment.LEADING))))
                                .addGap(35, 35, 35)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(ML)
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BTTAMBAH)
                            .addComponent(BTUPDATE)
                            .addComponent(BTDELETE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BTID)
                            .addComponent(TXID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TXNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BTNAMA))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TXHARGA, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BTHARGA))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TXDURASI, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BTDURASI))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTPROSES))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BTTAMBAHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTTAMBAHActionPerformed
        mode = "TAMBAH";
        setFormKosong();
        setFormEnabled(true);
        TXNAMA.requestFocus();
    }//GEN-LAST:event_BTTAMBAHActionPerformed

    private void BTUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTUPDATEActionPerformed
        mode = "UPDATE";
        setFormKosong();

        TXID.setEnabled(true);
        TXID.setText("");
        TXID.requestFocus();

        TXNAMA.setEnabled(false);
        TXHARGA.setEnabled(false);
        TXDURASI.setEnabled(false);

        BTPROSES.setEnabled(true);

        JOptionPane.showMessageDialog(this,
                "Masukkan ID lalu klik PROSES");
    }//GEN-LAST:event_BTUPDATEActionPerformed

    private void BTPROSESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTPROSESActionPerformed
        try {
            if (mode.equals("UPDATE")) {

                if (!TXNAMA.isEnabled()) {
                    int id = Integer.parseInt(TXID.getText());
                    Layanan l = controller.getById(id);

                    if (l == null) {
                        JOptionPane.showMessageDialog(this,
                                "ID tidak ditemukan!");
                        return;
                    }

                    TXNAMA.setEnabled(true);
                    TXHARGA.setEnabled(true);
                    TXDURASI.setEnabled(true);

                    TXNAMA.setText(l.getNamaLayanan());
                    TXHARGA.setText(String.valueOf(l.getHarga()));
                    TXDURASI.setText(String.valueOf(l.getDurasi()));

                    JOptionPane.showMessageDialog(this,
                            "ID valid, silakan edit data lalu klik PROSES lagi");
                    return;
                }

                if (!validasiForm()) {
                    return;
                }

                Layanan l = new Layanan();
                l.setIdLayanan(Integer.parseInt(TXID.getText()));
                l.setNamaLayanan(TXNAMA.getText());
                l.setHarga(Double.parseDouble(TXHARGA.getText()));
                l.setDurasi(Integer.parseInt(TXDURASI.getText()));

                controller.updateLayanan(l);
            } else if (mode.equals("TAMBAH")) {
                if (!validasiForm()) {
                    return;
                }

                Layanan l = new Layanan();
                l.setNamaLayanan(TXNAMA.getText());
                l.setHarga(Double.parseDouble(TXHARGA.getText()));
                l.setDurasi(Integer.parseInt(TXDURASI.getText()));

                controller.insert(l);

                JOptionPane.showMessageDialog(this,
                        "Layanan berhasil ditambahkan!");

            } else if (mode.equals("DELETE")) {
                int id = Integer.parseInt(TXID.getText());

                Layanan l = controller.getById(id);
                if (l == null) {
                    JOptionPane.showMessageDialog(this,
                            "ID tidak ditemukan di database!");
                    return;
                }

                int konfirmasi = JOptionPane.showConfirmDialog(
                        this,
                        "Yakin ingin menghapus layanan:\n"
                        + l.getNamaLayanan() + " ?",
                        "Konfirmasi Hapus",
                        JOptionPane.YES_NO_OPTION
                );

                if (konfirmasi == JOptionPane.YES_OPTION) {
                    controller.nonaktifkanLayanan(id);
                    JOptionPane.showMessageDialog(this,
                            "Layanan berhasil dinonaktifkan!");
                }

            }

            loadData();
            setFormKosong();
            setFormEnabled(false);
            mode = "";

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Input angka tidak valid!");
        }
    }//GEN-LAST:event_BTPROSESActionPerformed

    private void TXNAMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXNAMAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXNAMAActionPerformed

    private void TXIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXIDActionPerformed

    private void TXHARGAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXHARGAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXHARGAActionPerformed

    private void TXDURASIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXDURASIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXDURASIActionPerformed

    private void BTDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTDELETEActionPerformed
        mode = "DELETE";

        TXID.setEnabled(true);
        TXID.setText("");
        TXID.requestFocus();

        TXNAMA.setEnabled(false);
        TXHARGA.setEnabled(false);
        TXDURASI.setEnabled(false);

        BTPROSES.setEnabled(true);

        JOptionPane.showMessageDialog(this,
                "Masukkan ID layanan lalu klik PROSES");
    }//GEN-LAST:event_BTDELETEActionPerformed

    private void lblLaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLaporanMouseClicked
        new LaporanView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblLaporanMouseClicked

    private void lblTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTransaksiMouseClicked
        new TransaksiView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblTransaksiMouseClicked

    private void lblMLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMLMouseClicked
        new LayananView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblMLMouseClicked

    private void lblMTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMTMouseClicked
        new TerapisView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblMTMouseClicked

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
            java.util.logging.Logger.getLogger(LayananView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LayananView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LayananView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LayananView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LayananView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTDELETE;
    private javax.swing.JLabel BTDURASI;
    private javax.swing.JLabel BTHARGA;
    private javax.swing.JLabel BTID;
    private javax.swing.JLabel BTNAMA;
    private javax.swing.JButton BTPROSES;
    private javax.swing.JButton BTTAMBAH;
    private javax.swing.JButton BTUPDATE;
    private javax.swing.JLabel ML;
    private javax.swing.JTable TBLAYANAN;
    private javax.swing.JTextField TXDURASI;
    private javax.swing.JTextField TXHARGA;
    private javax.swing.JTextField TXID;
    private javax.swing.JTextField TXNAMA;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLaporan;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblML;
    private javax.swing.JLabel lblMT;
    private javax.swing.JLabel lblTransaksi;
    // End of variables declaration//GEN-END:variables
}
