package com.synct.james;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class test_layout extends JFrame implements ActionListener {
	private JPanel top,center,center_left;//容器
	private JLabel top_area,question,answer;//顯示lable
	private JTextArea mes_log;

	public test_layout() {
		// set_title
		super("test_layout");

		// top_init
		top_area = new JLabel("TOP_TEXT", JLabel.CENTER);// 文字靠右顯示
		top_area.setFont(new Font("宋體", Font.PLAIN, 36));// 設置文字大小
		top_area.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 15));// 設置留白
		top_area.setOpaque(true);// 設置不透明
		top_area.setBackground(Color.WHITE);
		
		top = new JPanel(new BorderLayout());// 文字顯示_控制版
		top.add(top_area, BorderLayout.CENTER);
		
		//question_init(center_left_up)
		question = new JLabel("題目", JLabel.CENTER);// 文字靠右顯示
		question.setFont(new Font("宋體", Font.PLAIN, 36));// 設置文字大小
		question.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 15));// 設置留白
		question.setOpaque(true);// 設置不透明
		question.setBackground(Color.blue);
		
		//answer_init(center_left_bottom)
		answer = new JLabel("答案", JLabel.CENTER);// 文字靠右顯示
		answer.setFont(new Font("宋體", Font.PLAIN, 36));// 設置文字大小
		answer.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 15));// 設置留白
		answer.setOpaque(true);// 設置不透明
		answer.setBackground(Color.yellow);
		
		//center_left_init
		GridBagConstraints gbc = new GridBagConstraints();// 網格約束
		gbc.fill = GridBagConstraints.BOTH;// 物件充滿網格
		gbc.gridwidth = 1;// 設定物件占用網格寬
		gbc.gridheight = 1;// 設定物件占用網格長
		gbc.weightx = 1;// 設定容器放大時物件相隔距離
		gbc.weighty = 1;// 設定容器放大時物件相隔距離
		gbc.insets = new Insets(0, 0, 0, 0);// 設定物件間的距離
		
		center_left = new JPanel(new GridBagLayout());
		gbc.gridx = 0;
		gbc.gridy = 0;
		center_left.add(question, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		center_left.add(answer, gbc);
		
		
		//right_init
		mes_log = new JTextArea();
		mes_log.setFont(new Font("宋體", Font.PLAIN, 36));
		mes_log.setText("1.1234");
		mes_log.setBackground(Color.RED);
		
		//center_init
		GridBagConstraints gbc2 = new GridBagConstraints();// 網格約束
		gbc2.fill = GridBagConstraints.BOTH;// 物件充滿網格
		gbc2.gridwidth = 1;// 設定物件占用網格寬
		gbc2.gridheight = 1;// 設定物件占用網格長
		gbc2.weightx = 1;// 設定容器放大時物件相隔距離
		gbc2.weighty = 1;// 設定容器放大時物件相隔距離
		gbc2.insets = new Insets(0, 0, 0, 0);// 設定物件間的距離
		
		
		center = new JPanel(new GridBagLayout());
		gbc2.gridx = 0;
		gbc2.gridy = 0;
		center.add(center_left, gbc2);
		gbc2.gridx = 1;
		gbc2.gridy = 0;
		center.add(mes_log, gbc2);

		//主框架
		setLayout(new BorderLayout());// 主框架
		add(top, BorderLayout.NORTH);// 主框架add
		add(center, BorderLayout.CENTER);// 主框架add

		setSize(500, 520);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new test_layout();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
