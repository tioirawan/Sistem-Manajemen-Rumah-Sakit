/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package kel2.ti2a.sistemrumahsakit.data.service;

import java.util.ArrayList;
import kel2.ti2a.sistemrumahsakit.data.model.Antrian;
import kel2.ti2a.sistemrumahsakit.data.model.ObatDiagnosa;

/**
 *
 * @author tioirawan
 */
public interface IPelayananService {
    
    /**
     * Fungsi untuk melihat seluruh antrian obat (Dilakukan oleh perawat)
     *
     * @return seluruh antrian obat
    */
    public ArrayList<Antrian> getDaftarAntrianCheckup(int unitServiceId);

     /**
     * Fungsi untuk melihat seluruh antrian obat (Dilakukan oleh apoteker)
     *
     * @return seluruh antrian obat
    */
    public ArrayList<Antrian> getDaftarAntrianObat();
    
    /**
     * Fungsi untuk melihat antrian saat ini dengan status checkup
     *
     * @param unitPelayananId id unit pelayanan yang akan diambil antrian saat ini
     *
     * @return antrian saat ini
    */
    public Antrian getAntrianCheckupSaatIni(int unitServiceId);

    /**
     * Fungsi untuk melihat antrian saat ini dengan status obat
     *
     * @return antrian saat ini
    */
    public Antrian getAntrianObatSaatIni();
    
    /**
     * Fungsi ini digunakan dokter ketika submit diagnosa (dilakukan sebelum perawat menekan next antrian)
     * 
     * @param dokterId
     * @param penyakit
     * @param resep
     * @return Antrian saat ini
     */
    public Antrian submitDiagnosaDanResep(int dokterId, String penyakit, ArrayList<ObatDiagnosa> obat);
    

    /**
     * Fungsi untuk next antrian saat checkup saat ini (Dilakukan oleh perawat)
     * pada implementasi antrian saat ini akan dirubah satusnya menjadi AntrianStatus.OBAT
     * dan antrian selanjutnya akan dirubah statusnya menjadi AntrianStatus.CHECKUP
     *
     * @param unitPelayananId id unit pelayanan yang akan dilakukan next antrian
     *
     * @return antrian saat ini
    */
    public Antrian nextAntrianCheckup(int unitPelayananId);
}
