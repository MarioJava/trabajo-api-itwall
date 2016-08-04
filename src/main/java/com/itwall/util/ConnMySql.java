package com.itwall.util;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnMySql {

    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    public ConnMySql() {
        driver = ConstantsConnexionEnum.DRIVER.getConstResponse();
        url = ConstantsConnexionEnum.URL.getConstResponse() + ConstantsConnexionEnum.BD.getConstResponse();
        user = ConstantsConnexionEnum.USER.getConstResponse();
        password = ConstantsConnexionEnum.PASSWORD.getConstResponse();
    }

    private static Connection cnx = null;

    public static Connection obtener() throws SQLException, ClassNotFoundException {

        if (cnx == null) {
            try {
                Class.forName(driver);
                cnx = (Connection) DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                throw new SQLException(ex);
            } catch (ClassNotFoundException ex) {
                throw new ClassCastException(ex.getMessage());
            }
        }
        return cnx;
    }

    public static void cerrar() throws SQLException {
        if (cnx != null) {
            cnx.close();
        }
    }

}
