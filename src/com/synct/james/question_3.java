package com.synct.james;

import java.math.BigDecimal;
import java.util.Scanner;

public class question_3 {
	// 提醒使用者請輸入梯形的上底、下底與高(數字間以空格隔開)
	// 2.計算梯型面(上底+下底)*高/2
	// 3.輸出梯型面積
	private static double topline;
	private static double baseline;
	private static double height;
	private static double trapezoidal_area;

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.println("請輸入梯形的上底、下底與高:");

		topline = scn.nextDouble();
		baseline = scn.nextDouble();
		height = scn.nextDouble();

		trapezoidal_area = (topline + baseline) * height / 2;
		BigDecimal b = new BigDecimal(trapezoidal_area);
		
		trapezoidal_area = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println("您輸入梯形的上底為:" + topline);
		System.out.println("您輸入梯形的下底為:" + baseline);
		System.out.println("您輸入梯形的高為:" + height);
		System.out.println("梯形的面積為:" + trapezoidal_area);
	}

}
