package top.huliweiba.coolweather.util;

import android.text.TextUtils;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import top.huliweiba.coolweather.db.City;
import top.huliweiba.coolweather.db.County;
import top.huliweiba.coolweather.db.Province;
import top.huliweiba.coolweather.gson.Weather;

/**
 * Created by Acer on 2017/10/5.
 */

public class Utility {
    public static boolean handleProvinceReqponse(String response){
        if(!TextUtils.isEmpty(response)){//判断字符串不为空且不为null
            try {
                JSONArray allProvince = new JSONArray(response);
                for (int i=0;i< allProvince.length();i++){
                    JSONObject provinceObject = allProvince.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleCityReqponse(String response, int provinceId){
        if(!TextUtils.isEmpty(response)){//判断字符串不为空且不为null
            try {
                JSONArray allCity = new JSONArray(response);
                for (int i=0;i<allCity.length();i++){
                    JSONObject cityObject = allCity.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleCountReqponse(String response,int cityId){
        if(!TextUtils.isEmpty(response)){//判断字符串不为空且不为null
            try {
                JSONArray allCounty = new JSONArray(response);
                for (int i=0;i<allCounty.length();i++){
                    JSONObject countyObject = allCounty.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    public static Weather handleWeatherResponse(String response){
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather5");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    };


}
