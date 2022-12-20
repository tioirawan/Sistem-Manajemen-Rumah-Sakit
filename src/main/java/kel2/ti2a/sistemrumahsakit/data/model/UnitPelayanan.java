/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kel2.ti2a.sistemrumahsakit.data.model;

/**
 *
 * @author tioirawan
 */
public abstract class UnitPelayanan {
    private String nama;
    private int dokter_id;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getDokter_id() {
        return dokter_id;
    }

    public void setDokter_id(int dokter_id) {
        this.dokter_id = dokter_id;
    }
    
    
}
