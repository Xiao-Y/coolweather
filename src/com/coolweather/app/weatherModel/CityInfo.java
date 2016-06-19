package com.coolweather.app.weatherModel;

import java.util.Date;

/**
 * 城市空气质量
 * 
 * @author XiaoY
 * @date: 2016年6月19日 上午11:27:37
 */
public class CityInfo {
	// 空气质量指数(AQI)是描述空气质量状况的定量指数
	private String AQI;
	// 一氧化碳1小时平均值。单位：mg/m³
	private String CO;
	// 二氧化氮1小时平均值。单位：μg/m³
	private String NO2;
	// 臭氧1小时平均值。单位：μg/m³
	private String O3;
	// PM2.5颗粒物（粒径小于等于2.5μm）1小时平均值。单位：μg/m³
	private String PM25;
	// PM10颗粒物（粒径小于等于10μm）1小时平均值。单位：μg/m³
	private String PM10;
	// 二氧化硫1小时平均值。单位：μg/m³
	private String SO2;
	// 空气质量类别，有“优、良、轻度污染、中度污染、重度污染、严重污染”6类
	private String Quality;
	// 数据发布时间
	//private Date Time;

	/**
	 * 空气质量指数(AQI)是描述空气质量状况的定量指数
	 * 
	 * @return
	 */
	public String getAQI() {
		return AQI;
	}

	/**
	 * 空气质量指数(AQI)是描述空气质量状况的定量指数
	 * 
	 * @param aqi
	 */
	public void setAQI(String aqi) {
		this.AQI = aqi;
	}

	/**
	 * 一氧化碳1小时平均值。单位：mg/m³
	 * 
	 * @return
	 */
	public String getCO() {
		return CO;
	}

	/**
	 * 一氧化碳1小时平均值。单位：mg/m³
	 * 
	 * @param co
	 */
	public void setCO(String co) {
		this.CO = co;
	}

	/**
	 * 二氧化氮1小时平均值。单位：μg/m³
	 * 
	 * @return
	 */
	public String getNO2() {
		return NO2;
	}

	/**
	 * 二氧化氮1小时平均值。单位：μg/m³
	 * 
	 * @param no2
	 */
	public void setNO2(String no2) {
		this.NO2 = no2;
	}

	/**
	 * 臭氧1小时平均值。单位：μg/m³
	 * 
	 * @return
	 */
	public String getO3() {
		return O3;
	}

	/**
	 * 臭氧1小时平均值。单位：μg/m³
	 * 
	 * @param o3
	 */
	public void setO3(String o3) {
		this.O3 = o3;
	}

	/**
	 * PM2.5颗粒物（粒径小于等于2.5μm）1小时平均值。单位：μg/m³
	 * 
	 * @return
	 */
	public String getPM25() {
		return PM25;
	}

	/**
	 * PM2.5颗粒物（粒径小于等于2.5μm）1小时平均值。单位：μg/m³
	 * 
	 * @param pm25
	 */
	public void setPM25(String pm25) {
		this.PM25 = pm25;
	}

	/**
	 * PM10颗粒物（粒径小于等于10μm）1小时平均值。单位：μg/m³
	 * 
	 * @return
	 */
	public String getPM10() {
		return PM10;
	}

	/**
	 * PM10颗粒物（粒径小于等于10μm）1小时平均值。单位：μg/m³
	 * 
	 * @param pm10
	 */
	public void setPM10(String pm10) {
		this.PM10 = pm10;
	}

	/**
	 * 二氧化硫1小时平均值。单位：μg/m³
	 * 
	 * @return
	 */
	public String getSO2() {
		return SO2;
	}

	/**
	 * 二氧化硫1小时平均值。单位：μg/m³
	 * 
	 * @param so2
	 */
	public void setSO2(String so2) {
		this.SO2 = so2;
	}

	/**
	 * 空气质量类别，有“优、良、轻度污染、中度污染、重度污染、严重污染”6类
	 * 
	 * @return
	 */
	public String getQuality() {
		return Quality;
	}

	/**
	 * 空气质量类别，有“优、良、轻度污染、中度污染、重度污染、严重污染”6类
	 * 
	 * @param quality
	 */
	public void setQuality(String quality) {
		this.Quality = quality;
	}

	/**
	 * 数据发布时间
	 * 
	 * @return
	 *//*
	public Date getTime() {
		return Time;
	}

	*//**
	 * 数据发布时间
	 * 
	 * @param time
	 *//*
	public void setTime(Date time) {
		this.Time = time;
	}*/
}
