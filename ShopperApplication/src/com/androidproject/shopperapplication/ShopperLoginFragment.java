package com.androidproject.shopperapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ShopperLoginFragment extends Fragment {

	private final String TAG = "ShopperApplication";

	private ShopperModel mShopperModel = new ShopperModel();

	private EditText mPhoneNumberEditText;
	private Button mLoginSubmitButton;

	/*
	 * sendSMS method is used to Send Message to the user with verification
	 * code. If sending message is successful, focus will go to Verification
	 * View. If not, focus will remain in current Activity.
	 */
	private boolean sendSMS(String phoneNumber) {
		Log.v(TAG, "inside sendSMS");
		mShopperModel.setRandomNumber();
		String msgText = "Application Name, verification code : "
				+ mShopperModel.getRandomNumber();
		boolean smsSentSuccessfully = false;

		try {

			SmsManager smsManager = SmsManager.getDefault();
			smsManager.sendTextMessage(phoneNumber, null, msgText, null, null);
			Toast.makeText(getActivity(), R.string.sms_sent_verification_code,
					Toast.LENGTH_SHORT).show();
			smsSentSuccessfully = true;
		} catch (Exception e) {
			Toast.makeText(getActivity(), R.string.sms_sending_failed,
					Toast.LENGTH_SHORT).show();
			smsSentSuccessfully = false;
		}
		return smsSentSuccessfully;
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		View v = inflater.inflate(R.layout.fragment_login, container, false);

		mPhoneNumberEditText = (EditText) v
				.findViewById(R.id.login_phone_number_editText);

		mLoginSubmitButton = (Button) v.findViewById(R.id.login_submit_button);
		mLoginSubmitButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (mPhoneNumberEditText.getText().toString().length() != 10) {
					Toast.makeText(getActivity(), R.string.phone_number_digits,
							Toast.LENGTH_SHORT).show();
				} else {
					// Log.v(TAG, "inside onClick");
					String phoneNumber = mPhoneNumberEditText.getText()
							.toString();
					// Log.v(TAG, phoneNumber);

					mShopperModel.setPhoneNumber(phoneNumber);
					boolean successStatus = sendSMS(phoneNumber);
					if (successStatus) {
						Intent mLoginIntent = new Intent(getActivity(),
								ShopperVerificationActivity.class);
						startActivity(mLoginIntent);
					}

				}
			}
		});

		return v;
	}
}
