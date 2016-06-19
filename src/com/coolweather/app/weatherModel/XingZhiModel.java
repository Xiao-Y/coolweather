package com.coolweather.app.weatherModel;

import java.util.List;

/**
 * 请求心知服务器返回数据的模型
 * 
 * @author XiaoY
 * @date: 2016年6月19日 上午11:36:09
 */
public class XingZhiModel {

	// 请求状态
	private String Stat;
	// 所有的天气情况
	private List<Weathers> Weathers;

	/**
	 * 请求状态
	 * 
	 * @return
	 */
	public String getStat() {
		return Stat;
	}

	/**
	 * 请求状态
	 * 
	 * @param Stat
	 */
	public void setStat(String Stat) {
		this.Stat = Stat;
	}

	/**
	 * 所有的天气情况
	 * 
	 * @return
	 */
	public List<Weathers> getWeathers() {
		return Weathers;
	}

	/**
	 * 所有的天气情况
	 * 
	 * @param weathers
	 */

	public void setWeathers(List<Weathers> weathers) {
		Weathers = weathers;
	}
}
