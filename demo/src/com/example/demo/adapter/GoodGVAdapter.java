package com.example.demo.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.demo.R;
import com.example.demo.Entity.GoodEntity;
import com.example.demo.utils.BitmapHelp;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.bitmap.BitmapCommonUtils;
import com.lidroid.xutils.bitmap.PauseOnScrollListener;

public class GoodGVAdapter extends BaseAdapter{
	
	private Context mContext;
	private List<GoodEntity> goods;
	private LayoutInflater inflater;
	private int Id;
	private int width;
	private int height;
	public static BitmapUtils bitmapUtils;

	public GoodGVAdapter(Context mContent,int Id,List<GoodEntity> goods,GridView list) {
		
		bitmapUtils = BitmapHelp.getBitmapUtils(mContent.getApplicationContext());
        bitmapUtils.configDefaultLoadingImage(R.drawable.juhuasuan);
        bitmapUtils.configDefaultLoadFailedImage(R.drawable.juhuasuan);
        bitmapUtils.configDefaultBitmapConfig(Bitmap.Config.RGB_565);

        //bitmapUtils.configMemoryCacheEnabled(false);
        //bitmapUtils.configDiskCacheEnabled(false);

        //bitmapUtils.configDefaultAutoRotation(true);

        //ScaleAnimation animation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,
        //        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        //animation.setDuration(800);

        // AlphaAnimation 在一些android系统上表现不正常, 造成图片列表中加载部分图片后剩余无法加载, 目前原因不明.
        // 可以模仿下面示例里的fadeInDisplay方法实现一个颜色渐变动画。
        //AlphaAnimation animation = new AlphaAnimation(0.0f, 1.0f);
        //animation.setDuration(1000);
        //bitmapUtils.configDefaultImageLoadAnimation(animation);

        // 设置最大宽高, 不设置时更具控件属性自适应.
        bitmapUtils.configDefaultBitmapMaxSize(BitmapCommonUtils.getScreenSize(mContent).scaleDown(3));

        // 滑动时加载图片，快速滑动时不加载图片
        list.setOnScrollListener(new PauseOnScrollListener(bitmapUtils, false, true));
		
        WindowManager wm = (WindowManager) mContent.getSystemService(Context.WINDOW_SERVICE);
        height = wm.getDefaultDisplay().getHeight();
        width = wm.getDefaultDisplay().getWidth();
        
		this.mContext = mContent;
		this.Id = Id;
		this.goods = goods;
		this.inflater = LayoutInflater.from(mContent);
	}

	@Override
	public int getCount() {
		return goods.size();
	}

	@Override
	public Object getItem(int position) {
		return goods.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		try
		{
			GoodEntity good = goods.get(position);
			ViewHolder holder = null;
			if (convertView == null) {
				holder = new ViewHolder();
				convertView = inflater.inflate(Id, null); 
				holder.tvMsg = (TextView) convertView.findViewById(R.id.good_name); 
	            holder.tvPrice = (TextView) convertView.findViewById(R.id.price);
	            holder.ivIsrc = (ImageView) convertView.findViewById(R.id.isrc); 
	            RelativeLayout.LayoutParams playParams = (RelativeLayout.LayoutParams) holder.ivIsrc.getLayoutParams();
	            playParams.width = width/2-40;
	            playParams.height = height/3;
	            holder.ivIsrc.setLayoutParams(playParams);
				
	            convertView.setTag(holder);
			}else {
				holder = (ViewHolder) convertView.getTag(); 
			}
			holder.tvMsg.setText(good.getMsg());
			holder.tvPrice.setText(good.getPrice()+"");
			holder.ivIsrc.setScaleType(ImageView.ScaleType.FIT_XY);
			bitmapUtils.display(holder.ivIsrc, good.getIsrc());
            //bitmapUtils.display((ImageView) view, imgSrcList.get(position), displayConfig);
            //bitmapUtils.display((ImageView) view, imgSrcList.get(position));
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		return convertView;
	}
	
	class ViewHolder
	{
		ImageView ivIsrc;
		TextView tvMsg;
		TextView tvPrice;
	}
	
}
