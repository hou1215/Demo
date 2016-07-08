package com.example.demo.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.demo.R;
import com.example.demo.adapter.HorizontalTabAdapter;
import com.example.demo.fragment.Fragment01;
import com.example.demo.fragment.Fragment02;
import com.example.demo.fragment.Fragment03;
import com.example.demo.fragment.Fragment04;
import com.example.demo.utils.HorizontalListView;


public class MainActivity extends FragmentActivity {
	
	

    /**
     * mFragmentArray 用于存放 fragment 对象 ********************************************************
     */
    private Fragment[] mFragmentArray=new Fragment[4];
    /**
     * mSelectedIndex 选择的下标
     * mCurrentIndex 当前的下标
     */
    private int mSelectedIndex = 0,mCurrentIndex = 0;
    
    private HorizontalListView listview;
    private String[] titles = {"主页","最新","购物车","我的"};
    private int[] Ids = {R.drawable.iv01,R.drawable.iv03,R.drawable.iv05,R.drawable.iv07};
    private int[] Imgs = {R.drawable.iv02,R.drawable.iv04,R.drawable.iv06,R.drawable.iv08};
	private HorizontalTabAdapter adapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setView();
        
    }
    
	private void setView()
    {
		
		listview = (HorizontalListView) findViewById(R.id.horizontallistview);
		adapter = new HorizontalTabAdapter(this, titles, Ids,Imgs);
		listview.setAdapter(adapter);
		
        
        mFragmentArray[0] = new Fragment01();
        mFragmentArray[1] = new Fragment02();
        mFragmentArray[2] = new Fragment03();
        mFragmentArray[3] = new Fragment04();
        
        mCurrentIndex = 0;
        mSelectedIndex = 0;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.relativeLayout, mFragmentArray[mSelectedIndex]);
        transaction.commit();

        setOnListener();
		
	}
	

    private void setOnListener() {
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				 
				 switch (position)
	                {
	                    case 0:
	                        mSelectedIndex = 0;
	                        break;
	                    case 1:
	                        mSelectedIndex = 1;
	                        break;
	                    case 2:
	                        mSelectedIndex = 2;
	                        break;
	                    case 3:
	                        mSelectedIndex = 3;
	                        break;
	                }
	                if (mSelectedIndex != mCurrentIndex)
	                {
	                    //单击是别的按钮 container中的要变
	                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
	                    if (mFragmentArray[mSelectedIndex].isAdded() == false)
	                    {
	                        //没添加过就添加fragment
	                        transaction.add(R.id.relativeLayout, mFragmentArray[mSelectedIndex]);
	                    }
	                    transaction.hide(mFragmentArray[mCurrentIndex]);
	                    transaction.show(mFragmentArray[mSelectedIndex]);
	                    transaction.commit();


	                    mCurrentIndex = mSelectedIndex;
	                }
	                adapter.setSelectIndex(position);
	                adapter.notifyDataSetChanged();
			}
		});
		
		
	}


}
