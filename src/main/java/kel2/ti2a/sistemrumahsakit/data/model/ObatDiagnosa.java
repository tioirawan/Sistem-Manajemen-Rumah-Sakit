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
 * @author User
 */
public class ObatDiagnosa {
    protected int obat_id;
    protected int diagnosa_id;
    protected String dosis;

    public int getObat_id() {
        return obat_id;
    }

    public void setObat_id(int obat_id) {
        this.obat_id = obat_id;
    }

    public int getDiagnosa_id() {
        return diagnosa_id;
    }

    public void setDiagnosa_id(int resep_id) {
        this.diagnosa_id = resep_id;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }
    
    
    public static ArrayList<ObatDiagnosa> getByDiagnosaId(int id) {
        ArrayList<ObatDiagnosa> obatDiagnosas = new ArrayList();
        ResultSet rs = DBHelper.selectQuery(
                "SELECT * FROM obat_diagnosa WHERE diagnosa_id = " + id);

        try { 
            while (rs.next()) {
                ObatDiagnosa obatDiagnosa = new ObatDiagnosa();
                obatDiagnosa.setObat_id(rs.getInt("obat_id"));
                obatDiagnosa.setDiagnosa_id(rs.getInt("diagnosa_id"));
                obatDiagnosa.setDosis(rs.getString("dosis"));
                obatDiagnosas.add(obatDiagnosa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return obatDiagnosas;
    }
}
