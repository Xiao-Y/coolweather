package com.coolweather.app.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.coolweather.app.model.City;
import com.coolweather.app.model.County;
import com.coolweather.app.model.Province;

/**
 * 数据库操作
 * 
 * @author XiaoY
 * @date: 2016年6月17日 下午11:15:57
 */
public class CoolWeatherDB {

	// 数据库名
	public static final String BD_NAME = "cool_weather";
	// 数据库版本
	public static final int VERSION = 1;

	private static CoolWeatherDB coolWeatherDB;
	private SQLiteDatabase db;

	private CoolWeatherDB(Context context) {
		CoolWeatherOpenHelper dbHelper = new CoolWeatherOpenHelper(context, BD_NAME, null, VERSION);
		db = dbHelper.getWritableDatabase();
	}

	public synchronized static CoolWeatherDB getInstance(Context context) {
		if (coolWeatherDB == null) {
			coolWeatherDB = new CoolWeatherDB(context);
		}
		return coolWeatherDB;
	}

	/**
	 * 保存省份信息
	 * 
	 * @param province
	 */
	public void saveProvince(Province province) {
		if (province != null) {
			ContentValues values = new ContentValues();
			values.put("province_name", province.getProvinceName());
			values.put("province_code", province.getProvinceCode());
			db.insert(Province.TABLE_NAME_PROVINCE, null, values);
		}
	}

	/**
	 * 查询所有的省份信息
	 * 
	 * @return
	 */
	public List<Province> loadProvince() {
		List<Province> list = new ArrayList<Province>();
		Cursor cursor = db.query(Province.TABLE_NAME_PROVINCE, null, null, null, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				int id = cursor.getInt(cursor.getColumnIndex("id"));
				String provinceName = cursor.getString(cursor.getColumnIndex("province_name"));
				String provinceCode = cursor.getString(cursor.getColumnIndex("province_code"));
				Province province = new Province();
				province.setId(id);
				province.setProvinceCode(provinceCode);
				province.setProvinceName(provinceName);
				list.add(province);
			} while (cursor.moveToNext());
		}
		if (cursor != null) {
			cursor.close();
		}
		return list;
	}

	/**
	 * 保存地市信息
	 * 
	 * @param city
	 */
	public void saveCity(City city) {
		if (city != null) {
			ContentValues values = new ContentValues();
			values.put("city_code", city.getCityCode());
			values.put("city_name", city.getCityName());
			values.put("province_id", city.getProvinceId());
			db.insert(City.TABLE_NAME_CITY, null, values);
		}
	}

	/**
	 * 根据省id获取市信息
	 * 
	 * @param provinceId
	 * @return
	 */
	public List<City> loadCity(int provinceId) {
		List<City> list = new ArrayList<City>();
		Cursor cursor = db.query(City.TABLE_NAME_CITY, null, "province_id = ?",
				new String[] { String.valueOf(provinceId) }, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				int id = cursor.getInt(cursor.getColumnIndex("id"));
				String cityName = cursor.getString(cursor.getColumnIndex("city_name"));
				String cityCode = cursor.getString(cursor.getColumnIndex("city_code"));
				City city = new City();
				city.setId(id);
				city.setCityCode(cityCode);
				city.setCityName(cityName);
				city.setProvinceId(provinceId);
				list.add(city);
			} while (cursor.moveToNext());
		}
		return list;
	}

	/**
	 * 保存县信息
	 * 
	 * @param city
	 */
	public void saveCounty(County county) {
		if (county != null) {
			ContentValues values = new ContentValues();
			values.put("county_code", county.getCountyCode());
			values.put("county_name", county.getCountyName());
			values.put("city_id", county.getCityId());
			db.insert(County.TABLE_NAME_COUNTY, null, values);
		}
	}

	/**
	 * 根据市id获取县信息
	 * 
	 * @param provinceId
	 * @return
	 */
	public List<County> loadCounty(int cityId) {
		List<County> list = new ArrayList<County>();
		Cursor cursor = db.query(County.TABLE_NAME_COUNTY, null, "city_id = ?",
				new String[] { String.valueOf(cityId) }, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				int id = cursor.getInt(cursor.getColumnIndex("id"));
				String countyName = cursor.getString(cursor.getColumnIndex("county_name"));
				String countyCode = cursor.getString(cursor.getColumnIndex("county_code"));
				County county = new County();
				county.setId(id);
				county.setCountyCode(countyCode);
				county.setCountyName(countyName);
				county.setCityId(cityId);
				list.add(county);
			} while (cursor.moveToNext());
		}
		return list;
	}
}
