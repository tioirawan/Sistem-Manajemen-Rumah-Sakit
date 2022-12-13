/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package kel2.ti2a.sistemrumahsakit.data.service;

import java.util.ArrayList;
import kel2.ti2a.sistemrumahsakit.data.model.Antrian;
import kel2.ti2a.sistemrumahsakit.data.model.Pasien;
import kel2.ti2a.sistemrumahsakit.data.model.Pembayaran;


/**
 *
 * @author tioirawan
 */
public interface IAdministrasiService {
    /**
     * Fungsi untuk mendaftarkan Pasien baru
     *
     * @param pasien pasien yang akan didaftarkan
     * 
     * @return true jika pendaftaran berhasil, false jika pendaftaran gagal
     */
    public boolean daftarkanPasien(Pasien pasien);

    /**
     * Fungsi untuk mendaftarkan pasien ke antrian
     *
     * @param pasienId id pasien yang akan didaftarkan ke antrian
     * @param unitPelayananId id unit pelayanan yang dipilih pasien
     * 
     * @return objek Antrian jika pendaftaran berhasil, false jika pendaftaran gagal
    */
    public Antrian daftarkanPasienKeAntrian(int pasienId, int unitPelayananId);


    /**
     * Fungsi untuk mendapatkan daftar transaksi pasien
     *
     * @param pasienId id pasien yang akan diambil daftar transaksinya
     *
     * @return daftar pembayaran pasien
     */
    public ArrayList<Pembayaran> getDaftarTransaksiPasien(int pasienId);

    /**
     * Fungsi untuk mengatur nominal pembayaran transaksi
     *
     * @param transaksiId id transaksi yang akan diatur nominal pembayarannya
     * @param nominal nominal pembayaran
     *
     * @return true jika pembayaran berhasil, false jika pembayaran gagal
    */
    public boolean setNominalPembayaran(int transaksiId, int nominal);
}
