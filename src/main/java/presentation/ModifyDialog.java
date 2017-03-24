package main.java.presentation;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ModifyDialog extends JDialog{
	JLabel id,name,course,score,time;
	JTextField idText,nameText,courseText,scoreText,timeText;
	JButton finish;
	public ModifyDialog(){
		super();
		setLayout(new FlowLayout());
		setSize(300, 200);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("成绩信息");
		
		name=new JLabel("姓名");
		course=new JLabel("课程");
		score=new JLabel("分数");
		time=new JLabel("日期");
		
		nameText=new JTextField(20);
		courseText=new JTextField(20);
		scoreText=new JTextField(20);
		timeText=new JTextField(20);
		
		finish=new JButton("完成");
		
		add(name);
		add(nameText);
		add(course);
		add(courseText);
		add(score);
		add(scoreText);
		add(time);
		add(timeText);
		add(finish);
		
	}
}
