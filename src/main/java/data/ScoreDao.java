package main.java.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import main.java.entity.Score;

public class ScoreDao extends BasicDao{
	public void add(Score score){
		try {
			Connection conn=getMysqlConnection();
			String sql="insert into scores(name,course,score,time) values(?,?,?,?)";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, score.getName());
			pstmt.setString(2, score.getCourse());
			pstmt.setDouble(3, score.getScore());
			pstmt.setString(4, score.getTime().toString());
			pstmt.execute();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Score> search(String str){
		ArrayList<Score> list=null;
		try {
			Connection conn=getMysqlConnection();
			list=new ArrayList<Score>();
			String sql="select * from scores where name like '%"+str+"%'";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				Score score=new Score();
				score.setSid(rs.getInt(1));
				score.setName(rs.getString(2));
				score.setCourse(rs.getString(3));
				score.setScore(rs.getDouble(4));
				score.setTime(rs.getString(5));
				list.add(score);
			}
			conn.close();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void delete(Score score){
		try {
			Connection conn=getMysqlConnection();
			String sql="delete from scores where sid="+score.getSid();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.executeUpdate();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modify(Score score){
		try {
			Connection conn=getMysqlConnection();
			String sql="update scores set name='"+score.getName()+"',course='"+score.getCourse()+"',"
					+ "score="+score.getScore()+",time='"+score.getTime().toString()+"' where sid="+score.getSid();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.executeUpdate();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ScoreDao dao=new ScoreDao();
		Score score=new Score();
		score.setSid(1);
		score.setName("小明");
		score.setCourse("微积分");
		score.setScore(90);
//		Calendar cal=Calendar.getInstance();
//		cal.set(2017, 0, 1);
//		Date time=cal.getTime();
		String time="2017-02-03";
		score.setTime(time);
		ArrayList<Score> list=dao.search("明");
		System.out.println(list.get(0).getName());
		
	}
	
}
