/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kel2.ti2a.sistemrumahsakit.data.model;

/**
 *
 * @author tioirawan
 */
public class Antrian {
    protected int id;
    protected int nomorAntrean;
    protected int pasien_id;
    protected int unitpelayanan_id;
    protected String timestamp;
    protected String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNomorAntrean() {
        return nomorAntrean;
    }

    public void setNomorAntrean(int nomorAntrean) {
        this.nomorAntrean = nomorAntrean;
    }

    public int getPasien_id() {
        return pasien_id;
    }

    public void setPasien_id(int pasien_id) {
        this.pasien_id = pasien_id;
    }

    public int getUnitpelayanan_id() {
        return unitpelayanan_id;
    }

    public void setUnitpelayanan_id(int unitpelayanan_id) {
        this.unitpelayanan_id = unitpelayanan_id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
