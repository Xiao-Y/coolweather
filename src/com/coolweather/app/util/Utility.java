package com.coolweather.app.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.text.TextUtils;

import com.coolweather.app.db.CoolWeatherDB;
import com.coolweather.app.model.City;
import com.coolweather.app.model.County;
import com.coolweather.app.model.Province;

public class Utility {

	/**
	 * 解析和处理服务器返回的省份数据
	 * 
	 * @param coolWeatherDB
	 * @param response
	 * @return
	 */
	public synchronized static boolean handleProvincesResponse(CoolWeatherDB coolWeatherDB,
			String response) {
		if (!TextUtils.isEmpty(response)) {
			try {
				JSONArray jsonArray = new JSONArray(response);
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject = jsonArray.getJSONObject(i);
					Province province = new Province();
					province.setProvinceCode(jsonObject.getString("key"));
					province.setProvinceName(jsonObject.getString("value"));
					coolWeatherDB.saveProvince(province);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}

	/**
	 * 解析和处理服务器返回的市级数据
	 * 
	 * @param coolWeatherDB
	 * @param response
	 * @return
	 */
	public synchronized static boolean handleCityResponse(CoolWeatherDB coolWeatherDB,
			String response, int provinceId) {
		if (!TextUtils.isEmpty(response)) {
			try {
				JSONArray jsonArray = new JSONArray(response);
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject = jsonArray.getJSONObject(i);
					City city = new City();
					city.setCityCode(jsonObject.getString("key"));
					city.setCityName(jsonObject.getString("value"));
					city.setProvinceId(provinceId);
					coolWeatherDB.saveCity(city);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}

	/**
	 * 解析和处理服务器返回的区级数据
	 * 
	 * @param coolWeatherDB
	 * @param response
	 * @return
	 */
	public synchronized static boolean handleCountyResponse(CoolWeatherDB coolWeatherDB,
			String response, int cityId) {
		if (!TextUtils.isEmpty(response)) {
			try {
				JSONArray jsonArray = new JSONArray(response);
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject = jsonArray.getJSONObject(i);
					County county = new County();
					county.setCountyCode(jsonObject.getString("key"));
					county.setCountyName(jsonObject.getString("value"));
					county.setCityId(cityId);
					coolWeatherDB.saveCounty(county);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}

}
