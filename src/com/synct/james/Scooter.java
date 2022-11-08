package com.synct.james;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

//extends繼承bike
public class Scooter extends Bike {
	private int speed;// 屬性
	private String color;// 屬性

	// 建構式無參數
	public Scooter() {
		//在建構式中this & super 要在第一行且只能擇一,否則會有錯誤
		
		//this 應用
		// 呼叫自己的建構式
		this(2);
		// 呼叫自己的屬性
		System.out.println("摩托車顏色=>" + this.color);
		System.out.println("摩托車速度=>" + this.speed);
		// 呼叫自己的方法
		this.engine_star();
		
		/*
		//super 應用
		// 呼叫父類別的建構式
		super();
		//super(10);
		// 呼叫父類別的屬性
		System.out.println("腳踏車顏色=>" + super.color);
		// 呼叫父類別的方法
		System.out.println(super.toString());
		*/
	}
	// 有傳參數建構式
	public Scooter(int i) {
		this.color = "RED";
		this.speed = 0;
	}
	// 自己寫的方法
	public void engine_star() {
		System.out.println("車子發動");
	}
	// 程式執行點
	public static void main(String[] args) {
		Scooter st = new Scooter();// new 出物件
	}

}
