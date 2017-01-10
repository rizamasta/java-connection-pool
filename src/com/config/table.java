/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.config;

/**
 *
 * @author Programmer JUJU
 */
public final class table {
    public javax.swing.table.DefaultTableModel tabel(String[] kolom, final boolean[] canEdit) {
        return new javax.swing.table.DefaultTableModel(new Object[][]{}, kolom) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
    }
    
}
