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
		setTitle("�ɼ���Ϣ");
		
		name=new JLabel("����");
		course=new JLabel("�γ�");
		score=new JLabel("����");
		time=new JLabel("����");
		
		nameText=new JTextField(20);
		courseText=new JTextField(20);
		scoreText=new JTextField(20);
		timeText=new JTextField(20);
		
		finish=new JButton("���");
		
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
