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
public abstract class Pasien {
    protected int id;
    protected String noPasien;
    protected String jenisKelamin;
    protected String nama;
    protected String tanggalLahir;
    protected String type;

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public String getNoPasien() {
        return noPasien;
    }

    public void setNoPasien(String nama) {
        this.noPasien = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String nip) {
        this.jenisKelamin = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String type) {
        this.nama = type;
    }

    public String getTanggaLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String password) {
        this.tanggalLahir = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // untuk loat data tambahan (dokter, perawat, dll...)
    protected abstract void loadData();

    public abstract void save();

    public abstract void delete();
    
    private static Pasien processResult(ResultSet rs) throws Exception {
        Pasien pasien;

        String type = rs.getString("type");

        if (type.equalsIgnoreCase("pasienBpjs")) {
            pasien = new PasienBpjs();
        } else if (type.equalsIgnoreCase("pasienAsuransi")) {
            pasien = new PasienAsuransi();
        } else if (type.equalsIgnoreCase("pasienumum")) {
            pasien = new PasienUmum();
        } else {
            return null;
        }

        pasien.setId(rs.getInt("id"));
        pasien.setJenisKelamin(rs.getString("jenisKelamin"));
        pasien.setNama(rs.getString("Nama"));
        pasien.setTanggalLahir(rs.getString("tanggalLahir"));
        pasien.setType(rs.getString("type"));
        pasien.setNoPasien(rs.getString("noPasien"));

        // load data detail dari tabel entah (Dokter, Perawat, dll)
        pasien.loadData();

        return pasien;
    }

    /**
     * Get karyawan berdasarkan ID, pastikan ID adalah ID karyawan, bukan ID jenisnya
     * 
     * @param id
     * @return Karyawan
     */
    public static Pasien getById(int id) {
        Pasien pasien = null;
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM pasien WHERE id = " + id);

        try {
            if (rs.next()) {
                pasien = processResult(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pasien;
    }

   public static ArrayList<Pasien> getAll(){
        ArrayList<Pasien> listPasien = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT * FROM pasien");

        try {
            while (rs.next()) {
                Pasien pasien = processResult(rs);
                listPasien.add(pasien);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listPasien;
   }
}
