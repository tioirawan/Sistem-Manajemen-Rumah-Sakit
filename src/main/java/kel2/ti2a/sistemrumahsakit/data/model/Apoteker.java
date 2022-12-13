package kel2.ti2a.sistemrumahsakit.data.model;

import java.sql.ResultSet;
import kel2.ti2a.sistemrumahsakit.data.helper.DBHelper;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tioirawan
 */
public class Apoteker extends Karyawan {

    private int apoteker_id;

    public int getApoteker_id() {
        return apoteker_id;
    }

    protected void setApoteker_id(int apoteker_id) {
        this.apoteker_id = apoteker_id;
    }

    @Override
    protected void loadData() {
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM apoteker WHERE karyawan_id = " + this.id);

        try {
            if (rs.next()) {
                this.apoteker_id = rs.getInt("id");
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
                    + " 'apoteker' "
                    + " )";

            id = DBHelper.insertQueryGetId(SQL);

            String SQL2 = "INSERT INTO apoteker (karyawan_id) VALUES ("
                    + " '" + this.id + "' "
                    + " )";

            DBHelper.executeQuery(SQL2);
        } else {
            String SQL = "UPDATE karyawan SET "
                    + " nama = '" + this.nama + "', "
                    + " nip = '" + this.nip + "', "
                    + " WHERE id = '" + this.id + "' ";

            DBHelper.executeQuery(SQL);

            // String SQL2 = "UPDATE apoteker SET "
            //         + " WHERE karyawan_id = '" + this.id + "' ";

            // DBHelper.executeQuery(SQL2);
        }
    }

    @Override
    public void delete() {
        DBHelper.executeQuery("DELETE FROM apoteker WHERE karyawan_id = '" + this.id + "'");
        DBHelper.executeQuery("DELETE FROM karyawan WHERE id = '" + this.id + "'");
    }

    public static void main(String[] args) {
//        Apoteker apoteker = new Apoteker();
//        
//        apoteker.setNama("Novita");
//        apoteker.setNip("2141720111");
//        apoteker.setPassword("apoteker123");
//        
//        apoteker.save();

        Apoteker apoteker = (Apoteker) Karyawan.getByNipAndPassword("2141720111", "apoteker123");
        
        System.out.println(apoteker.nama);
        System.out.println(apoteker.getApoteker_id());
    }
}
