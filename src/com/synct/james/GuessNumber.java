package com.synct.james;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuessNumber extends JFrame implements ActionListener {
	private JButton guess;
	private JTextField input;
	private JTextArea log;
	private String answer;
	private int counter;

	public GuessNumber() {
		super("猜數字遊戲");//使用父類別的建構式

		guess = new JButton("猜");
		input = new JTextField();
		log = new JTextArea();

		setLayout(new BorderLayout());//父類別JFrame的方法,設定版面樣式

		JPanel top = new JPanel(new BorderLayout());//控制版
		top.add(input, BorderLayout.CENTER);
		top.add(guess, BorderLayout.EAST);

		add(top, BorderLayout.NORTH);//JFrame的父類別java.awt.Container的方法
		add(log, BorderLayout.CENTER);//JFrame的父類別java.awt.Container的方法

		guess.addActionListener(this);
		//guess.setActionCommand("d1");//設定動作的代號

		setSize(640, 480);//JFrame的父類別java.awt.Window的方法
		setVisible(true);//JFrame的父類別java.awt.Window的方法
		setDefaultCloseOperation(EXIT_ON_CLOSE);//父類別JFrame的方法

		newRound();
	}

	public static void main(String[] args) {

		new GuessNumber();
	}

	private void newRound() {
		answer = createAnswer(3);
		counter = 0;
		log.setText("");
		// System.out.println(answer);
	}

	private String createAnswer(int dig) {
		//int陣列初始化
		int nums = 10;
		int[] poker = new int[nums];
		for (int i = 0; i < nums; i++) {
			poker[i] = i;//0~9
		}
			
		//陣列洗牌(隨機換位,倆倆交換)
		for (int i = nums - 1; i > 0; i--) {
			int rand = (int) (Math.random() * (i + 1));
			// poker[rand] <-> poker[i]
			int temp = poker[rand];
			poker[rand] = poker[i];
			poker[i] = temp;
		}
		
		//取前幾位數字
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < dig; i++) {
			sb.append(poker[i]);
		}

		return sb.toString();
	}

	//將介面 ActionListener 實做Override 出來的方法
	@Override
	public void actionPerformed(ActionEvent e) {
		//JButton的addActionListener被觸發就會執行
		//String cmd = e.getActionCommand();//可取得按鈕的動作的代號
		System.out.println("");
		counter++;
		
		String result = checkAB();
		log.append(counter + ". " + input.getText() + ":" + result + "\n");
		if (result.equals("3A0B")) {
			JOptionPane.showMessageDialog(null, "恭喜老爺");
			newRound();
		} else if (counter == 10) {
			JOptionPane.showMessageDialog(null, "魯蛇:" + answer);
			newRound();
		}

		input.setText("");
	}

	private String checkAB() {
		int a, b;
		a = b = 0;
		String gString = input.getText();
		
		//尋訪answer進行各字元比較
		for (int i = 0; i < answer.length(); i++) {
			char ac = answer.charAt(i);
			char gc = gString.charAt(i);
			
			if (ac == gc) {
				//數字與位置相同
				a++;
			} else if (answer.indexOf(gc) >= 0) {
				//有數字,位置不同
				b++;
			}
		}
		return String.format("%dA%dB", a, b);
	}

}
