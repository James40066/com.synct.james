package com.synct.james;

import java.math.BigDecimal;
import java.util.Scanner;

public class question_1 {
	// 計算幾天的平均溫度
	// 1.提醒使用者:要計算幾天的平均溫度?
	// 2.使用者輸入幾天：n (3)
	// 3.使用者輸入N (3)天的溫度：23.5 30.1 25.8
	// 4.計算N (3)天的平均溫度至小數點後2位：26.47
	private static int days;
	private static float total;
	private static float ave;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("要計算幾天的平均溫度?");
		days = scn.nextInt();
		for (int i = 0; i < days; i++) {
			System.out.println("請輸入第" + (i + 1) + "天的溫度");
			total = total + scn.nextFloat();
		}
		ave = total / days;
		BigDecimal b = new BigDecimal(ave);
	    ave = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
		// b.setScale(2, BigDecimal.ROUND_HALF_UP) 表明四捨五入,保留兩位小數
		System.out.println(days + "天的平均溫度為=>" + ave);
	}

}
