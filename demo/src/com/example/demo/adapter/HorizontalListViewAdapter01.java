package com.example.demo.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.demo.R;
import com.example.demo.fragment.Fragment04;
import com.example.demo.utils.Data;
  
public class HorizontalListViewAdapter01 extends BaseAdapter{  
    private List<String> mTitles;  
    private Context mContext;  
    private LayoutInflater mInflater;  
    private int selectIndex = -1;  
  
    public HorizontalListViewAdapter01(Context context, List<String> titles){  
        this.mContext = context;  
        this.mTitles = titles;  
        mInflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);//LayoutInflater.from(mContext);  
    }  
    @Override  
    public int getCount() {  
        return mTitles.size();  
    }  
    @Override  
    public Object getItem(int position) {  
        return position;  
    }  
  
    @Override  
    public long getItemId(int position) {  
        return position;  
    }  
  
    @Override  
    public View getView(int position, View convertView, ViewGroup parent) {  
  
    	Fragment04.lastIndex = position;

    	ViewHolder holder;  
        if(convertView==null){  
            holder = new ViewHolder();  
            convertView = mInflater.inflate(R.layout.c_text, null);  
            holder.mTitle = (TextView)convertView.findViewById(R.id.textView1);  
            changeView(holder.mTitle);
            convertView.setTag(holder);  
        }else{  
            holder = (ViewHolder)convertView.getTag();  
        } 
        
        if(position == selectIndex){  
            convertView.setSelected(true); 
            holder.mTitle.setTextColor(Color.parseColor("#000000"));
        }else{  
            convertView.setSelected(false);  
            holder.mTitle.setTextColor(Color.parseColor("#CDCDCD"));
        }  
          
        holder.mTitle.setText(mTitles.get(position));  
        
        if (holder.mTitle.getText().toString().equals("   ¿ªÇÀÖÐ")) {
        	Fragment04.index = position;
		}
        return convertView;  
    }  
    private void changeView(View view){
    	RelativeLayout.LayoutParams playParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        playParams.width = Data.width/5-10;
        view.setLayoutParams(playParams);
	}
    private static class ViewHolder {  
        private TextView mTitle ;  
    }  
      
    public void setSelectIndex(int i){  
        selectIndex = i;  
    }  
}
