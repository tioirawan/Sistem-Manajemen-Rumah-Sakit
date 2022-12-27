/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kel2.ti2a.sistemrumahsakit.data.model;

import java.sql.ResultSet;
import kel2.ti2a.sistemrumahsakit.data.helper.DBHelper;

/**
 *
 * @author tioirawan
 */
public class UnitPelayanan {
    private String nama;
    private int biayaPelayanan;
    private int dokter_id;

    public int getBiayaPelayanan() {
        return biayaPelayanan;
    }

    public void setBiayaPelayanan(int biayaPelayanan) {
        this.biayaPelayanan = biayaPelayanan;
    }
    

    public UnitPelayanan(String nama, int dokter_id, int biayaPelayanan) {
        this.nama = nama;
        this.dokter_id = dokter_id;
        this.biayaPelayanan = biayaPelayanan;
    }
    
    public UnitPelayanan(){
        
    }
    
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
        
    public static UnitPelayanan getById(int id) {
        UnitPelayanan up = null;
        String sql = "SELECT * FROM unitpelayanan WHERE id = '"
                + id +"'";
        ResultSet rs = DBHelper.selectQuery(sql);
        try {
            if (rs.next()) {
                up = new UnitPelayanan(rs.getString("nama"), rs.getInt("dokter_id"), rs.getInt("biayaPelayanan"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return up;
    }
    
    public static int getIdUnitPelayananByName(String nama){
        int id = 0;
        String sql = "SELECT * FROM unitpelayanan WHERE nama = '"
                + nama +"'";
        ResultSet rs = DBHelper.selectQuery(sql);
        try {
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
}
