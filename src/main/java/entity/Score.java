package main.java.entity;



public class Score {
	private int sid;
	private String name;
	private String course;
	private double score;
	private String time;
	
	public void setSid(int sid){
		this.sid=sid;
	}
	public int getSid(){
		return sid;
	}
	
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	
	public void setCourse(String course){
		this.course=course;
	}
	public String getCourse(){
		return course;
	}
	
	public void setScore(double score){
		this.score=score;
	}
	public double getScore(){
		return score;
	}
	
	public void setTime(String time){
		this.time=time;
	}
	public String getTime(){
		return time;
	}
}

