package com.coolweather.app.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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
			db.insert(BD_NAME, null, values);
		}
	}

	/**
	 * 查询所有的省份信息
	 * 
	 * @return
	 */
	public List<Province> loadProvince() {
		List<Province> list = new ArrayList<Province>();
		Cursor cursor = db.query("Province", null, null, null, null, null, null);
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
}
