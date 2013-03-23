package com.chan4lk.lesson2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThirdActivity extends Activity implements OnClickListener {

	EditText message;
	String number;
	public static String myMessage;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.third_screen);
		number=getIntent().getExtras().getString("number");
		message = (EditText) findViewById(R.id.et_num_ts);
		//message.setText(SecondActivity.dialNum);
		Button ok_btn = (Button) findViewById(R.id.ok_btn_ts);
		ok_btn.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.third_screen, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		Intent fs  = new Intent(ThirdActivity.this,FourthActivity.class);
		String msg = message.getText().toString();
		myMessage = msg;
		fs.putExtra("number", number);
		fs.putExtra("message", msg);
		startActivity(fs);
		
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
		
		
	}

}
