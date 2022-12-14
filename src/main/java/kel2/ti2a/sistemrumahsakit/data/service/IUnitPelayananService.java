/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package kel2.ti2a.sistemrumahsakit.data.service;

import java.util.ArrayList;
import kel2.ti2a.sistemrumahsakit.data.model.Antrian;
import kel2.ti2a.sistemrumahsakit.data.model.UnitPelayanan;

/**
 *
 * @author tioirawan
 */
public interface IUnitPelayananService {
    /**
     * Fungsi untuk mendapatkan daftar unit pelayanan
     *
     * @return daftar unit pelayanan
     */
    public ArrayList<UnitPelayanan> getDaftarUnitPelayanan();

    /**
     * Fungsi untuk mendapatkan daftar antrian unit pelayanan
     *
     * @param unitPelayananId id unit pelayanan yang akan diambil daftar antrian
     *
     * @return daftar antrian unit pelayanan
    */
    public ArrayList<Antrian> getDaftarAntrianUnitPelayanan(int unitPelayananId);

    /**
     * Fungsi untuk mendapatkan antrian aktif unit pelayanan
     *
     * @param unitPelayananId id unit pelayanan yang akan diambil antrian aktifnya
     *
     * @return antrian aktif unit pelayanan
    */
    public Antrian getAntrianAktifUnitPelayanan(int unitPelayananId);
    
    public UnitPelayanan getUnitPelayananDokter(int dokterId);
}
