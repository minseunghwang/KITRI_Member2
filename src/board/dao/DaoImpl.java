package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnect;
import model.Board;

public class DaoImpl implements Dao{
private DBConnect db;
	
	public DaoImpl() {
		db = DBConnect.getInstance();
	}
	
	@Override
	public void insert(Board b) {
		Connection conn = null;
		
		String sql = "insert into board values(seq_board.nextval ?, sysdate, ?, ?)";
		
		PreparedStatement pstmt = null;
		
		try {
			conn = db.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, b.getWriter());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getContent());
			
			pstmt.executeUpdate();
			
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
	public Board select(int num) {
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Board b = null;
		
		String sql = "select * from board where num = ?";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				b = new Board(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5));
			}
			return b;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		
		return null;
	}

	@Override
	public List selectAll() {
		
		Connection conn = null;
		ResultSet rs = null;
		ArrayList<Board> list = new ArrayList<Board>();
		
		String sql = "select * from board order by num";
		PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new Board(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public void update(Board b) {
		Connection conn = null;
		
		String sql = "update board set w_date = systdate, title=?, content=? where num=?";
		
		PreparedStatement pstmt = null;
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setInt(3, b.getNum());
			
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

	@Override
	public void delete(int num) {
		Connection conn = null;
		String sql = "delete board from num = ?";
		PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
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
