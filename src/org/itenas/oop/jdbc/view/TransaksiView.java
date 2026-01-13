/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itenas.oop.jdbc.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.itenas.oop.jdbc.repository.TransaksiController;
import org.itenas.oop.jdbc.repository.TerapisController;
import org.itenas.oop.jdbc.repository.LayananController;
import org.itenas.oop.jdbc.model.Terapis;
import org.itenas.oop.jdbc.model.Layanan;

public class TransaksiView extends javax.swing.JFrame {

    private final TransaksiController controller = new TransaksiController();

    private Integer currentIdTransaksiDb = null;

    private final List<Integer> idLayananList = new ArrayList<>();
    private final List<Integer> idTerapisList = new ArrayList<>();

    public TransaksiView() {
        initComponents();

        tblDetail.setModel(new DefaultTableModel(
        new Object[][]{},
        new String[]{"Layanan", "Terapis", "Subtotal"}
    ));

        loadComboLayanan();
        loadComboTerapis();

        txtTotal.setEditable(false);
        txtBalance.setEditable(false);

        txtTotal.setText("0");
        txtBayar.setText("0");
        txtBalance.setText("0");

        btnBayar.setEnabled(false);
    }

    private void loadComboTerapis() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        idTerapisList.clear();

        model.addElement("Pilih Terapis");
        idTerapisList.add(0);

        for (Terapis t : new TerapisController().getAllTerapis()) {
            model.addElement(t.getNamaTerapis());
            idTerapisList.add(t.getIdTerapis());
        }
        cbTerapis.setModel(model);
    }

    private void loadComboLayanan() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        idLayananList.clear();

        model.addElement("Pilih Layanan");
        idLayananList.add(0);

        for (Layanan l : new LayananController().getAllLayanan()) {
            model.addElement(l.getNamaLayanan());
            idLayananList.add(l.getIdLayanan());
        }
        cbLayanan.setModel(model);
    }

    private void hitungTotal() {
     DefaultTableModel model = (DefaultTableModel) tblDetail.getModel();
    List<Integer> subtotals = new ArrayList<>();

    for (int i = 0; i < model.getRowCount(); i++) {
        subtotals.add(Integer.parseInt(model.getValueAt(i, 2).toString()));
    }

    int total = controller.hitungTotalDariList(subtotals);
    txtTotal.setText(String.valueOf(total));
    }

    private void prosesPembayaranView() {
    int total = Integer.parseInt(txtTotal.getText());
    int bayar = Integer.parseInt(txtBayar.getText());

    int kembalian = controller.hitungKembalian(total, bayar);

    if (kembalian < 0) {
        JOptionPane.showMessageDialog(this,
            "Uang bayar kurang dari total!",
            "Peringatan",
            JOptionPane.WARNING_MESSAGE
        );
        txtBalance.setText("0");
        btnBayar.setEnabled(false);
        return;
    }

    txtBalance.setText(String.valueOf(kembalian));
    btnBayar.setEnabled(true);
}

    private void buatStruk() {
        StringBuilder struk = new StringBuilder();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        struk.append("========= SPA REFRESH RELAX =========\n");
        struk.append("ID Transaksi : ").append(currentIdTransaksiDb == null ? "-" : currentIdTransaksiDb).append("\n");
        struk.append("Tanggal      : ").append(now.format(format)).append("\n");
        struk.append("-----------------------------\n");

        DefaultTableModel model = (DefaultTableModel) tblDetail.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            String layanan = model.getValueAt(i, 0).toString();
int subtotal = Integer.parseInt(model.getValueAt(i, 2).toString());

struk.append(layanan)
     .append("   ")
     .append(subtotal)
     .append("\n");
        }

        struk.append("-----------------------------\n");
        struk.append("TOTAL     : ").append(txtTotal.getText()).append("\n");
        struk.append("BAYAR     : ").append(txtBayar.getText()).append("\n");
        struk.append("KEMBALIAN : ").append(txtBalance.getText()).append("\n");
        struk.append("-----------------------------\n");
        struk.append("Terima kasih 🙏\n");

        JTextArea areaStruk = new JTextArea(struk.toString());
        areaStruk.setEditable(false);
        areaStruk.setFont(new java.awt.Font("Monospaced", 0, 12));

        JOptionPane.showMessageDialog(this, new JScrollPane(areaStruk),
                "Struk Transaksi", JOptionPane.INFORMATION_MESSAGE);

        try {
            areaStruk.print();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal print");
        }
    }

    private void resetTransaksi() {
        currentIdTransaksiDb = null;

        btnAdd.setEnabled(true);
        btnRemove.setEnabled(true);
        btnBayar.setEnabled(false);

        txtBayar.setEditable(true);

        DefaultTableModel model = (DefaultTableModel) tblDetail.getModel();
        model.setRowCount(0);

        txtTotal.setText("0");
        txtBayar.setText("0");
        txtBalance.setText("0");

        cbLayanan.setSelectedIndex(0);
        cbTerapis.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ML = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cbLayanan = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbTerapis = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnBayar = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtmp = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txtBayar = new javax.swing.JTextField();
        txtBalance = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetail = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblLogout = new javax.swing.JLabel();
        lblMT = new javax.swing.JLabel();
        lblML = new javax.swing.JLabel();
        lblLaporan = new javax.swing.JLabel();
        lblTransaksi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ML.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ML.setForeground(new java.awt.Color(168, 116, 69));
        ML.setText("Transaksi");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(204, 204, 0)));

        cbLayanan.setForeground(new java.awt.Color(168, 116, 69));
        cbLayanan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));
        cbLayanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLayananActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(168, 116, 69));
        jLabel5.setText("LAYANAN");

        jLabel11.setForeground(new java.awt.Color(168, 116, 69));
        jLabel11.setText("TERAPIS");

        cbTerapis.setForeground(new java.awt.Color(168, 116, 69));
        cbTerapis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "" }));

        btnAdd.setBackground(new java.awt.Color(157, 186, 168));
        btnAdd.setForeground(new java.awt.Color(248, 243, 237));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnBayar.setBackground(new java.awt.Color(157, 186, 168));
        btnBayar.setForeground(new java.awt.Color(248, 243, 237));
        btnBayar.setText("Submit");
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });

        btnRemove.setBackground(new java.awt.Color(157, 186, 168));
        btnRemove.setForeground(new java.awt.Color(248, 243, 237));
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbTerapis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbLayanan, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(btnBayar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemove))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(17, 17, 17))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTerapis, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnBayar)
                    .addComponent(btnRemove))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(168, 116, 69));
        jLabel13.setText("Total");

        txtTotal.setEditable(false);
        txtTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(204, 204, 0)));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(168, 116, 69));
        jLabel14.setText("Metode Pembayaran");

        txtmp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tunai", "E-Wallet", "Debit", "Kredit" }));
        txtmp.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 0), null));
        txtmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmpActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(168, 116, 69));
        jLabel15.setText("Pembayaran");

        txtBayar.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 0), null));
        txtBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBayarActionPerformed(evt);
            }
        });

        txtBalance.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 0), null));
        txtBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBalanceActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(168, 116, 69));
        jLabel16.setText("Balance");

        tblDetail.setBackground(new java.awt.Color(242, 242, 242));
        tblDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Layanan", "Terapis", "Subtotal"
            }
        ));
        jScrollPane2.setViewportView(tblDetail);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(168, 116, 69));
        jLabel9.setText("SPADMIN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ML)
                    .addComponent(jLabel9))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ML)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(59, Short.MAX_VALUE))
        );

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

        lblLaporan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLaporan.setForeground(new java.awt.Color(248, 243, 237));
        lblLaporan.setText("Laporan");
        lblLaporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLaporanMouseClicked(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLaporan)
                    .addComponent(lblML)
                    .addComponent(lblMT)
                    .addComponent(lblLogout)
                    .addComponent(lblTransaksi))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(lblMT)
                .addGap(18, 18, 18)
                .addComponent(lblML)
                .addGap(18, 18, 18)
                .addComponent(lblTransaksi)
                .addGap(18, 18, 18)
                .addComponent(lblLaporan)
                .addGap(18, 18, 18)
                .addComponent(lblLogout)
                .addContainerGap(195, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBalanceActionPerformed

    private void txtBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBayarActionPerformed
    hitungTotal();

    int total = Integer.parseInt(txtTotal.getText());
    int bayar;

    try {
        bayar = Integer.parseInt(txtBayar.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Pembayaran harus angka!");
        return;
    }

    int kembalian = controller.hitungKembalian(total, bayar);

    if (kembalian < 0) {
        JOptionPane.showMessageDialog(this,
            "Uang pembayaran kurang!",
            "Peringatan",
            JOptionPane.WARNING_MESSAGE
        );
        txtBalance.setText("0");
        btnBayar.setEnabled(false);
    } else {
        txtBalance.setText(String.valueOf(kembalian));
        btnBayar.setEnabled(true);
    }
    }//GEN-LAST:event_txtBayarActionPerformed

    private void txtmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmpActionPerformed

    }//GEN-LAST:event_txtmpActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblDetail.getModel();

    if (model.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this,
            "Tidak ada data untuk dihapus!",
            "Peringatan",
            JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    int selectedRow = tblDetail.getSelectedRow();

    // CEK: apakah user memilih baris
    if (selectedRow < 0 || selectedRow >= model.getRowCount()) {
        JOptionPane.showMessageDialog(this,
            "Pilih baris yang ingin dihapus!",
            "Peringatan",
            JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(
        this,
        "Yakin ingin menghapus baris yang dipilih?",
        "Konfirmasi",
        JOptionPane.YES_NO_OPTION
    );

    if (confirm == JOptionPane.YES_OPTION) {
        model.removeRow(selectedRow);
        hitungTotal();
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblDetail.getModel();

    if (currentIdTransaksiDb == null || model.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this, "Belum ada transaksi!");
        return;
    }

    hitungTotal();
    int total = Integer.parseInt(txtTotal.getText());

    int bayar;
    try {
        bayar = Integer.parseInt(txtBayar.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Pembayaran harus angka!");
        return;
    }

    int kembalian = controller.hitungKembalian(total, bayar);
    if (kembalian < 0) {
        JOptionPane.showMessageDialog(this,
            "Uang pembayaran kurang!",
            "Peringatan",
            JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    txtBalance.setText(String.valueOf(kembalian));

    boolean sukses = controller.prosesPembayaran(
        currentIdTransaksiDb, bayar, total
    );

    if (!sukses) {
        JOptionPane.showMessageDialog(this, "Pembayaran gagal!");
        return;
    }

    controller.updateSubtotal(currentIdTransaksiDb, total);
    buatStruk();
    resetTransaksi();
    }//GEN-LAST:event_btnBayarActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
    int idxLayanan = cbLayanan.getSelectedIndex();
    int idxTerapis = cbTerapis.getSelectedIndex();

    if (idxLayanan == 0 || idxTerapis == 0) {
        JOptionPane.showMessageDialog(this, "Pilih layanan & terapis!");
        return;
    }

    int idLayanan = idLayananList.get(idxLayanan);
    int idTerapis = idTerapisList.get(idxTerapis);

    String namaLayanan = cbLayanan.getSelectedItem().toString();
    String namaTerapis = cbTerapis.getSelectedItem().toString();

    Integer hargaObj = controller.getHargaLayananById(idLayanan);
    int subtotal = (hargaObj != null) ? hargaObj : 0;

    if (currentIdTransaksiDb == null) {
        String metode = txtmp.getSelectedItem().toString();
        currentIdTransaksiDb = controller.createTransaksi(metode);

        if (currentIdTransaksiDb == -1) {
            JOptionPane.showMessageDialog(this, "Gagal membuat transaksi!");
            currentIdTransaksiDb = null;
            return;
        }
    }

    boolean sukses = controller.addDetail(
            currentIdTransaksiDb,
            idLayanan,
            idTerapis,
            subtotal
    );

    if (!sukses) {
        JOptionPane.showMessageDialog(this, "Gagal menyimpan detail transaksi!");
        return;
    }

    DefaultTableModel model = (DefaultTableModel) tblDetail.getModel();
    model.addRow(new Object[]{namaLayanan, namaTerapis, subtotal});

    hitungTotal();     
    }//GEN-LAST:event_btnAddActionPerformed

    private void cbLayananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLayananActionPerformed

    }//GEN-LAST:event_cbLayananActionPerformed

    private void lblMTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMTMouseClicked

        new TerapisView().setVisible(true);
     this.dispose(); 
    }//GEN-LAST:event_lblMTMouseClicked

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        new LoginView().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_lblLogoutMouseClicked

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
            java.util.logging.Logger.getLogger(TransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaksiView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ML;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBayar;
    private javax.swing.JButton btnRemove;
    private javax.swing.JComboBox<String> cbLayanan;
    private javax.swing.JComboBox<String> cbTerapis;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblLaporan;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblML;
    private javax.swing.JLabel lblMT;
    private javax.swing.JLabel lblTransaksi;
    private javax.swing.JTable tblDetail;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JComboBox<String> txtmp;
    // End of variables declaration//GEN-END:variables
}
