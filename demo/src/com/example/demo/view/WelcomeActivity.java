package com.example.demo.view;

import org.json.JSONException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.example.demo.R;
import com.example.demo.utils.Data;
import com.example.demo.utils.ParceJson;
import com.ta.util.http.AsyncHttpClient;
import com.ta.util.http.AsyncHttpResponseHandler;

public class WelcomeActivity extends Activity {
	
	private AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
	private static final String THINKANDROIDURL = "http://www.duitang.com/album/1733789/masn/p/1/24/";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		Data.height = wm.getDefaultDisplay().getHeight();
		Data.width = wm.getDefaultDisplay().getWidth();
		loadData();
		setay();
		
	}
	private void loadData() {
    	asyncHttpClient.get(THINKANDROIDURL, new AsyncHttpResponseHandler()
		{

			@Override
			public void onSuccess(String content)
			{
				try 
				{
					ParceJson.parseGoodEntity(content);
				} catch (JSONException e) 
				{
					e.printStackTrace();
				}
				super.onSuccess(content);
				
			}
		});
    	
	}
	
	private void setay() {
		Handler h = new Handler();
		h.postDelayed(new Runnable() {
			@Override
			public void run() {
				startActivity(new Intent(WelcomeActivity.this,MainActivity.class));	
				finish();
			}
		}, 3000);
	}
	
}
