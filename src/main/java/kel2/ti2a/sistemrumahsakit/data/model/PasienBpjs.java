/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kel2.ti2a.sistemrumahsakit.data.model;

import java.sql.ResultSet;
import kel2.ti2a.sistemrumahsakit.data.helper.DBHelper;

/**
 *
 * @author User
 */
public class PasienBpjs extends Pasien{
    
    private int pasien_id;
    private String noBpjs;

    public int getPasien_id() {
        return pasien_id;
    }

    public void setPasien_id(int pasien_id) {
        this.pasien_id = pasien_id;
    }

    public String getNoBpjs() {
        return noBpjs;
    }

    public void setNoBpjs(String noBPJS) {
        this.noBpjs = noBPJS;
    }
    
    

    @Override
    protected void loadData() {
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM pasienbpjs WHERE pasien_id = " + this.id);

        try {
            if (rs.next()) {
                this.pasien_id = rs.getInt("id");
                this.noBpjs = rs.getString("noBpjs");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save() {
        if (Pasien.getById(id) == null) {
            String SQL = "INSERT INTO pasien (noPasien, jenisKelamin, nama, tanggalLahir, type) VALUES ("
                    + " '" + this.noPasien + "', "
                    + " '" + this.jenisKelamin + "', "
                    + " '" + this.nama + "', "
                    + " '" + this.tanggalLahir + "', "
                    + " 'pasienbpjs'"
                    + " )";

            id = DBHelper.insertQueryGetId(SQL);

            String SQL2 = "INSERT INTO pasienbpjs (pasien_id, noBpjs) VALUES ("
                    + " '" + this.id + "' "
                    + " '" + this.noBpjs + "' "
                    + " )";

            DBHelper.executeQuery(SQL2);
        } else {
            String SQL = "UPDATE pasien SET "
                    + " noPasien = '" + this.noPasien + "', "
                    + " jenisKelamin = '" + this.jenisKelamin + "', "
                    + " nama = '" + this.nama + "', " 
                    + " tanggalLahir = '" + this.tanggalLahir + "' "
                    + " WHERE id = '" + this.id + "' ";

            DBHelper.executeQuery(SQL);

             String SQL2 = "UPDATE pasienbpjs SET " 
                     + " noBpjs = '" + this.noBpjs + "' "
                     + " WHERE pasien_id = '" + this.id + "' ";

             DBHelper.executeQuery(SQL2);
        }
    }

    @Override
    public void delete() {
        DBHelper.executeQuery("DELETE FROM pasienbpjs WHERE pasien_id = '" + this.id + "'");
        DBHelper.executeQuery("DELETE FROM pasien WHERE id = '" + this.id + "'");
    }
    
}
