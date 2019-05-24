package pooling;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtil {

	
	static ComboPooledDataSource datasource=null;
	static {
		datasource=new ComboPooledDataSource();
	}
	public static DataSource getDataSource() {
		return datasource;
	}
	
	public static Connection getConn() throws SQLException {
		return datasource.getConnection();
		}
	
	public static void release(Connection conn, Statement st, ResultSet rs) {
		closeConn(conn);
		closeSt(st);
		closeRs(rs);
	}
	public static void release(Connection conn, Statement st) {
		closeConn(conn);
		closeSt(st);
		
	}
	
	private static void closeRs(ResultSet rs) {
		
		try {
			if(rs!=null) {
				
					rs.close();
				}}
			catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			finally {
				rs=null;
			}
	}

	private static void closeSt(Statement st) {
		try {
			if(st!=null) {
				
					st.close();
				}}
			catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			finally {
				st=null;
			}
	}

	private static void closeConn(Connection conn) {
		try {
			if(conn!=null) {
				
					conn.close();
				}}
			catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			finally {
				conn=null;
			}
	}

	

}
