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
    private int dokter_id;
    private int antrean_id;
    private String penyakit;
    private String tglDatang;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDokter_id() {
        return dokter_id;
    }

    public void setDokter_id(int dokter_id) {
        this.dokter_id = dokter_id;
    }

    public int getAntrean_id() {
        return antrean_id;
    }

    public void setAntrean_id(int antrean_id) {
        this.antrean_id = antrean_id;
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

    public static ArrayList<Diagnosa> getDiagnosaByPasienID(int id) {
        ArrayList<Diagnosa> ListDiagnosa = new ArrayList();
        ResultSet rs = DBHelper.selectQuery(
                "SELECT * FROM diagnosa JOIN antrean ON diagnosa.antrean_id = antrean.id WHERE antrean.pasien_id = " + id + " ORDER BY diagnosa.id DESC"
        );

        try {
            while (rs.next()) {
                Diagnosa d = new Diagnosa();
                d.setId(rs.getInt("id"));
                d.setDokter_id(rs.getInt("dokter_id"));
                d.setAntrean_id(rs.getInt("antrean_id"));
                d.setPenyakit(rs.getString("penyakit"));
                d.setTglDatang(rs.getString("tglDatang"));

                ListDiagnosa.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListDiagnosa;
    }

    public static Diagnosa getById(int id) {
        Diagnosa d = null;
        ResultSet rs = DBHelper.selectQuery(
                "SELECT * FROM diagnosa WHERE id = " + id
        );

        try {
            if (rs.next()) {
                d = new Diagnosa();
                d.setId(rs.getInt("id"));
                d.setDokter_id(rs.getInt("dokter_id"));
                d.setAntrean_id(rs.getInt("antrean_id"));
                d.setPenyakit(rs.getString("penyakit"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return d;
    }

    public void save() {
        if(getById(id) == null) {
            add();
        } else {
            update();
        }
    }

    protected void add() {
         String SQL = "INSERT INTO diagnosa (dokter_id, antrean_id, penyakit) VALUES("
                + "'" + this.dokter_id + "', "
                + "'" + this.antrean_id + "', "
                + "'" + this.penyakit + "'"
                + ")";
                
        this.id = DBHelper.insertQueryGetId(SQL);
    }

    protected void update() {
        String SQL = "UPDATE diagnosa SET "
                + "dokter_id = '" + this.dokter_id + "', "
                + "antrean_id = '" + this.antrean_id + "', "
                + "penyakit = '" + this.penyakit + "' "
                + "WHERE id = '" + this.id + "'";
                
        DBHelper.executeQuery(SQL);
    }

    public void addObat(int obat_id, String dosis)  {
        String SQL = "INSERT INTO obat_diagnosa (obat_id, diagnosa_id, dosis) VALUES("
                + "'" + obat_id + "', "
                + "'" + this.id + "', "
                + "'" + dosis + "'"
                + ")";
                
        DBHelper.executeQuery(SQL);
    }

    public ArrayList<ObatDiagnosa> getObatDiagnosa() {
        return ObatDiagnosa.getByDiagnosaId(this.id);
    }

    public static void main(String[] args) {
//        Diagnosa d = new Diagnosa();
//        
//        d.setAntrean_id(2);
//        d.setPenyakit("Sakit panu");
//        d.setDokter_id(6);

        Diagnosa d = Diagnosa.getDiagnosaByPasienID(2).get(0);
        
//        d.addObat(1, "2 kapsul per malam");
//        d.addObat(2, "is it gonna work?");
//        
        ArrayList<ObatDiagnosa> obat = d.getObatDiagnosa();
        
        System.out.println(d.id);
        
        for(ObatDiagnosa o: obat) {
            System.out.println(o.getObat_id());
            System.out.println(o.dosis);
        }
        
        d.save();
    }

}
