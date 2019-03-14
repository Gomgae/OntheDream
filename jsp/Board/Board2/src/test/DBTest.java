package test;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class DBTest {
	public DBTest(){
		Connection conn = null;
	
		try{
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/aaa");
			conn = ds.getConnection();
			System.out.println("DB立加 己傍");
		}catch(Exception e){
			System.out.println("DB立加 角菩");
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
