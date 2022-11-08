package com.synct.james;

public class Bike {

	public double speed;
	public String color;// 屬性
	
	public Bike() {
		color = "BLUE";
		speed = 0;
		System.out.println("now speed=>" + speed);
	}
	
	public Bike(double i) {
		color = "YELLO";
		speed = i;
		System.out.println("now speed=>" + speed);
	}

	public void UpSpeed() {
		speed = speed < 1 ? 1 : speed * 1.2;
	}

	public void DownSpeed() {
		speed = speed < 1 ? 1 : speed * 0.6;
	}

	public double getSpeed() {
		return speed;

	}

	public String toString() {
		return "Bike:" + speed;
	}

}
