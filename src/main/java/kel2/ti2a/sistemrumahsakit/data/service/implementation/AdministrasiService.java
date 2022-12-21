/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kel2.ti2a.sistemrumahsakit.data.service.implementation;

import java.util.ArrayList;
import kel2.ti2a.sistemrumahsakit.data.model.Antrian;
import kel2.ti2a.sistemrumahsakit.data.model.Pasien;
import kel2.ti2a.sistemrumahsakit.data.model.PasienAsuransi;
import kel2.ti2a.sistemrumahsakit.data.model.PasienBpjs;
import kel2.ti2a.sistemrumahsakit.data.model.PasienUmum;
import kel2.ti2a.sistemrumahsakit.data.model.Transaksi;
import kel2.ti2a.sistemrumahsakit.data.service.IAdministrasiService;

/**
 *
 * @author User
 */
public class AdministrasiService implements IAdministrasiService{

    @Override
    public boolean daftarkanPasien(Pasien pasien) {
        try {
            if (pasien.getType().equalsIgnoreCase("pasienumum")) {
                pasien = (PasienUmum) pasien;
            } else if(pasien.getType().equalsIgnoreCase("pasienbpjs")){
                pasien = (PasienBpjs) pasien;
            } else if(pasien.getType().equalsIgnoreCase("pasienasuransi")) {
                pasien = (PasienAsuransi) pasien;
            } else {
                return false;
            }
            pasien.save();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Antrian daftarkanPasienKeAntrian(int nomorPasien, int unitPelayananId) {
        Antrian antre = null;
        try {
            antre = new Antrian();
            antre.insertIntoAntrean(nomorPasien, unitPelayananId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return antre;
    }

    @Override
    public ArrayList<Transaksi> getDaftarTransaksiPasien(int pasienId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean setPembayaran(int transaksiId, String metode, int nominal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
