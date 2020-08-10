package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conn.DBConnect;
import model.Member;

public class JoinDaoImpl implements JoinDao{
	private DBConnect db;
	
	public JoinDaoImpl() {
		db = DBConnect.getInstance();
	}

	@Override
	public void insert(Member m) {
		Connection conn = null;
		
		String sql = "insert into member2 values(?, ?, ?, ?)";
		
		PreparedStatement pstmt = null;
		
		try {
			conn = db.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());
			
			pstmt.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public Member select(String id) {
		Connection conn = null;
		ResultSet rs = null;
		Member m = null;
		String sql = "select * from member2 where id = ?";
		PreparedStatement pstmt = null;
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void update(Member m) {
		Connection conn = null;
		
		String sql = "update member2 set pwd = ? , name = ?, email = ? where id = ?";
		
		PreparedStatement pstmt = null;
		
		try {
			conn = db.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getPwd());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getId());
			
			pstmt.executeQuery();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

	@Override
	public void delete(String id) {
		Connection conn = null;
		
		String sql = "delete member2 where id = ?";
		
		PreparedStatement pstmt = null;
		
		try {
			conn = db.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
