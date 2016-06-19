package com.coolweather.app.weatherModel;

import java.util.Date;

/**
 * 当前天气情况
 * 
 * @author XiaoY
 * @date: 2016年6月19日 上午10:57:25
 */
public class WeatherInfo {

	// private int Index;
	private String Rising;
	private String Extra;

	// 风寒
	private int Chill;
	// 天气现象代码，例如“4”
	private String Code;
	// 风向文字，例如“西北”
	private String Direction;
	// 相对湿度，范围0~1
	private String Humidity;
	// 气压。单位为mb百帕或in英寸
	private String Pressure;
	// 风速，单位为km/h公里每小时或mph英里每小时
	private String Speed;
	// 日出时间
	private String Sunrise;
	// 日落时间
	private String Sunset;
	// 温度，单位为c摄氏度或f华氏度
	private int Temperature;
	// 天气现象文字，例如“多云”
	private String Text;
	// 能见度，单位为km公里或mi英里
	private String Visibility;
	// 云量，范围0~100，天空被云覆盖的百分比
	private String Cop;
	// 数据更新时间（该城市的本地时间）
	//private Date Date;
	// 星期几
	private String Day;
	// 当天最高温度
	private int High;
	// 当天最低温度
	private int Low;

	/*
	 * public int getIndex() { return Index; }
	 * 
	 * public void setIndex(int index) { this.Index = index; }
	 */
	public String getRising() {
		return Rising;
	}

	public void setRising(String rising) {
		this.Rising = rising;
	}

	/**
	 * 风寒
	 * 
	 * @return
	 */
	public int getChill() {
		return Chill;
	}

	/**
	 * 风寒
	 * 
	 * @param chill
	 */
	public void setChill(int chill) {
		this.Chill = chill;
	}

	/**
	 * 天气现象代码，例如“4”
	 * 
	 * @return
	 */
	public String getCode() {
		return Code;
	}

	/**
	 * 天气现象代码，例如“4”
	 * 
	 * @param code
	 */
	public void setCode(String code) {
		this.Code = code;
	}

	/**
	 * 风向文字，例如“西北”
	 * 
	 * @return
	 */
	public String getDirection() {
		return Direction;
	}

	/**
	 * 风向文字，例如“西北”
	 * 
	 * @param direction
	 */
	public void setDirection(String direction) {
		this.Direction = direction;
	}

	/**
	 * 相对湿度，范围0~1
	 * 
	 * @return
	 */
	public String getHumidity() {
		return Humidity;
	}

	/**
	 * 相对湿度，范围0~1
	 * 
	 * @param humidity
	 */
	public void setHumidity(String humidity) {
		this.Humidity = humidity;
	}

	/**
	 * 气压。单位为mb百帕或in英寸
	 * 
	 * @return
	 */
	public String getPressure() {
		return Pressure;
	}

	/**
	 * 气压。单位为mb百帕或in英寸
	 * 
	 * @param pressure
	 */
	public void setPressure(String pressure) {
		this.Pressure = pressure;
	}

	/**
	 * 风速，单位为km/h公里每小时或mph英里每小时
	 * 
	 * @return
	 */
	public String getSpeed() {
		return Speed;
	}

	/**
	 * 风速，单位为km/h公里每小时或mph英里每小时
	 * 
	 * @param speed
	 */
	public void setSpeed(String speed) {
		this.Speed = speed;
	}

	/**
	 * 日出时间
	 * 
	 * @return
	 */
	public String getSunrise() {
		return Sunrise;
	}

	/**
	 * 日出时间
	 * 
	 * @param sunrise
	 */
	public void setSunrise(String sunrise) {
		this.Sunrise = sunrise;
	}

	/**
	 * 日落时间
	 * 
	 * @return
	 */
	public String getSunset() {
		return Sunset;
	}

	/**
	 * 日落时间
	 * 
	 * @param sunset
	 */
	public void setSunset(String sunset) {
		this.Sunset = sunset;
	}

	/**
	 * 温度，单位为c摄氏度或f华氏度
	 * 
	 * @return
	 */
	public int getTemperature() {
		return Temperature;
	}

	/**
	 * 温度，单位为c摄氏度或f华氏度
	 * 
	 * @param temperature
	 */
	public void setTemperature(int temperature) {
		this.Temperature = temperature;
	}

	/**
	 * 天气现象文字，例如“多云”
	 * 
	 * @return
	 */
	public String getText() {
		return Text;
	}

	/**
	 * 天气现象文字，例如“多云”
	 * 
	 * @param text
	 */
	public void setText(String text) {
		this.Text = text;
	}

	/**
	 * 能见度，单位为km公里或mi英里
	 * 
	 * @return
	 */
	public String getVisibility() {
		return Visibility;
	}

	/**
	 * 能见度，单位为km公里或mi英里
	 * 
	 * @param visibility
	 */
	public void setVisibility(String visibility) {
		this.Visibility = visibility;
	}

	public String getExtra() {
		return Extra;
	}

	public void setExtra(String extra) {
		this.Extra = extra;
	}

	/**
	 * 云量，范围0~100，天空被云覆盖的百分比
	 * 
	 * @return
	 */
	public String getCop() {
		return Cop;
	}

	/**
	 * 云量，范围0~100，天空被云覆盖的百分比
	 * 
	 * @param cop
	 */
	public void setCop(String cop) {
		this.Cop = cop;
	}

	/**
	 * 数据更新时间（该城市的本地时间）
	 * 
	 * @return
	 *//*
	public Date getDate() {
		return Date;
	}

	*//**
	 * 数据更新时间（该城市的本地时间）
	 * 
	 * @param date
	 *//*
	public void setDate(Date date) {
		this.Date = date;
	}*/

	/**
	 * 星期几
	 * 
	 * @return
	 */
	public String getDay() {
		return Day;
	}

	/**
	 * 星期几
	 * 
	 * @param day
	 */
	public void setDay(String day) {
		this.Day = day;
	}

	/**
	 * 当天最高温度
	 * 
	 * @return
	 */
	public int getHigh() {
		return High;
	}

	/**
	 * 当天最高温度
	 * 
	 * @param high
	 */
	public void setHigh(int high) {
		this.High = high;
	}

	/**
	 * 当天最低温度
	 * 
	 * @return
	 */
	public int getLow() {
		return Low;
	}

	/**
	 * 当天最低温度
	 * 
	 * @param low
	 */
	public void setLow(int low) {
		this.Low = low;
	}
}
