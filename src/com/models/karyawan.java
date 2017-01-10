/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.config.DataSource;
import com.config.pojoKaryawan;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Programmer JUJU
 */
public class karyawan {

    public Boolean insert(String[] value) throws SQLException, IOException, PropertyVetoException {
        boolean result = false;
        try {
            try (Connection connection = DataSource.getInstance().getConnection()) {
                try (Statement statement = connection.createStatement()) {
                    String query = "INSERT INTO karyawan SET "
                            + "nik ='" + value[0] + "',"
                            + "nama ='" + value[1] + "',"
                            + "telp ='" + value[2] + "',"
                            + "alamat ='" + value[3] + "'";
                    statement.execute(query);
                }

            }
            result = true;
        } catch (SQLException sqle) {
            System.err.println("Insert Karyawan Failed : " + sqle);
        }

        return result;
    }

    /**
     *
     * @param var
     * @param id
     * @param fieldOrder
     * @param order
     * @param limit
     * @return
     * @throws SQLException
     * @throws IOException
     * @throws PropertyVetoException
     */
    public pojoKaryawan view(String var, Integer id, String fieldOrder, Integer order, Integer limit) throws SQLException, IOException, PropertyVetoException {
        String[] orderDirect = {"ASC", "DESC"};
        pojoKaryawan pojo = null;
        String query;
        if (!"".equals(var)) {
            query = "SELECT * FROM karyawan WHERE nik like '%" + var + "%' OR nama like '%" + var + "%' order by " + fieldOrder + " " + orderDirect[order] + " limit " + limit;
        } else {
            query = "SELECT * FROM karyawan where 1 order by " + fieldOrder + " " + orderDirect[order] + " limit " + limit;
        }
        if (id != 0) {
            query = "SELECT * FROM karyawan where uid=" + id;
        }

        try {
            try (Connection conn = DataSource.getInstance().getConnection()) {
                try (Statement st = conn.createStatement()) {
                    try (ResultSet rs = st.executeQuery(query)) {
                        rs.last();
                        pojo = new pojoKaryawan(rs.getRow());
                        rs.beforeFirst();
                        while (rs.next()) {
                            pojo.setId(rs.getInt("uid"), rs.getRow() - 1);
                            pojo.setNik(rs.getString("nik"), rs.getRow() - 1);
                            pojo.setNama(rs.getString("nama"), rs.getRow() - 1);
                            pojo.setTelp(rs.getString("telp"), rs.getRow() - 1);
                            pojo.setAlamat(rs.getString("alamat"), rs.getRow() - 1);
                        }
                    }
                }
            }
        } catch (SQLException | IOException | PropertyVetoException sqle) {
            System.err.println("View Karyawan Failed : " + sqle);
        }
        return pojo;
    }

    /**
     *
     * @param value
     * @param id
     * @return
     * @throws SQLException
     * @throws IOException
     * @throws PropertyVetoException
     */
    public Boolean update(String[] value, Integer id) throws SQLException, IOException, PropertyVetoException {
        boolean result = false;
        try {
            try (Connection conn = DataSource.getInstance().getConnection()) {
                try (Statement statement = conn.createStatement()) {
                    String query = "UPDATE karyawan SET "
                            + "nik ='" + value[0] + "',"
                            + "nama ='" + value[1] + "',"
                            + "telp ='" + value[2] + "',"
                            + "alamat ='" + value[3] + "'"
                            + " WHERE uid=" + id;
                    statement.execute(query);
                }
            }
            result = true;
        } catch (SQLException sqle) {
            System.err.println("Update Karyawan Failed : " + sqle);
        }
        return result;
    }

    public Boolean delete(Integer id) throws SQLException, IOException, PropertyVetoException {
        boolean result = false;
        try {
            try (Connection conn = DataSource.getInstance().getConnection()) {
                try (Statement statement = conn.createStatement()) {
                    String query = "DELETE FROM karyawan"
                            + " WHERE uid=" + id;
                    statement.execute(query);
                }
            }
            result = true;
        } catch (SQLException sqle) {
            System.err.println("Delete Karyawan Failed : " + sqle);
        }
        return result;
    }
}
