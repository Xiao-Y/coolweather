package com.coolweather.app.weatherModel;

/**
 * 空气质量
 * 
 * @author XiaoY
 * @date: 2016年6月19日 上午11:06:46
 */
public class AirQuality {
	// 城市空气质量
	private CityInfo CityInfo;
	// 监测站信息
	private StationInfo StationInfo;

	/**
	 * 城市空气质量
	 * 
	 * @return
	 */
	public CityInfo getCityInfo() {
		return CityInfo;
	}

	/**
	 * 城市空气质量
	 * 
	 * @param cityInfo
	 */
	public void setCityInfo(CityInfo cityInfo) {
		this.CityInfo = cityInfo;
	}

	/**
	 * 监测站信息
	 * 
	 * @return
	 */
	public StationInfo getStationInfo() {
		return StationInfo;
	}

	/**
	 * 监测站信息
	 * 
	 * @param stationInfo
	 */
	public void setStationInfo(StationInfo stationInfo) {
		this.StationInfo = stationInfo;
	}
}
