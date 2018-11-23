package com.threechat.view.test;

public class RegTest {

	public static void main(String[] args) {
		String reg="^[A-Za-z0-9]{3,20}+$";
		System.out.println("111".matches(reg));
	}
}
