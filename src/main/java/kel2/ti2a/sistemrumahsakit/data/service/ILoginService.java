/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kel2.ti2a.sistemrumahsakit.data.service;

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
     * @return true jika login berhasil, false jika login gagal
    */
    boolean login(String nip, String password);
}
