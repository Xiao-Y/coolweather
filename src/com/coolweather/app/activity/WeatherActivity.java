package com.coolweather.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coolweather.app.service.AutoUpdateService;
import com.coolweather.app.util.HttpCallbackListener;
import com.coolweather.app.util.HttpUtil;
import com.coolweather.app.util.Utility;

public class WeatherActivity extends Activity implements OnClickListener {

	public static final String COUNTY_CODE = "countyCode";

	private LinearLayout weatherInfoLayout;
	// 显示城市名
	private TextView cityNameText;
	// 显示发布时间
	private TextView publishText;
	// 天气描述
	private TextView weatherDespText;
	// 显示温度1
	private TextView temp1Text;
	// 显示温度2
	private TextView temp2Text;
	// 显示当前的日期
	private TextView currentDateText;
	// 切换城市
	private Button switchCity;
	// 刷新天气
	private Button refreshWeather;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.weather_layout);
		weatherInfoLayout = (LinearLayout) this.findViewById(R.id.weather_info_layout);
		cityNameText = (TextView) this.findViewById(R.id.city_name);
		publishText = (TextView) this.findViewById(R.id.publish_text);
		weatherDespText = (TextView) this.findViewById(R.id.weather_desp);
		temp1Text = (TextView) this.findViewById(R.id.temp1);
		temp2Text = (TextView) this.findViewById(R.id.temp2);
		currentDateText = (TextView) this.findViewById(R.id.current_date);
		switchCity = (Button) this.findViewById(R.id.switch_city);
		switchCity.setOnClickListener(this);
		refreshWeather = (Button) this.findViewById(R.id.refresh_weather);
		refreshWeather.setOnClickListener(this);
		String countyCode = getIntent().getStringExtra("county_code");

		if (!TextUtils.isEmpty(countyCode)) {
			// 查询天气
			publishText.setText("同步中....");
			weatherInfoLayout.setVisibility(View.INVISIBLE);
			cityNameText.setVisibility(View.INVISIBLE);
			this.queryWeatherInfo(countyCode);
		} else {
			// 没countyCode时显示本地天气
			this.showWeather();
		}
	}

	/**
	 * 根据countyCode查询天气
	 * 
	 * @param countyCode
	 */
	private void queryWeatherInfo(String countyCode) {
		String address = "http://www.thinkpage.cn/weather/api.svc/getWeather?city=" + countyCode
				+ "&language=zh-CHS&provider=CMA&unit=C&aqi=city";
		HttpUtil.senedHttpRequest(address, new HttpCallbackListener() {

			@Override
			public void onFinish(String response) {
				Utility.handleWeatherResponse(WeatherActivity.this, response);
				runOnUiThread(new Runnable() {

					@Override
					public void run() {
						showWeather();
					}
				});
			}

			@Override
			public void onError(Exception e) {
				runOnUiThread(new Runnable() {

					@Override
					public void run() {
						publishText.setText("同步失败....");
					}
				});
			}
		});
	}

	/**
	 * 没countyCode时显示本地天气
	 */
	private void showWeather() {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		cityNameText.setText(prefs.getString("city_name", ""));
		temp1Text.setText(prefs.getString("temp1", "") + "℃");
		temp2Text.setText(prefs.getString("temp2", "") + "℃");
		weatherDespText.setText(prefs.getString("weather_desp", ""));
		publishText.setText("今天" + prefs.getString("publish_time", "") + "发布");
		currentDateText.setText(prefs.getString("current_date", ""));
		weatherInfoLayout.setVisibility(View.VISIBLE);
		cityNameText.setVisibility(View.VISIBLE);
		Intent intent = new Intent(this, AutoUpdateService.class);
		this.startService(intent);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.switch_city:
			Intent intent = new Intent(this, ChooseAreaActivity.class);
			intent.putExtra("from_weather_activity", true);
			this.startActivity(intent);
			this.finish();
			break;
		case R.id.refresh_weather:
			publishText.setText("同步中....");
			SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
			String weatherCode = prefs.getString("weather_code", "");
			if (!TextUtils.isEmpty(weatherCode)) {
				this.queryWeatherInfo(weatherCode);
			}
			break;
		default:
			break;
		}
	}
}
