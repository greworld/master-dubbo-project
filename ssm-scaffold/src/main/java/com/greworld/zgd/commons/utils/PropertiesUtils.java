package com.greworld.zgd.commons.utils;

import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * @author 风骚的GRE
 * @Description Properties文件操作工具类
 * @date 2018/1/29.
 */
public class PropertiesUtils {
    public static PropertiesConfiguration smsPropertiesConfiguration = null;

    public static PropertiesConfiguration configPropertiesConfiguration = null;

    public static PropertiesConfiguration getConfigPropertiesConfiguration(){
        if(null == configPropertiesConfiguration){
            try {
                configPropertiesConfiguration  = new PropertiesConfiguration("conf/prod/application.properties");
            } catch (org.apache.commons.configuration.ConfigurationException e) {
                e.printStackTrace();
            }
        }
        return configPropertiesConfiguration;
    }
}
