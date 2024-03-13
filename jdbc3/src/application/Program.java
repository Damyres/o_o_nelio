package application;

import db.DB;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

        //Inserindo dados na tabela
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConnection();
/*
            st = conn.prepareStatement(
                    "insert into pessoa " +
                            "(nome, cpf)" +
                            "values" +
                            "(?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, "Maria  da Silva");
            st.setString(2, "01237689503");
*/

//            st = conn.prepareStatement("insert into pessoa (nome) values ('nome1'), ('nome2')",
//                    Statement.RETURN_GENERATED_KEYS); não atende a regra not null

            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("Done! Id = " + id);
                }

            } else {
                System.out.println("No rwnn affected");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DB.closeStatemaint(st);
            DB.closeConnection();
        }
    }
}
