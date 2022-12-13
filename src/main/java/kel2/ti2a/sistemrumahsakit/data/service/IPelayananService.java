/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package kel2.ti2a.sistemrumahsakit.data.service;

import java.util.ArrayList;
import kel2.ti2a.sistemrumahsakit.data.model.Antrian;

/**
 *
 * @author tioirawan
 */
public interface IPelayananService {
    /**
     * Fungsi untuk set antrian aktif unit pelayanan menjadi checkup
     *
     * @param antrianId id antrian yang akan di dequeue
     *
     * @return antrian aktif baru unit pelayanan
    */
    public Antrian setAntrianAktifCheckup(int antrianId);

    /**
      * Fungsi untuk set antrian aktif unit pelayanan menjadi selesai checkup
      *
      * @param antrianId id antrian yang akan di dequeue
      *
      * @return antrian aktif baru unit pelayanan
      */
    public Antrian setAntrianAktifSelesaiCheckup(int antrianId);

    /**
      * Fungsi untuk set antrian aktif unit pelayanan menjadi selesai obat
      *
      * @param antrianId id antrian yang akan di dequeue
      *
      * @return antrian aktif baru unit pelayanan
      */
    public Antrian setAntrianAktifSelesaiObat(int antrianId);

    /**
     * Fungsi untuk melihat antrian saat ini dengan status checkup
     *
     * @param unitPelayananId id unit pelayanan yang akan diambil antrian saat ini
     *
     * @return antrian saat ini
    */
    public Antrian getAntrianCheckupSaatIni(int unitPelayananId);

    /**
     * Fungsi untuk melihat antrian saat ini dengan status obat
     *
     * @return antrian saat ini
    */
    public Antrian getAntrianObatSaatIni();

     /**
     * Fungsi untuk melihat seluruh antrian obat
     *
     * @return seluruh antrian obat
    */
    public ArrayList<Antrian> getDaftarAntrianObat();

    /**
     * Fungsi untuk next antrian saat checkup saat ini
     * pada implementasi antrian saat ini akan dirubah satusnya menjadi AntrianStatus.OBAT
     * dan antrian selanjutnya akan dirubah statusnya menjadi AntrianStatus.CHECKUP
     *
     * @param unitPelayananId id unit pelayanan yang akan dilakukan next antrian
     *
     * @return antrian saat ini
    */
    public Antrian nextAntrianCheckup(int unitPelayananId);
}
