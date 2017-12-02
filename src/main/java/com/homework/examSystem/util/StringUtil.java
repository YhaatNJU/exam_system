package com.homework.examSystem.util;

/**
 * @author yha
 * @decription 操作字符串的工具类
 * @create 2017-11-10 16:52
 **/
public class StringUtil {

    /**
     * 检查字符串是不是null或者空字符串
     * @param s
     * @return
     */
    public static boolean isNullOrEmpty(String s){
        if (s == null || s.equals(""))
            return true;
        return false;
    }

}
