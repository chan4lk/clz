package com.chan4lk.lesson2;
/*
 * 
 * @author Chandima Ranaweera
 * @version 1.1
 * 
 */
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

public class SecondActivity extends Activity implements OnClickListener {
	EditText number;
	public static String dialNum;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_screen);
		
		number = (EditText) findViewById(R.id.et_txt_sc);
		Button button = (Button)findViewById(R.id.ok_btn_sc);
		//number.setText("717460432");
		
		button.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		dialNum = number.getText().toString();
		
		Toast.makeText(SecondActivity.this, R.string.my_toast, Toast.LENGTH_LONG).show();
	    Intent thirdIntend = new Intent(SecondActivity.this,ThirdActivity.class);
	    thirdIntend.putExtra("number", dialNum);
	    startActivity(thirdIntend);
		
		
	}

	

}
