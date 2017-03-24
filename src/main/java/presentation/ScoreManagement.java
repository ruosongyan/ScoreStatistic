package main.java.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import main.java.entity.Score;
import main.java.logic.ScoreService;

public class ScoreManagement {
	JFrame frame=null;
	ScoreService scoreService=new ScoreService();
	public ScoreManagement(){
		init();
		 // 显示窗口
       
	}
	
	public void init(){
//		JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("学生成绩统计系统");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(780, 600);
        frame.setVisible(true);
        
        JPanel desktop = new JPanel();
        frame.getContentPane().add(desktop);
        desktop.setLayout(new BorderLayout());
        
        JPanel functionPanel = new JPanel();
        functionPanel.setLayout(null);
        JLabel icon1=new JLabel("Score");
        icon1.setFont(new Font("",1,30));//设置字体大小
        icon1.setForeground(Color.white);//设置字体颜色
        icon1.setBounds(30, 10, 160, 40);
        functionPanel.add(icon1);
        JLabel icon2=new JLabel("Statistic");
        icon2.setFont(new Font("",1,30));//设置字体大小
        icon2.setForeground(Color.white);//设置字体颜色
        icon2.setBounds(15,50,160,40);
        functionPanel.add(icon2);
        functionPanel.setBackground(new Color(99,6,95));
        functionPanel.setPreferredSize(new Dimension(160,600));
        JPanel navPanel=new JPanel();
        navPanel.setBackground(new Color(115, 40, 111));
        navPanel.setSize(160, 400);
        navPanel.setBounds(0, 110, 160, 500);
        navPanel.setLayout(null);
        JLabel sm=new JLabel();
        ImageIcon image = new ImageIcon("score.png");
        sm.setIcon(image);
        sm.setBounds(40, 30, 100, 70);
        JLabel smText=new JLabel("成绩统计");
        smText.setFont(new Font("",1,15));//设置字体大小
        smText.setForeground(Color.white);//设置字体颜色
        smText.setBounds(45, 100, 100, 30);
        navPanel.add(sm);
        navPanel.add(smText);
        functionPanel.add(navPanel);
        desktop.add(functionPanel,BorderLayout.WEST);
        
        JPanel contentPanel=new JPanel();
        contentPanel.setLayout(new BorderLayout());
        JPanel operationPanel=new JPanel();
        contentPanel.add(operationPanel,BorderLayout.NORTH);
        contentPanel.setPreferredSize(new Dimension(620,600));
        desktop.add(contentPanel,BorderLayout.CENTER);

        operationPanel.setLayout(new FlowLayout());
        operationPanel.setBackground(Color.white);
        operationPanel.setPreferredSize(new Dimension(520,80));
        JButton add=new JButton("新增");
        add.setSize(150, 50);
        JButton modify=new JButton("修改");
        modify.setSize(150, 50);
        JButton delete=new JButton("删除");
        delete.setSize(150, 50);
        JButton search=new JButton("查询");
        search.setSize(150, 50);
        JTextField text=new JTextField("请输入学生姓名", 10);
        text.setSize(150, 50);
        
        JLabel name=new JLabel("姓名");
        JLabel course=new JLabel("课程");
        JLabel score=new JLabel("分数");
        JLabel time=new JLabel("日期");
		
		JTextField nameText=new JTextField(5);
		JTextField courseText=new JTextField(5);
		JTextField scoreText=new JTextField(5);
		JTextField timeText=new JTextField(5);
		
		operationPanel.add(name);
		operationPanel.add(nameText);
		operationPanel.add(course);
		operationPanel.add(courseText);
		operationPanel.add(score);
		operationPanel.add(scoreText);
		operationPanel.add(time);
		operationPanel.add(timeText);
		
        operationPanel.add(add);
        operationPanel.add(modify);
        operationPanel.add(delete);
        operationPanel.add(text);
        operationPanel.add(search);
        
        JPanel tablePanel=new JPanel();
        contentPanel.add(tablePanel,BorderLayout.CENTER);
        Vector<String> tableColumnNames = new Vector<String>();  
        tableColumnNames.add("序号");  
        tableColumnNames.add("姓名");
        tableColumnNames.add("课程");
        tableColumnNames.add("成绩");
        tableColumnNames.add("日期");
        
        Vector<Vector<String>> tableValues = new Vector<Vector<String>>();
        ArrayList<Score> list=scoreService.searchScore("");
        for (int i = 0; i < list.size(); i++) {  
            Vector<String> vector = new Vector<String>();
            Score s=list.get(i);
            vector.add(String.valueOf(s.getSid()));  
            vector.add(s.getName());
            vector.add(s.getCourse());
            vector.add(String.valueOf(s.getScore()));
            vector.add(s.getTime());
            tableValues.add(vector);  
        }  
        DefaultTableModel defaultTableModel = new DefaultTableModel(  
                tableValues, tableColumnNames);  
        JTable table = new JTable(defaultTableModel); 
        table.setBackground(Color.white);
        int column=table.getColumnCount();
        for(int i=0;i<column;i++){
        	TableColumn col=table.getColumnModel().getColumn(i);
        	col.setPreferredWidth(115);
        }
        tablePanel.add(table);
        tablePanel.setBackground(Color.white);
        
        //设置事件
        table.addMouseListener(new MouseAdapter() {
        	@Override
			public void mouseClicked(MouseEvent e) {
        		int row=table.getSelectedRow();
        		nameText.setText(defaultTableModel.getValueAt(row, 1).toString());
        		courseText.setText(defaultTableModel.getValueAt(row, 2).toString());
        		scoreText.setText(defaultTableModel.getValueAt(row, 3).toString());
        		timeText.setText(defaultTableModel.getValueAt(row, 4).toString());
        	}
        });
       
        add.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                // TODO Auto-generated method stub  
            	Vector<String> vector = new Vector<String>();
                Score score=new Score();
                vector.add(String.valueOf(defaultTableModel.getRowCount()+1));
                vector.add(nameText.getText()); 
                vector.add(courseText.getText());
                vector.add(scoreText.getText());
                vector.add(timeText.getText());
                score.setSid(defaultTableModel.getRowCount()+1);
                score.setName(nameText.getText());
                score.setCourse(courseText.getText());
                score.setScore(Double.valueOf(scoreText.getText()));
                score.setTime(timeText.getText());
                scoreService.addScore(score);
                defaultTableModel.addRow(vector);
                table.removeAll();
                table.setModel(defaultTableModel);
                defaultTableModel.fireTableDataChanged();
            }
        });
        
        modify.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                // TODO Auto-generated method stub  
                int row=table.getSelectedRow();
                defaultTableModel.setValueAt(nameText.getText(), row, 1);
                defaultTableModel.setValueAt(courseText.getText(), row, 2);
                defaultTableModel.setValueAt(scoreText.getText(), row, 3);
                defaultTableModel.setValueAt(timeText.getText(), row, 4);
                
                Score s=new Score();
                s.setSid(Integer.parseInt(defaultTableModel.getValueAt(row, 0).toString()));
                s.setName(nameText.getText());
                s.setCourse(courseText.getText());
                s.setScore(Double.parseDouble(scoreText.getText()));
                s.setTime(timeText.getText());
                scoreService.modifyScore(s);
              }  
        });
        
        search.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                // TODO Auto-generated method stub  
                int row=table.getRowCount();
                System.out.println(row);
                Vector<Vector<String>> tValues = new Vector<Vector<String>>();
                String str=text.getText();
                ArrayList<Score> list=scoreService.searchScore(str);
                for (int i = 0; i < list.size(); i++) {  
                    Vector<String> vector = new Vector<String>();
                    Score s=list.get(i);
                    vector.add(String.valueOf(s.getSid()));  
                    vector.add(s.getName());
                    vector.add(s.getCourse());
                    vector.add(String.valueOf(s.getScore()));
                    vector.add(s.getTime());
                    tValues.add(vector);  
                }
                int column=table.getColumnCount();
                defaultTableModel.setDataVector(tValues, tableColumnNames);
                defaultTableModel.fireTableDataChanged();
                for(int i=0;i<column;i++){
                	TableColumn col=table.getColumnModel().getColumn(i);
                	col.setPreferredWidth(115);
                }
                  
              }  
        });
        
        delete.addActionListener(new ActionListener() {    
            @Override  
            public void actionPerformed(ActionEvent e) {  
                // TODO Auto-generated method stub  
                int[] selectedRows = table.getSelectedRows(); // table
                for (int i = 0; i < selectedRows.length; i++) {  
                    defaultTableModel.removeRow(selectedRows[i] - i);  
                }  
            }  
        });  
        
        
        
        operationPanel.updateUI();
        
        
       
	}
	
	public void addListener(){
		
	}
	
	public static void main(String[] args) {
		ScoreManagement sm=new ScoreManagement();
	}
	
}
