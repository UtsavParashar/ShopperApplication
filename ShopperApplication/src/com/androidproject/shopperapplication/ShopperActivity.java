package com.androidproject.shopperapplication;

import android.support.v4.app.Fragment;


public class ShopperActivity extends SingleFragmentShopperActivity {

	@Override
	protected Fragment createFragment() {
		// TODO Auto-generated method stub
		return new ShopperLoginFragment();
	}


    
}
