package com.coolweather.app.model;

/**
 * 省
 * 
 * @author XiaoY
 * @date: 2016年6月17日 下午11:12:16
 */
public class Province {

	public static final String TABLE_NAME_PROVINCE = "Province";

	private int id;
	private String provinceName;
	private String provinceCode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
}
