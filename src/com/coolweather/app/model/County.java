package com.coolweather.app.model;

/**
 * 县
 * 
 * @author XiaoY
 * @date: 2016年6月17日 下午11:14:46
 */
public class County {

	public static final String TABLE_NAME_COUNTY = "County";

	private int id;
	private String countyName;
	private String countyCode;
	private int cityId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public String getCountyCode() {
		return countyCode;
	}

	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
}
