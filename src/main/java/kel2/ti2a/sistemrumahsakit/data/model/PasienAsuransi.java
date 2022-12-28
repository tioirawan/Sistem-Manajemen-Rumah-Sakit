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
public class PasienAsuransi extends Pasien{
        private int pasien_id;
        private String noAsuransi;
        private String namaAsuransi;

    public int getPasien_id() {
        return pasien_id;
    }

    public void setPasien_id(int pasien_id) {
        this.pasien_id = pasien_id;
    }

    public String getNoAsuransi() {
        return noAsuransi;
    }

    public void setNoAsuransi(String noAsuransi) {
        this.noAsuransi = noAsuransi;
    }

    public String getNamaAsuransi() {
        return namaAsuransi;
    }

    public void setNamaAsuransi(String namaAsuransi) {
        this.namaAsuransi = namaAsuransi;
    }

    @Override
    protected void loadData() {
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM pasienasuransi WHERE pasien_id = " + this.id);

        try {
            if (rs.next()) {
                this.pasien_id = rs.getInt("id");
                this.noAsuransi = rs.getString("noAsuransi");
                this.namaAsuransi = rs.getString("namaAsuransi");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save() {
        if (Pasien.getById(id) == null) {
            String SQL = "INSERT INTO pasien (jenisKelamin, nama, tanggalLahir, type) VALUES ("
                    + " '" + this.jenisKelamin + "', "
                    + " '" + this.nama + "', "
                    + " '" + this.tanggalLahir + "', "
                    + " 'pasienasuransi'"
                    + " )";

            id = DBHelper.insertQueryGetId(SQL);

            String SQL2 = "INSERT INTO pasienasuransi (pasien_id, noAsuransi, namaAsuransi) VALUES ("
                    + " '" + this.id + "', "
                    + " '" + this.noAsuransi + "', "
                    + " '" + this.namaAsuransi + "' "
                    + " )";

            DBHelper.executeQuery(SQL2);
        } else {
            String SQL = "UPDATE pasien SET "
                    + " jenisKelamin = '" + this.jenisKelamin + "', "
                    + " nama = '" + this.nama + "', " 
                    + " tanggalLahir = '" + this.tanggalLahir + "' "
                    + " WHERE id = '" + this.id + "' ";

            DBHelper.executeQuery(SQL);

             String SQL2 = "UPDATE pasienasuransi SET " 
                     + " noAsuransi = '" + this.noAsuransi + "', "
                     + " namaAsuransi = '" + this.namaAsuransi + "' "
                     + " WHERE pasien_id = '" + this.id + "' ";

             DBHelper.executeQuery(SQL2);
        }
    }

    @Override
    public void delete() {
        DBHelper.executeQuery("DELETE FROM pasienasuransi WHERE pasien_id = '" + this.id + "'");
        DBHelper.executeQuery("DELETE FROM pasien WHERE id = '" + this.id + "'");
    }
    
}
