package com.coolweather.app.db;

import com.coolweather.app.model.City;
import com.coolweather.app.model.County;
import com.coolweather.app.model.Province;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class CoolWeatherOpenHelper extends SQLiteOpenHelper {

	// 创建省表语句
	public static final String CREATE_PROVINCE = "create table " + Province.TABLE_NAME_PROVINCE
			+ " ( id integer primary key autoincrement, province_name text, province_code text )";
	// 创建市表语句
	public static final String CREATE_CITY = "create table "
			+ City.TABLE_NAME_CITY
			+ " ( id integer primary key autoincrement, city_name text, city_code text, province_id integer )";
	// 创建县表语句
	public static final String CREATE_COUNTY = "create table "
			+ County.TABLE_NAME_COUNTY
			+ " ( id integer primary key autoincrement, county_name text, county_code text, city_id integer )";

	public CoolWeatherOpenHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_PROVINCE);
		db.execSQL(CREATE_CITY);
		db.execSQL(CREATE_COUNTY);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
