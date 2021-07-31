package com.baiju.techanicaltest;

import org.json.JSONException;
import org.json.JSONObject;

public class weatherData {

    private String mTeperature,mCity,mWeatherType;
    private int mCondition;
    public static weatherData fromJson(JSONObject jsonObject) {
        try {

            weatherData weatherD = new weatherData();
            weatherD.mCity = jsonObject.getString("name");
            weatherD.mCondition = jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherD.mWeatherType = jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            double tempResult = jsonObject.getJSONObject("main").getDouble("temp") - 273.15;
            int roundedValue = (int) Math.rint(tempResult);
            weatherD.mTeperature = Integer.toString(roundedValue);
            return weatherD;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getmTeperature() {
        return mTeperature+"°C";
    }

    public String getmCity() {
        return mCity;
    }

    public String getmWeatherType() {
        return mWeatherType;
    }
}
