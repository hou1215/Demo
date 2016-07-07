package com.example.demo.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.demo.R;
import com.example.demo.adapter.HorizontalListViewAdapter01;
import com.example.demo.adapter.ViewPagerAdapter;
import com.example.demo.utils.HorizontalListView;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class Fragment04 extends Fragment {

	public static int index = 2;
	public static int lastIndex = 4;
	private View view;
	private ViewPagerAdapter adapter;
	private ViewPager viewpager;
	private HorizontalListView listview;
	private String[] titles = {"","","   今日上新", "   已开抢", "   开抢中", "  即将开始", "   昨日上新","",""};
	private List<String> list = new ArrayList<String>();
	
	private HorizontalListViewAdapter01 hListViewAdapter;

	public Fragment04() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_fragment02, container, false);
		
		initView();
		
		setOnlistener();
		adapter = new ViewPagerAdapter(getChildFragmentManager());
		viewpager.setAdapter(adapter);
		hListViewAdapter = new HorizontalListViewAdapter01(getActivity(),list);  
		listview.setAdapter(hListViewAdapter); 
		
		viewpager.setCurrentItem(2);
		hListViewAdapter.setSelectIndex(2);
		return view;
	}
	
	@SuppressWarnings("deprecation")
	private void setOnlistener() {
		try 
		{
			listview.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					/*switch (position) {
					case 2:
						viewpager.setCurrentItem(position - 2);
						break;
					case 3:
						viewpager.setCurrentItem(position - 2);
						break;
					case 4:
						viewpager.setCurrentItem(position - 2);
						break;
					case 5:
						viewpager.setCurrentItem(position - 2);
						break;
					case 6:
						viewpager.setCurrentItem(position - 2);
						break;
					}*/
				}
			});
			viewpager.setOnPageChangeListener(new OnPageChangeListener() {
				private int preItem = 2;
				@Override
				public void onPageSelected(int position) {
					if (list.size() == 5) {
						switch (position) {
						case 0:
							listview.setSelection(position);
							break;
						case 1:
							listview.setSelection(position);
							break;
						case 2:
							listview.setSelection(position);
							break;
						case 3:
							listview.setSelection(position);
							break;
						case 4:
							listview.setSelection(position);
							break;
						}
					}
					if (list.size() == 9) {
						initList5(lastIndex);
						hListViewAdapter.notifyDataSetChanged();
						switch (position) {
						case 0:
							listview.setSelection(position + 2);
							break;
						case 1:
							listview.setSelection(position + 2);
							break;
						case 2:
							listview.setSelection(position + 2);
							break;
						case 3:
							listview.setSelection(position + 2);
							break;
						case 4:
							listview.setSelection(position + 2);
							break;
						}
					}
					
					
					if(position == preItem ){
						//不作处理
						}
						if(position > preItem){
						//从左向右滑
							
							list.remove(0);
							list.add(titles[position + 4]);
							
						preItem = position;
						}
						if(position < preItem){
						//从右向左滑
							
							list.remove(list.size() - 1);
							list.add(0, titles[position]);
							
						preItem = position;
					}
						
						
					hListViewAdapter.setSelectIndex(2);
					hListViewAdapter.notifyDataSetChanged();
					
				}
				
				@Override
				public void onPageScrolled(int arg0, float arg1, int arg2) {
					
				}
				
				@Override
				public void onPageScrollStateChanged(int arg0) {
					
				}
			});
			listview.setOnTouchListener(new OnTouchListener() {
				
				private float x_tmp1;
				private float y_tmp1;
				private float x_tmp2;
				private float y_tmp2;

				@Override
				public boolean onTouch(View v, MotionEvent event) {
					
				    float x = event.getX();  
			        float y = event.getY(); 
			        
					switch (event.getAction()) {
					case MotionEvent.ACTION_DOWN:
						
						x_tmp1 = x;  
		                y_tmp1 = y;  
		                
						if (list.size() == 5) {
							initList07();
							hListViewAdapter.setSelectIndex(lastIndex - 2);
							hListViewAdapter.notifyDataSetChanged();
						}
						
						break;
					case MotionEvent.ACTION_MOVE:
						x_tmp2 = x;  
		                y_tmp2 = y;  
		                /*if(x_tmp1 != 0 && y_tmp1 != 0){  
		                    if(x_tmp1 - x_tmp2 > 8){  
		                    	
		                    }  
		                    if(x_tmp2 - x_tmp1 > 8){  
		                    	
		                    }  
		                }*/  
						break;
					case MotionEvent.ACTION_UP:
						hListViewAdapter.notifyDataSetChanged();
						
						Log.i("tag", "lastIndex = "+lastIndex);
						
						viewpager.setCurrentItem(lastIndex - 4);
						hListViewAdapter.setSelectIndex(lastIndex - 2);
						hListViewAdapter.notifyDataSetChanged();
						break;
					}
					
					return false;
				}

				
			});
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void initView() {
		viewpager = (ViewPager) view.findViewById(R.id.viewpager);
		listview = (HorizontalListView) view.findViewById(R.id.horizontallistview);

		initList05(4);
		
	}
	private void initList5(int lastIndex) {
		list.clear();
		list.add(titles[lastIndex - 4]);
		list.add(titles[lastIndex - 3]);
		list.add(titles[lastIndex - 2]);
		list.add(titles[lastIndex - 1]);
		list.add(titles[lastIndex    ]);
		
	}
	private void initList05(int index) {
		list.clear();
		list.add(titles[index - 2]);
		list.add(titles[index - 1]);
		list.add(titles[index]);
		list.add(titles[index + 1]);
		list.add(titles[index + 2]);
		
	}
	private void initList07() {
		list.clear();
		list.add(titles[0]);
		list.add(titles[1]);
		list.add(titles[2]);
		list.add(titles[3]);
		list.add(titles[4]);
		list.add(titles[5]);
		list.add(titles[6]);
		list.add(titles[7]);
		list.add(titles[8]);
		
	}

}
