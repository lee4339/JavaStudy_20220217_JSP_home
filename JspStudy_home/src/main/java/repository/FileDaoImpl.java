package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import db.DBConnectionMgr;

public class FileDaoImpl implements FileDao {
	private DBConnectionMgr pool;
	
	public FileDaoImpl(DBConnectionMgr pool) {
		this.pool = pool;
	}
	
	@Override
	public int uploadFile(ArrayList<String> fileList) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			con = pool.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into file_mst values ");
			for(String fileName : fileList) {
				sql.append("(0,\'");
				sql.append(fileName);
				sql.append("\',now(), now()),");
			}
			
			sql.delete(sql.length() - 1, sql.length());
			System.out.println(sql.toString());
			pstmt = con.prepareStatement(sql.toString());
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		
		return result;
	}
	
}
