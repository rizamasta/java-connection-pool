/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.config;

/**
 *
 * @author Riza Masta
 */
public class pojoKaryawan {

    int length = 1;
    int id[];
    String[] nik;
    String[] nama;
    String[] alamat;
    String[] telp;

    public pojoKaryawan(int length) {
        this.length = length;
        id = new int[length];
        nik = new String[length];
        nama = new String[length];
        alamat = new String[length];
        telp = new String[length];
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setId(int id, int row) {
        this.id[row] = id;
    }

    public void setNik(String nik, int row) {
        this.nik[row] = nik;
    }

    public void setNama(String nama, int row) {
        this.nama[row] = nama;
    }

    public void setAlamat(String alamat, int row) {
        this.alamat[row] = alamat;
    }

    public void setTelp(String telp, int row) {
        this.telp[row] = telp;
    }

    public int getId(int row) {
        int uid;
        try {
            uid = id[row];
        } catch (Exception ex) {
            return row;
        }
        return uid;
    }

    public String getNik(int row) {
        return nik[row];
    }

    public String getNama(int row) {
        return nama[row];
    }

    public String getAlamat(int row) {
        return alamat[row];
    }

    public String getTelp(int row) {
        return telp[row];
    }

    public int getLength() {
        return length;
    }
}
