/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kel2.ti2a.sistemrumahsakit.data.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import kel2.ti2a.sistemrumahsakit.data.helper.DBHelper;

/**
 *
 * @author josaf
 */
public class Diagnosa {
    private int id;
    private String dokter_id;
    private String pasien_id;
    private String resep_id;
    private String penyakit;
    private String tglDatang;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDokter_id() {
        return dokter_id;
    }

    public void setDokter_id(String dokter_id) {
        this.dokter_id = dokter_id;
    }

    public String getPasien_id() {
        return pasien_id;
    }

    public void setPasien_id(String pasien_id) {
        this.pasien_id = pasien_id;
    }

    public String getResep_id() {
        return resep_id;
    }

    public void setResep_id(String resep_id) {
        this.resep_id = resep_id;
    }

    public String getPenyakit() {
        return penyakit;
    }

    public void setPenyakit(String penyakit) {
        this.penyakit = penyakit;
    }

    public String getTglDatang() {
        return tglDatang;
    }

    public void setTglDatang(String tglDatang) {
        this.tglDatang = tglDatang;
    }
    
    public ArrayList<Diagnosa> getDiagnosaByPasienID(String id){
        ArrayList<Diagnosa> ListDiagnosa = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM diagnosa WHERE pasien_id = '" + id + "'");
        
        try {
            while(rs.next()){
                Diagnosa d = new Diagnosa();
                d.setId(rs.getInt("id"));
                d.setDokter_id(rs.getString("dokter_id"));
                d.setPasien_id(rs.getString("pasien_id"));
                d.setPenyakit(rs.getString("penyakit"));
                d.setResep_id(rs.getString("resep_id"));
                d.setTglDatang(rs.getString("tglDatang"));
                
                ListDiagnosa.add(d);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return ListDiagnosa;
    }
    
    public void saveDiagnosaPasienById(String id, Diagnosa d){
        String SQL = "INSERT INTO diagnosa (dokter_id, pasien_id, resep_id, penyakit, tglDatang) VALUES("
                + d.getDokter_id() + ", "
                + d.getPasien_id() + ", "
                + d.getResep_id()+ ", "
                + d.getPenyakit()+ ", "
                + d.getTglDatang() + ")";
        
        this.id = DBHelper.insertQueryGetId(SQL);
        System.out.println(this.id);
    }
}
