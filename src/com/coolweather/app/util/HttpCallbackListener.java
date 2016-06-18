package com.coolweather.app.util;

public interface HttpCallbackListener {

	void onFinish();

	void onError(Exception e);

}
