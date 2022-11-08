package com.synct.james;

public class Jim08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] poker = new int[52]; 

		long start = System.currentTimeMillis();

		for (int i = 0; i < poker.length; i++) {//尋訪poker陣列

			int rand = (int) (Math.random() * 52); //產生隨機0~51的亂數牌
			
			// 檢查機制
			boolean isDup = false;
			//先檢查poker陣列裡的牌是否有與目前的rand牌有重複
			for (int j = 0; j < i; j++) {
				if (poker[j] == rand) {
					isDup = true;
					break;
				}
			}

			if (!isDup) {
				//rand若無與之前的牌重複就放入poker陣列
				poker[i] = rand;
				System.out.println("第"+i+"張牌=>"+poker[i]);
			} else {
				//若有重複就倒退上一動
				i--;
			}
			
		}
		System.out.println("------");
		//System.out.println(System.currentTimeMillis() - start);
	}
}
