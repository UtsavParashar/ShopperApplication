package com.androidproject.shopperapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ShopperVerificationFragment extends Fragment {
	
	private ShopperModel mShopperModel = new ShopperModel();
	
	private EditText mVerificationEditText;
	private Button mVerificationSubmitButton;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		View v = inflater.inflate(R.layout.fragment_verification, container, false);
		
		mVerificationEditText = (EditText) v.findViewById(R.id.verification_verification_code_editText);
		
		mVerificationSubmitButton = (Button)v.findViewById(R.id.verification_submit_button);
		mVerificationSubmitButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String mGeneratedCode = mShopperModel.getRandomNumber();
				String mUserCode =  mVerificationEditText.getText().toString();
				
				if(mGeneratedCode.equals(mUserCode)){
					Toast.makeText(getActivity(),"Successful", Toast.LENGTH_LONG).show();
				}else{
					Toast.makeText(getActivity(), R.string.verification_code_not_match_toast, Toast.LENGTH_LONG).show();
				}
			}
		});	
		return v;
	}
}
