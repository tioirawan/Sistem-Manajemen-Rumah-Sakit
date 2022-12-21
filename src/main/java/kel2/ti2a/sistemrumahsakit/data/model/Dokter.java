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
 * @author tioirawan
 */
public class Dokter extends Karyawan {
    private int unitPelayananId;
    private int dokter_id;
    private int karyawan_id;
    private String status; // koas, dokter, spesialis
    private int tarif;

    public int getUnitPelayananId() {
        return unitPelayananId;
    }
    
    public int getDokterId() {
        return dokter_id;
    }

    protected void setDokter_id(int dokter_id) {
        this.dokter_id = dokter_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public int getKaryawan_id() {
        return karyawan_id;
    }

    public void setKaryawan_id(int karyawan_id) {
        this.karyawan_id = karyawan_id;
    }   
    
    public static int getUnitPelayananIdByDokterId(int dokter_id){
        int unitPelayananId = 0;
        ResultSet rs = DBHelper.selectQuery("SELECT up.id FROM dokter d LEFT JOIN unitpelayanan up ON d.id = up.dokter_id WHERE d.id =" + dokter_id + "");
        try{
            while (rs.next()) {
                unitPelayananId = rs.getInt("id");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return unitPelayananId;
    }

    @Override
    protected void loadData() {
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM dokter WHERE karyawan_id = " + this.id);

        try {
            if (rs.next()) {
                this.dokter_id = rs.getInt("id");
                this.karyawan_id = rs.getInt("karyawan_id");
                this.status = rs.getString("status");
                this.tarif = rs.getInt("tarif");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    @Override
    public void save() {
        if (Karyawan.getById(id) == null) {
            String SQL = "INSERT INTO karyawan (nama, nip, password, type) VALUES ("
                    + " '" + this.nama + "', "
                    + " '" + this.nip + "', "
                    + " '" + this.password + "', "
                    + " 'dokter' "
                    + " )";

            id = DBHelper.insertQueryGetId(SQL);

            String SQL2 = "INSERT INTO dokter (karyawan_id, status, tarif) VALUES ("
                    + " '" + id + "', "
                    + " '" + this.status + "', "
                    + " '" + this.tarif + "' "
                    + " )";

            DBHelper.executeQuery(SQL2);
        } else {
            String SQL = "UPDATE karyawan SET "
                    + " nama = '" + this.nama + "', "
                    + " nip = '" + this.nip + "', "
                    + " WHERE id = '" + this.id + "' ";

            DBHelper.executeQuery(SQL);

            String SQL2 = "UPDATE dokter SET "
                    + " status = '" + this.status + "', "
                    + " tarif = '" + this.tarif + "' "
                    + " WHERE id = '" + this.dokter_id + "' ";

            DBHelper.executeQuery(SQL2);
        }
    }

    @Override
    public void delete() {
        // TODO: when possible: use cascade on delete karyawan
        DBHelper.executeQuery("DELETE FROM dokter WHERE id = '" + this.dokter_id + "'");
        DBHelper.executeQuery("DELETE FROM karyawan WHERE id = '" + this.id + "'");
    }

    // for testing
    public static void main(String[] args) {
        Karyawan k = Karyawan.getByNipAndPassword("2141720003", "dokter123");
//
//        if (k == null) {
//            Dokter dokter = new Dokter();
//
//            dokter.setNama("Dr. Tio");
//            dokter.setNip("2141720003");
//            dokter.setPassword("dokter123");
//            dokter.setStatus("spesialis");
//            dokter.setTarif(100000);
//
//            dokter.save();
//            k = dokter;
//        }

        System.out.println(k.nama);
        System.out.println(((Dokter) k).getTarif());


//        Dokter dokter = new Dokter();
//
//        dokter.setNama("Dr. Fino");
//        dokter.setNip("2141720020");
//        dokter.setPassword("dokter123");
//        dokter.setStatus("coass");
//        dokter.setTarif(50000);
//
//        dokter.save();

//        ArrayList<Karyawan> list = Karyawan.getAll();
//
//        for (Karyawan k : list) {
//            System.out.println(k.nama);
//        }
    }

}
