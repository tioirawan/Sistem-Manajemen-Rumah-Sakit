/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kel2.ti2a.sistemrumahsakit.data.service;

import kel2.ti2a.sistemrumahsakit.data.model.Karyawan;

/**
 *
 * @author tioirawan
 */
public interface ILoginService {
    /**
     * Fungsi untuk login menggunakan nip dan password
     * 
     * @param nip nip yang digunakan untuk login
     * @param password password yang digunakan untuk login
     *
     * @return Karyawan dan throw exception jika nip atau password salah
    */
    public Karyawan login(String nip, String password);
}
