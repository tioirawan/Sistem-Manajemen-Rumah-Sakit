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
public abstract class Karyawan {
    protected int id;
    protected String nama;
    protected String nip;
    protected String type;
    protected String password;

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getType() {
        return type;
    }

    protected void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // untuk loat data tambahan (dokter, perawat, dll...)
    protected abstract void loadData();

    public abstract void save();

    public abstract void delete();
    
    private static Karyawan processResult(ResultSet rs) throws Exception {
        Karyawan karyawan;

        String type = rs.getString("type");

        if (type.equalsIgnoreCase("dokter")) {
            karyawan = new Dokter();
        } else if (type.equalsIgnoreCase("perawat")) {
            karyawan = new Perawat();
        } else if (type.equalsIgnoreCase("apoteker")) {
            karyawan = new Apoteker();
        } else if (type.equalsIgnoreCase("admin")) {
            karyawan = new Admin();
        } else {
            return null;
        }

        karyawan.setId(rs.getInt("id"));
        karyawan.setNama(rs.getString("nama"));
        karyawan.setNip(rs.getString("nip"));
        karyawan.setType(rs.getString("type"));
        karyawan.setPassword(rs.getString("password"));

        // load data detail dari tabel entah (Dokter, Perawat, dll)
        karyawan.loadData();

        return karyawan;
    }

    /**
     * Get karyawan berdasarkan ID, pastikan ID adalah ID karyawan, bukan ID jenisnya
     * 
     * @param id
     * @return Karyawan
     */
    public static Karyawan getById(int id) {
        Karyawan karyawan = null;
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM karyawan WHERE id = " + id);

        try {
            if (rs.next()) {
                karyawan = processResult(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return karyawan;
    }

    public static Karyawan getByNipAndPassword(String nip, String password) {
        Karyawan karyawan = null;
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM karyawan WHERE nip = '" + nip + "' AND password = '" + password + "'");

        try {
            if (rs.next()) {
                karyawan = processResult(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return karyawan;
    }

   public static ArrayList<Karyawan> getAll(){
        ArrayList<Karyawan> listKaryawan = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT * FROM karyawan");

        try {
            while (rs.next()) {
                Karyawan karyawan = processResult(rs);
                listKaryawan.add(karyawan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listKaryawan;
   }
}
