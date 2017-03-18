package main.java.presentation;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import main.java.entity.Score;
import main.java.logic.ScoreService;

public class AddDialog extends JDialog{
	JLabel id,name,course,score,time;
	JTextField idText,nameText,courseText,scoreText,timeText;
	JButton finish;
	DefaultTableModel defaultTableModel;
	JTable table;
	ScoreService scoreService=new ScoreService();
	public AddDialog(DefaultTableModel defaultTableModel,JTable table){
		super();
		this.defaultTableModel=defaultTableModel;
		this.table=table;
		setLayout(new FlowLayout());
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		finish.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                // TODO Auto-generated method stub  
                Vector<String> vector = new Vector<String>();
                Score score=new Score();  
                vector.add(nameText.getText()); 
                vector.add(courseText.getText());
                vector.add(scoreText.getText());
                vector.add(timeText.getText());
//              scoreService.addScore(score);
                defaultTableModel.getDataVector().add(vector);
                table.setModel(defaultTableModel);
                dispose();
            }
        });
		
	}
}
