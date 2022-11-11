package com.synct.james;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

public class calculator extends JFrame implements ActionListener {
	private JPanel top, center;
	private JLabel log;
	private JButton btn_0, btn_00, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9;
	private JButton btn_add, btn_min, btn_mul, btn_div, btn_undo, btn_equals, btn_clear, btn_point;
	private String label_text = "";
	private String num_1, num_2 = "";
	private String action = "";
	private boolean is_select_action, count_over = false;

	public calculator() {
		// set_title
		super("計算機");

		// btn_init
		btn_init();

		// log_init
		log_init();

		// layout_init
		top = new JPanel(new BorderLayout());// 文字顯示_控制版
		top.add(log, BorderLayout.CENTER);

		center = new JPanel(new GridBagLayout());// 按鈕_控制版
		center_init();

		setLayout(new BorderLayout());// 主框架
		add(log, BorderLayout.NORTH);// 主框架add
		add(center, BorderLayout.CENTER);// 主框架add
		setSize(500, 520);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String ActionCommand = e.getActionCommand();

			switch (ActionCommand) {
			// --number--
			case "0":
				label_text += "0";
				break;
			case "00":
				label_text += "00";
				break;
			case "1":
				label_text += "1";
				break;
			case "2":
				label_text += "2";
				break;
			case "3":
				label_text += "3";
				break;
			case "4":
				label_text += "4";
				break;
			case "5":
				label_text += "5";
				break;
			case "6":
				label_text += "6";
				break;
			case "7":
				label_text += "7";
				break;
			case "8":
				label_text += "8";
				break;
			case "9":
				label_text += "9";
				break;
			case ".":
				label_text += ".";
				break;
			// --action--
			case "+":
				if (!is_select_action && label_text.length() > 0) {
					action = "+";
					set_value();
					label_text += "+";
				}
				break;
			case "-":
				if (!is_select_action && label_text.length() > 0) {
					action = "-";
					set_value();
					label_text += "-";
				}
				break;
			case "*":
				if (!is_select_action && label_text.length() > 0) {
					action = "*";
					set_value();
					label_text += "*";
				}
				break;
			case "/":
				if (!is_select_action && label_text.length() > 0) {
					action = "/";
					set_value();
					label_text += "/";
				}
				break;
			// --other--
			case "=":
				if (label_text.length() > 0) {
					set_value();
					do_count();
				}
				break;
			case "C":
				re_set();
				break;
			case "undo":
				undo();
				break;
			}
			log.setText(label_text);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void do_count() {
		try {
			if (!count_over) {
				double count = 0.0;
				if (action == "+") {
					count = Double.parseDouble(num_1) + Double.parseDouble(num_2);
				} else if (action == "-") {
					count = Double.parseDouble(num_1) - Double.parseDouble(num_2);
				} else if (action == "*") {
					count = Double.parseDouble(num_1) * Double.parseDouble(num_2);
				} else if (action == "/") {
					count = Double.parseDouble(num_1) / Double.parseDouble(num_2);
				}
				label_text += "=";
				label_text += count;
				count_over = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void set_value() {
		try {
			if (is_select_action) {
				num_2 = label_text.substring(label_text.lastIndexOf(action) + 1, label_text.length());
			} else {
				num_1 = label_text;
				is_select_action = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void undo() {
		try {
			if (!count_over && label_text.length() > 0) {
				// 遇到運算符號
				if (label_text.substring(label_text.length() - 1, label_text.length()).equals(action)) {
					action = "";
					is_select_action = false;
				}
				label_text = label_text.substring(0, label_text.length() - 1);
			}
			log.setText(label_text);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void re_set() {
		try {
			num_1 = "";
			num_2 = "";
			is_select_action = false;
			count_over = false;
			action = "";
			label_text = "";
			log.setText(label_text);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void center_init() {
		try {
			GridBagConstraints gbc = new GridBagConstraints();// 網格約束
			// gbc.gridwidth = GridBagConstraints.REMAINDER;//下一行排列
			// gbc.fill = GridBagConstraints.HORIZONTAL;//物件只充填滿寬度
			// gbc.fill = GridBagConstraints.VERTICAL//物件只充填滿長度
			gbc.fill = GridBagConstraints.BOTH;// 物件充滿網格
			gbc.gridwidth = 1;// 設定物件占用網格寬
			gbc.gridheight = 1;// 設定物件占用網格長
			gbc.weightx = 1;// 設定容器放大時物件相隔距離
			gbc.weighty = 1;// 設定容器放大時物件相隔距離
			gbc.insets = new Insets(3, 3, 3, 3);// 設定物件間的距離

			// add_btn
			gbc.gridx = 0;
			gbc.gridy = 0;
			center.add(btn_7, gbc);
			gbc.gridx = 1;
			gbc.gridy = 0;
			center.add(btn_8, gbc);
			gbc.gridx = 2;
			gbc.gridy = 0;
			center.add(btn_9, gbc);
			gbc.gridx = 3;
			gbc.gridy = 0;
			center.add(btn_div, gbc);
			gbc.gridx = 4;
			gbc.gridy = 0;
			center.add(btn_undo, gbc);
			// ---------
			gbc.gridx = 0;
			gbc.gridy = 1;
			center.add(btn_4, gbc);
			gbc.gridx = 1;
			gbc.gridy = 1;
			center.add(btn_5, gbc);
			gbc.gridx = 2;
			gbc.gridy = 1;
			center.add(btn_6, gbc);
			gbc.gridx = 3;
			gbc.gridy = 1;
			center.add(btn_mul, gbc);
			gbc.gridx = 4;
			gbc.gridy = 1;
			center.add(btn_clear, gbc);
			// ---------
			gbc.gridx = 0;
			gbc.gridy = 2;
			center.add(btn_1, gbc);
			gbc.gridx = 1;
			gbc.gridy = 2;
			center.add(btn_2, gbc);
			gbc.gridx = 2;
			gbc.gridy = 2;
			center.add(btn_3, gbc);
			gbc.gridx = 3;
			gbc.gridy = 2;
			center.add(btn_min, gbc);
			// ---------
			gbc.gridx = 0;
			gbc.gridy = 3;
			center.add(btn_0, gbc);
			gbc.gridx = 1;
			gbc.gridy = 3;
			center.add(btn_00, gbc);
			gbc.gridx = 2;
			gbc.gridy = 3;
			center.add(btn_point, gbc);
			gbc.gridx = 3;
			gbc.gridy = 3;
			center.add(btn_add, gbc);
			// ---------
			gbc.gridx = 4;
			gbc.gridy = 2;
			gbc.gridheight = 2;
			center.add(btn_equals, gbc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void btn_init() {
		try {
			// btn_init
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
			btn_add = new JButton("➕");
			btn_min = new JButton("➖");
			btn_mul = new JButton("✖");
			btn_div = new JButton("➗");
			btn_undo = new JButton("←");
			btn_equals = new JButton("=");
			btn_clear = new JButton("AC");
			btn_point = new JButton(".");
			// set_border
			btn_0.setBorder(BorderFactory.createRaisedBevelBorder());
			btn_00.setBorder(BorderFactory.createRaisedBevelBorder());
			btn_1.setBorder(BorderFactory.createRaisedBevelBorder());
			btn_2.setBorder(BorderFactory.createRaisedBevelBorder());
			btn_3.setBorder(BorderFactory.createRaisedBevelBorder());
			btn_4.setBorder(BorderFactory.createRaisedBevelBorder());
			btn_5.setBorder(BorderFactory.createRaisedBevelBorder());
			btn_6.setBorder(BorderFactory.createRaisedBevelBorder());
			btn_7.setBorder(BorderFactory.createRaisedBevelBorder());
			btn_8.setBorder(BorderFactory.createRaisedBevelBorder());
			btn_9.setBorder(BorderFactory.createRaisedBevelBorder());
			btn_add.setBorder(BorderFactory.createRaisedBevelBorder());
			btn_min.setBorder(BorderFactory.createRaisedBevelBorder());
			btn_mul.setBorder(BorderFactory.createRaisedBevelBorder());
			btn_div.setBorder(BorderFactory.createRaisedBevelBorder());
			btn_undo.setBorder(BorderFactory.createRaisedBevelBorder());
			btn_equals.setBorder(BorderFactory.createRaisedBevelBorder());
			btn_clear.setBorder(BorderFactory.createRaisedBevelBorder());
			btn_point.setBorder(BorderFactory.createRaisedBevelBorder());
			// setFont
			btn_0.setFont(new Font("宋體", Font.PLAIN, 16));
			btn_00.setFont(new Font("宋體", Font.PLAIN, 16));
			btn_1.setFont(new Font("宋體", Font.PLAIN, 16));
			btn_2.setFont(new Font("宋體", Font.PLAIN, 16));
			btn_3.setFont(new Font("宋體", Font.PLAIN, 16));
			btn_4.setFont(new Font("宋體", Font.PLAIN, 16));
			btn_5.setFont(new Font("宋體", Font.PLAIN, 16));
			btn_6.setFont(new Font("宋體", Font.PLAIN, 16));
			btn_7.setFont(new Font("宋體", Font.PLAIN, 16));
			btn_8.setFont(new Font("宋體", Font.PLAIN, 16));
			btn_9.setFont(new Font("宋體", Font.PLAIN, 16));
			btn_add.setFont(new Font("宋體", Font.PLAIN, 16));
			btn_min.setFont(new Font("宋體", Font.PLAIN, 16));
			btn_mul.setFont(new Font("宋體", Font.PLAIN, 16));
			btn_div.setFont(new Font("宋體", Font.PLAIN, 16));
			btn_undo.setFont(new Font("宋體", Font.PLAIN, 16));
			btn_equals.setFont(new Font("宋體", Font.PLAIN, 16));
			btn_clear.setFont(new Font("宋體", Font.PLAIN, 16));
			btn_point.setFont(new Font("宋體", Font.PLAIN, 16));
			// addActionListener
			btn_0.addActionListener(this);
			btn_00.addActionListener(this);
			btn_1.addActionListener(this);
			btn_2.addActionListener(this);
			btn_3.addActionListener(this);
			btn_4.addActionListener(this);
			btn_5.addActionListener(this);
			btn_6.addActionListener(this);
			btn_7.addActionListener(this);
			btn_8.addActionListener(this);
			btn_9.addActionListener(this);
			btn_add.addActionListener(this);
			btn_min.addActionListener(this);
			btn_mul.addActionListener(this);
			btn_div.addActionListener(this);
			btn_undo.addActionListener(this);
			btn_equals.addActionListener(this);
			btn_clear.addActionListener(this);
			btn_point.addActionListener(this);
			// setActionCommand
			btn_0.setActionCommand("0");
			btn_00.setActionCommand("00");
			btn_1.setActionCommand("1");
			btn_2.setActionCommand("2");
			btn_3.setActionCommand("3");
			btn_4.setActionCommand("4");
			btn_5.setActionCommand("5");
			btn_6.setActionCommand("6");
			btn_7.setActionCommand("7");
			btn_8.setActionCommand("8");
			btn_9.setActionCommand("9");
			btn_add.setActionCommand("+");
			btn_min.setActionCommand("-");
			btn_mul.setActionCommand("*");
			btn_div.setActionCommand("/");
			btn_undo.setActionCommand("undo");
			btn_equals.setActionCommand("=");
			btn_clear.setActionCommand("C");
			btn_point.setActionCommand(".");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void log_init() {
		try {
			log = new JLabel("", JLabel.RIGHT);// 文字靠右顯示
			log.setPreferredSize(new Dimension(480, 100));// 設置標籤寬高
			// log.setHorizontalTextPosition(JLabel.RIGHT);// 設置標籤文字在水平方向的對齊方式
			// log.setVerticalTextPosition(JLabel.CENTER);// 設置標籤文字在垂直方向的對齊方式
			log.setFont(new Font("宋體", Font.PLAIN, 36));// 設置文字大小
			log.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 15));// 設置留白
			log.setOpaque(true);// 設置不透明
			log.setBackground(Color.WHITE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new calculator();
	}

}
