package com.example.demo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.demo.fragment.TimerFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter{
	



	public ViewPagerAdapter(FragmentManager fm) {
		super(fm);
	}
	
	@Override
	public Fragment getItem(int position) {
		switch (position) {
		case 0:
			return new TimerFragment();
		case 1:
			return new TimerFragment();
		case 2:
			return new TimerFragment();
		case 3:
			return new TimerFragment();
		case 4:
			return new TimerFragment();
		}
		return null;
	}

	@Override
	public int getCount() {
		return 5;
	}

}
