package com.example.demo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.demo.R;
import com.example.demo.adapter.GoodAdapter;
import com.example.demo.utils.Data;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class Fragment01 extends Fragment {
	
	
	private View view;
	private ListView list;
	private GoodAdapter adapter;
	
	public Fragment01() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_fragment01, container, false);
		list = (ListView) view.findViewById(R.id.list);
		
		adapter = new GoodAdapter(getActivity(),R.layout.good_list, Data.goods,list);
		list.setAdapter(adapter);
		return view;
	}

}
