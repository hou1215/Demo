package com.example.demo.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Boxes extends View{
	
	Paint paint = new Paint();
	private float scale;
	

	public Boxes(Context context, AttributeSet attrs) {
		super(context, attrs,0);
	}
	
	public Boxes(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		
	}
	
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		float xStart = (Data.width / 5 * 2);
		float xEnd =  (Data.width / 5 * 3);
		float yStart = 0;
		float yEnd = 100;
		paint.setColor(Color.parseColor("#90FF0000"));
		paint.setStyle(Paint.Style.FILL_AND_STROKE);
		paint.setAntiAlias(true); 
		canvas.drawRect(xStart,yStart,xEnd,yEnd,paint);
		
	}

}
