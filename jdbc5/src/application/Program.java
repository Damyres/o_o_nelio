package application;

import db.DB;
import db.DbIntegrityException;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

//deletando dados do banco

        Connection conn = DB.getConnection();
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(

                    "DELETE FROM pessoa"
                            + " WHERE "
                            + " id = ? ");

            st.setInt(1, 1);
            int rowsAffected = st.executeUpdate();

            System.out.println("Done! Rows affected " + rowsAffected);

        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());

        } finally {
            DB.closeStatemaint(st);
            DB.closeConnection();
        }
    }
}
