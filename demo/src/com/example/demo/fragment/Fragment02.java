package com.example.demo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.demo.R;
import com.example.demo.adapter.HorizontalListViewAdapter;
import com.example.demo.adapter.ViewPagerAdapter;
import com.example.demo.utils.HorizontalListView;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class Fragment02 extends Fragment {

	private View view;
	private ViewPagerAdapter adapter;
	private ViewPager viewpager;
	private HorizontalListView listview;
	String[] titles = {"","","   今日上新", "   已开抢", "   开抢中", "  即将开始", "   昨日上新","",""};
	
	private HorizontalListViewAdapter hListViewAdapter;

	public Fragment02() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_fragment02, container, false);
		
		initView();
		
		setOnlistener();
		adapter = new ViewPagerAdapter(getChildFragmentManager());
		viewpager.setAdapter(adapter);
		hListViewAdapter = new HorizontalListViewAdapter(getActivity(),titles);  
		listview.setAdapter(hListViewAdapter); 
		
		viewpager.setCurrentItem(2);
		hListViewAdapter.setSelectIndex(4);
		listview.setSelection(4);
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
					switch (position) {
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
					}
				}
			});
			
			
			viewpager.setOnPageChangeListener(new OnPageChangeListener() {
				
				private int preItem = 2;

				@Override
				public void onPageSelected(int position) {
					switch (position) {
					case 0:
						listview.setSelection(position - 2);
						break;
					case 1:
						listview.setSelection(position - 2);
						break;
					case 2:
						listview.setSelection(position - 2);
						break;
					case 3:
						listview.setSelection(position - 2);
						break;
					case 4:
						listview.setSelection(position - 2);
						break;
					}
					hListViewAdapter.setSelectIndex(position + 2);
					hListViewAdapter.notifyDataSetChanged();
					
				}
				
				@Override
				public void onPageScrolled(int arg0, float arg1, int arg2) {
					
				}
				
				@Override
				public void onPageScrollStateChanged(int arg0) {
					
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void initView() {
		
		viewpager = (ViewPager) view.findViewById(R.id.viewpager);
		listview = (HorizontalListView) view.findViewById(R.id.horizontallistview);

	}

}
