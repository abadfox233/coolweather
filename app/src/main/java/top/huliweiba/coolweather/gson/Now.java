package top.huliweiba.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Acer on 2017/10/5.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More{
        @SerializedName("txt")
        public String info;

    }



}
