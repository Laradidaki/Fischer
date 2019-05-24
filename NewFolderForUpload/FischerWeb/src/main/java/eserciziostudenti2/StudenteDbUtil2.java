package eserciziostudenti2;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import pooling.JDBCUtil;

public class StudenteDbUtil2 {
public List<Studente> getStudenti() throws Exception {
		
		QueryRunner runner =  new QueryRunner(JDBCUtil.getDataSource());
		return runner.query("select * from studente order by cognome", new BeanListHandler<Studente>(Studente.class));
		
	
	        }

	
}
