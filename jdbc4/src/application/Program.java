package application;

import db.DB;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

        Connection conn = DB.getConnection();
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "UPDATE pessoa "
                            + "SET nome = ? "
                            + "WHERE "
                            + "(id = ?) ");
            st.setString(1, "Lorenzo Rezende");
            st.setInt(2, 1);

            int rowsAffected = st.executeUpdate();

            System.out.println("Done! Rows affected " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DB.closeStatemaint(st);
            DB.closeConnection();
        }
    }
}
