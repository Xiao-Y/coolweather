package com.coolweather.app.util;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.coolweather.app.db.CoolWeatherDB;
import com.coolweather.app.model.City;
import com.coolweather.app.model.County;
import com.coolweather.app.model.Province;
import com.coolweather.app.weatherModel.WeatherInfo;
import com.coolweather.app.weatherModel.Weathers;
import com.coolweather.app.weatherModel.XingZhiModel;
import com.google.gson.Gson;

public class Utility {

	public static final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);

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

	public static void handleWeatherResponse(Context context, String response) {
		Gson gson = new Gson();
		XingZhiModel json = gson.fromJson(response, XingZhiModel.class);
		List<Weathers> weatherListt = json.getWeathers();
		Weathers weathers = weatherListt.get(0);
		String cityName = weathers.getCityName();
		String weatherCode = weathers.getCityId();
		String publishTime = weathers.getLastBuildDate();
		List<WeatherInfo> forecast = weathers.getForecast();
		WeatherInfo weatherInfo = forecast.get(0);
		String temp1 = weatherInfo.getHigh() + "";
		String temp2 = weatherInfo.getLow() + "";
		WeatherInfo current = weathers.getCurrent();
		String weatherDesp = current.getText();
		saveWeatherInfo(context, cityName, weatherCode, temp1, temp2, weatherDesp, publishTime);
	}

	/**
	 * 将服务器返回的所有天气信息存储到SharedPreferences文件中
	 * 
	 * @param context
	 * @param cityName
	 * @param weatherCode
	 * @param temp1
	 * @param temp2
	 * @param weatherDesp
	 * @param publishTime
	 */
	private static void saveWeatherInfo(Context context, String cityName, String weatherCode,
			String temp1, String temp2, String weatherDesp, String publishTime) {
		SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context)
				.edit();
		editor.putBoolean("city_selected", true);
		editor.putString("city_name", cityName);
		editor.putString("weather_code", weatherCode);
		editor.putString("temp1", temp1);
		editor.putString("temp2", temp2);
		editor.putString("weather_desp", weatherDesp);
		String[] dateTime = DateUtil.formatDateTime(publishTime);
		editor.putString("publish_time", dateTime[2]);
		editor.putString("current_date", dateTime[1]);
		editor.commit();
	}
}
