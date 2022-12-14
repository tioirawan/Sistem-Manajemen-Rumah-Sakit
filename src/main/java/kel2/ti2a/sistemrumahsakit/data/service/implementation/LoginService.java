/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kel2.ti2a.sistemrumahsakit.data.service.implementation;

import kel2.ti2a.sistemrumahsakit.data.model.Karyawan;
import kel2.ti2a.sistemrumahsakit.data.service.ILoginService;

/**
 *
 * @author tioirawan
 */
public class LoginService implements ILoginService {

    @Override
    public Karyawan login(String nip, String password) {
        Karyawan karyawan = Karyawan.getByNipAndPassword(nip, password);

        return karyawan;
    }

    public static void main(String[] args) {
        // contoh penggunakan LoginService
        LoginService service = new LoginService();

        Karyawan k = service.login("2141720003", "dokter123");

        System.out.println(k.getNama());
    }

}
