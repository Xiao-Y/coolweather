package com.coolweather.app.weatherModel;

import java.util.List;

/**
 * 所有的天气情况
 * 
 * @author XiaoY
 * @date: 2016年6月19日 上午11:33:48
 */
public class Weathers {

	// 城市ID
	public String CityId;
	// 城市名称
	public String CityName;
	// 国家代码
	public String Country;
	// 数据更新时间（该城市的本地时间）
	public String LastBuildDate;
	// 限行区域
	public String Region;

	// 当前的天气
	private WeatherInfo Current;
	// 空气质量
	private AirQuality AirQuality;
	// 预测后几天的天气
	private List<WeatherInfo> Forecast;

	/**
	 * 城市ID
	 * 
	 * @return
	 */
	public String getCityId() {
		return CityId;
	}

	/**
	 * 城市ID
	 * 
	 * @param cityId
	 */
	public void setCityId(String cityId) {
		this.CityId = cityId;
	}

	/**
	 * 城市名称
	 * 
	 * @return
	 */
	public String getCityName() {
		return CityName;
	}

	/**
	 * 城市名称
	 * 
	 * @param cityName
	 */
	public void setCityName(String cityName) {
		this.CityName = cityName;
	}

	/**
	 * 国家代码
	 * 
	 * @return
	 */
	public String getCountry() {
		return Country;
	}

	/**
	 * 国家代码
	 * 
	 * @param country
	 */
	public void setCountry(String country) {
		this.Country = country;
	}

	/**
	 * 数据更新时间（该城市的本地时间）
	 * 
	 * @return
	 */
	public String getLastBuildDate() {
		return LastBuildDate;
	}

	/**
	 * 数据更新时间（该城市的本地时间）
	 * 
	 * @param lastBuildDate
	 */
	public void setLastBuildDate(String lastBuildDate) {
		this.LastBuildDate = lastBuildDate;
	}

	/**
	 * 限行区域
	 * 
	 * @return
	 */
	public String getRegion() {
		return Region;
	}

	/**
	 * 限行区域
	 * 
	 * @param region
	 */
	public void setRegion(String region) {
		this.Region = region;
	}

	/**
	 * 当前的天气
	 * 
	 * @return
	 */
	public WeatherInfo getCurrent() {
		return Current;
	}

	/**
	 * 当前的天气
	 * 
	 * @param current
	 */
	public void setCurrent(WeatherInfo current) {
		this.Current = current;
	}

	/**
	 * 空气质量
	 * 
	 * @return
	 */
	public AirQuality getAirQuality() {
		return AirQuality;
	}

	/**
	 * 空气质量
	 * 
	 * @param airQuality
	 */
	public void setAirQuality(AirQuality airQuality) {
		this.AirQuality = airQuality;
	}

	/**
	 * 预测后几天的天气
	 * 
	 * @return
	 */
	public void setForecast(List<WeatherInfo> forecast) {
		this.Forecast = forecast;
	}

	/**
	 * 预测后几天的天气
	 * 
	 * @param Forecast
	 */
	public List<WeatherInfo> getForecast() {
		return Forecast;
	}
}
