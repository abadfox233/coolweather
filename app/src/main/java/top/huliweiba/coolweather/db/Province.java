package top.huliweiba.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Acer on 2017/10/5.
 */

public class Province extends DataSupport {

    private int id;
    private String provinceName;
    private int provinceCode;
    public int getId(){
        return id;
    }
    public String getProvinceName(){
        return provinceName;
    }
    public int getProvinceCode(){
        return provinceCode;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setProvinceName(String provinceName){
        this.provinceName = provinceName;
    }
    private void setProvinceCode(int provinceCode){
        this.provinceCode = provinceCode;
    }

}