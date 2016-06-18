package com.coolweather.app.model;

/**
 * 市
 * 
 * @author XiaoY
 * @date: 2016年6月17日 下午11:13:29
 */
public class City {

	public static final String TABLE_NAME_CITY = "City";

	private int id;
	private String cityName;
	private String cityCode;
	private int provinceId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
}
