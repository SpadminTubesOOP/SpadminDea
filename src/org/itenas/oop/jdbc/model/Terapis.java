package org.itenas.oop.jdbc.model;

public class Terapis {

    private int idTerapis;
    private String namaTerapis;
    private String noTelp;
    private String jenisKelamin;

    public Terapis() {
    }

    public int getIdTerapis() {
        return idTerapis;
    }

    public void setIdTerapis(int idTerapis) {
        this.idTerapis = idTerapis;
    }

    public String getNamaTerapis() {
        return namaTerapis;
    }

    public void setNamaTerapis(String namaTerapis) {
        this.namaTerapis = namaTerapis;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
}
