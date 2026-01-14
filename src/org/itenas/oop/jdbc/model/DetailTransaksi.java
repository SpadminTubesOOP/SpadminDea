package org.itenas.oop.jdbc.model;

public class DetailTransaksi implements HitungBiaya {

    private int idDetail;
    private int idTransaksi;
    private int idLayanan;
    private int idTerapis;
    private int qty;
    private int harga; 

    @Override
    public int hitungSubtotal() {
        return qty * harga;
    }

    public int getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(int idDetail) {
        this.idDetail = idDetail;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getIdLayanan() {
        return idLayanan;
    }

    public void setIdLayanan(int idLayanan) {
        this.idLayanan = idLayanan;
    }

    public int getIdTerapis() {
        return idTerapis;
    }

    public void setIdTerapis(int idTerapis) {
        this.idTerapis = idTerapis;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}