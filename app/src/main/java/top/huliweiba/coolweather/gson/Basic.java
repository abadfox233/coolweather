package top.huliweiba.coolweather.gson;

import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.UnsafeAllocator;

/**
 * Created by Acer on 2017/10/5.
 */

public class Basic {

    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update{

        @SerializedName("loc")
        public String updateTime;

    }

}
