package org.itenas.oop.jdbc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Transaksi {

    private int idTransaksi;
    private Date tanggal;
    private String metodePembayaran;

    // COMPOSITION: Transaksi punya banyak DetailTransaksi
    private List<DetailTransaksi> detailList;

    public Transaksi() {
        detailList = new ArrayList<>();
        tanggal = new Date();
    }

    public void tambahDetail(DetailTransaksi detail) {
        detailList.add(detail);
    }

    // POLYMORPHISM via Interface HitungBiaya
    public int hitungTotal() {
        int total = 0;
        for (HitungBiaya item : detailList) {
            total += item.hitungSubtotal();
        }
        return total;
    }

    // ================= GETTER & SETTER =================

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public List<DetailTransaksi> getDetailList() {
        return detailList;
    }
}
