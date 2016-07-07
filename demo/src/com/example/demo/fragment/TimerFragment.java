package com.example.demo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.demo.R;
import com.example.demo.adapter.GoodGVAdapter;
import com.example.demo.utils.Data;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class TimerFragment extends Fragment {

	private View view;
	private GridView gv;
	private GoodGVAdapter adapter;

	public TimerFragment() {
	}
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_timer, container, false);
		
		gv = (GridView) view.findViewById(R.id.good);
		adapter = new GoodGVAdapter(getActivity(),R.layout.good_grid, Data.goods,gv);
		gv.setAdapter(adapter);
		
		return view;
	}

}
