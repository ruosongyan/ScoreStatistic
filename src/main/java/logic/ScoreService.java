package main.java.logic;

import java.util.ArrayList;

import main.java.data.ScoreDao;
import main.java.entity.Score;

public class ScoreService {
	public void addScore(Score score){
		ScoreDao scoreDao=new ScoreDao();
		scoreDao.add(score);
	}
	
	public void deleteScore(Score score){
		ScoreDao scoreDao=new ScoreDao();
		scoreDao.delete(score);
	}
	
	public ArrayList<Score> searchScore(String str){
		ScoreDao scoreDao=new ScoreDao();
		ArrayList<Score> list=scoreDao.search(str);
		return list;
	}
	
	public void modifyScore(Score score){
		ScoreDao scoreDao=new ScoreDao();
		scoreDao.modify(score);
	}
	
	public static void main(String[] args) {
		ScoreService scoreService=new ScoreService();
		ArrayList<Score> list=scoreService.searchScore("Ã÷");
		System.out.println(list.get(0).getName());
	}
	
}
