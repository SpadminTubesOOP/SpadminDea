package org.itenas.oop.jdbc.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.itenas.oop.jdbc.repository.LaporanController;

/**
 *
 * @author HP
 */
public class LaporanView extends javax.swing.JFrame {

    private TableRowSorter sorter;

    public LaporanView() {
        initComponents();
        initTable();
        initTanggalSpinner();
        setColumnWidth();
    }

    private void initTanggalSpinner() {
        Calendar cal = Calendar.getInstance();
        Date akhir = cal.getTime();
        cal.add(Calendar.DAY_OF_MONTH, -7);
        Date awal = cal.getTime();

        spTanggalAwal.setModel(new SpinnerDateModel(awal, null, null, Calendar.DAY_OF_MONTH));
        spTanggalAkhir.setModel(new SpinnerDateModel(akhir, null, null, Calendar.DAY_OF_MONTH));

        spTanggalAwal.setEditor(new JSpinner.DateEditor(spTanggalAwal, "dd-MM-yyyy"));
        spTanggalAkhir.setEditor(new JSpinner.DateEditor(spTanggalAkhir, "dd-MM-yyyy"));
    }

    private void initTable() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Tanggal", "Terapis", "Layanan", "Subtotal", "Metode"}
        ) {
            public boolean isCellEditable(int r, int c) {
                return false;
            }
        };

        tblLaporan.setModel(model);
        sorter = new TableRowSorter<>(model);
        tblLaporan.setRowSorter(sorter);
    }

    private void setColumnWidth() {
        tblLaporan.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblLaporan.getColumnModel().getColumn(1).setPreferredWidth(130);
        tblLaporan.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblLaporan.getColumnModel().getColumn(3).setPreferredWidth(140);
        tblLaporan.getColumnModel().getColumn(4).setPreferredWidth(100);
        tblLaporan.getColumnModel().getColumn(5).setPreferredWidth(90);
    }

    private void cetakPDF() {
        try {
            if (tblLaporan.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this,
                        "Tidak ada data untuk dicetak!",
                        "Peringatan",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            Document document = new Document(PageSize.A4.rotate());

            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Simpan Laporan PDF");

            String timeStamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            chooser.setSelectedFile(
                    new File("Laporan_Transaksi_" + timeStamp + ".pdf")
            );

            chooser.setFileFilter(
                    new javax.swing.filechooser.FileNameExtensionFilter(
                            "PDF Files", "pdf"
                    )
            );

            int userChoice = chooser.showSaveDialog(this);
            if (userChoice != JFileChooser.APPROVE_OPTION) {
                return;
            }

            File file = chooser.getSelectedFile();
            if (!file.getName().toLowerCase().endsWith(".pdf")) {
                file = new File(file.getAbsolutePath() + ".pdf");
            }

            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();

            // ===== JUDUL =====
            Font titleFont = new Font(Font.HELVETICA, 16, Font.BOLD);
            Paragraph title = new Paragraph("LAPORAN TRANSAKSI\n\n", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // ===== TABEL =====
            PdfPTable pdfTable = new PdfPTable(tblLaporan.getColumnCount());
            pdfTable.setWidthPercentage(100);

            for (int i = 0; i < tblLaporan.getColumnCount(); i++) {
                pdfTable.addCell(new PdfPCell(
                        new Phrase(tblLaporan.getColumnName(i))
                ));
            }

            for (int row = 0; row < tblLaporan.getRowCount(); row++) {
                for (int col = 0; col < tblLaporan.getColumnCount(); col++) {
                    Object value = tblLaporan.getValueAt(row, col);
                    pdfTable.addCell(value == null ? "" : value.toString());
                }
            }

            document.add(pdfTable);
            document.add(new Paragraph("\n"));

            Paragraph ringkasan = new Paragraph(
                    "Total Penjualan : Rp " + jAkumulasi.getText(),
                    new Font(Font.HELVETICA, 12, Font.BOLD)
            );
            ringkasan.setAlignment(Element.ALIGN_RIGHT);

            document.add(ringkasan);
            document.close();

            JOptionPane.showMessageDialog(this,
                    "PDF berhasil disimpan!\n\n" + file.getAbsolutePath(),
                    "Sukses",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Gagal membuat PDF:\n" + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblLogout = new javax.swing.JLabel();
        lblMT = new javax.swing.JLabel();
        lblML = new javax.swing.JLabel();
        lblTransaksi = new javax.swing.JLabel();
        lblLaporan = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        LT = new javax.swing.JLabel();
        lblTanggal = new javax.swing.JLabel();
        spTanggalAkhir = new javax.swing.JSpinner();
        spTanggalAwal = new javax.swing.JSpinner();
        lblNama = new javax.swing.JLabel();
        btnTampilkan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLaporan = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lblTotalTransaksi = new javax.swing.JLabel();
        jHasilTransaksi = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblAkumulasi = new javax.swing.JLabel();
        jCetakLaporan = new javax.swing.JButton();
        jAkumulasi = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(157, 186, 168));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLaporan)
                    .addComponent(lblTransaksi)
                    .addComponent(lblML)
                    .addComponent(lblMT)
                    .addComponent(lblLogout))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(172, 172, 172)
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

        LT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LT.setForeground(new java.awt.Color(168, 116, 69));
        LT.setText("Laporan Transaksi");

        lblTanggal.setForeground(new java.awt.Color(168, 116, 69));
        lblTanggal.setText("Tanggal Awal :");

        spTanggalAkhir.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(204, 204, 0)));

        spTanggalAwal.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(204, 204, 0)));

        lblNama.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNama.setForeground(new java.awt.Color(168, 116, 69));
        lblNama.setText("-");

        btnTampilkan.setBackground(new java.awt.Color(157, 186, 168));
        btnTampilkan.setForeground(new java.awt.Color(248, 243, 237));
        btnTampilkan.setText("Tampilkan");
        btnTampilkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTampilkanActionPerformed(evt);
            }
        });

        tblLaporan.setBackground(new java.awt.Color(242, 242, 242));
        tblLaporan.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(153, 153, 0)));
        tblLaporan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID ", "Tanggal ", "Terapis ", "Layanan ", "Subtotal ", "Metode "
            }
        ));
        jScrollPane1.setViewportView(tblLaporan);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblTotalTransaksi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTotalTransaksi.setForeground(new java.awt.Color(168, 116, 69));
        lblTotalTransaksi.setText("Total Transaksi");

        jHasilTransaksi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jHasilTransaksi.setForeground(new java.awt.Color(179, 179, 75));
        jHasilTransaksi.setText("0");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(168, 116, 69));
        jLabel3.setText("%");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotalTransaksi)
                    .addComponent(jHasilTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTotalTransaksi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jHasilTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblAkumulasi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAkumulasi.setForeground(new java.awt.Color(168, 116, 69));
        lblAkumulasi.setText("Akumulasi Penjualan ");

        jCetakLaporan.setBackground(new java.awt.Color(157, 186, 168));
        jCetakLaporan.setForeground(new java.awt.Color(248, 243, 237));
        jCetakLaporan.setText("Cetak Laporan");
        jCetakLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCetakLaporanActionPerformed(evt);
            }
        });

        jAkumulasi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jAkumulasi.setForeground(new java.awt.Color(179, 179, 75));
        jAkumulasi.setText("Rp 0");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(168, 116, 69));
        jLabel2.setText(" $");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jAkumulasi, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCetakLaporan)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblAkumulasi)
                        .addContainerGap(252, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCetakLaporan)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblAkumulasi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jAkumulasi, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(LT))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTanggal)
                                .addGap(18, 18, 18)
                                .addComponent(spTanggalAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNama)
                                .addGap(8, 8, 8)
                                .addComponent(spTanggalAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTampilkan, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 872, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(12, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(LT)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTanggal)
                    .addComponent(spTanggalAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spTanggalAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNama)
                    .addComponent(btnTampilkan))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTampilkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTampilkanActionPerformed
        Date tglAwal = (Date) spTanggalAwal.getValue();
        Date tglAkhir = (Date) spTanggalAkhir.getValue();

        if (tglAwal.after(tglAkhir)) {
            JOptionPane.showMessageDialog(this,
                    "Tanggal awal tidak boleh lebih besar dari tanggal akhir!",
                    "Peringatan",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        LaporanController controller = new LaporanController();
        List<Object[]> data = controller.getLaporan(tglAwal, tglAkhir);

        DefaultTableModel model = (DefaultTableModel) tblLaporan.getModel();
        model.setRowCount(0);
        for (Object[] row : data) {
            model.addRow(row);
        }

        jHasilTransaksi.setText(
                String.valueOf(controller.getTotalTransaksi(tglAwal, tglAkhir))
        );

        jAkumulasi.setText(
                "Rp " + controller.getAkumulasiPenjualan(tglAwal, tglAkhir)
        );
    }//GEN-LAST:event_btnTampilkanActionPerformed

    private void jCetakLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCetakLaporanActionPerformed
        cetakPDF();
    }//GEN-LAST:event_jCetakLaporanActionPerformed

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        new LoginView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void lblMTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMTMouseClicked
        // TODO add your handling code here:
        new TerapisView().setVisible(true);
        dispose(); 
    }//GEN-LAST:event_lblMTMouseClicked

    private void lblMLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMLMouseClicked
        // TODO add your handling code here:
        new LayananView().setVisible(true);
        dispose(); 
    }//GEN-LAST:event_lblMLMouseClicked

    private void lblTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTransaksiMouseClicked
        // TODO add your handling code here:
        new TransaksiView().setVisible(true);
        dispose(); 
    }//GEN-LAST:event_lblTransaksiMouseClicked

    private void lblLaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLaporanMouseClicked
        // TODO add your handling code here:
        new LaporanView().setVisible(true);
        dispose(); 
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
            java.util.logging.Logger.getLogger(LaporanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaporanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaporanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaporanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LaporanView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LT;
    private javax.swing.JButton btnTampilkan;
    private javax.swing.JLabel jAkumulasi;
    private javax.swing.JButton jCetakLaporan;
    private javax.swing.JLabel jHasilTransaksi;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAkumulasi;
    private javax.swing.JLabel lblLaporan;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblML;
    private javax.swing.JLabel lblMT;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JLabel lblTotalTransaksi;
    private javax.swing.JLabel lblTransaksi;
    private javax.swing.JSpinner spTanggalAkhir;
    private javax.swing.JSpinner spTanggalAwal;
    private javax.swing.JTable tblLaporan;
    // End of variables declaration//GEN-END:variables
}
