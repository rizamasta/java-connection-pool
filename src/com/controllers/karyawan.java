/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.config.pojoKaryawan;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Programmer JUJU
 */
public class karyawan {

    com.models.karyawan karyawanModel = new com.models.karyawan();

    /**
     * 
     * @param field
     * @return
     * @throws SQLException
     * @throws IOException
     * @throws PropertyVetoException 
     */
    public Boolean insertKaryawan(String field[]) throws SQLException, IOException, PropertyVetoException {
        boolean save = false;
        if ("".equals(field[0])) {
            JOptionPane.showMessageDialog(null, "Mohon isikan kolom NIK", "Lengkapi Data", 0);
        } else if ("".equals(field[1])) {
            JOptionPane.showMessageDialog(null, "Mohon isi Nama", "Lengkapi Data", 0);
        } else if ("".equals(field[2])) {
            JOptionPane.showMessageDialog(null, "Berikan No Telpon", "Lengkapi Data", 0);
        } else if ("".equals(field[3])) {
            JOptionPane.showMessageDialog(null, "Mohon Mohon Lengkapi Data", "Lengkapi Data", 0);
        } else {
            karyawanModel.insert(field);
            save = true;
        }
        return save;
    }
    
    /**
     * 
     * @param var
     * @param id
     * @param field
     * @param order
     * @param Limit
     * @return
     * @throws SQLException
     * @throws IOException
     * @throws PropertyVetoException 
     */
    public pojoKaryawan view(String var,Integer id,String field,Integer order, Integer limit) throws SQLException,IOException,PropertyVetoException{
        pojoKaryawan resultSet;
        resultSet = karyawanModel.view(var,0,field,order,limit);
        return resultSet;
    }
    public Boolean updateKaryawan(String[] field,Integer id) throws SQLException,IOException,PropertyVetoException{
        boolean save = false;
        if ("".equals(field[0])) {
            JOptionPane.showMessageDialog(null, "Mohon isikan kolom NIK", "Lengkapi Data", 0);
        } else if ("".equals(field[1])) {
            JOptionPane.showMessageDialog(null, "Mohon isi Nama", "Lengkapi Data", 0);
        } else if ("".equals(field[2])) {
            JOptionPane.showMessageDialog(null, "Berikan No Telpon", "Lengkapi Data", 0);
        } else if ("".equals(field[3])) {
            JOptionPane.showMessageDialog(null, "Mohon Mohon Lengkapi Data", "Lengkapi Data", 0);
        } else {
            karyawanModel.update(field,id);
            save = true;
        }
        return save;
    }
    public Boolean deleteKaryawan(Integer id) throws SQLException,IOException,PropertyVetoException{
        boolean save = false;
        if (id==0) {
            JOptionPane.showMessageDialog(null, "Tidak Bisa Mendapatkan ID", "Error", 0);
        } else {
            karyawanModel.delete(id);
            save = true;
        }
        return save;
    }

}
