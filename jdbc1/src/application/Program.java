package application;

import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
    public static void main(String[] args) {

//  conectar o banco e desconectar o banco

//        Connection conn = DB.getConnection();
//        DB.closeConnection();



// Acessando dados de uma tabela

        Connection conn = null;

        Statement st = null;

        ResultSet rs = null;

        try {
            conn = DB.getConnection();

            st = conn.createStatement();

            rs = st.executeQuery("select * from pessoa ");

            while (rs.next()){
                System.out.println(rs.getInt("id") + ", " +
                        rs.getString("nome") + ", " + rs.getString("cpf") + ", ");
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            DB.closeResultSet(rs);
            DB.closeStatemaint(st);
            DB.closeConnection();
        }
    }
}
