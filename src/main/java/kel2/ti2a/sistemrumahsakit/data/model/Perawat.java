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
public class Perawat extends Karyawan {

    private int perawat_id;
    private int unit_pelayanan_id;

    public int getPerawat_id() {
        return perawat_id;
    }

    public void setPerawat_id(int perawat_id) {
        this.perawat_id = perawat_id;
    }

    public int getUnit_pelayanan_id() {
        return unit_pelayanan_id;
    }

    public void setUnit_pelayanan_id(int unit_pelayanan_id) {
        this.unit_pelayanan_id = unit_pelayanan_id;
    }

    @Override
    protected void loadData() {
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM perawat WHERE karyawan_id = " + this.id);

        try {
            if (rs.next()) {
                this.perawat_id = rs.getInt("id");
                this.unit_pelayanan_id = rs.getInt("unitpelayanan_id");
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
                    + " 'perawat' "
                    + " )";

            id = DBHelper.insertQueryGetId(SQL);

            String SQL2 = "INSERT INTO perawat (karyawan_id, unitpelayanan_id) VALUES ("
                    + " '" + this.id + "', "
                    + " '" + this.unit_pelayanan_id + "' "
                    + " )";

            DBHelper.executeQuery(SQL2);
        } else {
            String SQL = "UPDATE karyawan SET "
                    + " nama = '" + this.nama + "', "
                    + " nip = '" + this.nip + "', "
                    + " WHERE id = '" + this.id + "' ";

            DBHelper.executeQuery(SQL);

            String SQL2 = "UPDATE admin SET "
                    + " unitpelayanan_id = '" + this.unit_pelayanan_id + "' "
                    + " WHERE karyawan_id = '" + this.id + "' ";

            DBHelper.executeQuery(SQL2);
        }
    }

    @Override
    public void delete() {
        DBHelper.executeQuery("DELETE FROM perawat WHERE karyawan_id = " + this.id);
        DBHelper.executeQuery("DELETE FROM karyawan WHERE id = " + this.id);
    }

    public static void main(String[] args) {
//        Perawat p = new Perawat();
//
//        p.setNama("Adinda");
//        p.setNip("2141722220");
//        p.setPassword("perawat123");
//        p.setUnit_pelayanan_id(1);
//
//        p.save();

        Perawat p = (Perawat) Karyawan.getByNipAndPassword("2141720031", "perawat123");

        System.out.println(p.nama);
        System.out.println(p.unit_pelayanan_id);
    }
}
