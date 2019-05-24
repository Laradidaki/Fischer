//package eserciziostudenti2;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.sql.DataSource;
//
//import pooling.ConnectionPool;
//
//public class StudenteDbUtil {
//
//	private DataSource datasource;
//	
//	public StudenteDbUtil(DataSource theDataSource) {
//		datasource=theDataSource;
//	}
//	
//	public List<Studente> getStudenti() throws Exception {
//		
//		List<Studente>studenti=new ArrayList<Studente>();
//		
//		  ResultSet rsObj = null;
//	        Connection connObj = null;
//	        PreparedStatement pstmtObj = null;
//	        ConnectionPool jdbcObj = new ConnectionPool();
//	        
//	        try {
//	        	  datasource = jdbcObj.setUpPool();
//	        		connObj=datasource.getConnection();
//	        		String sql="select * from studente order by cognome";
//	        		pstmtObj=connObj.prepareStatement(sql);
//	        		rsObj = pstmtObj.executeQuery();
//	        		while(rsObj.next()) {
//	        			int id=rsObj.getInt("id");
//	        			String nome=rsObj.getString("nome");
//	        			String cognome=rsObj.getString("cognome");
//	        			String email=rsObj.getString("email");
//	        			
//	        			Studente tempStudente=new Studente(id, nome, cognome, email);
//	        			studenti.add(tempStudente);
//	        		}
//	        	
//	        	return studenti;
//	        }
//	        
//	        finally {
//	        	close(connObj,pstmtObj,rsObj);
//	        }
//	        
//	}
//
//	private void close(Connection connObj, PreparedStatement pstmtObj, ResultSet rsObj) {
//		try {
//            // Closing ResultSet Object
//            if(rsObj != null) {
//                rsObj.close();
//            }
//            // Closing PreparedStatement Object
//            if(pstmtObj != null) {
//                pstmtObj.close();
//            }
//            // Closing Connection Object
//            if(connObj != null) {
//                connObj.close();
//            }
//        } catch(Exception sqlException) {
//            sqlException.printStackTrace();
//        }
//    
//}
//}
