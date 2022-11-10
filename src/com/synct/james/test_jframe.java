package com.synct.james;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class test_jframe extends JFrame implements ActionListener {
	private JButton btn_0,btn_00,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9;
	private JButton btn_add,btn_min,btn_mul,btn_div,btn_undo,btn_equals,btn_clear,btn_point;
	private JLabel log;
	
	public test_jframe() {
super("計算機");//title
		
		//btn_init
		btn_0 = new JButton("0");
		btn_00 = new JButton("00");
		btn_1 = new JButton("1");
		btn_2 = new JButton("2");
		btn_3 = new JButton("3");
		btn_4 = new JButton("4");
		btn_5 = new JButton("5");
		btn_6 = new JButton("6");
		btn_7 = new JButton("7");
		btn_8 = new JButton("8");
		btn_9 = new JButton("9");
		btn_add = new JButton("+");
		btn_min = new JButton("-");
		btn_mul = new JButton("*");
		btn_div = new JButton("/");
		btn_undo = new JButton("<-");
		btn_equals = new JButton("=");
		btn_clear = new JButton("AC");
		btn_point = new JButton(".");
		
		
		//btn_9.setBorder(BorderFactory.createRaisedBevelBorder()); 
		//log_init
		log = new JLabel();
		log.setText("1+1=2");
		log.setPreferredSize(new java.awt.Dimension(600,100));
		
		
		//layout_init
		setLayout(new BorderLayout());//主框架
		
		JPanel top = new JPanel(new BorderLayout());//文字顯示_控制版
		top.add(log, BorderLayout.CENTER);
		
		JPanel JPanel_equals =  new JPanel(new GridLayout(1,2));//按鈕_控制版
		JPanel_equals.add(btn_equals);
		
		JPanel center =  new JPanel(new GridLayout(0,5,5,5));//按鈕_控制版
		
		center.add(btn_7);
		center.add(btn_8);
		center.add(btn_9);
		center.add(btn_div);
		center.add(btn_undo);
		
		center.add(btn_4);
		center.add(btn_5);
		center.add(btn_6);
		center.add(btn_mul);
		center.add(btn_clear);
		
		center.add(btn_3);
		center.add(btn_2);
		center.add(btn_1);
		center.add(btn_add);
		center.add(JPanel_equals);
		
		center.add(btn_0);
		center.add(btn_00);
		center.add(btn_point);
		center.add(btn_min);
		
		
		
		
		add(log, BorderLayout.NORTH);//主框架add
		add(center, BorderLayout.CENTER);//主框架add

	
		//guess.setActionCommand("d1");//設定動作的代號

		
		setSize(480, 640);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new test_jframe();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
