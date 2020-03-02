package jdbcExample.com.lionani07.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.plaf.basic.BasicTabbedPaneUI;

import com.mysql.cj.xdevapi.DbDoc;

public class Program {

	public static void main(String[] args) {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			con = DB.getConnection();
			st = con.createStatement();
			String sql = "SELECT * FROM department";
			rs = st.executeQuery(sql);

			while (rs.next()) {
				System.out.printf("Departament-> Id: %d, Name: %s\n", rs.getInt("Id"), rs.getString("Name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeResulset(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}

	}

}
