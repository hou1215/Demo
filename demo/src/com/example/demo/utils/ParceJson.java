package com.example.demo.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.example.demo.Entity.GoodEntity;

public class ParceJson {
	public static void parseGoodEntity(String json) throws JSONException {
		JSONObject  dataJson = new JSONObject(json);
		JSONObject  showapi_res_body = dataJson.getJSONObject("data");
		JSONArray  pagebean = showapi_res_body.getJSONArray("blogs");
		
		for (int i = 0; i < pagebean.length(); i++) {

			JSONObject object = pagebean.getJSONObject(i);
			GoodEntity good = new GoodEntity();
			
			good.setMsg(object.getString("msg"));
			good.setGood(object.getBoolean("good"));
			good.setIsrc(object.getString("isrc"));
			good.setPrice(object.getInt("price"));
			
			Data.goods.add(good);
		}
	}
}
