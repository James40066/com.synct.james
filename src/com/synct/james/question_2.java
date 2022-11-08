package com.synct.james;

import java.math.BigDecimal;
import java.util.Scanner;

public class question_2 {
	// 計算標準體重
	// 提醒使用者輸入性別(1男生、2女生)?(整數變數 int)
	// 2.提醒使用者輸入身高(公分)?(浮點數變數 double)
	// 3.計算出標準體重
	// 男生：(身高-80)*0.7
	// 女生：(身高-70)*0.6
	private static int gender;
	private static double height;
	private static double Standard_weight;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("請輸入您的性別(1男生、2女生)");
		gender = scn.nextInt();

		System.out.println("請輸入您的身高(公分)");
		height = scn.nextDouble();

		if (gender == 1) {
			Standard_weight = (height - 80) * 0.7;
		} else {
			Standard_weight = (height - 70) * 0.6;
		}
		BigDecimal b = new BigDecimal(Standard_weight);
		Standard_weight = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

		System.out.println("您的性別為" + (gender == 1 ? "男" : "女") + "生");
		System.out.println("您的身高為" + height );
		System.out.println("您的標準體重應為=>" + Standard_weight);
	
	}
}
