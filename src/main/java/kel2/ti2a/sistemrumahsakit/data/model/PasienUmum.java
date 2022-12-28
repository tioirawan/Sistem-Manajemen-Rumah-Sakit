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
public class PasienUmum extends Pasien{
    
    private int pasien_id;

    public int getPasien_id() {
        return pasien_id;
    }

    public void setPasien_id(int pasien_id) {
        this.pasien_id = pasien_id;
    }
    private String noKtp;

    public String getNoKtp() {
        return noKtp;
    }

    public void setNoKtp(String noKtp) {
        this.noKtp = noKtp;
    }
    
    

    @Override
    protected void loadData() {
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM pasienumum WHERE pasien_id = " + this.id);

        try {
            if (rs.next()) {
                this.pasien_id = rs.getInt("id");
                this.noKtp = rs.getString("noKtp");
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
                    + " 'pasienumum'"
                    + " )";

            id = DBHelper.insertQueryGetId(SQL);

            String SQL2 = "INSERT INTO pasienumum (pasien_id, noKtp) VALUES ("
                    + " '" + this.id + "' ,"
                    + " '" + this.noKtp + "' "
                    + " )";

            DBHelper.executeQuery(SQL2);
        } else {
            String SQL = "UPDATE pasien SET "
                    + " jenisKelamin = '" + this.jenisKelamin + "', "
                    + " nama = '" + this.nama + "', " 
                    + " tanggalLahir = '" + this.tanggalLahir + "' "
                    + " WHERE id = '" + this.id + "' ";

            DBHelper.executeQuery(SQL);

             String SQL2 = "UPDATE pasienumum SET " 
                     + " noKtp = '" + this.noKtp + "' "
                     + " WHERE pasien_id = '" + this.id + "' ";

             DBHelper.executeQuery(SQL2);
        }
    }

    @Override
    public void delete() {
        DBHelper.executeQuery("DELETE FROM pasienumum WHERE pasien_id = '" + this.id + "'");
        DBHelper.executeQuery("DELETE FROM pasien WHERE id = '" + this.id + "'");
    }
    
}
