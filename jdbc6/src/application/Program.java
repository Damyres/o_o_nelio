package application;

import db.DB;
import db.DbIntegrityException;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

//deletando dados do banco

        Connection conn = DB.getConnection();
        Statement st = null;

        try {
            conn = DB.getConnection();
            st= conn.createStatement();


            System.out.println("Done! Rows affected " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DB.closeStatemaint(st);
            DB.closeConnection();
        }
    }
}
