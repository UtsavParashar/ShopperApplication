package com.androidproject.shopperapplication;

import java.util.UUID;

public class ShopperModel {
	private UUID mId;
	private String mPhoneNumber;
	private String mRandomNumber;
	
	public ShopperModel(){
		mId = UUID.randomUUID();
	}

	public String getPhoneNumber() {
		return mPhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		mPhoneNumber = phoneNumber;
	}

	public UUID getId() {
		return mId;
	}
	
	public void setRandomNumber(){
		mRandomNumber = String.valueOf((int) (Math.random() * 9999) + 1000);
	}
	
	public String getRandomNumber(){
		return mRandomNumber;
	}
}
