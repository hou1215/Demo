package com.example.demo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.demo.R;
import com.example.demo.utils.Data;
  
public class HorizontalListViewAdapter extends BaseAdapter{  
    private String[] mTitles;  
    private Context mContext;  
    private LayoutInflater mInflater;  
    private int selectIndex = -1;  
  
    public HorizontalListViewAdapter(Context context, String[] titles){  
        this.mContext = context;  
        this.mTitles = titles;  
        mInflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);//LayoutInflater.from(mContext);  
    }  
    @Override  
    public int getCount() {  
        return mTitles.length;  
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
  
        ViewHolder holder;  
        if(convertView==null){  
            holder = new ViewHolder();  
            convertView = mInflater.inflate(R.layout.c_text, null);  
            holder.mTitle = (TextView)convertView.findViewById(R.id.textView1);  
            changeView(holder.mTitle);
            convertView.setTag(holder);  
        }else{  
            holder=(ViewHolder)convertView.getTag();  
        }  
        if(position == selectIndex){  
            convertView.setSelected(true); 
            holder.mTitle.setTextColor(Color.parseColor("#000000"));
        }else{  
            convertView.setSelected(false);  
            holder.mTitle.setTextColor(Color.parseColor("#CDCDCD"));
        }  
          
        holder.mTitle.setText(mTitles[position]);  
  
        return convertView;  
    }  
    private void changeView(View view){
    	RelativeLayout.LayoutParams playParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        playParams.width = Data.width/5-20;
        view.setLayoutParams(playParams);
	}
    private static class ViewHolder {  
        private TextView mTitle ;  
    }  
      
    public void setSelectIndex(int i){  
        selectIndex = i;  
    }  
}
