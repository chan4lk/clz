package com.chan4lk.lesson2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainScreenActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_screen);
		final Intent i = new Intent(MainScreenActivity.this,SecondActivity.class);
		
		new Thread(){
			public void run(){
				try{
					Thread.sleep(5000);
					startActivity(i);
				}
				catch (Exception e) {
					// TODO: handle exception
				}
				finally{
				
				}
			}
			
		}.start();
		
		this.finish();
		
		/*Thread t = new Thread();
		t.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			//Thread.stop();
			startActivity(i);	
			this.finish();
		}*/
	}

	
}
