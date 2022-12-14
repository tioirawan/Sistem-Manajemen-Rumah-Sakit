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
public class Admin extends Karyawan {

    private int admin_id;
    private String bagian;

    public int getAdmin_id() {
        return admin_id;
    }

    protected void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getBagian() {
        return bagian;
    }

    public void setBagian(String bagian) {
        this.bagian = bagian;
    }

    @Override
    protected void loadData() {
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM admin WHERE karyawan_id = " + this.id);

        try {
            if (rs.next()) {
                setAdmin_id(rs.getInt("id"));
                setBagian(rs.getString("bagian"));
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
                    + " 'admin' "
                    + " )";

            id = DBHelper.insertQueryGetId(SQL);

            String SQL2 = "INSERT INTO admin (karyawan_id, bagian) VALUES ("
                    + " '" + this.id + "', "
                    + " '" + this.bagian + "' "
                    + " )";

            DBHelper.executeQuery(SQL2);
        } else {
            String SQL = "UPDATE karyawan SET "
                    + " nama = '" + this.nama + "', "
                    + " nip = '" + this.nip + "', "
                    + " WHERE id = '" + this.id + "' ";

            DBHelper.executeQuery(SQL);

            String SQL2 = "UPDATE admin SET "
                    + " bagian = '" + this.bagian + "' "
                    + " WHERE karyawan_id = '" + this.id + "' ";

            DBHelper.executeQuery(SQL2);
        }
    }

    @Override
    public void delete() {
        DBHelper.executeQuery("DELETE FROM admin WHERE id = '" + this.admin_id + "'");
        DBHelper.executeQuery("DELETE FROM karyawan WHERE id = '" + this.id + "'");
    }

    public static void main(String[] args) {
//        Admin admin = new Admin();
//        
//        admin.setNama("Pak Suryono");
//        admin.setBagian("administrasi");
//        admin.setNip("2141720003");
//        admin.setPassword("admin123");
//        
//        admin.save();

        Admin admin = (Admin) Karyawan.getByNipAndPassword("2141720093", "admin123");
        
        System.out.println(admin.getNama());
        System.out.println(admin.getAdmin_id());
    }

}
