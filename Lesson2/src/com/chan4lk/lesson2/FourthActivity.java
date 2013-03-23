package com.chan4lk.lesson2;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FourthActivity extends Activity implements OnClickListener {

	EditText numTxt;
	EditText messageTxt;
	String number;
	String message;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fourth_screen);
		
		Button okBtn = (Button)findViewById(R.id.ok_btn_fs);
		Button sendBtn = (Button)findViewById(R.id.send_btn_fs);
		
		numTxt = (EditText)findViewById(R.id.et_num_fs);
		messageTxt = (EditText)findViewById(R.id.et_message_fs);
		
		number = getIntent().getExtras().getString("number");
		message = getIntent().getExtras().getString("message");
		
		//numTxt.setText(SecondActivity.dialNum);
		//messageTxt.setText(ThirdActivity.myMessage);
		
		numTxt.setText(number);
		messageTxt.setText(message);
		
		okBtn.setOnClickListener(this);
		sendBtn.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ok_btn_fs:
			SmsManager smsManager = SmsManager.getDefault();
			smsManager.sendTextMessage(number, null, message, null, null);			
			Toast.makeText(getApplicationContext(), "Message Sent", Toast.LENGTH_LONG).show();
			
			break;
		case R.id.send_btn_fs:
			Intent intentt = new Intent(Intent.ACTION_VIEW);
			intentt.setData(Uri.parse(message));
			intentt.setType("vnd.android-dir/mms-sms");
            intentt.putExtra(Intent.EXTRA_TEXT, "");
            intentt.putExtra("address", number);
            getApplicationContext().startActivity(intentt);

			break;
		default:
			numTxt.setText("");
			messageTxt.setText("");
			break;
		}
		
		
	}

	
}
